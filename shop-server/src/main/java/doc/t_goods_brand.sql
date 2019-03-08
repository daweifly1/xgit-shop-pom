  drop TABLE if exists t_goods_brand;
  -- 建表SQL
  CREATE TABLE t_goods_brand (
  id bigint(20) NOT NULL COMMENT '主键',
          name   varchar(255)  NULL  COMMENT '品牌名称',
          first_letter   varchar(255)  NULL  COMMENT '首字母',
          sort  bigint(20)  NULL  COMMENT '排序',
          factory_status  int(10)  NULL  COMMENT '是否为品牌制造商：0->不是；1->是',
          show_status  int(10)  NULL  COMMENT '展示状态，0否1是',
          product_count  int(10)  NULL  COMMENT '产品数量',
          product_comment_count  int(10)  NULL  COMMENT '产品评论数量',
          logo   varchar(255)  NULL  COMMENT '品牌logo',
          big_pic   varchar(255)  NULL  COMMENT '专区大图',
          brand_story   varchar(255)  NULL  COMMENT '品牌故事',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='品牌表';
