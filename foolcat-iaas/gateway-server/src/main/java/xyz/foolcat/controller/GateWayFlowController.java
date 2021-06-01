package xyz.foolcat.controller;

import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiDefinition;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.GatewayApiDefinitionManager;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author Leojan
 * @date 2021-06-01 16:18
 */

@RestController
public class GateWayFlowController {

    /**
     * 获取当前系统限流策略
     */
    @RequestMapping("/gw/flow/rules")
    public Set<GatewayFlowRule> getCurrentGatewayFlowRules() {
        return GatewayRuleManager.getRules();
    }

    /**
     * 获取自定义API限流策略
     */
    @RequestMapping("/gw/api/groups")
    public Set<ApiDefinition> getApiGroups() {
        return GatewayApiDefinitionManager.getApiDefinitions();
    }
}
