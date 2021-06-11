create table sys_user
(
    id          bigint(20)   NOT NULL primary key comment '主键',
    username    varchar(32)  NOT NULL comment '账号',
    password    varchar(256) NOT NULL comment '密码',
    nickname    varchar(32) comment '昵称',
    mobile      varchar(16) comment '手机号',
    email       varchar(128) comment '邮箱',
    status      tinyint      NOT NULL DEFAULT 1 comment '状态',
    creator     bigint(20)   NOT NULL comment '创建者',
    modifier    bigint(20)   NOT NULL comment '修改者',
    create_time datetime     NOT NULL comment '创建时间',
    update_time datetime     NOT NULL comment '修改时间'
) engine = Innodb
  default charset = utf8mb4 comment = '平台用户';

create table sys_role
(
    id          bigint(20)  NOT NULL primary key comment '主键',
    name        varchar(32) NOT NULL comment '名称',
    code        varchar(32) NOT NULL comment '代码',
    description varchar(32) comment '描述',
    status      tinyint     NOT NULL DEFAULT 1 comment '状态',
    creator     bigint(20)  NOT NULL comment '创建者',
    modifier    bigint(20)  NOT NULL comment '修改者',
    create_time datetime    NOT NULL comment '创建时间',
    update_time datetime    NOT NULL comment '修改时间'
) engine = Innodb
  default charset = utf8mb4 comment = '角色';

create table sys_menu
(
    id          bigint(20)  NOT NULL primary key comment '主键',
    parent_id   varchar(32) comment '上级菜单ID',
    parent_key  varchar(255) comment '上级菜单唯一key',
    type        tinyint     NOT NULL DEFAULT 2 comment '类型',
    name        varchar(64) NOT NULL comment '名称',
    description varchar(255) comment '描述',
    target_url  varchar(128) comment '目标地址',
    sort        int comment '排序索引',
    status      tinyint     NOT NULL comment '状态',
    creator     bigint(20)  NOT NULL comment '创建者',
    modifier    bigint(20)  NOT NULL comment '修改者',
    create_time datetime    NOT NULL comment '创建时间',
    update_time datetime    NOT NULL comment '修改时间'
) engine = Innodb
  default charset = utf8mb4 comment = '系统菜单';

create table sys_privilege
(
    id          bigint(20)  NOT NULL primary key comment '主键',
    menu_id     varchar(32) comment '所属菜单ID',
    name        varchar(64) NOT NULL comment '名称',
    description varchar(255) comment '描述',
    url         varchar(255) comment '目标地址',
    method      varchar(255) comment '',
    creator     bigint(20)  NOT NULL comment '创建者',
    modifier    bigint(20)  NOT NULL comment '修改者',
    create_time datetime    NOT NULL comment '创建时间',
    update_time datetime    NOT NULL comment '修改时间'
) engine = Innodb
  default charset = utf8mb4 comment = '权限配置';

create table sys_user_role
(
    id          bigint(20) NOT NULL primary key comment '主键',
    role_id     bigint(20) comment '角色ID',
    user_id     bigint(20) comment '用户ID',
    creator     bigint(20) NOT NULL comment '创建者',
    modifier    bigint(20) NOT NULL comment '修改者',
    create_time datetime   NOT NULL comment '创建时间',
    update_time datetime   NOT NULL comment '修改时间'
) engine = Innodb
  default charset = utf8mb4 comment = '用户角色配置';

create table sys_role_menu
(
    id          bigint(20) NOT NULL primary key comment '主键',
    role_id     bigint(20) comment '角色ID',
    menu_id     bigint(20) comment '菜单ID',
    creator     bigint(20) NOT NULL comment '创建者',
    modifier    bigint(20) NOT NULL comment '修改者',
    create_time datetime   NOT NULL comment '创建时间',
    update_time datetime   NOT NULL comment '修改时间'
) engine = Innodb
  default charset = utf8mb4 comment = '角色菜单';

create table sys_role_privilege
(
    id           bigint(20) NOT NULL primary key comment '主键',
    role_id      bigint(20) comment '角色ID',
    privilege_id bigint(20) comment '权限ID',
    creator      bigint(20) NOT NULL comment '创建者',
    modifier     bigint(20) NOT NULL comment '修改者',
    create_time  datetime   NOT NULL comment '创建时间',
    update_time  datetime   NOT NULL comment '修改时间'
) engine = Innodb
  default charset = utf8mb4 comment = '角色权限配置';

create table sys_role_privilege_user
(
    id           bigint(20) NOT NULL primary key comment '主键',
    role_id      bigint(20) comment '角色ID',
    user_id      bigint(20) comment '用户ID',
    privilege_id bigint(20) comment '权限ID'
) engine = Innodb
  default charset = utf8mb4 comment = '用户权限配置';

create table sys_user_log
(
    id          bigint(20)  NOT NULL primary key comment '主键',
    group_name  varchar(255) comment '组',
    user_id     bigint(20) comment '用户ID',
    type        smallint comment '日志类型-1查询2修改3新增4删除5导出6审核',
    method      varchar(255) comment '方法',
    params      text(65535) comment '参数',
    ip          varchar(64) comment 'IP地址',
    description varchar(255) comment '描述',
    remark      varchar(255) comment '备注',
    creator     varchar(32) NOT NULL comment '创建者',
    create_time datetime    NOT NULL comment '创建时间'
) engine = Innodb
  default charset = utf8mb4 comment = '系统日志';
