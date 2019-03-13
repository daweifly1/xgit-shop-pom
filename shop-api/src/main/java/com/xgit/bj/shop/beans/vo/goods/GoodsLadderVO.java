package com.xgit.bj.shop.beans.vo.goods;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 产品阶梯价格表(只针对同商品) VO类
 */
@Data
@ToString
public class GoodsLadderVO  implements Serializable{
    private static final long serialVersionUID = -1L;
    @ApiModelProperty(value = "pk")
    private Long id;
    @ApiModelProperty(value = "商品id")
    private Long goodsId;
    @ApiModelProperty(value = "满足的商品数量")
    private Long count;
    @ApiModelProperty(value = "折扣")
    private BigDecimal discount;
    @ApiModelProperty(value = "折后价格")
    private BigDecimal price;
    @ApiModelProperty(value = "创建人")
    private String dbCreateAuthor;
    @ApiModelProperty(value = "创建时间")
    private Date dbCreateTime;
    @ApiModelProperty(value = "更新人")
    private String dbUpdateAuthor;
    @ApiModelProperty(value = "更新时间")
    private Date dbUpdateTime;
}
