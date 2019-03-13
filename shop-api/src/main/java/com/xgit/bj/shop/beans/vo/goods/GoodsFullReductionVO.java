package com.xgit.bj.shop.beans.vo.goods;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 产品满减表(只针对同商品) VO类
 */
@Data
@ToString
public class GoodsFullReductionVO  implements Serializable{
    private static final long serialVersionUID = -1L;
    @ApiModelProperty(value = "pk")
    private Long id;
    @ApiModelProperty(value = "商品id")
    private Long goodsId;
    @ApiModelProperty(value = "满价减价格")
    private BigDecimal fullPrice;
    @ApiModelProperty(value = "减免价格")
    private BigDecimal reducePrice;
    @ApiModelProperty(value = "创建人")
    private String dbCreateAuthor;
    @ApiModelProperty(value = "创建时间")
    private Date dbCreateTime;
    @ApiModelProperty(value = "更新人")
    private String dbUpdateAuthor;
    @ApiModelProperty(value = "更新时间")
    private Date dbUpdateTime;
}
