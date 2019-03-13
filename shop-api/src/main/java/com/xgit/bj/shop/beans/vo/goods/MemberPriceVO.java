package com.xgit.bj.shop.beans.vo.goods;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 商品会员价格表 VO类
 */
@Data
@ToString
public class MemberPriceVO  implements Serializable{
    private static final long serialVersionUID = -1L;
    @ApiModelProperty(value = "pk")
    private Long id;
    @ApiModelProperty(value = "商品id")
    private Long goodsId;
    @ApiModelProperty(value = "会员等级id")
    private Long memberLevelId;
    @ApiModelProperty(value = "会员价格")
    private BigDecimal memberPrice;
    @ApiModelProperty(value = "会员等级全称")
    private String memberLevelName;
    @ApiModelProperty(value = "创建人")
    private String dbCreateAuthor;
    @ApiModelProperty(value = "创建时间")
    private Date dbCreateTime;
    @ApiModelProperty(value = "更新人")
    private String dbUpdateAuthor;
    @ApiModelProperty(value = "更新时间")
    private Date dbUpdateTime;
}
