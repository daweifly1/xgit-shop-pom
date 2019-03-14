/*
MySQL Backup
Source Server Version: 5.5.5
Source Database: mall-m
Date: 2019/3/14 17:33:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `t_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `brand_id` bigint(20) DEFAULT NULL COMMENT '品牌ID',
  `goods_category_id` bigint(20) DEFAULT NULL COMMENT '类目id',
  `feight_template_id` bigint(20) DEFAULT NULL COMMENT '运费模板',
  `goods_attribute_category_id` bigint(20) DEFAULT NULL COMMENT '属性分类id',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `goods_sn` varchar(255) DEFAULT NULL COMMENT '货号',
  `delete_status` int(10) DEFAULT NULL COMMENT '删除状态：0->未删除；1->已删除',
  `publish_status` int(10) DEFAULT NULL COMMENT '上架状态：0->下架；1->上架',
  `new_status` int(10) DEFAULT NULL COMMENT '新品状态:0->不是新品；1->新品',
  `recommand_status` int(10) DEFAULT NULL COMMENT '推荐状态；0->不推荐；1->推荐',
  `verify_status` int(10) DEFAULT NULL COMMENT '审核状态：0->未审核；1->审核通过',
  `sort` bigint(20) DEFAULT NULL COMMENT '排序',
  `sale` int(10) DEFAULT NULL COMMENT '销量',
  `price` decimal(10,0) DEFAULT NULL COMMENT '价格',
  `promotion_price` bigint(20) DEFAULT NULL COMMENT '促销价格',
  `gift_growth` int(10) DEFAULT NULL COMMENT '赠送的成长值',
  `gift_point` int(10) DEFAULT NULL COMMENT '赠送的积分',
  `use_point_limit` int(10) DEFAULT NULL COMMENT '限制使用的积分数',
  `sub_title` varchar(255) DEFAULT NULL COMMENT '副标题',
  `description` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `original_price` bigint(20) DEFAULT NULL COMMENT '市场价',
  `stock` int(10) DEFAULT NULL COMMENT '库存',
  `low_stock` int(10) DEFAULT NULL COMMENT '库存预警值',
  `unit` varchar(255) DEFAULT NULL COMMENT '单位',
  `weight` bigint(20) DEFAULT NULL COMMENT '商品重量，默认为克',
  `preview_status` int(10) DEFAULT NULL COMMENT '是否为预告商品：0->不是；1->是',
  `service_ids` varchar(255) DEFAULT NULL COMMENT '以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮',
  `keywords` varchar(255) DEFAULT NULL COMMENT '关键词',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `album_pics` varchar(255) DEFAULT NULL COMMENT '画册图片，连产品图片限制为5张，以逗号分割',
  `detail_title` varchar(255) DEFAULT NULL COMMENT '详细标题',
  `detail_desc` varchar(255) DEFAULT NULL COMMENT '详情描述',
  `detail_html` varchar(255) DEFAULT NULL COMMENT '产品详情网页内容',
  `detail_mobile_html` varchar(255) DEFAULT NULL COMMENT '移动端网页详情',
  `promotion_start_time` timestamp NULL DEFAULT NULL COMMENT '促销开始时间',
  `promotion_end_time` timestamp NULL DEFAULT NULL COMMENT '促销结束时间',
  `promotion_per_limit` int(10) DEFAULT NULL COMMENT '活动限购数量',
  `promotion_type` int(10) DEFAULT NULL COMMENT '促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购',
  `brand_name` varchar(255) DEFAULT NULL COMMENT '品牌名称',
  `goods_category_name` varchar(255) DEFAULT NULL COMMENT '商品分类名称',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='商品信息';

-- ----------------------------
--  Table structure for `t_goods_attribute`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_attribute`;
CREATE TABLE `t_goods_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_attribute_category_id` bigint(20) DEFAULT NULL COMMENT '产品属性分类ID',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `select_type` int(10) DEFAULT NULL COMMENT '属性选择类型：0->唯一；1->单选；2->多选',
  `input_type` int(10) DEFAULT NULL COMMENT '属性录入方式：0->手工录入；1->从列表中选取',
  `input_list` varchar(255) DEFAULT NULL COMMENT '可选值列表，以逗号隔开',
  `sort` int(10) DEFAULT NULL COMMENT '排序字段：最高的可以单独上传图片',
  `filter_type` int(10) DEFAULT NULL COMMENT '分类筛选样式：0->普通；1->颜色',
  `search_type` int(10) DEFAULT NULL COMMENT '检索类型；0->不需要进行检索；1->关键字检索；2->范围检索',
  `related_status` int(10) DEFAULT NULL COMMENT '相同属性产品是否关联；0->不关联；1->关联',
  `hand_add_status` int(10) DEFAULT NULL COMMENT '是否支持手动新增；0->不支持；1->支持',
  `type` int(10) DEFAULT NULL COMMENT '属性的类型；0->规格；1->参数',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='商品属性参数表';

-- ----------------------------
--  Table structure for `t_goods_attribute_category`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_attribute_category`;
CREATE TABLE `t_goods_attribute_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `attribute_count` int(10) DEFAULT NULL COMMENT '属性数量',
  `param_count` int(10) DEFAULT NULL COMMENT '参数数量',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='产品属性分类表';

-- ----------------------------
--  Table structure for `t_goods_attribute_img`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_attribute_img`;
CREATE TABLE `t_goods_attribute_img` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '产品属性分类ID',
  `color` varchar(255) DEFAULT NULL COMMENT '颜色属性',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8mb4 COMMENT='商品颜色属性图片';

-- ----------------------------
--  Table structure for `t_goods_attribute_value`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_attribute_value`;
CREATE TABLE `t_goods_attribute_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品id',
  `goods_attribute_id` bigint(20) DEFAULT NULL COMMENT '商品属性id',
  `goods_attribute_category_name` varchar(255) DEFAULT NULL COMMENT '产品属性分类名称',
  `value` varchar(255) DEFAULT NULL COMMENT '手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='存储产品参数信息的表';

-- ----------------------------
--  Table structure for `t_goods_brand`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_brand`;
CREATE TABLE `t_goods_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '品牌名称',
  `first_letter` varchar(255) DEFAULT NULL COMMENT '首字母',
  `sort` bigint(20) DEFAULT NULL COMMENT '排序',
  `factory_status` int(10) DEFAULT NULL COMMENT '是否为品牌制造商：0->不是；1->是',
  `show_status` int(10) DEFAULT NULL COMMENT '展示状态，0否1是',
  `goods_count` int(10) DEFAULT NULL COMMENT '产品数量',
  `goods_comment_count` int(10) DEFAULT NULL COMMENT '产品评论数量',
  `logo` varchar(255) DEFAULT NULL COMMENT '品牌logo',
  `big_pic` varchar(255) DEFAULT NULL COMMENT '专区大图',
  `brand_story` varchar(255) DEFAULT NULL COMMENT '品牌故事',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='品牌表';

-- ----------------------------
--  Table structure for `t_goods_category`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_category`;
CREATE TABLE `t_goods_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上机分类的编号：0表示一级分类',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `level` int(10) DEFAULT NULL COMMENT '分类级别：0->1级；1->2级',
  `goods_count` int(10) DEFAULT NULL COMMENT '分类下商品数量，统计得到',
  `goods_unit` varchar(255) DEFAULT NULL COMMENT '单位',
  `nav_status` int(10) DEFAULT NULL COMMENT '是否显示在导航栏：0->不显示；1->显示',
  `show_status` int(10) DEFAULT NULL COMMENT '显示状态：0->不显示；1->显示',
  `sort` bigint(20) DEFAULT NULL COMMENT '排序',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `keywords` varchar(255) DEFAULT NULL COMMENT '关键词',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='商品类目信息信息表';

-- ----------------------------
--  Table structure for `t_goods_full_reduction`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_full_reduction`;
CREATE TABLE `t_goods_full_reduction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品id',
  `full_price` decimal(10,0) DEFAULT NULL COMMENT '满价减价格',
  `reduce_price` decimal(10,0) DEFAULT NULL COMMENT '减免价格',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='产品满减表(只针对同商品)';

-- ----------------------------
--  Table structure for `t_goods_ladder`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_ladder`;
CREATE TABLE `t_goods_ladder` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品id',
  `count` bigint(20) DEFAULT NULL COMMENT '满足的商品数量',
  `discount` decimal(10,0) DEFAULT NULL COMMENT '折扣',
  `price` decimal(10,0) DEFAULT NULL COMMENT '折后价格',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='产品阶梯价格表(只针对同商品)';

-- ----------------------------
--  Table structure for `t_member_price`
-- ----------------------------
DROP TABLE IF EXISTS `t_member_price`;
CREATE TABLE `t_member_price` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品id',
  `member_level_id` bigint(20) DEFAULT NULL COMMENT '会员等级id',
  `member_price` decimal(10,0) DEFAULT NULL COMMENT '会员价格',
  `member_level_name` varchar(255) DEFAULT NULL COMMENT '会员等级全称',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品会员价格表';

-- ----------------------------
--  Table structure for `t_sku_stock`
-- ----------------------------
DROP TABLE IF EXISTS `t_sku_stock`;
CREATE TABLE `t_sku_stock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品id',
  `sku_code` varchar(255) DEFAULT NULL COMMENT 'sku编码',
  `price` decimal(10,0) DEFAULT NULL COMMENT '价格',
  `stock` int(10) DEFAULT NULL COMMENT '库存',
  `low_stock` int(10) DEFAULT NULL COMMENT '预警库存',
  `sp1` varchar(255) DEFAULT NULL COMMENT '销售属性1',
  `sp2` varchar(255) DEFAULT NULL COMMENT '销售属性2',
  `sp3` varchar(255) DEFAULT NULL COMMENT '销售属性3',
  `pic` varchar(255) DEFAULT NULL COMMENT '展示图片',
  `sale` int(10) DEFAULT NULL COMMENT '销量',
  `promotion_price` decimal(10,0) DEFAULT NULL COMMENT '单品促销价格',
  `lock_stock` int(10) DEFAULT NULL COMMENT '锁定库存',
  `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
  `db_create_time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
  `db_update_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COMMENT='SKU的库存';

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `t_goods` VALUES ('1','1','1',NULL,'1','压缩机','2019/3/14/290788877113753600.png','1',NULL,'1','1','1',NULL,'1',NULL,'10000000',NULL,'1','1','1','压缩机','1','12000000','120',NULL,'台','100000000000','1','1','压缩机','压缩机',NULL,'压缩机','压缩机','<p>pc</p>','<p>h5</p>',NULL,NULL,NULL,NULL,NULL,NULL,'chendawei','2019-03-13 17:41:34','chendawei','2019-03-13 17:41:34'), ('2','1','1',NULL,'1','离心机','2019/3/13/290568370158305280.png','1',NULL,'1','1','1',NULL,'3',NULL,'1000000',NULL,'1','1','1','离心机','离心机','1300000','100',NULL,'台','10000000000','1','1','1','离心机',NULL,'1','1','<p>pcccccccccccccc</p>','<p>hh5</p>',NULL,NULL,NULL,NULL,NULL,NULL,'chendawei','2019-03-13 19:35:06',NULL,'2019-03-13 19:35:06'), ('3','1','1',NULL,'1','波音737 MAX','2019/3/14/290789406564941824.jpg','3',NULL,'1','1','1',NULL,'3',NULL,'10',NULL,'1','1','1','波音737 MAX','波音737 MAX','12','100',NULL,'架','20000000000','1','1','波音737 MAX','波音737 MAX',NULL,'波音737 MAX','波音737 MAX','<p>ppp</p>','<p>555</p>',NULL,NULL,NULL,NULL,NULL,NULL,'chendawei','2019-03-14 10:13:17',NULL,'2019-03-14 10:13:17'), ('4','1','1',NULL,'2','华为牛逼','2019/3/14/290790786771976192.jpg','4',NULL,'1','1','1',NULL,'4',NULL,'100000000',NULL,'1','1','1','1','华为牛逼','120000000','12',NULL,'部','200','1','1','华为牛逼','华为牛逼',NULL,'华为牛逼','华为牛逼','<p>ppp</p>','<p>ccc</p>',NULL,NULL,NULL,NULL,NULL,NULL,'chendawei','2019-03-14 10:19:27',NULL,'2019-03-14 10:19:27');
INSERT INTO `t_goods_attribute` VALUES ('1','1','颜色','2','1','红,橙,黄,绿,黑,白','1','1','1','1','0','0','chendawei','2019-03-13 16:18:56',NULL,'2019-03-13 16:18:56'), ('2','1','尺寸','2','1','20T,40T,80T','2','0','0','0','0','0','chendawei','2019-03-13 16:22:57',NULL,'2019-03-13 16:22:57'), ('3','2','颜色','2','1','红,白,黑,银,玫瑰金,宝石蓝','1','1','1','1','0','0','chendawei','2019-03-14 10:17:03',NULL,'2019-03-14 10:17:03'), ('4','2','尺寸','2','1','5,6,7,8','1','0','1','1','0','0','chendawei','2019-03-14 10:17:56',NULL,'2019-03-14 10:17:56');
INSERT INTO `t_goods_attribute_category` VALUES ('1','设备',NULL,NULL,'chendawei','2019-03-13 16:17:26',NULL,'2019-03-13 16:17:26'), ('2','数码',NULL,NULL,'chendawei','2019-03-14 10:15:41',NULL,'2019-03-14 10:15:41');
INSERT INTO `t_goods_attribute_img` VALUES ('67','2','红','2019/3/13/290568370158305280.png','chendawei','2019-03-13 19:35:06',NULL,'2019-03-13 19:35:06'), ('68','2','橙','2019/3/13/290568391385677824.png','chendawei','2019-03-13 19:35:06',NULL,'2019-03-13 19:35:06'), ('69','2','黄',NULL,'chendawei','2019-03-13 19:35:06',NULL,'2019-03-13 19:35:06'), ('70','2','绿',NULL,'chendawei','2019-03-13 19:35:06',NULL,'2019-03-13 19:35:06'), ('71','2','黑',NULL,'chendawei','2019-03-13 19:35:06',NULL,'2019-03-13 19:35:06'), ('72','2','白',NULL,'chendawei','2019-03-13 19:35:06',NULL,'2019-03-13 19:35:06'), ('139','1','红',NULL,'chendawei','2019-03-14 10:11:04',NULL,'2019-03-14 10:11:04'), ('140','1','橙','2019/3/14/290788877113753600.png','chendawei','2019-03-14 10:11:04',NULL,'2019-03-14 10:11:04'), ('141','1','黄','2019/3/14/290770234409746432.png','chendawei','2019-03-14 10:11:04',NULL,'2019-03-14 10:11:04'), ('142','1','绿','2019/3/13/290561337715589120.png','chendawei','2019-03-14 10:11:04',NULL,'2019-03-14 10:11:04'), ('143','1','黑','2019/3/13/290559505178034176.png','chendawei','2019-03-14 10:11:04',NULL,'2019-03-14 10:11:04'), ('144','1','白','2019/3/13/290561204651294720.jpg','chendawei','2019-03-14 10:11:04',NULL,'2019-03-14 10:11:04'), ('145','3','红',NULL,'chendawei','2019-03-14 10:13:18',NULL,'2019-03-14 10:13:18'), ('146','3','橙',NULL,'chendawei','2019-03-14 10:13:18',NULL,'2019-03-14 10:13:18'), ('147','3','黄',NULL,'chendawei','2019-03-14 10:13:18',NULL,'2019-03-14 10:13:18'), ('148','3','绿',NULL,'chendawei','2019-03-14 10:13:18',NULL,'2019-03-14 10:13:18'), ('149','3','黑',NULL,'chendawei','2019-03-14 10:13:18',NULL,'2019-03-14 10:13:18'), ('150','3','白','2019/3/14/290789406564941824.jpg','chendawei','2019-03-14 10:13:18',NULL,'2019-03-14 10:13:18'), ('151','4','红','2019/3/14/290790786771976192.jpg','chendawei','2019-03-14 10:19:27',NULL,'2019-03-14 10:19:27'), ('152','4','白','2019/3/14/290790809521881088.jpg','chendawei','2019-03-14 10:19:27',NULL,'2019-03-14 10:19:27'), ('153','4','黑','2019/3/14/290790823744765952.png','chendawei','2019-03-14 10:19:27',NULL,'2019-03-14 10:19:27'), ('154','4','银','2019/3/14/290790836944240640.jpg','chendawei','2019-03-14 10:19:27',NULL,'2019-03-14 10:19:27'), ('155','4','玫瑰金','2019/3/14/290790903570759680.jpg','chendawei','2019-03-14 10:19:27',NULL,'2019-03-14 10:19:27'), ('156','4','宝石蓝','2019/3/14/290790922302521344.png','chendawei','2019-03-14 10:19:27',NULL,'2019-03-14 10:19:27');
INSERT INTO `t_goods_category` VALUES ('1','0','设备','0',NULL,'台','1','1','1','2019/3/13/290517010654167040.jpg','设备','设备','chendawei','2019-03-13 16:10:51',NULL,'2019-03-13 16:11:50'), ('2','0','建材','0',NULL,'批','1','1','2','2019/3/13/290517799502086144.jpg','建材','建材','chendawei','2019-03-13 16:13:55',NULL,'2019-03-13 16:13:55'), ('3','1','设备-01','1',NULL,'台','1','1','3','2019/3/13/290517931089985536.jpg','设备-01','设备-01','chendawei','2019-03-13 16:14:28',NULL,'2019-03-13 16:15:28'), ('4','1','设备-02','1',NULL,'台','1','1','4','','设备-02','设备-02','chendawei','2019-03-13 16:15:55',NULL,'2019-03-13 16:15:55'), ('5','2','建材-01','1',NULL,'批','1','1','5',NULL,'建材-01','建材-01','chendawei','2019-03-13 16:16:19','chendawei','2019-03-13 16:16:19'), ('6','2','建材-02','1',NULL,'批','0','1','6',NULL,'建材-02','建材-02','chendawei','2019-03-13 16:16:37','chendawei','2019-03-13 16:16:37');
INSERT INTO `t_sku_stock` VALUES ('9','2','0','1000000','25','0','红','20T',NULL,'2019/3/13/290568370158305280.png',NULL,NULL,NULL,'chendawei','2019-03-13 19:35:06',NULL,'2019-03-13 19:35:06'), ('10','2','1','1000000','25','0','红','40T',NULL,'2019/3/13/290568370158305280.png',NULL,NULL,NULL,'chendawei','2019-03-13 19:35:06',NULL,'2019-03-13 19:35:06'), ('11','2','2','1000000','25','0','橙','20T',NULL,'2019/3/13/290568391385677824.png',NULL,NULL,NULL,'chendawei','2019-03-13 19:35:06',NULL,'2019-03-13 19:35:06'), ('12','2','3','1000000','25','0','橙','40T',NULL,'2019/3/13/290568391385677824.png',NULL,NULL,NULL,'chendawei','2019-03-13 19:35:06',NULL,'2019-03-13 19:35:06'), ('13','1','0','10000000','30','0','黄','40T',NULL,'2019/3/14/290770234409746432.png',NULL,NULL,NULL,'chendawei','2019-03-14 08:57:01',NULL,'2019-03-14 08:57:01'), ('14','1','1','10000000','30','0','黄','80T',NULL,'2019/3/14/290770234409746432.png',NULL,NULL,NULL,'chendawei','2019-03-14 08:57:01',NULL,'2019-03-14 08:57:01'), ('15','1','2','10000000','30','0','绿','40T',NULL,'2019/3/13/290561337715589120.png',NULL,NULL,NULL,'chendawei','2019-03-14 08:57:01',NULL,'2019-03-14 08:57:01'), ('16','1','3','10000000','30','0','绿','80T',NULL,'2019/3/13/290561337715589120.png',NULL,NULL,NULL,'chendawei','2019-03-14 08:57:01',NULL,'2019-03-14 08:57:01'), ('17','3','0','10','100','0','白','80T',NULL,'2019/3/14/290789406564941824.jpg',NULL,NULL,NULL,'chendawei','2019-03-14 10:13:18',NULL,'2019-03-14 10:13:18'), ('18','4','0','100000000','1','0','红','5',NULL,'2019/3/14/290790786771976192.jpg',NULL,NULL,NULL,'chendawei','2019-03-14 10:19:27',NULL,'2019-03-14 10:19:27'), ('19','4','1','100000000','1','0','红','6',NULL,'2019/3/14/290790786771976192.jpg',NULL,NULL,NULL,'chendawei','2019-03-14 10:19:27',NULL,'2019-03-14 10:19:27'), ('20','4','2','100000000','1','0','白','5',NULL,'2019/3/14/290790809521881088.jpg',NULL,NULL,NULL,'chendawei','2019-03-14 10:19:27',NULL,'2019-03-14 10:19:27'), ('21','4','3','100000000','1','0','白','6',NULL,'2019/3/14/290790809521881088.jpg',NULL,NULL,NULL,'chendawei','2019-03-14 10:19:27',NULL,'2019-03-14 10:19:27'), ('22','4','4','100000000','1','0','黑','5',NULL,'2019/3/14/290790823744765952.png',NULL,NULL,NULL,'chendawei','2019-03-14 10:19:27',NULL,'2019-03-14 10:19:27'), ('23','4','5','100000000','1','0','黑','6',NULL,'2019/3/14/290790823744765952.png',NULL,NULL,NULL,'chendawei','2019-03-14 10:19:27',NULL,'2019-03-14 10:19:27'), ('24','4','6','100000000','1','0','银','5',NULL,'2019/3/14/290790836944240640.jpg',NULL,NULL,NULL,'chendawei','2019-03-14 10:19:27',NULL,'2019-03-14 10:19:27'), ('25','4','7','100000000','1','0','银','6',NULL,'2019/3/14/290790836944240640.jpg',NULL,NULL,NULL,'chendawei','2019-03-14 10:19:27',NULL,'2019-03-14 10:19:27'), ('26','4','8','100000000','1','0','玫瑰金','5',NULL,'2019/3/14/290790903570759680.jpg',NULL,NULL,NULL,'chendawei','2019-03-14 10:19:27',NULL,'2019-03-14 10:19:27'), ('27','4','9','100000000','1','0','玫瑰金','6',NULL,'2019/3/14/290790903570759680.jpg',NULL,NULL,NULL,'chendawei','2019-03-14 10:19:27',NULL,'2019-03-14 10:19:27'), ('28','4','10','100000000','1','0','宝石蓝','5',NULL,'2019/3/14/290790922302521344.png',NULL,NULL,NULL,'chendawei','2019-03-14 10:19:27',NULL,'2019-03-14 10:19:27'), ('29','4','11','100000000','1','0','宝石蓝','6',NULL,'2019/3/14/290790922302521344.png',NULL,NULL,NULL,'chendawei','2019-03-14 10:19:27',NULL,'2019-03-14 10:19:27');
