package com.xgit.bj.shop.generic.facade.goods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xgit.bj.shop.beans.vo.goods.GoodsAttributeVO;
import com.xgit.bj.shop.generic.service.goods.GoodsAttributeService;

/**
 * GoodsAttribute 后台组合service的实现类
 */
@Service
public class GoodsAttributeFacade  {


        private static final Logger logger = LoggerFactory.getLogger(GoodsAttributeFacade.class);


        @Autowired
        private GoodsAttributeService goodsAttributeService;


}
