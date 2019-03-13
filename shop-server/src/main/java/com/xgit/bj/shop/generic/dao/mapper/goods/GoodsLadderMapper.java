package com.xgit.bj.shop.generic.dao.mapper.goods;

import com.xgit.bj.shop.generic.dao.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.xgit.bj.core.rsp.PageCommonVO;
import com.xgit.bj.core.rsp.SearchCommonVO;
import java.util.List;
import com.xgit.bj.shop.generic.dao.entity.goods.GoodsLadderDO;
import com.xgit.bj.shop.beans.vo.goods.GoodsLadderVO;
/**
 * 产品阶梯价格表(只针对同商品) Mapper
 */
@Mapper
public interface GoodsLadderMapper  extends BaseMapper<GoodsLadderVO, GoodsLadderDO> {

    PageCommonVO list(SearchCommonVO<GoodsLadderVO> condition);

    List<GoodsLadderDO> queryList(GoodsLadderVO condition);

    int insert(GoodsLadderDO model);

    int merge(GoodsLadderDO model);

    int updateByPrimaryKeySelective(GoodsLadderDO bean);

    int deleteByPrimaryKeySelective(Long id);

    int batchDeleteByIds(@Param(value = "ids") List<Long> ids);

    List<GoodsLadderDO> queryListByIds(@Param(value = "ids") List<Long> ids);

}
