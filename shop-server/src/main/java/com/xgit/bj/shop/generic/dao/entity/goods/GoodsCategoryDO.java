package com.xgit.bj.shop.generic.dao.entity.goods;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品类目信息信息表 DO
 */
@Data
@ToString
public class GoodsCategoryDO  implements Serializable{
    private static final long serialVersionUID = -1L;
    //主键
    private Long id;
    //上机分类的编号：0表示一级分类
    private Long parentId;
    //名称
    private String name;
    //分类级别：0->1级；1->2级
    private Integer level;
    //分类下商品数量，统计得到
    private Integer productCount;
    //单位
    private String productUnit;
    //是否显示在导航栏：0->不显示；1->显示
    private Integer navStatus;
    //显示状态：0->不显示；1->显示
    private Integer showStatus;
    //排序
    private Long sort;
    //图标
    private String icon;
    //关键词
    private String keywords;
    //描述
    private String description;
    //创建人
    private String dbCreateAuthor;
    //创建时间
    private Date dbCreateTime;
    //更新人
    private String dbUpdateAuthor;
    //更新时间
    private Date dbUpdateTime;

}
