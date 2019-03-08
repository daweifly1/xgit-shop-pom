package com.xgit.bj.shop.beans.vo.goods;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 存储产品参数信息的表 VO类
 */
@Data
@ToString
public class GoodsAttributeValueVO  implements Serializable{
    private static final long serialVersionUID = -1L;
    @ApiModelProperty(value = "pk")
    private Long id;
    @ApiModelProperty(value = "商品id")
    private Long productId;
    @ApiModelProperty(value = "商品属性id")
    private Long productAttributeId;
    @ApiModelProperty(value = "手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开")
    private String value;
    @ApiModelProperty(value = "创建人")
    private String dbCreateAuthor;
    @ApiModelProperty(value = "创建时间")
    private Date dbCreateTime;
    @ApiModelProperty(value = "更新人")
    private String dbUpdateAuthor;
    @ApiModelProperty(value = "更新时间")
    private Date dbUpdateTime;
}
