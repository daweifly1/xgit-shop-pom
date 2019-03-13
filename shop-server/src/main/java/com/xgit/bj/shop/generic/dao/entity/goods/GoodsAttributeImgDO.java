package com.xgit.bj.shop.generic.dao.entity.goods;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品颜色属性图片 DO
 */
@Data
@ToString
public class GoodsAttributeImgDO  implements Serializable{
    private static final long serialVersionUID = -1L;
    //主键
    private Long id;
    //产品属性分类ID
    private Long goodsId;
    //颜色属性
    private String color;
    //图片
    private String pic;
    //创建人
    private String dbCreateAuthor;
    //创建时间
    private Date dbCreateTime;
    //更新人
    private String dbUpdateAuthor;
    //更新时间
    private Date dbUpdateTime;

}
