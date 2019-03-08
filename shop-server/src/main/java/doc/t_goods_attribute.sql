  drop TABLE if exists t_goods_attribute;
  -- 建表SQL
  CREATE TABLE t_goods_attribute (
  id bigint(20) NOT NULL COMMENT '主键',
          product_attribute_category_id  bigint(20)  NULL  COMMENT '产品属性分类ID',
          name   varchar(255)  NULL  COMMENT '名称',
          select_type  int(10)  NULL  COMMENT '属性选择类型：0->唯一；1->单选；2->多选',
          input_type  int(10)  NULL  COMMENT '属性录入方式：0->手工录入；1->从列表中选取',
          input_list   varchar(255)  NULL  COMMENT '可选值列表，以逗号隔开',
          sort  int(10)  NULL  COMMENT '排序字段：最高的可以单独上传图片',
          filter_type  int(10)  NULL  COMMENT '分类筛选样式：1->普通；1->颜色',
          search_type  int(10)  NULL  COMMENT '检索类型；0->不需要进行检索；1->关键字检索；2->范围检索',
          related_status  int(10)  NULL  COMMENT '相同属性产品是否关联；0->不关联；1->关联',
          hand_add_status  int(10)  NULL  COMMENT '是否支持手动新增；0->不支持；1->支持',
          type  int(10)  NULL  COMMENT '属性的类型；0->规格；1->参数',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品属性参数表';
