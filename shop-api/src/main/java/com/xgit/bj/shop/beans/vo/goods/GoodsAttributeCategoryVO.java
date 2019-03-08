package com.xgit.bj.shop.beans.vo.goods;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 产品属性分类表 VO类
 */
@Data
@ToString
public class GoodsAttributeCategoryVO  implements Serializable{
    private static final long serialVersionUID = -1L;
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "属性数量")
    private Integer attributeCount;
    @ApiModelProperty(value = "参数数量")
    private Integer paramCount;
    @ApiModelProperty(value = "创建人")
    private String dbCreateAuthor;
    @ApiModelProperty(value = "创建时间")
    private Date dbCreateTime;
    @ApiModelProperty(value = "更新人")
    private String dbUpdateAuthor;
    @ApiModelProperty(value = "更新时间")
    private Date dbUpdateTime;
}
