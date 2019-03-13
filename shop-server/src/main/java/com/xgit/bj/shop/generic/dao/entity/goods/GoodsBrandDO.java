package com.xgit.bj.shop.generic.dao.entity.goods;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 品牌表 DO
 */
@Data
@ToString
public class GoodsBrandDO  implements Serializable{
    private static final long serialVersionUID = -1L;
    //pk
    private Long id;
    //品牌名称
    private String name;
    //首字母
    private String firstLetter;
    //排序
    private Long sort;
    //是否为品牌制造商：0->不是；1->是
    private Integer factoryStatus;
    //展示状态，0否1是
    private Integer showStatus;
    //产品数量
    private Integer goodsCount;
    //产品评论数量
    private Integer goodsCommentCount;
    //品牌logo
    private String logo;
    //专区大图
    private String bigPic;
    //品牌故事
    private String brandStory;
    //创建人
    private String dbCreateAuthor;
    //创建时间
    private Date dbCreateTime;
    //更新人
    private String dbUpdateAuthor;
    //更新时间
    private Date dbUpdateTime;

}
