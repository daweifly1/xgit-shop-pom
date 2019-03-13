package com.xgit.bj.shop.generic.facade.goods;

import com.xgit.bj.auth.service.VO.sys.SysAccountVO;
import com.xgit.bj.common.util.BeanUtil;
import com.xgit.bj.shop.beans.param.goods.GoodsParam;
import com.xgit.bj.shop.beans.vo.goods.GoodsAttributeImgVO;
import com.xgit.bj.shop.beans.vo.goods.SkuStockVO;
import com.xgit.bj.shop.framework.consts.ErrorCode;
import com.xgit.bj.shop.generic.dao.entity.goods.GoodsDO;
import com.xgit.bj.shop.generic.service.goods.GoodsAttributeImgService;
import com.xgit.bj.shop.generic.service.goods.GoodsService;
import com.xgit.bj.shop.generic.service.goods.SkuStockService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Goods 后台组合service的实现类
 */
@Slf4j
@Service
public class GoodsFacade {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private SkuStockService skuStockService;

    @Autowired
    private GoodsAttributeImgService goodsAttributeImgService;

    @Transactional
    public ErrorCode save(GoodsParam goodsParam, SysAccountVO sysAccountVO) {
        //先删除sku信息
        if (CollectionUtils.isNotEmpty(goodsParam.getSkuStockList())) {
            if (null != goodsParam.getId()) {
                skuStockService.deleteByGoodsId(goodsParam.getId());
            }
        }
        if (CollectionUtils.isNotEmpty(goodsParam.getGoodsAttributeImgs())) {
            if (null != goodsParam.getId()) {
                goodsAttributeImgService.deleteByGoodsId(goodsParam.getId());
            }
        }
        ErrorCode code = goodsService.save(goodsParam, sysAccountVO);
        if (code == ErrorCode.Success) {
            if (CollectionUtils.isNotEmpty(goodsParam.getSkuStockList())) {
                for (SkuStockVO vo : goodsParam.getSkuStockList()) {
                    vo.setGoodsId(goodsParam.getId());
                    vo.setDbCreateAuthor(sysAccountVO.getLoginName());
                }
                skuStockService.batchInsert(goodsParam.getSkuStockList());
            }

            if (CollectionUtils.isNotEmpty(goodsParam.getGoodsAttributeImgs())) {
                for (GoodsAttributeImgVO vo : goodsParam.getGoodsAttributeImgs()) {
                    vo.setGoodsId(goodsParam.getId());
                    vo.setDbCreateAuthor(sysAccountVO.getLoginName());
                }
                goodsAttributeImgService.batchInsert(goodsParam.getGoodsAttributeImgs());
            }
        }
        return code;
    }

    public GoodsParam item(Long id) {
        GoodsDO goodsDo = goodsService.queryById(id);
        if (null != goodsDo) {
            GoodsParam result = BeanUtil.do2bo(goodsDo, GoodsParam.class);
            List<SkuStockVO> ll = skuStockService.queryListByGoodsId(id);
            result.setSkuStockList(ll);

            List<GoodsAttributeImgVO> imgs = goodsAttributeImgService.queryListByGoodsId(id);
            result.setGoodsAttributeImgs(imgs);
        }
        return null;
    }
}
