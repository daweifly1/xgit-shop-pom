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
import com.xgit.bj.shop.beans.vo.goods.GoodsBrandVO;
import com.xgit.bj.shop.generic.dao.entity.goods.GoodsBrandDO;
import com.xgit.bj.shop.generic.dao.mapper.goods.GoodsBrandMapper;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

/**
 * GoodsBrand 后台接口实现类
 */
@Slf4j
@Service
public class GoodsBrandService  extends BaseService<GoodsBrandVO, GoodsBrandDO> {

        @Autowired
        private GoodsBrandMapper goodsBrandMapper;

        @PostConstruct
        public void init() {
                super.addMapper(goodsBrandMapper);
        }

        protected GoodsBrandService() {
                super(GoodsBrandVO.class, GoodsBrandDO.class);
        }

        /**
         * 查询列表
         *
         * @param condition
         */
        public PageCommonVO<GoodsBrandVO> list(SearchCommonVO<GoodsBrandVO> condition) {
                if (null == condition.getFilters()) {
                        condition.setFilters(new GoodsBrandVO());
                }
                PageCommonVO<GoodsBrandVO> page= super.list(condition);
                //TODO．．．是否需要其他操作完善数据
                return page;
        }

        /**
         * 查询列表
         *
         * @param vo
         */
        public List<GoodsBrandDO> queryList(GoodsBrandVO vo) {
                return goodsBrandMapper.queryList(vo);
        }


        /**
         * 查询单条记录
         *
         * @param id
         */
        public GoodsBrandDO queryById(Long id) {
                GoodsBrandVO vo=new GoodsBrandVO();
                vo.setId(id);
                List<GoodsBrandDO> list=queryList(vo);
                if (CollectionUtils.isNotEmpty(list)) {
                        return list.get(0);
                }
                return null;
        }
        /**
         * 保存数据
         *
         * @param goodsBrandVO
         * @param user
         */
        @Transactional(rollbackFor = Exception.class)
        public ErrorCode save(GoodsBrandVO goodsBrandVO, SysAccountVO user){
                //TODO　是否需要前置校验逻辑
                //初始时候数据状态
                int saveStatus=0;
                doSave(goodsBrandVO, user);
                //TODO　是否需要后置操作
                return ErrorCode.Success;
        }

        /**
         * 根据状态，等信息保存数据
         * @param goodsBrandVO
         * @param user
         */
        private void doSave(GoodsBrandVO goodsBrandVO,SysAccountVO user) throws ShopException {
                //TODO 保存是否需要校验？
                preSaveCheck(goodsBrandVO,user);
                GoodsBrandDO goodsBrandDO = getDO(goodsBrandVO);
                Date now =new Date();
                if (null==goodsBrandDO.getId()) {
                goodsBrandDO.setDbCreateAuthor(user.getLoginName());
                goodsBrandDO.setDbCreateTime(now);
                //TODO ...其他新增时候需要赋值的记录
                log.info("新增操作，goodsBrandDO:{}",goodsBrandDO);
                } else {
                goodsBrandDO.setDbUpdateAuthor(user.getLoginName());
                log.info("编辑操作，goodsBrandDO:{}", goodsBrandDO);
                //TODO 之前的记录需要处理？例如删除关联信息
                }
                //TODO 状态处理,..　关联信息处理

                boolean isSuccess = this.merge(goodsBrandDO) > 0;
                if (!isSuccess) {
                        throw new ShopException("保存记录失败");
                }
                //TODO　关联信息后置处理。。。
        }
        /**
         * 保存前信息校验
         */
        private void preSaveCheck(GoodsBrandVO goodsBrandVO, SysAccountVO user) throws ShopException {
                if (null == goodsBrandVO) {
                        throw new ShopException(ErrorCode.IllegalArument.getDesc());
                }
                //TODO如果是提交操作或者某些状态下需要做校验吗？
        }

        @Transactional(rollbackFor = Exception.class)
        public int merge(GoodsBrandDO dto) {
                if(null==dto.getId()){
                        return goodsBrandMapper.insert(dto);
                }
                return goodsBrandMapper.updateByPrimaryKeySelective(dto);
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
            return goodsBrandMapper.batchDeleteByIds(ids);
        }

}
