package com.xgit.bj.shop.generic.dao.mapper.goods;

import com.xgit.bj.shop.generic.dao.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.xgit.bj.core.rsp.PageCommonVO;
import com.xgit.bj.core.rsp.SearchCommonVO;
import java.util.List;
import com.xgit.bj.shop.generic.dao.entity.goods.SkuStockDO;
import com.xgit.bj.shop.beans.vo.goods.SkuStockVO;
/**
 * SKU的库存 Mapper
 */
@Mapper
public interface SkuStockMapper  extends BaseMapper<SkuStockVO, SkuStockDO> {

    PageCommonVO list(SearchCommonVO<SkuStockVO> condition);

    List<SkuStockDO> queryList(SkuStockVO condition);

    int insert(SkuStockDO model);

    int merge(SkuStockDO model);

    int updateByPrimaryKeySelective(SkuStockDO bean);

    int deleteByPrimaryKeySelective(Long id);

    int batchDeleteByIds(@Param(value = "ids") List<Long> ids);

    List<SkuStockDO> queryListByIds(@Param(value = "ids") List<Long> ids);

    int deleteByGoodsId(@Param(value = "goodsId") Long goodsId);

    int batchInsert(List<SkuStockDO> do2bo4List);
}
