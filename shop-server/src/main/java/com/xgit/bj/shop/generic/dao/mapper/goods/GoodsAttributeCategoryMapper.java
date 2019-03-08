package com.xgit.bj.shop.generic.dao.mapper.goods;

import com.xgit.bj.shop.generic.dao.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.xgit.bj.core.rsp.PageCommonVO;
import com.xgit.bj.core.rsp.SearchCommonVO;
import java.util.List;
import com.xgit.bj.shop.generic.dao.entity.goods.GoodsAttributeCategoryDO;
import com.xgit.bj.shop.beans.vo.goods.GoodsAttributeCategoryVO;
/**
 * 产品属性分类表 Mapper
 */
@Mapper
public interface GoodsAttributeCategoryMapper  extends BaseMapper<GoodsAttributeCategoryVO, GoodsAttributeCategoryDO> {

    PageCommonVO list(SearchCommonVO<GoodsAttributeCategoryVO> condition);

    List<GoodsAttributeCategoryDO> queryList(GoodsAttributeCategoryVO condition);

    int insert(GoodsAttributeCategoryDO model);

    int merge(GoodsAttributeCategoryDO model);

    int updateByPrimaryKeySelective(GoodsAttributeCategoryDO bean);

    int deleteByPrimaryKeySelective(Long id);

    List<GoodsAttributeCategoryDO> queryListByIds(@Param(value = "ids") List<Long> ids);

}
