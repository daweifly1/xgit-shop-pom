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

import com.xgit.bj.shop.beans.vo.goods.GoodsAttributeCategoryVO;
import com.xgit.bj.shop.generic.service.goods.GoodsAttributeCategoryService;
import com.xgit.bj.shop.generic.facade.goods.GoodsAttributeCategoryFacade;


/**
 * GoodsAttributeCategory Controller 实现类
 */
@Api(value = "产品属性分类表--TODO ")
@RestController
@RequestMapping("/goodsAttributeCategory")
public class GoodsAttributeCategoryController extends BasicController {
        private static final Logger logger = LoggerFactory.getLogger(GoodsAttributeCategoryController.class);
        @Autowired
        private GoodsAttributeCategoryService goodsAttributeCategoryService;

        @Autowired
        private GoodsAttributeCategoryFacade goodsAttributeCategoryFacade;

        @RequestMapping(value = "/list", method = RequestMethod.POST)
        @ApiOperation(value = "产品属性分类表分页列表信息")
        public ActionResult<PageInfo<GoodsAttributeCategoryVO>> list(@RequestBody SearchCommonVO<GoodsAttributeCategoryVO> condition) {
                PageCommonVO<GoodsAttributeCategoryVO> pageCommonVO = goodsAttributeCategoryService.list(condition);
                return actionResult(pageCommonVO.getPageInfo());
        }


        @RequestMapping(value = "/save", method = RequestMethod.POST)
        @ApiOperation(value = "产品属性分类表-保存")
        public ActionResult<ErrorCode> save(@RequestBody GoodsAttributeCategoryVO goodsAttributeCategoryVO) {
                if (null == goodsAttributeCategoryVO) {
                        //TODO　校验逻辑。。
                        return actionResult(ErrorCode.IllegalArument);
                }
                try {
                        ErrorCode code = goodsAttributeCategoryService.save(goodsAttributeCategoryVO, getSysAccountVO());
                        return actionResult(code);
                } catch (Exception e) {
                        return new ActionResult(ErrorCode.Failure.getCode(), e.getMessage());
                }
        }



        @RequestMapping(value = "/item", method = RequestMethod.GET)
        @ApiOperation(value = "根据id查询产品属性分类表详情")
        public ActionResult<GoodsAttributeCategoryVO> item(String id) {
                GoodsAttributeCategoryVO goodsAttributeCategoryVO = goodsAttributeCategoryService.item(id);
                return actionResult(goodsAttributeCategoryVO);
        }

        @RequestMapping(value = "/delete", method = RequestMethod.POST)
        @ApiOperation(value = "产品属性分类表-保存")
        public ActionResult<ErrorCode> delete(@RequestBody Long[] ids) {
                if (null == ids||ids.length<1) {
                        return actionResult(ErrorCode.IllegalArument);
                }
                try {
                        int count= goodsAttributeCategoryService.batchDelete(Arrays.asList(ids));
                        if(count>0){
                                return new ActionResult(ErrorCode.Success);
                        }
                        return actionResult(ErrorCode.Failure);
                } catch (Exception e) {
                        return new ActionResult(ErrorCode.Failure.getCode(), e.getMessage());
                }
        }
}
