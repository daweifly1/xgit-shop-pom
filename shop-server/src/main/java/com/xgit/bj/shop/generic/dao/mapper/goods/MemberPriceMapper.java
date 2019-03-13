package com.xgit.bj.shop.generic.dao.mapper.goods;

import com.xgit.bj.shop.generic.dao.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.xgit.bj.core.rsp.PageCommonVO;
import com.xgit.bj.core.rsp.SearchCommonVO;
import java.util.List;
import com.xgit.bj.shop.generic.dao.entity.goods.MemberPriceDO;
import com.xgit.bj.shop.beans.vo.goods.MemberPriceVO;
/**
 * 商品会员价格表 Mapper
 */
@Mapper
public interface MemberPriceMapper  extends BaseMapper<MemberPriceVO, MemberPriceDO> {

    PageCommonVO list(SearchCommonVO<MemberPriceVO> condition);

    List<MemberPriceDO> queryList(MemberPriceVO condition);

    int insert(MemberPriceDO model);

    int merge(MemberPriceDO model);

    int updateByPrimaryKeySelective(MemberPriceDO bean);

    int deleteByPrimaryKeySelective(Long id);

    int batchDeleteByIds(@Param(value = "ids") List<Long> ids);

    List<MemberPriceDO> queryListByIds(@Param(value = "ids") List<Long> ids);

}
