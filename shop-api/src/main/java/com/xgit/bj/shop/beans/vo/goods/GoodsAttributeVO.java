package com.xgit.bj.shop.beans.vo.goods;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 商品属性参数表 VO类
 */
@Data
@ToString
public class GoodsAttributeVO  implements Serializable{
    private static final long serialVersionUID = -1L;
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "产品属性分类ID")
    private Long goodsAttributeCategoryId;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "属性选择类型：0->唯一；1->单选；2->多选")
    private Integer selectType;
    @ApiModelProperty(value = "属性录入方式：0->手工录入；1->从列表中选取")
    private Integer inputType;
    @ApiModelProperty(value = "可选值列表，以逗号隔开")
    private String inputList;
    @ApiModelProperty(value = "排序字段：最高的可以单独上传图片")
    private Integer sort;
    @ApiModelProperty(value = "分类筛选样式：0->普通；1->颜色")
    private Integer filterType;
    @ApiModelProperty(value = "检索类型；0->不需要进行检索；1->关键字检索；2->范围检索")
    private Integer searchType;
    @ApiModelProperty(value = "相同属性产品是否关联；0->不关联；1->关联")
    private Integer relatedStatus;
    @ApiModelProperty(value = "是否支持手动新增；0->不支持；1->支持")
    private Integer handAddStatus;
    @ApiModelProperty(value = "属性的类型；0->规格；1->参数")
    private Integer type;
    @ApiModelProperty(value = "创建人")
    private String dbCreateAuthor;
    @ApiModelProperty(value = "创建时间")
    private Date dbCreateTime;
    @ApiModelProperty(value = "更新人")
    private String dbUpdateAuthor;
    @ApiModelProperty(value = "更新时间")
    private Date dbUpdateTime;
}
