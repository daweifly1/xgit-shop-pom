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
import com.xgit.bj.shop.beans.vo.goods.GoodsAttributeCategoryVO;
import com.xgit.bj.shop.generic.dao.entity.goods.GoodsAttributeCategoryDO;
import com.xgit.bj.shop.generic.dao.mapper.goods.GoodsAttributeCategoryMapper;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

/**
 * GoodsAttributeCategory 后台接口实现类
 */
@Slf4j
@Service
public class GoodsAttributeCategoryService  extends BaseService<GoodsAttributeCategoryVO, GoodsAttributeCategoryDO> {

        @Autowired
        private GoodsAttributeCategoryMapper goodsAttributeCategoryMapper;

        @PostConstruct
        public void init() {
                super.addMapper(goodsAttributeCategoryMapper);
        }

        protected GoodsAttributeCategoryService() {
                super(GoodsAttributeCategoryVO.class, GoodsAttributeCategoryDO.class);
        }

        /**
         * 查询列表
         *
         * @param condition
         */
        public PageCommonVO<GoodsAttributeCategoryVO> list(SearchCommonVO<GoodsAttributeCategoryVO> condition) {
                if (null == condition.getFilters()) {
                        condition.setFilters(new GoodsAttributeCategoryVO());
                }
                PageCommonVO<GoodsAttributeCategoryVO> page= super.list(condition);
                //TODO．．．是否需要其他操作完善数据
                return page;
        }

        /**
         * 查询列表
         *
         * @param vo
         */
        public List<GoodsAttributeCategoryDO> queryList(GoodsAttributeCategoryVO vo) {
                return goodsAttributeCategoryMapper.queryList(vo);
        }


        /**
         * 查询单条记录
         *
         * @param id
         */
        public GoodsAttributeCategoryDO queryById(Long id) {
                GoodsAttributeCategoryVO vo=new GoodsAttributeCategoryVO();
                vo.setId(id);
                List<GoodsAttributeCategoryDO> list=queryList(vo);
                if (CollectionUtils.isNotEmpty(list)) {
                        return list.get(0);
                }
                return null;
        }
        /**
         * 保存数据
         *
         * @param goodsAttributeCategoryVO
         * @param user
         */
        @Transactional(rollbackFor = Exception.class)
        public ErrorCode save(GoodsAttributeCategoryVO goodsAttributeCategoryVO, SysAccountVO user){
                //TODO　是否需要前置校验逻辑
                //初始时候数据状态
                int saveStatus=0;
                doSave(goodsAttributeCategoryVO, user);
                //TODO　是否需要后置操作
                return ErrorCode.Success;
        }

        /**
         * 根据状态，等信息保存数据
         * @param goodsAttributeCategoryVO
         * @param user
         */
        private void doSave(GoodsAttributeCategoryVO goodsAttributeCategoryVO,SysAccountVO user) throws ShopException {
                //TODO 保存是否需要校验？
                preSaveCheck(goodsAttributeCategoryVO,user);
                GoodsAttributeCategoryDO goodsAttributeCategoryDO = getDO(goodsAttributeCategoryVO);
                Date now =new Date();
                if (null==goodsAttributeCategoryDO.getId()) {
                goodsAttributeCategoryDO.setDbCreateAuthor(user.getLoginName());
                goodsAttributeCategoryDO.setDbCreateTime(now);
                //TODO ...其他新增时候需要赋值的记录
                log.info("新增操作，goodsAttributeCategoryDO:{}",goodsAttributeCategoryDO);
                } else {
                goodsAttributeCategoryDO.setDbUpdateAuthor(user.getLoginName());
                log.info("编辑操作，goodsAttributeCategoryDO:{}", goodsAttributeCategoryDO);
                //TODO 之前的记录需要处理？例如删除关联信息
                }
                //TODO 状态处理,..　关联信息处理

                boolean isSuccess = this.merge(goodsAttributeCategoryDO) > 0;
                if (!isSuccess) {
                        throw new ShopException("保存记录失败");
                }
                //TODO　关联信息后置处理。。。
        }
        /**
         * 保存前信息校验
         */
        private void preSaveCheck(GoodsAttributeCategoryVO goodsAttributeCategoryVO, SysAccountVO user) throws ShopException {
                if (null == goodsAttributeCategoryVO) {
                        throw new ShopException(ErrorCode.IllegalArument.getDesc());
                }
                //TODO如果是提交操作或者某些状态下需要做校验吗？
        }

        @Transactional(rollbackFor = Exception.class)
        public int merge(GoodsAttributeCategoryDO dto) {
                if(null==dto.getId()){
                        return goodsAttributeCategoryMapper.insert(dto);
                }
                return goodsAttributeCategoryMapper.updateByPrimaryKeySelective(dto);
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
              i =+ goodsAttributeCategoryMapper.deleteByPrimaryKeySelective(id);
            }
            return i;
        }

}
