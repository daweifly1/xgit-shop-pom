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

import com.xgit.bj.shop.beans.vo.goods.GoodsAttributeValueVO;
import com.xgit.bj.shop.generic.service.goods.GoodsAttributeValueService;
import com.xgit.bj.shop.generic.facade.goods.GoodsAttributeValueFacade;


/**
 * GoodsAttributeValue Controller 实现类
 */
@Api(value = "存储产品参数信息的表--TODO ")
@RestController
@RequestMapping("/goodsAttributeValue")
public class GoodsAttributeValueController extends BasicController {
        private static final Logger logger = LoggerFactory.getLogger(GoodsAttributeValueController.class);
        @Autowired
        private GoodsAttributeValueService goodsAttributeValueService;

        @Autowired
        private GoodsAttributeValueFacade goodsAttributeValueFacade;

        @RequestMapping(value = "/list", method = RequestMethod.POST)
        @ApiOperation(value = "存储产品参数信息的表分页列表信息")
        public ActionResult<PageInfo<GoodsAttributeValueVO>> list(@RequestBody SearchCommonVO<GoodsAttributeValueVO> condition) {
                PageCommonVO<GoodsAttributeValueVO> pageCommonVO = goodsAttributeValueService.list(condition);
                return actionResult(pageCommonVO.getPageInfo());
        }


        @RequestMapping(value = "/save", method = RequestMethod.POST)
        @ApiOperation(value = "存储产品参数信息的表-保存")
        public ActionResult<ErrorCode> save(@RequestBody GoodsAttributeValueVO goodsAttributeValueVO) {
                if (null == goodsAttributeValueVO) {
                        //TODO　校验逻辑。。
                        return actionResult(ErrorCode.IllegalArument);
                }
                try {
                        ErrorCode code = goodsAttributeValueService.save(goodsAttributeValueVO, getSysAccountVO());
                        return actionResult(code);
                } catch (Exception e) {
                        return new ActionResult(ErrorCode.Failure.getCode(), e.getMessage());
                }
        }



        @RequestMapping(value = "/item", method = RequestMethod.GET)
        @ApiOperation(value = "根据id查询存储产品参数信息的表详情")
        public ActionResult<GoodsAttributeValueVO> item(String id) {
                GoodsAttributeValueVO goodsAttributeValueVO = goodsAttributeValueService.item(id);
                return actionResult(goodsAttributeValueVO);
        }

        @RequestMapping(value = "/delete", method = RequestMethod.POST)
        @ApiOperation(value = "存储产品参数信息的表-保存")
        public ActionResult<ErrorCode> delete(@RequestBody Long[] ids) {
                if (null == ids||ids.length<1) {
                        return actionResult(ErrorCode.IllegalArument);
                }
                try {
                        int count= goodsAttributeValueService.batchDelete(Arrays.asList(ids));
                        if(count>0){
                                return new ActionResult(ErrorCode.Success);
                        }
                        return actionResult(ErrorCode.Failure);
                } catch (Exception e) {
                        return new ActionResult(ErrorCode.Failure.getCode(), e.getMessage());
                }
        }
}
