package com.xgit.bj.shop.generic.dao.entity.goods;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * SKU的库存 DO
 */
@Data
@ToString
public class SkuStockDO  implements Serializable{
    private static final long serialVersionUID = -1L;
    //pk
    private Long id;
    //商品id
    private Long goodsId;
    //sku编码
    private String skuCode;
    //价格
    private BigDecimal price;
    //库存
    private Integer stock;
    //预警库存
    private Integer lowStock;
    //销售属性1
    private String sp1;
    //销售属性2
    private String sp2;
    //销售属性3
    private String sp3;
    //展示图片
    private String pic;
    //销量
    private Integer sale;
    //单品促销价格
    private BigDecimal promotionPrice;
    //锁定库存
    private Integer lockStock;
    //创建人
    private String dbCreateAuthor;
    //创建时间
    private Date dbCreateTime;
    //更新人
    private String dbUpdateAuthor;
    //更新时间
    private Date dbUpdateTime;

}
