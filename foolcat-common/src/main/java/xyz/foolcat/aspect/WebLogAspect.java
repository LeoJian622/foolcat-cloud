package xyz.foolcat.aspect;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import xyz.foolcat.model.WebLog;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author Leojan
 * @date 2021-06-17 10:20
 */

@Aspect
@Component
@Order(1)
@Slf4j
public class WebLogAspect {

    @Pointcut("execution( * xyz.foolcat.controller.*.*(..))")
    public void webLog() {
    }

    @Around(value = "webLog()")
    public Object recordWebLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object resutl = null;
        //创建计时器
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        //执行任务
        resutl = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        stopwatch.stop();

        //获取登录的用户
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //获取方法
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        //获取方法上的APIOperation注解
        ApiOperation annotation = method.getAnnotation(ApiOperation.class);
        // 获取目标对象的类型名称
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        //获取请求上文
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        // 获取请求的url 地址
        String requestUrl = request.getRequestURL().toString();
        WebLog webLog = WebLog.builder()
                .basePath(StrUtil.removeSuffix(requestUrl, URLUtil.url(requestUrl).getPath()))
                .description(annotation == null ? "none description" : annotation.value())
                .parameter(getMethodParameter(method, proceedingJoinPoint.getArgs()))
                .method(className + '.' + method.getName())
                .result(resutl == null ? "" : JSON.toJSONString(resutl))
                .recodeTime(System.currentTimeMillis())
                .spendTime(Math.toIntExact(stopwatch.getTotalTimeMillis()))
                .url(request.getRequestURI())
                .url(request.getRequestURL().toString())
                .username(authentication == null ? "anonymous" : authentication.getPrincipal().toString())
                .build();
        log.info(JSON.toJSONString(webLog, true));
        return resutl;
    }

    private Object getMethodParameter(Method method, Object[] args) {
        LocalVariableTableParameterNameDiscoverer localVariableTableParameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = localVariableTableParameterNameDiscoverer.getParameterNames(method);

        HashMap<String, Object> methodParameters = new HashMap<>();
        if (args != null) {
            for (int i = 0; i < parameterNames.length; i++) {
                methodParameters.put(parameterNames[i], args[i] == null ? "" : JSON.toJSONString(args[i]));
            }
        }
        return methodParameters;
    }
}
