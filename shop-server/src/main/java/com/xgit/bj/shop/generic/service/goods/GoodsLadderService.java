package com.xgit.bj.shop.generic.service.goods;

import com.xgit.bj.auth.service.VO.sys.SysAccountVO;
import com.xgit.bj.core.rsp.PageCommonVO;
import com.xgit.bj.core.rsp.SearchCommonVO;
import com.xgit.bj.shop.beans.vo.goods.GoodsLadderVO;
import com.xgit.bj.shop.framework.consts.ErrorCode;
import com.xgit.bj.shop.framework.exception.ShopException;
import com.xgit.bj.shop.generic.dao.entity.goods.GoodsLadderDO;
import com.xgit.bj.shop.generic.dao.mapper.goods.GoodsLadderMapper;
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
 * GoodsLadder 后台接口实现类
 */
@Slf4j
@Service
public class GoodsLadderService extends BaseService<GoodsLadderVO, GoodsLadderDO> {

    @Autowired
    private GoodsLadderMapper goodsLadderMapper;

    @PostConstruct
    public void init() {
        super.addMapper(goodsLadderMapper);
    }

    protected GoodsLadderService() {
        super(GoodsLadderVO.class, GoodsLadderDO.class);
    }

    /**
     * 查询列表
     *
     * @param condition
     */
    public PageCommonVO<GoodsLadderVO> list(SearchCommonVO<GoodsLadderVO> condition) {
        if (null == condition.getFilters()) {
            condition.setFilters(new GoodsLadderVO());
        }
        PageCommonVO<GoodsLadderVO> page = super.list(condition);
        //TODO．．．是否需要其他操作完善数据
        return page;
    }

    /**
     * 查询列表
     *
     * @param vo
     */
    public List<GoodsLadderDO> queryList(GoodsLadderVO vo) {
        return goodsLadderMapper.queryList(vo);
    }


    /**
     * 查询单条记录
     *
     * @param id
     */
    public GoodsLadderDO queryById(Long id) {
        GoodsLadderVO vo = new GoodsLadderVO();
        vo.setId(id);
        List<GoodsLadderDO> list = queryList(vo);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 保存数据
     *
     * @param goodsLadderVO
     * @param user
     */
    @Transactional(rollbackFor = Exception.class)
    public ErrorCode save(GoodsLadderVO goodsLadderVO, SysAccountVO user) {
        //TODO　是否需要前置校验逻辑
        //初始时候数据状态
        int saveStatus = 0;
        doSave(goodsLadderVO, user);
        //TODO　是否需要后置操作
        return ErrorCode.Success;
    }

    /**
     * 根据状态，等信息保存数据
     *
     * @param goodsLadderVO
     * @param user
     */
    private void doSave(GoodsLadderVO goodsLadderVO, SysAccountVO user) throws ShopException {
        //TODO 保存是否需要校验？
        preSaveCheck(goodsLadderVO, user);
        GoodsLadderDO goodsLadderDO = getDO(goodsLadderVO);
        Date now = new Date();
        if (null == goodsLadderDO.getId()) {
            goodsLadderDO.setDbCreateAuthor(user.getLoginName());
            goodsLadderDO.setDbCreateTime(now);
            //TODO ...其他新增时候需要赋值的记录
            log.info("新增操作，goodsLadderDO:{}", goodsLadderDO);
        } else {
            goodsLadderDO.setDbUpdateAuthor(user.getLoginName());
            log.info("编辑操作，goodsLadderDO:{}", goodsLadderDO);
            //TODO 之前的记录需要处理？例如删除关联信息
        }
        //TODO 状态处理,..　关联信息处理

        boolean isSuccess = this.merge(goodsLadderDO) > 0;
        if (!isSuccess) {
            throw new ShopException("保存记录失败");
        }
        //TODO　关联信息后置处理。。。
    }

    /**
     * 保存前信息校验
     */
    private void preSaveCheck(GoodsLadderVO goodsLadderVO, SysAccountVO user) throws ShopException {
        if (null == goodsLadderVO) {
            throw new ShopException(ErrorCode.IllegalArument.getDesc());
        }
        //TODO如果是提交操作或者某些状态下需要做校验吗？
    }

    @Transactional(rollbackFor = Exception.class)
    public int merge(GoodsLadderDO dto) {
        if (null == dto.getId()) {
            return goodsLadderMapper.insert(dto);
        }
        return goodsLadderMapper.updateByPrimaryKeySelective(dto);
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
        return goodsLadderMapper.batchDeleteByIds(ids);
    }

}
