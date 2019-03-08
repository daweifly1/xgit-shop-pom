package com.xgit.bj.shop.beans.vo.goods;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品类目信息信息表 VO类
 */
@Data
@ToString
public class GoodsCategoryVO implements Serializable {
    private static final long serialVersionUID = -1L;
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "上级分类的编号：0表示一级分类")
    private Long parentId;
    @ApiModelProperty(value = "上级分类的名称")
    private String parentName;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "分类级别：0->1级；1->2级")
    private Integer level;
    @ApiModelProperty(value = "分类下商品数量，统计得到")
    private Integer productCount;
    @ApiModelProperty(value = "单位")
    private String productUnit;
    @ApiModelProperty(value = "是否显示在导航栏：0->不显示；1->显示")
    private Integer navStatus;
    @ApiModelProperty(value = "显示状态：0->不显示；1->显示")
    private Integer showStatus;
    @ApiModelProperty(value = "排序")
    private Long sort;
    @ApiModelProperty(value = "图标")
    private String icon;
    @ApiModelProperty(value = "关键词")
    private String keywords;
    @ApiModelProperty(value = "描述")
    private String description;
    @ApiModelProperty(value = "创建人")
    private String dbCreateAuthor;
    @ApiModelProperty(value = "创建时间")
    private Date dbCreateTime;
    @ApiModelProperty(value = "更新人")
    private String dbUpdateAuthor;
    @ApiModelProperty(value = "更新时间")
    private Date dbUpdateTime;
}
