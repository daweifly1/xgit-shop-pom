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

import com.xgit.bj.shop.beans.vo.goods.SkuStockVO;
import com.xgit.bj.shop.generic.service.goods.SkuStockService;
import com.xgit.bj.shop.generic.facade.goods.SkuStockFacade;


/**
 * SkuStock Controller 实现类
 */
@Api(value = "SKU的库存--TODO ")
@RestController
@RequestMapping("/skuStock")
public class SkuStockController extends BasicController {
        private static final Logger logger = LoggerFactory.getLogger(SkuStockController.class);
        @Autowired
        private SkuStockService skuStockService;

        @Autowired
        private SkuStockFacade skuStockFacade;

        @RequestMapping(value = "/list", method = RequestMethod.POST)
        @ApiOperation(value = "SKU的库存分页列表信息")
        public ActionResult<PageInfo<SkuStockVO>> list(@RequestBody SearchCommonVO<SkuStockVO> condition) {
                PageCommonVO<SkuStockVO> pageCommonVO = skuStockService.list(condition);
                return actionResult(pageCommonVO.getPageInfo());
        }


        @RequestMapping(value = "/save", method = RequestMethod.POST)
        @ApiOperation(value = "SKU的库存-保存")
        public ActionResult<ErrorCode> save(@RequestBody SkuStockVO skuStockVO) {
                if (null == skuStockVO) {
                        //TODO　校验逻辑。。
                        return actionResult(ErrorCode.IllegalArument);
                }
                try {
                        ErrorCode code = skuStockService.save(skuStockVO, getSysAccountVO());
                        return actionResult(code);
                } catch (Exception e) {
                        return new ActionResult(ErrorCode.Failure.getCode(), e.getMessage());
                }
        }



        @RequestMapping(value = "/item", method = RequestMethod.GET)
        @ApiOperation(value = "根据id查询SKU的库存详情")
        public ActionResult<SkuStockVO> item(String id) {
                SkuStockVO skuStockVO = skuStockService.item(id);
                return actionResult(skuStockVO);
        }

        @RequestMapping(value = "/delete", method = RequestMethod.POST)
        @ApiOperation(value = "SKU的库存-保存")
        public ActionResult<ErrorCode> delete(@RequestBody Long[] ids) {
                if (null == ids||ids.length<1) {
                        return actionResult(ErrorCode.IllegalArument);
                }
                try {
                        int count= skuStockService.batchDelete(Arrays.asList(ids));
                        if(count>0){
                                return new ActionResult(ErrorCode.Success);
                        }
                        return actionResult(ErrorCode.Failure);
                } catch (Exception e) {
                        return new ActionResult(ErrorCode.Failure.getCode(), e.getMessage());
                }
        }
}
