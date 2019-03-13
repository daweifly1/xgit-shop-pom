package com.xgit.bj.shop.generic.dao.mapper.goods;

import com.xgit.bj.shop.generic.dao.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.xgit.bj.core.rsp.PageCommonVO;
import com.xgit.bj.core.rsp.SearchCommonVO;
import java.util.List;
import com.xgit.bj.shop.generic.dao.entity.goods.GoodsAttributeImgDO;
import com.xgit.bj.shop.beans.vo.goods.GoodsAttributeImgVO;
/**
 * 商品颜色属性图片 Mapper
 */
@Mapper
public interface GoodsAttributeImgMapper  extends BaseMapper<GoodsAttributeImgVO, GoodsAttributeImgDO> {

    PageCommonVO list(SearchCommonVO<GoodsAttributeImgVO> condition);

    List<GoodsAttributeImgDO> queryList(GoodsAttributeImgVO condition);

    int insert(GoodsAttributeImgDO model);

    int merge(GoodsAttributeImgDO model);

    int updateByPrimaryKeySelective(GoodsAttributeImgDO bean);

    int deleteByPrimaryKeySelective(Long id);

    int batchDeleteByIds(@Param(value = "ids") List<Long> ids);

    List<GoodsAttributeImgDO> queryListByIds(@Param(value = "ids") List<Long> ids);

}
