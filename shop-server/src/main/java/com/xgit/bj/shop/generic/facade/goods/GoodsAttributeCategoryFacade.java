package com.xgit.bj.shop.generic.facade.goods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xgit.bj.shop.beans.vo.goods.GoodsAttributeCategoryVO;
import com.xgit.bj.shop.generic.service.goods.GoodsAttributeCategoryService;

/**
 * GoodsAttributeCategory 后台组合service的实现类
 */
@Service
public class GoodsAttributeCategoryFacade  {


        private static final Logger logger = LoggerFactory.getLogger(GoodsAttributeCategoryFacade.class);


        @Autowired
        private GoodsAttributeCategoryService goodsAttributeCategoryService;


}
