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

import com.xgit.bj.shop.beans.vo.goods.GoodsCategoryVO;
import com.xgit.bj.shop.generic.service.goods.GoodsCategoryService;
import com.xgit.bj.shop.generic.facade.goods.GoodsCategoryFacade;


/**
 * GoodsCategory Controller 实现类
 */
@Api(value = "商品类目信息信息表--TODO ")
@RestController
@RequestMapping("/goodsCategory")
public class GoodsCategoryController extends BasicController {
        private static final Logger logger = LoggerFactory.getLogger(GoodsCategoryController.class);
        @Autowired
        private GoodsCategoryService goodsCategoryService;

        @Autowired
        private GoodsCategoryFacade goodsCategoryFacade;

        @RequestMapping(value = "/list", method = RequestMethod.POST)
        @ApiOperation(value = "商品类目信息信息表分页列表信息")
        public ActionResult<PageInfo<GoodsCategoryVO>> list(@RequestBody SearchCommonVO<GoodsCategoryVO> condition) {
                PageCommonVO<GoodsCategoryVO> pageCommonVO = goodsCategoryService.list(condition);
                return actionResult(pageCommonVO.getPageInfo());
        }


        @RequestMapping(value = "/save", method = RequestMethod.POST)
        @ApiOperation(value = "商品类目信息信息表-保存")
        public ActionResult<ErrorCode> save(@RequestBody GoodsCategoryVO goodsCategoryVO) {
                if (null == goodsCategoryVO) {
                        //TODO　校验逻辑。。
                        return actionResult(ErrorCode.IllegalArument);
                }
                try {
                        ErrorCode code = goodsCategoryService.save(goodsCategoryVO, getSysAccountVO());
                        return actionResult(code);
                } catch (Exception e) {
                        return new ActionResult(ErrorCode.Failure.getCode(), e.getMessage());
                }
        }



        @RequestMapping(value = "/item", method = RequestMethod.GET)
        @ApiOperation(value = "根据id查询商品类目信息信息表详情")
        public ActionResult<GoodsCategoryVO> item(String id) {
                GoodsCategoryVO goodsCategoryVO = goodsCategoryService.item(id);
                return actionResult(goodsCategoryVO);
        }

        @RequestMapping(value = "/delete", method = RequestMethod.POST)
        @ApiOperation(value = "商品类目信息信息表-保存")
        public ActionResult<ErrorCode> delete(@RequestBody Long[] ids) {
                if (null == ids||ids.length<1) {
                        return actionResult(ErrorCode.IllegalArument);
                }
                try {
                        int count= goodsCategoryService.batchDelete(Arrays.asList(ids));
                        if(count>0){
                                return new ActionResult(ErrorCode.Success);
                        }
                        return actionResult(ErrorCode.Failure);
                } catch (Exception e) {
                        return new ActionResult(ErrorCode.Failure.getCode(), e.getMessage());
                }
        }
}
