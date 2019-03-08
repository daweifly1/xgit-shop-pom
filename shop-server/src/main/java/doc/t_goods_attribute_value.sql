  drop TABLE if exists t_goods_attribute_value;
  -- 建表SQL
  CREATE TABLE t_goods_attribute_value (
  id bigint(20) NOT NULL COMMENT '主键',
          product_id  bigint(20)  NULL  COMMENT '商品id',
          product_attribute_id  bigint(20)  NULL  COMMENT '商品属性id',
          value   varchar(255)  NULL  COMMENT '手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='存储产品参数信息的表';
