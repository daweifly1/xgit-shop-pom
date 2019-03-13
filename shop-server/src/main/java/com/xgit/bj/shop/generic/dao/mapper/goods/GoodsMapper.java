package com.xgit.bj.shop.generic.dao.mapper.goods;

import com.xgit.bj.shop.generic.dao.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.xgit.bj.core.rsp.PageCommonVO;
import com.xgit.bj.core.rsp.SearchCommonVO;
import java.util.List;
import com.xgit.bj.shop.generic.dao.entity.goods.GoodsDO;
import com.xgit.bj.shop.beans.vo.goods.GoodsVO;
/**
 * 商品信息 Mapper
 */
@Mapper
public interface GoodsMapper  extends BaseMapper<GoodsVO, GoodsDO> {

    PageCommonVO list(SearchCommonVO<GoodsVO> condition);

    List<GoodsDO> queryList(GoodsVO condition);

    int insert(GoodsDO model);

    int merge(GoodsDO model);

    int updateByPrimaryKeySelective(GoodsDO bean);

    int deleteByPrimaryKeySelective(Long id);

    int batchDeleteByIds(@Param(value = "ids") List<Long> ids);

    List<GoodsDO> queryListByIds(@Param(value = "ids") List<Long> ids);

}
