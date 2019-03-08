  drop TABLE if exists t_goods_category;
  -- 建表SQL
  CREATE TABLE t_goods_category (
  id bigint(20) NOT NULL COMMENT '主键',
          parent_id  bigint(20)  NULL  COMMENT '上机分类的编号：0表示一级分类',
          name   varchar(255)  NULL  COMMENT '名称',
          level  int(10)  NULL  COMMENT '分类级别：0->1级；1->2级',
          product_count  int(10)  NULL  COMMENT '分类下商品数量，统计得到',
          product_unit   varchar(255)  NULL  COMMENT '单位',
          nav_status  int(10)  NULL  COMMENT '是否显示在导航栏：0->不显示；1->显示',
          show_status  int(10)  NULL  COMMENT '显示状态：0->不显示；1->显示',
          sort  bigint(20)  NULL  COMMENT '排序',
          icon   varchar(255)  NULL  COMMENT '图标',
          keywords   varchar(255)  NULL  COMMENT '关键词',
          description   varchar(255)  NULL  COMMENT '描述',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品类目信息信息表';
