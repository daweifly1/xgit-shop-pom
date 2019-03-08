package com.xgit.bj.shop.generic.dao.mapper.goods;

import com.xgit.bj.shop.generic.dao.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.xgit.bj.core.rsp.PageCommonVO;
import com.xgit.bj.core.rsp.SearchCommonVO;
import java.util.List;
import com.xgit.bj.shop.generic.dao.entity.goods.GoodsAttributeValueDO;
import com.xgit.bj.shop.beans.vo.goods.GoodsAttributeValueVO;
/**
 * 存储产品参数信息的表 Mapper
 */
@Mapper
public interface GoodsAttributeValueMapper  extends BaseMapper<GoodsAttributeValueVO, GoodsAttributeValueDO> {

    PageCommonVO list(SearchCommonVO<GoodsAttributeValueVO> condition);

    List<GoodsAttributeValueDO> queryList(GoodsAttributeValueVO condition);

    int insert(GoodsAttributeValueDO model);

    int merge(GoodsAttributeValueDO model);

    int updateByPrimaryKeySelective(GoodsAttributeValueDO bean);

    int deleteByPrimaryKeySelective(Long id);

    List<GoodsAttributeValueDO> queryListByIds(@Param(value = "ids") List<Long> ids);

}
