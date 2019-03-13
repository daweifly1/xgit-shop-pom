package com.xgit.bj.shop.beans.vo.goods;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 商品颜色属性图片 VO类
 */
@Data
@ToString
public class GoodsAttributeImgVO  implements Serializable{
    private static final long serialVersionUID = -1L;
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "产品属性分类ID")
    private Long goodsId;
    @ApiModelProperty(value = "颜色属性")
    private String color;
    @ApiModelProperty(value = "图片")
    private String pic;
    @ApiModelProperty(value = "创建人")
    private String dbCreateAuthor;
    @ApiModelProperty(value = "创建时间")
    private Date dbCreateTime;
    @ApiModelProperty(value = "更新人")
    private String dbUpdateAuthor;
    @ApiModelProperty(value = "更新时间")
    private Date dbUpdateTime;
}
