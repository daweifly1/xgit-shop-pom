  drop TABLE if exists t_goods;
  -- 建表SQL
  CREATE TABLE t_goods (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
          brand_id  bigint(20)  NULL  COMMENT '品牌ID',
          product_category_id  bigint(20)  NULL  COMMENT '类目id',
          feight_template_id  bigint(20)  NULL  COMMENT '运费模板',
          product_attribute_category_id  bigint(20)  NULL  COMMENT '属性分类id',
          name   varchar(255)  NULL  COMMENT '名称',
          pic   varchar(255)  NULL  COMMENT '图片',
          goods_sn   varchar(255)  NULL  COMMENT '货号',
          delete_status  int(10)  NULL  COMMENT '删除状态：0->未删除；1->已删除',
          publish_status  int(10)  NULL  COMMENT '上架状态：0->下架；1->上架',
          new_status  int(10)  NULL  COMMENT '新品状态:0->不是新品；1->新品',
          recommand_status  int(10)  NULL  COMMENT '推荐状态；0->不推荐；1->推荐',
          verify_status  int(10)  NULL  COMMENT '审核状态：0->未审核；1->审核通过',
          sort  bigint(20)  NULL  COMMENT '排序',
          sale  int(10)  NULL  COMMENT '销量',
          price  DECIMAL    NULL  COMMENT '价格',
          promotion_price  bigint(20)  NULL  COMMENT '促销价格',
          gift_growth  int(10)  NULL  COMMENT '赠送的成长值',
          gift_point  int(10)  NULL  COMMENT '赠送的积分',
          use_point_limit  int(10)  NULL  COMMENT '限制使用的积分数',
          sub_title   varchar(255)  NULL  COMMENT '副标题',
          description   varchar(255)  NULL  COMMENT '商品描述',
          original_price  bigint(20)  NULL  COMMENT '市场价',
          stock  int(10)  NULL  COMMENT '库存',
          low_stock  int(10)  NULL  COMMENT '库存预警值',
          unit   varchar(255)  NULL  COMMENT '单位',
          weight  bigint(20)  NULL  COMMENT '商品重量，默认为克',
          preview_status  int(10)  NULL  COMMENT '是否为预告商品：0->不是；1->是',
          service_ids   varchar(255)  NULL  COMMENT '以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮',
          keywords   varchar(255)  NULL  COMMENT '关键词',
          note   varchar(255)  NULL  COMMENT '备注',
          album_pics   varchar(255)  NULL  COMMENT '画册图片，连产品图片限制为5张，以逗号分割',
          detail_title   varchar(255)  NULL  COMMENT '详细标题',
          detail_desc   varchar(255)  NULL  COMMENT '详情描述',
          detail_html   varchar(255)  NULL  COMMENT '产品详情网页内容',
          detail_mobile_html   varchar(255)  NULL  COMMENT '移动端网页详情',
          promotion_start_time  timestamp  NULL  COMMENT '促销开始时间',
          promotion_end_time  timestamp  NULL  COMMENT '促销结束时间',
          promotion_per_limit  int(10)  NULL  COMMENT '活动限购数量',
          promotion_type  int(10)  NULL  COMMENT '促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购',
          brand_name   varchar(255)  NULL  COMMENT '品牌名称',
          product_category_name   varchar(255)  NULL  COMMENT '商品分类名称',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品信息';
  drop TABLE if exists t_goods_attribute;
  -- 建表SQL
  CREATE TABLE t_goods_attribute (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
          goods_attribute_category_id  bigint(20)  NULL  COMMENT '产品属性分类ID',
          name   varchar(255)  NULL  COMMENT '名称',
          select_type  int(10)  NULL  COMMENT '属性选择类型：0->唯一；1->单选；2->多选',
          input_type  int(10)  NULL  COMMENT '属性录入方式：0->手工录入；1->从列表中选取',
          input_list   varchar(255)  NULL  COMMENT '可选值列表，以逗号隔开',
          sort  int(10)  NULL  COMMENT '排序字段：最高的可以单独上传图片',
          filter_type  int(10)  NULL  COMMENT '分类筛选样式：0->普通；1->颜色',
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
  drop TABLE if exists t_goods_attribute_category;
  -- 建表SQL
  CREATE TABLE t_goods_attribute_category (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
          name   varchar(255)  NULL  COMMENT '名称',
          attribute_count  int(10)  NULL  COMMENT '属性数量',
          param_count  int(10)  NULL  COMMENT '参数数量',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='产品属性分类表';
  drop TABLE if exists t_goods_attribute_img;
  -- 建表SQL
  CREATE TABLE t_goods_attribute_img (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
          goods_id  bigint(20)  NULL  COMMENT '产品属性分类ID',
          color   varchar(255)  NULL  COMMENT '颜色属性',
          pic   varchar(255)  NULL  COMMENT '图片',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品颜色属性图片';
  drop TABLE if exists t_goods_attribute_value;
  -- 建表SQL
  CREATE TABLE t_goods_attribute_value (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
          goods_id  bigint(20)  NULL  COMMENT '商品id',
          goods_attribute_id  bigint(20)  NULL  COMMENT '商品属性id',
          goods_attribute_category_name   varchar(255)  NULL  COMMENT '产品属性分类名称',
          value   varchar(255)  NULL  COMMENT '手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='存储产品参数信息的表';
  drop TABLE if exists t_goods_brand;
  -- 建表SQL
  CREATE TABLE t_goods_brand (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
          name   varchar(255)  NULL  COMMENT '品牌名称',
          first_letter   varchar(255)  NULL  COMMENT '首字母',
          sort  bigint(20)  NULL  COMMENT '排序',
          factory_status  int(10)  NULL  COMMENT '是否为品牌制造商：0->不是；1->是',
          show_status  int(10)  NULL  COMMENT '展示状态，0否1是',
          goods_count  int(10)  NULL  COMMENT '产品数量',
          goods_comment_count  int(10)  NULL  COMMENT '产品评论数量',
          logo   varchar(255)  NULL  COMMENT '品牌logo',
          big_pic   varchar(255)  NULL  COMMENT '专区大图',
          brand_story   varchar(255)  NULL  COMMENT '品牌故事',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='品牌表';
  drop TABLE if exists t_goods_category;
  -- 建表SQL
  CREATE TABLE t_goods_category (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
          parent_id  bigint(20)  NULL  COMMENT '上机分类的编号：0表示一级分类',
          name   varchar(255)  NULL  COMMENT '名称',
          level  int(10)  NULL  COMMENT '分类级别：0->1级；1->2级',
          goods_count  int(10)  NULL  COMMENT '分类下商品数量，统计得到',
          goods_unit   varchar(255)  NULL  COMMENT '单位',
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
  drop TABLE if exists t_goods_full_reduction;
  -- 建表SQL
  CREATE TABLE t_goods_full_reduction (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
          goods_id  bigint(20)  NULL  COMMENT '商品id',
          full_price  DECIMAL    NULL  COMMENT '满价减价格',
          reduce_price  DECIMAL    NULL  COMMENT '减免价格',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='产品满减表(只针对同商品)';
  drop TABLE if exists t_goods_ladder;
  -- 建表SQL
  CREATE TABLE t_goods_ladder (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
          goods_id  bigint(20)  NULL  COMMENT '商品id',
          count  bigint(20)  NULL  COMMENT '满足的商品数量',
          discount  DECIMAL    NULL  COMMENT '折扣',
          price  DECIMAL    NULL  COMMENT '折后价格',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='产品阶梯价格表(只针对同商品)';
  drop TABLE if exists t_member_price;
  -- 建表SQL
  CREATE TABLE t_member_price (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
          goods_id  bigint(20)  NULL  COMMENT '商品id',
          member_level_id  bigint(20)  NULL  COMMENT '会员等级id',
          member_price  DECIMAL    NULL  COMMENT '会员价格',
          member_level_name   varchar(255)  NULL  COMMENT '会员等级全称',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品会员价格表';
  drop TABLE if exists t_sku_stock;
  -- 建表SQL
  CREATE TABLE t_sku_stock (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
          goods_id  bigint(20)  NULL  COMMENT '商品id',
          sku_code   varchar(255)  NULL  COMMENT 'sku编码',
          price  DECIMAL    NULL  COMMENT '价格',
          stock  int(10)  NULL  COMMENT '库存',
          low_stock  int(10)  NULL  COMMENT '预警库存',
          sp1   varchar(255)  NULL  COMMENT '销售属性1',
          sp2   varchar(255)  NULL  COMMENT '销售属性2',
          sp3   varchar(255)  NULL  COMMENT '销售属性3',
          pic   varchar(255)  NULL  COMMENT '展示图片',
          sale  int(10)  NULL  COMMENT '销量',
          promotion_price  DECIMAL    NULL  COMMENT '单品促销价格',
          lock_stock  int(10)  NULL  COMMENT '锁定库存',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='SKU的库存';
