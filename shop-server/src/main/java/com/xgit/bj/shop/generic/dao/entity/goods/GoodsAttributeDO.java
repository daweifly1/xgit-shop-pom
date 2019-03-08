package com.xgit.bj.shop.generic.dao.entity.goods;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品属性参数表 DO
 */
@Data
@ToString
public class GoodsAttributeDO  implements Serializable{
    private static final long serialVersionUID = -1L;
    //主键
    private Long id;
    //产品属性分类ID
    private Long productAttributeCategoryId;
    //名称
    private String name;
    //属性选择类型：0->唯一；1->单选；2->多选
    private Integer selectType;
    //属性录入方式：0->手工录入；1->从列表中选取
    private Integer inputType;
    //可选值列表，以逗号隔开
    private String inputList;
    //排序字段：最高的可以单独上传图片
    private Integer sort;
    //分类筛选样式：1->普通；1->颜色
    private Integer filterType;
    //检索类型；0->不需要进行检索；1->关键字检索；2->范围检索
    private Integer searchType;
    //相同属性产品是否关联；0->不关联；1->关联
    private Integer relatedStatus;
    //是否支持手动新增；0->不支持；1->支持
    private Integer handAddStatus;
    //属性的类型；0->规格；1->参数
    private Integer type;
    //创建人
    private String dbCreateAuthor;
    //创建时间
    private Date dbCreateTime;
    //更新人
    private String dbUpdateAuthor;
    //更新时间
    private Date dbUpdateTime;

}
