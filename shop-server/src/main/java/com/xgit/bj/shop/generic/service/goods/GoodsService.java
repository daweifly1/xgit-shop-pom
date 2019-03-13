package com.xgit.bj.shop.generic.service.goods;

import com.xgit.bj.auth.service.VO.sys.SysAccountVO;
import com.xgit.bj.core.rsp.PageCommonVO;
import com.xgit.bj.core.rsp.SearchCommonVO;
import com.xgit.bj.shop.beans.vo.goods.GoodsVO;
import com.xgit.bj.shop.framework.consts.ErrorCode;
import com.xgit.bj.shop.framework.exception.ShopException;
import com.xgit.bj.shop.generic.dao.entity.goods.GoodsDO;
import com.xgit.bj.shop.generic.dao.mapper.goods.GoodsMapper;
import com.xgit.bj.shop.generic.service.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

/**
 * Goods 后台接口实现类
 */
@Slf4j
@Service
public class GoodsService extends BaseService<GoodsVO, GoodsDO> {

    @Autowired
    private GoodsMapper goodsMapper;

    @PostConstruct
    public void init() {
        super.addMapper(goodsMapper);
    }

    protected GoodsService() {
        super(GoodsVO.class, GoodsDO.class);
    }

    /**
     * 查询列表
     *
     * @param condition
     */
    public PageCommonVO<GoodsVO> list(SearchCommonVO<GoodsVO> condition) {
        if (null == condition.getFilters()) {
            condition.setFilters(new GoodsVO());
        }
        PageCommonVO<GoodsVO> page = super.list(condition);
        //TODO．．．是否需要其他操作完善数据
        return page;
    }

    /**
     * 查询列表
     *
     * @param vo
     */
    public List<GoodsDO> queryList(GoodsVO vo) {
        return goodsMapper.queryList(vo);
    }


    /**
     * 查询单条记录
     *
     * @param id
     */
    public GoodsDO queryById(Long id) {
        GoodsVO vo = new GoodsVO();
        vo.setId(id);
        List<GoodsDO> list = queryList(vo);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 保存数据
     *
     * @param goodsVO
     * @param user
     */
    @Transactional(rollbackFor = Exception.class)
    public ErrorCode save(GoodsVO goodsVO, SysAccountVO user) {
        //TODO　是否需要前置校验逻辑
        //初始时候数据状态
        int saveStatus = 0;
        doSave(goodsVO, user);
        //TODO　是否需要后置操作
        return ErrorCode.Success;
    }

    /**
     * 根据状态，等信息保存数据
     *
     * @param goodsVO
     * @param user
     */
    private void doSave(GoodsVO goodsVO, SysAccountVO user) throws ShopException {
        //TODO 保存是否需要校验？
        preSaveCheck(goodsVO, user);
        GoodsDO goodsDO = getDO(goodsVO);
        Date now = new Date();
        if (null == goodsDO.getId()) {
            goodsDO.setDbCreateAuthor(user.getLoginName());
            goodsDO.setDbCreateTime(now);
            //TODO ...其他新增时候需要赋值的记录
            log.info("新增操作，goodsDO:{}", goodsDO);
        } else {
            goodsDO.setDbUpdateAuthor(user.getLoginName());
            log.info("编辑操作，goodsDO:{}", goodsDO);
            //TODO 之前的记录需要处理？例如删除关联信息
        }
        //TODO 状态处理,..　关联信息处理

        boolean isSuccess = this.merge(goodsDO) > 0;
        if (!isSuccess) {
            throw new ShopException("保存记录失败");
        }
        //TODO　关联信息后置处理。。。
    }

    /**
     * 保存前信息校验
     */
    private void preSaveCheck(GoodsVO goodsVO, SysAccountVO user) throws ShopException {
        if (null == goodsVO) {
            throw new ShopException(ErrorCode.IllegalArument.getDesc());
        }
        //TODO如果是提交操作或者某些状态下需要做校验吗？
    }

    @Transactional(rollbackFor = Exception.class)
    public int merge(GoodsDO dto) {
        if (null == dto.getId()) {
            return goodsMapper.insert(dto);
        }
        return goodsMapper.updateByPrimaryKeySelective(dto);
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
        int i = 0;
        for (Long id : ids) {
            i = +goodsMapper.deleteByPrimaryKeySelective(id);
        }
        return i;
    }

}
