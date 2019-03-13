package com.xgit.bj.shop.beans.param.goods;

import com.xgit.bj.shop.beans.vo.goods.GoodsAttributeImgVO;
import com.xgit.bj.shop.beans.vo.goods.GoodsAttributeValueVO;
import com.xgit.bj.shop.beans.vo.goods.GoodsFullReductionVO;
import com.xgit.bj.shop.beans.vo.goods.GoodsLadderVO;
import com.xgit.bj.shop.beans.vo.goods.GoodsVO;
import com.xgit.bj.shop.beans.vo.goods.MemberPriceVO;
import com.xgit.bj.shop.beans.vo.goods.SkuStockVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class GoodsParam extends GoodsVO {
    @ApiModelProperty("商品的sku库存信息")
    private List<SkuStockVO> skuStockList;
    @ApiModelProperty("商品颜色属性对应的图片信息")
    private List<GoodsAttributeImgVO> goodsAttributeImgs;


    @ApiModelProperty("商品阶梯价格设置")
    private List<GoodsLadderVO> productLadderList;
    @ApiModelProperty("商品满减价格设置")
    private List<GoodsFullReductionVO> goodsFullReductionVOList;
    @ApiModelProperty("商品会员价格设置")
    private List<MemberPriceVO> memberPriceList;
    @ApiModelProperty("商品参数及自定义规格属性")
    private List<GoodsAttributeValueVO> goodsAttributeValueVOList;
//    @ApiModelProperty("专题和商品关系")
//    private List<CmsSubjectProductRelation> subjectProductRelationList;
//    @ApiModelProperty("优选专区和商品的关系")
//    private List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList;
}
