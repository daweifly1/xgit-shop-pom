package com.xgit.bj.shop.generic.dao.entity.goods;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品属性分类表 DO
 */
@Data
@ToString
public class GoodsAttributeCategoryDO  implements Serializable{
    private static final long serialVersionUID = -1L;
    //主键
    private Long id;
    //名称
    private String name;
    //属性数量
    private Integer attributeCount;
    //参数数量
    private Integer paramCount;
    //创建人
    private String dbCreateAuthor;
    //创建时间
    private Date dbCreateTime;
    //更新人
    private String dbUpdateAuthor;
    //更新时间
    private Date dbUpdateTime;

}
