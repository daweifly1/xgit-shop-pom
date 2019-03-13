package com.xgit.bj.shop.generic.dao.entity.goods;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品会员价格表 DO
 */
@Data
@ToString
public class MemberPriceDO  implements Serializable{
    private static final long serialVersionUID = -1L;
    //pk
    private Long id;
    //商品id
    private Long goodsId;
    //会员等级id
    private Long memberLevelId;
    //会员价格
    private BigDecimal memberPrice;
    //会员等级全称
    private String memberLevelName;
    //创建人
    private String dbCreateAuthor;
    //创建时间
    private Date dbCreateTime;
    //更新人
    private String dbUpdateAuthor;
    //更新时间
    private Date dbUpdateTime;

}
