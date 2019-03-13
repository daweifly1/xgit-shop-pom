package com.xgit.bj.shop.generic.dao.mapper.goods;

import com.xgit.bj.shop.generic.dao.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.xgit.bj.core.rsp.PageCommonVO;
import com.xgit.bj.core.rsp.SearchCommonVO;
import java.util.List;
import com.xgit.bj.shop.generic.dao.entity.goods.GoodsFullReductionDO;
import com.xgit.bj.shop.beans.vo.goods.GoodsFullReductionVO;
/**
 * 产品满减表(只针对同商品) Mapper
 */
@Mapper
public interface GoodsFullReductionMapper  extends BaseMapper<GoodsFullReductionVO, GoodsFullReductionDO> {

    PageCommonVO list(SearchCommonVO<GoodsFullReductionVO> condition);

    List<GoodsFullReductionDO> queryList(GoodsFullReductionVO condition);

    int insert(GoodsFullReductionDO model);

    int merge(GoodsFullReductionDO model);

    int updateByPrimaryKeySelective(GoodsFullReductionDO bean);

    int deleteByPrimaryKeySelective(Long id);

    int batchDeleteByIds(@Param(value = "ids") List<Long> ids);

    List<GoodsFullReductionDO> queryListByIds(@Param(value = "ids") List<Long> ids);

}
