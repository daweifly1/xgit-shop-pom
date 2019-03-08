  drop TABLE if exists t_goods_attribute_category;
  -- 建表SQL
  CREATE TABLE t_goods_attribute_category (
  id bigint(20) NOT NULL COMMENT '主键',
          name   varchar(255)  NULL  COMMENT '名称',
          attribute_count  int(10)  NULL  COMMENT '属性数量',
          param_count  int(10)  NULL  COMMENT '参数数量',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='产品属性分类表';
