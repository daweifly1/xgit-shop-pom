package com.xgit.bj.shop.generic.service.goods;

import com.xgit.bj.auth.service.VO.sys.SysAccountVO;
import com.xgit.bj.common.util.BeanUtil;
import com.xgit.bj.core.rsp.PageCommonVO;
import com.xgit.bj.core.rsp.SearchCommonVO;
import com.xgit.bj.shop.beans.vo.goods.GoodsAttributeImgVO;
import com.xgit.bj.shop.framework.consts.ErrorCode;
import com.xgit.bj.shop.framework.exception.ShopException;
import com.xgit.bj.shop.generic.dao.entity.goods.GoodsAttributeImgDO;
import com.xgit.bj.shop.generic.dao.mapper.goods.GoodsAttributeImgMapper;
import com.xgit.bj.shop.generic.service.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * GoodsAttributeImg 后台接口实现类
 */
@Slf4j
@Service
public class GoodsAttributeImgService extends BaseService<GoodsAttributeImgVO, GoodsAttributeImgDO> {

    @Autowired
    private GoodsAttributeImgMapper goodsAttributeImgMapper;

    @PostConstruct
    public void init() {
        super.addMapper(goodsAttributeImgMapper);
    }

    protected GoodsAttributeImgService() {
        super(GoodsAttributeImgVO.class, GoodsAttributeImgDO.class);
    }

    /**
     * 查询列表
     *
     * @param condition
     */
    public PageCommonVO<GoodsAttributeImgVO> list(SearchCommonVO<GoodsAttributeImgVO> condition) {
        if (null == condition.getFilters()) {
            condition.setFilters(new GoodsAttributeImgVO());
        }
        PageCommonVO<GoodsAttributeImgVO> page = super.list(condition);
        //TODO．．．是否需要其他操作完善数据
        return page;
    }

    /**
     * 查询列表
     *
     * @param vo
     */
    public List<GoodsAttributeImgDO> queryList(GoodsAttributeImgVO vo) {
        return goodsAttributeImgMapper.queryList(vo);
    }


    /**
     * 查询单条记录
     *
     * @param id
     */
    public GoodsAttributeImgDO queryById(Long id) {
        GoodsAttributeImgVO vo = new GoodsAttributeImgVO();
        vo.setId(id);
        List<GoodsAttributeImgDO> list = queryList(vo);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 保存数据
     *
     * @param goodsAttributeImgVO
     * @param user
     */
    @Transactional(rollbackFor = Exception.class)
    public ErrorCode save(GoodsAttributeImgVO goodsAttributeImgVO, SysAccountVO user) {
        //TODO　是否需要前置校验逻辑
        //初始时候数据状态
        int saveStatus = 0;
        doSave(goodsAttributeImgVO, user);
        //TODO　是否需要后置操作
        return ErrorCode.Success;
    }

    /**
     * 根据状态，等信息保存数据
     *
     * @param goodsAttributeImgVO
     * @param user
     */
    private void doSave(GoodsAttributeImgVO goodsAttributeImgVO, SysAccountVO user) throws ShopException {
        //TODO 保存是否需要校验？
        preSaveCheck(goodsAttributeImgVO, user);
        GoodsAttributeImgDO goodsAttributeImgDO = getDO(goodsAttributeImgVO);
        Date now = new Date();
        if (null == goodsAttributeImgDO.getId()) {
            goodsAttributeImgDO.setDbCreateAuthor(user.getLoginName());
            goodsAttributeImgDO.setDbCreateTime(now);
            //TODO ...其他新增时候需要赋值的记录
            log.info("新增操作，goodsAttributeImgDO:{}", goodsAttributeImgDO);
        } else {
            goodsAttributeImgDO.setDbUpdateAuthor(user.getLoginName());
            log.info("编辑操作，goodsAttributeImgDO:{}", goodsAttributeImgDO);
            //TODO 之前的记录需要处理？例如删除关联信息
        }
        //TODO 状态处理,..　关联信息处理

        boolean isSuccess = this.merge(goodsAttributeImgDO) > 0;
        if (!isSuccess) {
            throw new ShopException("保存记录失败");
        }
        //TODO　关联信息后置处理。。。
    }

    /**
     * 保存前信息校验
     */
    private void preSaveCheck(GoodsAttributeImgVO goodsAttributeImgVO, SysAccountVO user) throws ShopException {
        if (null == goodsAttributeImgVO) {
            throw new ShopException(ErrorCode.IllegalArument.getDesc());
        }
        //TODO如果是提交操作或者某些状态下需要做校验吗？
    }

    @Transactional(rollbackFor = Exception.class)
    public int merge(GoodsAttributeImgDO dto) {
        if (null == dto.getId()) {
            return goodsAttributeImgMapper.insert(dto);
        }
        return goodsAttributeImgMapper.updateByPrimaryKeySelective(dto);
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    @Transactional
    public int batchDelete(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return goodsAttributeImgMapper.batchDeleteByIds(ids);
    }

    public int deleteByGoodsId(Long goodsId) {
        return goodsAttributeImgMapper.deleteByGoodsId(goodsId);
    }

    public int batchInsert(List<GoodsAttributeImgVO> goodsAttributeImgs) {
        return goodsAttributeImgMapper.batchInsert(BeanUtil.do2bo4List(goodsAttributeImgs, GoodsAttributeImgDO.class));
    }

    public List<GoodsAttributeImgVO> queryListByGoodsId(Long goodsId) {
        GoodsAttributeImgVO vo = new GoodsAttributeImgVO();
        vo.setGoodsId(goodsId);
        List<GoodsAttributeImgDO> ll = queryList(vo);
        if (null != ll) {
            return BeanUtil.do2bo4List(ll, GoodsAttributeImgVO.class);
        }
        return new ArrayList<>();
    }
}
