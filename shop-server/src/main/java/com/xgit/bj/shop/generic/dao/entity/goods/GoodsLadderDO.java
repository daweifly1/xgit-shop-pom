package com.xgit.bj.shop.generic.dao.entity.goods;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品阶梯价格表(只针对同商品) DO
 */
@Data
@ToString
public class GoodsLadderDO  implements Serializable{
    private static final long serialVersionUID = -1L;
    //pk
    private Long id;
    //商品id
    private Long goodsId;
    //满足的商品数量
    private Long count;
    //折扣
    private BigDecimal discount;
    //折后价格
    private BigDecimal price;
    //创建人
    private String dbCreateAuthor;
    //创建时间
    private Date dbCreateTime;
    //更新人
    private String dbUpdateAuthor;
    //更新时间
    private Date dbUpdateTime;

}
