package com.xgit.bj.shop.generic.dao.entity.goods;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品满减表(只针对同商品) DO
 */
@Data
@ToString
public class GoodsFullReductionDO  implements Serializable{
    private static final long serialVersionUID = -1L;
    //pk
    private Long id;
    //商品id
    private Long goodsId;
    //满价减价格
    private BigDecimal fullPrice;
    //减免价格
    private BigDecimal reducePrice;
    //创建人
    private String dbCreateAuthor;
    //创建时间
    private Date dbCreateTime;
    //更新人
    private String dbUpdateAuthor;
    //更新时间
    private Date dbUpdateTime;

}
