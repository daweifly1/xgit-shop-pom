package com.xgit.bj.shop.generic.facade.goods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xgit.bj.shop.beans.vo.goods.GoodsFullReductionVO;
import com.xgit.bj.shop.generic.service.goods.GoodsFullReductionService;

/**
 * GoodsFullReduction 后台组合service的实现类
 */
@Service
public class GoodsFullReductionFacade  {


        private static final Logger logger = LoggerFactory.getLogger(GoodsFullReductionFacade.class);


        @Autowired
        private GoodsFullReductionService goodsFullReductionService;


}
