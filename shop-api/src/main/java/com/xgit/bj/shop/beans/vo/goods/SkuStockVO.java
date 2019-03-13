package com.xgit.bj.shop.beans.vo.goods;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
/**
 * SKU的库存 VO类
 */
@Data
@ToString
public class SkuStockVO  implements Serializable{
    private static final long serialVersionUID = -1L;
    @ApiModelProperty(value = "pk")
    private Long id;
    @ApiModelProperty(value = "商品id")
    private Long goodsId;
    @ApiModelProperty(value = "sku编码")
    private String skuCode;
    @ApiModelProperty(value = "价格")
    private BigDecimal price;
    @ApiModelProperty(value = "库存")
    private Integer stock;
    @ApiModelProperty(value = "预警库存")
    private Integer lowStock;
    @ApiModelProperty(value = "销售属性1")
    private String sp1;
    @ApiModelProperty(value = "销售属性2")
    private String sp2;
    @ApiModelProperty(value = "销售属性3")
    private String sp3;
    @ApiModelProperty(value = "展示图片")
    private String pic;
    @ApiModelProperty(value = "销量")
    private Integer sale;
    @ApiModelProperty(value = "单品促销价格")
    private BigDecimal promotionPrice;
    @ApiModelProperty(value = "锁定库存")
    private Integer lockStock;
    @ApiModelProperty(value = "创建人")
    private String dbCreateAuthor;
    @ApiModelProperty(value = "创建时间")
    private Date dbCreateTime;
    @ApiModelProperty(value = "更新人")
    private String dbUpdateAuthor;
    @ApiModelProperty(value = "更新时间")
    private Date dbUpdateTime;
}
