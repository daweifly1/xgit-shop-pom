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
import com.xgit.bj.shop.beans.vo.goods.GoodsCategoryVO;
import com.xgit.bj.shop.generic.dao.entity.goods.GoodsCategoryDO;
import com.xgit.bj.shop.generic.dao.mapper.goods.GoodsCategoryMapper;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

/**
 * GoodsCategory 后台接口实现类
 */
@Slf4j
@Service
public class GoodsCategoryService  extends BaseService<GoodsCategoryVO, GoodsCategoryDO> {

        @Autowired
        private GoodsCategoryMapper goodsCategoryMapper;

        @PostConstruct
        public void init() {
                super.addMapper(goodsCategoryMapper);
        }

        protected GoodsCategoryService() {
                super(GoodsCategoryVO.class, GoodsCategoryDO.class);
        }

        /**
         * 查询列表
         *
         * @param condition
         */
        public PageCommonVO<GoodsCategoryVO> list(SearchCommonVO<GoodsCategoryVO> condition) {
                if (null == condition.getFilters()) {
                        condition.setFilters(new GoodsCategoryVO());
                }
                PageCommonVO<GoodsCategoryVO> page= super.list(condition);
                //TODO．．．是否需要其他操作完善数据
                return page;
        }

        /**
         * 查询列表
         *
         * @param vo
         */
        public List<GoodsCategoryDO> queryList(GoodsCategoryVO vo) {
                return goodsCategoryMapper.queryList(vo);
        }


        /**
         * 查询单条记录
         *
         * @param id
         */
        public GoodsCategoryDO queryById(Long id) {
                GoodsCategoryVO vo=new GoodsCategoryVO();
                vo.setId(id);
                List<GoodsCategoryDO> list=queryList(vo);
                if (CollectionUtils.isNotEmpty(list)) {
                        return list.get(0);
                }
                return null;
        }
        /**
         * 保存数据
         *
         * @param goodsCategoryVO
         * @param user
         */
        @Transactional(rollbackFor = Exception.class)
        public ErrorCode save(GoodsCategoryVO goodsCategoryVO, SysAccountVO user){
                //TODO　是否需要前置校验逻辑
                //初始时候数据状态
                int saveStatus=0;
                doSave(goodsCategoryVO, user);
                //TODO　是否需要后置操作
                return ErrorCode.Success;
        }

        /**
         * 根据状态，等信息保存数据
         * @param goodsCategoryVO
         * @param user
         */
        private void doSave(GoodsCategoryVO goodsCategoryVO,SysAccountVO user) throws ShopException {
                //TODO 保存是否需要校验？
                preSaveCheck(goodsCategoryVO,user);
                GoodsCategoryDO goodsCategoryDO = getDO(goodsCategoryVO);
                Date now =new Date();
                if (null==goodsCategoryDO.getId()) {
                goodsCategoryDO.setDbCreateAuthor(user.getLoginName());
                goodsCategoryDO.setDbCreateTime(now);
                //TODO ...其他新增时候需要赋值的记录
                log.info("新增操作，goodsCategoryDO:{}",goodsCategoryDO);
                } else {
                goodsCategoryDO.setDbUpdateAuthor(user.getLoginName());
                log.info("编辑操作，goodsCategoryDO:{}", goodsCategoryDO);
                //TODO 之前的记录需要处理？例如删除关联信息
                }
                //TODO 状态处理,..　关联信息处理

                boolean isSuccess = this.merge(goodsCategoryDO) > 0;
                if (!isSuccess) {
                        throw new ShopException("保存记录失败");
                }
                //TODO　关联信息后置处理。。。
        }
        /**
         * 保存前信息校验
         */
        private void preSaveCheck(GoodsCategoryVO goodsCategoryVO, SysAccountVO user) throws ShopException {
                if (null == goodsCategoryVO) {
                        throw new ShopException(ErrorCode.IllegalArument.getDesc());
                }
                //TODO如果是提交操作或者某些状态下需要做校验吗？
        }

        @Transactional(rollbackFor = Exception.class)
        public int merge(GoodsCategoryDO dto) {
                if(null==dto.getId()){
                        return goodsCategoryMapper.insert(dto);
                }
                return goodsCategoryMapper.updateByPrimaryKeySelective(dto);
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
            int i=0;
            for(Long id:ids){
              i =+ goodsCategoryMapper.deleteByPrimaryKeySelective(id);
            }
            return i;
        }

}
