package com.xgit.bj.shop.web.background.goods;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.xgit.bj.core.rsp.PageCommonVO;
import com.xgit.bj.core.rsp.SearchCommonVO;
import com.xgit.bj.core.rsp.ActionResult;
import com.xgit.bj.shop.web.background.base.BasicController;
import com.xgit.bj.shop.framework.consts.ErrorCode;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xgit.bj.shop.beans.vo.goods.GoodsLadderVO;
import com.xgit.bj.shop.generic.service.goods.GoodsLadderService;
import com.xgit.bj.shop.generic.facade.goods.GoodsLadderFacade;


/**
 * GoodsLadder Controller 实现类
 */
@Api(value = "产品阶梯价格表(只针对同商品)--TODO ")
@RestController
@RequestMapping("/goodsLadder")
public class GoodsLadderController extends BasicController {
        private static final Logger logger = LoggerFactory.getLogger(GoodsLadderController.class);
        @Autowired
        private GoodsLadderService goodsLadderService;

        @Autowired
        private GoodsLadderFacade goodsLadderFacade;

        @RequestMapping(value = "/list", method = RequestMethod.POST)
        @ApiOperation(value = "产品阶梯价格表(只针对同商品)分页列表信息")
        public ActionResult<PageInfo<GoodsLadderVO>> list(@RequestBody SearchCommonVO<GoodsLadderVO> condition) {
                PageCommonVO<GoodsLadderVO> pageCommonVO = goodsLadderService.list(condition);
                return actionResult(pageCommonVO.getPageInfo());
        }


        @RequestMapping(value = "/save", method = RequestMethod.POST)
        @ApiOperation(value = "产品阶梯价格表(只针对同商品)-保存")
        public ActionResult<ErrorCode> save(@RequestBody GoodsLadderVO goodsLadderVO) {
                if (null == goodsLadderVO) {
                        //TODO　校验逻辑。。
                        return actionResult(ErrorCode.IllegalArument);
                }
                try {
                        ErrorCode code = goodsLadderService.save(goodsLadderVO, getSysAccountVO());
                        return actionResult(code);
                } catch (Exception e) {
                        return new ActionResult(ErrorCode.Failure.getCode(), e.getMessage());
                }
        }



        @RequestMapping(value = "/item", method = RequestMethod.GET)
        @ApiOperation(value = "根据id查询产品阶梯价格表(只针对同商品)详情")
        public ActionResult<GoodsLadderVO> item(String id) {
                GoodsLadderVO goodsLadderVO = goodsLadderService.item(id);
                return actionResult(goodsLadderVO);
        }

        @RequestMapping(value = "/delete", method = RequestMethod.POST)
        @ApiOperation(value = "产品阶梯价格表(只针对同商品)-保存")
        public ActionResult<ErrorCode> delete(@RequestBody Long[] ids) {
                if (null == ids||ids.length<1) {
                        return actionResult(ErrorCode.IllegalArument);
                }
                try {
                        int count= goodsLadderService.batchDelete(Arrays.asList(ids));
                        if(count>0){
                                return new ActionResult(ErrorCode.Success);
                        }
                        return actionResult(ErrorCode.Failure);
                } catch (Exception e) {
                        return new ActionResult(ErrorCode.Failure.getCode(), e.getMessage());
                }
        }
}
