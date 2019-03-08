package com.xgit.bj.shop.generic.dao.mapper.goods;

import com.xgit.bj.shop.generic.dao.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.xgit.bj.core.rsp.PageCommonVO;
import com.xgit.bj.core.rsp.SearchCommonVO;
import java.util.List;
import com.xgit.bj.shop.generic.dao.entity.goods.GoodsBrandDO;
import com.xgit.bj.shop.beans.vo.goods.GoodsBrandVO;
/**
 * 品牌表 Mapper
 */
@Mapper
public interface GoodsBrandMapper  extends BaseMapper<GoodsBrandVO, GoodsBrandDO> {

    PageCommonVO list(SearchCommonVO<GoodsBrandVO> condition);

    List<GoodsBrandDO> queryList(GoodsBrandVO condition);

    int insert(GoodsBrandDO model);

    int merge(GoodsBrandDO model);

    int updateByPrimaryKeySelective(GoodsBrandDO bean);

    int deleteByPrimaryKeySelective(Long id);

    List<GoodsBrandDO> queryListByIds(@Param(value = "ids") List<Long> ids);

}
