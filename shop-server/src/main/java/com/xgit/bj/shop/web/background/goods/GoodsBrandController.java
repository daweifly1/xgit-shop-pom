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

import com.xgit.bj.shop.beans.vo.goods.GoodsBrandVO;
import com.xgit.bj.shop.generic.service.goods.GoodsBrandService;
import com.xgit.bj.shop.generic.facade.goods.GoodsBrandFacade;


/**
 * GoodsBrand Controller 实现类
 */
@Api(value = "品牌表--TODO ")
@RestController
@RequestMapping("/goodsBrand")
public class GoodsBrandController extends BasicController {
        private static final Logger logger = LoggerFactory.getLogger(GoodsBrandController.class);
        @Autowired
        private GoodsBrandService goodsBrandService;

        @Autowired
        private GoodsBrandFacade goodsBrandFacade;

        @RequestMapping(value = "/list", method = RequestMethod.POST)
        @ApiOperation(value = "品牌表分页列表信息")
        public ActionResult<PageInfo<GoodsBrandVO>> list(@RequestBody SearchCommonVO<GoodsBrandVO> condition) {
                PageCommonVO<GoodsBrandVO> pageCommonVO = goodsBrandService.list(condition);
                return actionResult(pageCommonVO.getPageInfo());
        }


        @RequestMapping(value = "/save", method = RequestMethod.POST)
        @ApiOperation(value = "品牌表-保存")
        public ActionResult<ErrorCode> save(@RequestBody GoodsBrandVO goodsBrandVO) {
                if (null == goodsBrandVO) {
                        //TODO　校验逻辑。。
                        return actionResult(ErrorCode.IllegalArument);
                }
                try {
                        ErrorCode code = goodsBrandService.save(goodsBrandVO, getSysAccountVO());
                        return actionResult(code);
                } catch (Exception e) {
                        return new ActionResult(ErrorCode.Failure.getCode(), e.getMessage());
                }
        }



        @RequestMapping(value = "/item", method = RequestMethod.GET)
        @ApiOperation(value = "根据id查询品牌表详情")
        public ActionResult<GoodsBrandVO> item(String id) {
                GoodsBrandVO goodsBrandVO = goodsBrandService.item(id);
                return actionResult(goodsBrandVO);
        }

        @RequestMapping(value = "/delete", method = RequestMethod.POST)
        @ApiOperation(value = "品牌表-保存")
        public ActionResult<ErrorCode> delete(@RequestBody Long[] ids) {
                if (null == ids||ids.length<1) {
                        return actionResult(ErrorCode.IllegalArument);
                }
                try {
                        int count= goodsBrandService.batchDelete(Arrays.asList(ids));
                        if(count>0){
                                return new ActionResult(ErrorCode.Success);
                        }
                        return actionResult(ErrorCode.Failure);
                } catch (Exception e) {
                        return new ActionResult(ErrorCode.Failure.getCode(), e.getMessage());
                }
        }
}
