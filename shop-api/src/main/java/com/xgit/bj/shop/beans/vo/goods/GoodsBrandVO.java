package com.xgit.bj.shop.beans.vo.goods;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 品牌表 VO类
 */
@Data
@ToString
public class GoodsBrandVO  implements Serializable{
    private static final long serialVersionUID = -1L;
    @ApiModelProperty(value = "pk")
    private Long id;
    @ApiModelProperty(value = "品牌名称")
    private String name;
    @ApiModelProperty(value = "首字母")
    private String firstLetter;
    @ApiModelProperty(value = "排序")
    private Long sort;
    @ApiModelProperty(value = "是否为品牌制造商：0->不是；1->是")
    private Integer factoryStatus;
    @ApiModelProperty(value = "展示状态，0否1是")
    private Integer showStatus;
    @ApiModelProperty(value = "产品数量")
    private Integer goodsCount;
    @ApiModelProperty(value = "产品评论数量")
    private Integer goodsCommentCount;
    @ApiModelProperty(value = "品牌logo")
    private String logo;
    @ApiModelProperty(value = "专区大图")
    private String bigPic;
    @ApiModelProperty(value = "品牌故事")
    private String brandStory;
    @ApiModelProperty(value = "创建人")
    private String dbCreateAuthor;
    @ApiModelProperty(value = "创建时间")
    private Date dbCreateTime;
    @ApiModelProperty(value = "更新人")
    private String dbUpdateAuthor;
    @ApiModelProperty(value = "更新时间")
    private Date dbUpdateTime;
}
