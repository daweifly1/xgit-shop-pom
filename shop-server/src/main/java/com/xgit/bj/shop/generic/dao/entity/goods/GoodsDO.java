package com.xgit.bj.shop.generic.dao.entity.goods;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品信息 DO
 */
@Data
@ToString
public class GoodsDO  implements Serializable{
    private static final long serialVersionUID = -1L;
    //pk
    private Long id;
    //品牌ID
    private Long brandId;
    //类目id
    private Long goodsCategoryId;
    //运费模板
    private Long feightTemplateId;
    //属性分类id
    private Long productAttributeCategoryId;
    //名称
    private String name;
    //图片
    private String pic;
    //货号
    private String goodsSn;
    //删除状态：0->未删除；1->已删除
    private Integer deleteStatus;
    //上架状态：0->下架；1->上架
    private Integer publishStatus;
    //新品状态:0->不是新品；1->新品
    private Integer newStatus;
    //推荐状态；0->不推荐；1->推荐
    private Integer recommandStatus;
    //审核状态：0->未审核；1->审核通过
    private Integer verifyStatus;
    //排序
    private Long sort;
    //销量
    private Integer sale;
    //价格
    private BigDecimal price;
    //促销价格
    private Long promotionPrice;
    //赠送的成长值
    private Integer giftGrowth;
    //赠送的积分
    private Integer giftPoint;
    //限制使用的积分数
    private Integer usePointLimit;
    //副标题
    private String subTitle;
    //商品描述
    private String description;
    //市场价
    private Long originalPrice;
    //库存
    private Integer stock;
    //库存预警值
    private Integer lowStock;
    //单位
    private String unit;
    //商品重量，默认为克
    private Long weight;
    //是否为预告商品：0->不是；1->是
    private Integer previewStatus;
    //以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮
    private String serviceIds;
    //关键词
    private String keywords;
    //备注
    private String note;
    //画册图片，连产品图片限制为5张，以逗号分割
    private String albumPics;
    //详细标题
    private String detailTitle;
    //详情描述
    private String detailDesc;
    //产品详情网页内容
    private String detailHtml;
    //移动端网页详情
    private String detailMobileHtml;
    //促销开始时间
    private Date promotionStartTime;
    //促销结束时间
    private Date promotionEndTime;
    //活动限购数量
    private Integer promotionPerLimit;
    //促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购
    private Integer promotionType;
    //品牌名称
    private String brandName;
    //商品分类名称
    private String productCategoryName;
    //创建人
    private String dbCreateAuthor;
    //创建时间
    private Date dbCreateTime;
    //更新人
    private String dbUpdateAuthor;
    //更新时间
    private Date dbUpdateTime;

}
