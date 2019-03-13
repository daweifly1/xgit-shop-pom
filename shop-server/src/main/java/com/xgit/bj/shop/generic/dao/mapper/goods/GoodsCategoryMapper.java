package com.xgit.bj.shop.generic.dao.mapper.goods;

import com.xgit.bj.shop.generic.dao.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.xgit.bj.core.rsp.PageCommonVO;
import com.xgit.bj.core.rsp.SearchCommonVO;
import java.util.List;
import com.xgit.bj.shop.generic.dao.entity.goods.GoodsCategoryDO;
import com.xgit.bj.shop.beans.vo.goods.GoodsCategoryVO;
/**
 * 商品类目信息信息表 Mapper
 */
@Mapper
public interface GoodsCategoryMapper  extends BaseMapper<GoodsCategoryVO, GoodsCategoryDO> {

    PageCommonVO list(SearchCommonVO<GoodsCategoryVO> condition);

    List<GoodsCategoryDO> queryList(GoodsCategoryVO condition);

    int insert(GoodsCategoryDO model);

    int merge(GoodsCategoryDO model);

    int updateByPrimaryKeySelective(GoodsCategoryDO bean);

    int deleteByPrimaryKeySelective(Long id);

    int batchDeleteByIds(@Param(value = "ids") List<Long> ids);

    List<GoodsCategoryDO> queryListByIds(@Param(value = "ids") List<Long> ids);

}
