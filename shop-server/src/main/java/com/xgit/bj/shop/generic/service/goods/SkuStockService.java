package com.xgit.bj.shop.generic.service.goods;

import com.xgit.bj.auth.service.VO.sys.SysAccountVO;
import com.xgit.bj.common.util.BeanUtil;
import com.xgit.bj.core.rsp.PageCommonVO;
import com.xgit.bj.core.rsp.SearchCommonVO;
import com.xgit.bj.shop.beans.vo.goods.SkuStockVO;
import com.xgit.bj.shop.framework.consts.ErrorCode;
import com.xgit.bj.shop.framework.exception.ShopException;
import com.xgit.bj.shop.generic.dao.entity.goods.SkuStockDO;
import com.xgit.bj.shop.generic.dao.mapper.goods.SkuStockMapper;
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
 * SkuStock 后台接口实现类
 */
@Slf4j
@Service
public class SkuStockService extends BaseService<SkuStockVO, SkuStockDO> {

    @Autowired
    private SkuStockMapper skuStockMapper;

    @PostConstruct
    public void init() {
        super.addMapper(skuStockMapper);
    }

    protected SkuStockService() {
        super(SkuStockVO.class, SkuStockDO.class);
    }

    /**
     * 查询列表
     *
     * @param condition
     */
    public PageCommonVO<SkuStockVO> list(SearchCommonVO<SkuStockVO> condition) {
        if (null == condition.getFilters()) {
            condition.setFilters(new SkuStockVO());
        }
        PageCommonVO<SkuStockVO> page = super.list(condition);
        //TODO．．．是否需要其他操作完善数据
        return page;
    }

    /**
     * 查询列表
     *
     * @param vo
     */
    public List<SkuStockDO> queryList(SkuStockVO vo) {
        return skuStockMapper.queryList(vo);
    }


    /**
     * 查询单条记录
     *
     * @param id
     */
    public SkuStockDO queryById(Long id) {
        SkuStockVO vo = new SkuStockVO();
        vo.setId(id);
        List<SkuStockDO> list = queryList(vo);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 保存数据
     *
     * @param skuStockVO
     * @param user
     */
    @Transactional(rollbackFor = Exception.class)
    public ErrorCode save(SkuStockVO skuStockVO, SysAccountVO user) {
        //TODO　是否需要前置校验逻辑
        //初始时候数据状态
        int saveStatus = 0;
        doSave(skuStockVO, user);
        //TODO　是否需要后置操作
        return ErrorCode.Success;
    }

    /**
     * 根据状态，等信息保存数据
     *
     * @param skuStockVO
     * @param user
     */
    private void doSave(SkuStockVO skuStockVO, SysAccountVO user) throws ShopException {
        //TODO 保存是否需要校验？
        preSaveCheck(skuStockVO, user);
        SkuStockDO skuStockDO = getDO(skuStockVO);
        Date now = new Date();
        if (null == skuStockDO.getId()) {
            skuStockDO.setDbCreateAuthor(user.getLoginName());
            skuStockDO.setDbCreateTime(now);
            //TODO ...其他新增时候需要赋值的记录
            log.info("新增操作，skuStockDO:{}", skuStockDO);
        } else {
            skuStockDO.setDbUpdateAuthor(user.getLoginName());
            log.info("编辑操作，skuStockDO:{}", skuStockDO);
            //TODO 之前的记录需要处理？例如删除关联信息
        }
        //TODO 状态处理,..　关联信息处理

        boolean isSuccess = this.merge(skuStockDO) > 0;
        if (!isSuccess) {
            throw new ShopException("保存记录失败");
        }
        //TODO　关联信息后置处理。。。
    }

    /**
     * 保存前信息校验
     */
    private void preSaveCheck(SkuStockVO skuStockVO, SysAccountVO user) throws ShopException {
        if (null == skuStockVO) {
            throw new ShopException(ErrorCode.IllegalArument.getDesc());
        }
        //TODO如果是提交操作或者某些状态下需要做校验吗？
    }

    @Transactional(rollbackFor = Exception.class)
    public int merge(SkuStockDO dto) {
        if (null == dto.getId()) {
            return skuStockMapper.insert(dto);
        }
        return skuStockMapper.updateByPrimaryKeySelective(dto);
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
        return skuStockMapper.batchDeleteByIds(ids);
    }

    public int deleteByGoodsId(Long goodsId) {
        return skuStockMapper.deleteByGoodsId(goodsId);
    }

    public int batchInsert(List<SkuStockVO> skuStockList) {
        return skuStockMapper.batchInsert(BeanUtil.do2bo4List(skuStockList, SkuStockDO.class));
    }

    public List<SkuStockVO> queryListByGoodsId(Long goodsId) {
        SkuStockVO vo = new SkuStockVO();
        vo.setGoodsId(goodsId);
        List<SkuStockDO> ll = queryList(vo);
        if (null != ll) {
            return BeanUtil.do2bo4List(ll, SkuStockVO.class);
        }
        return new ArrayList<>();
    }
}
