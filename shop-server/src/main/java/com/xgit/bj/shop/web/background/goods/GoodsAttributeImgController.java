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

import com.xgit.bj.shop.beans.vo.goods.GoodsAttributeImgVO;
import com.xgit.bj.shop.generic.service.goods.GoodsAttributeImgService;
import com.xgit.bj.shop.generic.facade.goods.GoodsAttributeImgFacade;


/**
 * GoodsAttributeImg Controller 实现类
 */
@Api(value = "商品颜色属性图片--TODO ")
@RestController
@RequestMapping("/goodsAttributeImg")
public class GoodsAttributeImgController extends BasicController {
        private static final Logger logger = LoggerFactory.getLogger(GoodsAttributeImgController.class);
        @Autowired
        private GoodsAttributeImgService goodsAttributeImgService;

        @Autowired
        private GoodsAttributeImgFacade goodsAttributeImgFacade;

        @RequestMapping(value = "/list", method = RequestMethod.POST)
        @ApiOperation(value = "商品颜色属性图片分页列表信息")
        public ActionResult<PageInfo<GoodsAttributeImgVO>> list(@RequestBody SearchCommonVO<GoodsAttributeImgVO> condition) {
                PageCommonVO<GoodsAttributeImgVO> pageCommonVO = goodsAttributeImgService.list(condition);
                return actionResult(pageCommonVO.getPageInfo());
        }


        @RequestMapping(value = "/save", method = RequestMethod.POST)
        @ApiOperation(value = "商品颜色属性图片-保存")
        public ActionResult<ErrorCode> save(@RequestBody GoodsAttributeImgVO goodsAttributeImgVO) {
                if (null == goodsAttributeImgVO) {
                        //TODO　校验逻辑。。
                        return actionResult(ErrorCode.IllegalArument);
                }
                try {
                        ErrorCode code = goodsAttributeImgService.save(goodsAttributeImgVO, getSysAccountVO());
                        return actionResult(code);
                } catch (Exception e) {
                        return new ActionResult(ErrorCode.Failure.getCode(), e.getMessage());
                }
        }



        @RequestMapping(value = "/item", method = RequestMethod.GET)
        @ApiOperation(value = "根据id查询商品颜色属性图片详情")
        public ActionResult<GoodsAttributeImgVO> item(String id) {
                GoodsAttributeImgVO goodsAttributeImgVO = goodsAttributeImgService.item(id);
                return actionResult(goodsAttributeImgVO);
        }

        @RequestMapping(value = "/delete", method = RequestMethod.POST)
        @ApiOperation(value = "商品颜色属性图片-保存")
        public ActionResult<ErrorCode> delete(@RequestBody Long[] ids) {
                if (null == ids||ids.length<1) {
                        return actionResult(ErrorCode.IllegalArument);
                }
                try {
                        int count= goodsAttributeImgService.batchDelete(Arrays.asList(ids));
                        if(count>0){
                                return new ActionResult(ErrorCode.Success);
                        }
                        return actionResult(ErrorCode.Failure);
                } catch (Exception e) {
                        return new ActionResult(ErrorCode.Failure.getCode(), e.getMessage());
                }
        }
}
