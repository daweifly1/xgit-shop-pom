package com.xgit.bj.shop.generic.service.goods;

import com.xgit.bj.auth.service.VO.sys.SysAccountVO;
import com.xgit.bj.shop.framework.exception.ShopException;
import com.xgit.bj.shop.framework.consts.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xgit.bj.core.rsp.PageCommonVO;
import com.xgit.bj.core.rsp.SearchCommonVO;
import javax.annotation.PostConstruct;
import com.xgit.bj.shop.generic.service.base.BaseService;
import com.xgit.bj.shop.beans.vo.goods.GoodsFullReductionVO;
import com.xgit.bj.shop.generic.dao.entity.goods.GoodsFullReductionDO;
import com.xgit.bj.shop.generic.dao.mapper.goods.GoodsFullReductionMapper;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

/**
 * GoodsFullReduction 后台接口实现类
 */
@Slf4j
@Service
public class GoodsFullReductionService  extends BaseService<GoodsFullReductionVO, GoodsFullReductionDO> {

        @Autowired
        private GoodsFullReductionMapper goodsFullReductionMapper;

        @PostConstruct
        public void init() {
                super.addMapper(goodsFullReductionMapper);
        }

        protected GoodsFullReductionService() {
                super(GoodsFullReductionVO.class, GoodsFullReductionDO.class);
        }

        /**
         * 查询列表
         *
         * @param condition
         */
        public PageCommonVO<GoodsFullReductionVO> list(SearchCommonVO<GoodsFullReductionVO> condition) {
                if (null == condition.getFilters()) {
                        condition.setFilters(new GoodsFullReductionVO());
                }
                PageCommonVO<GoodsFullReductionVO> page= super.list(condition);
                //TODO．．．是否需要其他操作完善数据
                return page;
        }

        /**
         * 查询列表
         *
         * @param vo
         */
        public List<GoodsFullReductionDO> queryList(GoodsFullReductionVO vo) {
                return goodsFullReductionMapper.queryList(vo);
        }


        /**
         * 查询单条记录
         *
         * @param id
         */
        public GoodsFullReductionDO queryById(Long id) {
                GoodsFullReductionVO vo=new GoodsFullReductionVO();
                vo.setId(id);
                List<GoodsFullReductionDO> list=queryList(vo);
                if (CollectionUtils.isNotEmpty(list)) {
                        return list.get(0);
                }
                return null;
        }
        /**
         * 保存数据
         *
         * @param goodsFullReductionVO
         * @param user
         */
        @Transactional(rollbackFor = Exception.class)
        public ErrorCode save(GoodsFullReductionVO goodsFullReductionVO, SysAccountVO user){
                //TODO　是否需要前置校验逻辑
                //初始时候数据状态
                int saveStatus=0;
                doSave(goodsFullReductionVO, user);
                //TODO　是否需要后置操作
                return ErrorCode.Success;
        }

        /**
         * 根据状态，等信息保存数据
         * @param goodsFullReductionVO
         * @param user
         */
        private void doSave(GoodsFullReductionVO goodsFullReductionVO,SysAccountVO user) throws ShopException {
                //TODO 保存是否需要校验？
                preSaveCheck(goodsFullReductionVO,user);
                GoodsFullReductionDO goodsFullReductionDO = getDO(goodsFullReductionVO);
                Date now =new Date();
                if (null==goodsFullReductionDO.getId()) {
                goodsFullReductionDO.setDbCreateAuthor(user.getLoginName());
                goodsFullReductionDO.setDbCreateTime(now);
                //TODO ...其他新增时候需要赋值的记录
                log.info("新增操作，goodsFullReductionDO:{}",goodsFullReductionDO);
                } else {
                goodsFullReductionDO.setDbUpdateAuthor(user.getLoginName());
                log.info("编辑操作，goodsFullReductionDO:{}", goodsFullReductionDO);
                //TODO 之前的记录需要处理？例如删除关联信息
                }
                //TODO 状态处理,..　关联信息处理

                boolean isSuccess = this.merge(goodsFullReductionDO) > 0;
                if (!isSuccess) {
                        throw new ShopException("保存记录失败");
                }
                //TODO　关联信息后置处理。。。
        }
        /**
         * 保存前信息校验
         */
        private void preSaveCheck(GoodsFullReductionVO goodsFullReductionVO, SysAccountVO user) throws ShopException {
                if (null == goodsFullReductionVO) {
                        throw new ShopException(ErrorCode.IllegalArument.getDesc());
                }
                //TODO如果是提交操作或者某些状态下需要做校验吗？
        }

        @Transactional(rollbackFor = Exception.class)
        public int merge(GoodsFullReductionDO dto) {
                if(null==dto.getId()){
                        return goodsFullReductionMapper.insert(dto);
                }
                return goodsFullReductionMapper.updateByPrimaryKeySelective(dto);
        }

        /**
         * 批量删除
         *
         * @param ids
         */
        @Transactional
        public int batchDelete(List<Long> ids) {
            if (CollectionUtils.isEmpty(ids)){
                return 0;
            }
            return goodsFullReductionMapper.batchDeleteByIds(ids);
        }

}
