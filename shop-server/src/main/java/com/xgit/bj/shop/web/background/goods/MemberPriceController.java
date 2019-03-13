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

import com.xgit.bj.shop.beans.vo.goods.MemberPriceVO;
import com.xgit.bj.shop.generic.service.goods.MemberPriceService;
import com.xgit.bj.shop.generic.facade.goods.MemberPriceFacade;


/**
 * MemberPrice Controller 实现类
 */
@Api(value = "商品会员价格表--TODO ")
@RestController
@RequestMapping("/memberPrice")
public class MemberPriceController extends BasicController {
        private static final Logger logger = LoggerFactory.getLogger(MemberPriceController.class);
        @Autowired
        private MemberPriceService memberPriceService;

        @Autowired
        private MemberPriceFacade memberPriceFacade;

        @RequestMapping(value = "/list", method = RequestMethod.POST)
        @ApiOperation(value = "商品会员价格表分页列表信息")
        public ActionResult<PageInfo<MemberPriceVO>> list(@RequestBody SearchCommonVO<MemberPriceVO> condition) {
                PageCommonVO<MemberPriceVO> pageCommonVO = memberPriceService.list(condition);
                return actionResult(pageCommonVO.getPageInfo());
        }


        @RequestMapping(value = "/save", method = RequestMethod.POST)
        @ApiOperation(value = "商品会员价格表-保存")
        public ActionResult<ErrorCode> save(@RequestBody MemberPriceVO memberPriceVO) {
                if (null == memberPriceVO) {
                        //TODO　校验逻辑。。
                        return actionResult(ErrorCode.IllegalArument);
                }
                try {
                        ErrorCode code = memberPriceService.save(memberPriceVO, getSysAccountVO());
                        return actionResult(code);
                } catch (Exception e) {
                        return new ActionResult(ErrorCode.Failure.getCode(), e.getMessage());
                }
        }



        @RequestMapping(value = "/item", method = RequestMethod.GET)
        @ApiOperation(value = "根据id查询商品会员价格表详情")
        public ActionResult<MemberPriceVO> item(String id) {
                MemberPriceVO memberPriceVO = memberPriceService.item(id);
                return actionResult(memberPriceVO);
        }

        @RequestMapping(value = "/delete", method = RequestMethod.POST)
        @ApiOperation(value = "商品会员价格表-保存")
        public ActionResult<ErrorCode> delete(@RequestBody Long[] ids) {
                if (null == ids||ids.length<1) {
                        return actionResult(ErrorCode.IllegalArument);
                }
                try {
                        int count= memberPriceService.batchDelete(Arrays.asList(ids));
                        if(count>0){
                                return new ActionResult(ErrorCode.Success);
                        }
                        return actionResult(ErrorCode.Failure);
                } catch (Exception e) {
                        return new ActionResult(ErrorCode.Failure.getCode(), e.getMessage());
                }
        }
}
