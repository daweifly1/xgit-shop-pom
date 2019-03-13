package com.xgit.bj.shop.web.background.goods;

import com.github.pagehelper.PageInfo;
import com.xgit.bj.core.rsp.ActionResult;
import com.xgit.bj.core.rsp.PageCommonVO;
import com.xgit.bj.core.rsp.SearchCommonVO;
import com.xgit.bj.shop.beans.param.goods.GoodsParam;
import com.xgit.bj.shop.beans.vo.goods.GoodsVO;
import com.xgit.bj.shop.framework.consts.ErrorCode;
import com.xgit.bj.shop.generic.facade.goods.GoodsFacade;
import com.xgit.bj.shop.generic.service.goods.GoodsService;
import com.xgit.bj.shop.web.background.base.BasicController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


/**
 * Goods Controller 实现类
 */
@Api(value = "商品信息--TODO ")
@RestController
@RequestMapping("/goods")
public class GoodsController extends BasicController {
        private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
        @Autowired
        private GoodsService goodsService;

        @Autowired
        private GoodsFacade goodsFacade;

        @RequestMapping(value = "/list", method = RequestMethod.POST)
        @ApiOperation(value = "商品信息分页列表信息")
        public ActionResult<PageInfo<GoodsVO>> list(@RequestBody SearchCommonVO<GoodsVO> condition) {
                PageCommonVO<GoodsVO> pageCommonVO = goodsService.list(condition);
                return actionResult(pageCommonVO.getPageInfo());
        }


        @RequestMapping(value = "/save", method = RequestMethod.POST)
        @ApiOperation(value = "商品信息-保存")
        public ActionResult<ErrorCode> save(@RequestBody GoodsParam goodsParam) {
                if (null == goodsParam) {
                        //TODO　校验逻辑。。
                        return actionResult(ErrorCode.IllegalArument);
                }
                try {
                        ErrorCode code = goodsFacade.save(goodsParam, getSysAccountVO());
                        return actionResult(code);
                } catch (Exception e) {
                        return new ActionResult(ErrorCode.Failure.getCode(), e.getMessage());
                }
        }



        @RequestMapping(value = "/item", method = RequestMethod.GET)
        @ApiOperation(value = "根据id查询商品信息详情")
        public ActionResult<GoodsParam> item(Long id) {
                GoodsParam goodsVO = goodsFacade.item(id);
                return actionResult(goodsVO);
        }

        @RequestMapping(value = "/delete", method = RequestMethod.POST)
        @ApiOperation(value = "商品信息-保存")
        public ActionResult<ErrorCode> delete(@RequestBody Long[] ids) {
                if (null == ids||ids.length<1) {
                        return actionResult(ErrorCode.IllegalArument);
                }
                try {
                        int count= goodsService.batchDelete(Arrays.asList(ids));
                        if(count>0){
                                return new ActionResult(ErrorCode.Success);
                        }
                        return actionResult(ErrorCode.Failure);
                } catch (Exception e) {
                        return new ActionResult(ErrorCode.Failure.getCode(), e.getMessage());
                }
        }
}
