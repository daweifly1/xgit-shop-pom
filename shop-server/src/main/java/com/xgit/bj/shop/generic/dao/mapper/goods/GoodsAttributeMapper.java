package com.xgit.bj.shop.generic.dao.mapper.goods;

import com.xgit.bj.shop.generic.dao.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.xgit.bj.core.rsp.PageCommonVO;
import com.xgit.bj.core.rsp.SearchCommonVO;
import java.util.List;
import com.xgit.bj.shop.generic.dao.entity.goods.GoodsAttributeDO;
import com.xgit.bj.shop.beans.vo.goods.GoodsAttributeVO;
/**
 * 商品属性参数表 Mapper
 */
@Mapper
public interface GoodsAttributeMapper  extends BaseMapper<GoodsAttributeVO, GoodsAttributeDO> {

    PageCommonVO list(SearchCommonVO<GoodsAttributeVO> condition);

    List<GoodsAttributeDO> queryList(GoodsAttributeVO condition);

    int insert(GoodsAttributeDO model);

    int merge(GoodsAttributeDO model);

    int updateByPrimaryKeySelective(GoodsAttributeDO bean);

    int deleteByPrimaryKeySelective(Long id);

    int batchDeleteByIds(@Param(value = "ids") List<Long> ids);

    List<GoodsAttributeDO> queryListByIds(@Param(value = "ids") List<Long> ids);

}
