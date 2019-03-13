package com.xgit.bj.shop.generic.dao.entity.goods;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 存储产品参数信息的表 DO
 */
@Data
@ToString
public class GoodsAttributeValueDO  implements Serializable{
    private static final long serialVersionUID = -1L;
    //pk
    private Long id;
    //商品id
    private Long goodsId;
    //商品属性id
    private Long goodsAttributeId;
    //产品属性分类名称
    private String goodsAttributeCategoryName;
    //手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开
    private String value;
    //创建人
    private String dbCreateAuthor;
    //创建时间
    private Date dbCreateTime;
    //更新人
    private String dbUpdateAuthor;
    //更新时间
    private Date dbUpdateTime;

}
