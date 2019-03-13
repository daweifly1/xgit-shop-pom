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
import com.xgit.bj.shop.beans.vo.goods.MemberPriceVO;
import com.xgit.bj.shop.generic.dao.entity.goods.MemberPriceDO;
import com.xgit.bj.shop.generic.dao.mapper.goods.MemberPriceMapper;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

/**
 * MemberPrice 后台接口实现类
 */
@Slf4j
@Service
public class MemberPriceService  extends BaseService<MemberPriceVO, MemberPriceDO> {

        @Autowired
        private MemberPriceMapper memberPriceMapper;

        @PostConstruct
        public void init() {
                super.addMapper(memberPriceMapper);
        }

        protected MemberPriceService() {
                super(MemberPriceVO.class, MemberPriceDO.class);
        }

        /**
         * 查询列表
         *
         * @param condition
         */
        public PageCommonVO<MemberPriceVO> list(SearchCommonVO<MemberPriceVO> condition) {
                if (null == condition.getFilters()) {
                        condition.setFilters(new MemberPriceVO());
                }
                PageCommonVO<MemberPriceVO> page= super.list(condition);
                //TODO．．．是否需要其他操作完善数据
                return page;
        }

        /**
         * 查询列表
         *
         * @param vo
         */
        public List<MemberPriceDO> queryList(MemberPriceVO vo) {
                return memberPriceMapper.queryList(vo);
        }


        /**
         * 查询单条记录
         *
         * @param id
         */
        public MemberPriceDO queryById(Long id) {
                MemberPriceVO vo=new MemberPriceVO();
                vo.setId(id);
                List<MemberPriceDO> list=queryList(vo);
                if (CollectionUtils.isNotEmpty(list)) {
                        return list.get(0);
                }
                return null;
        }
        /**
         * 保存数据
         *
         * @param memberPriceVO
         * @param user
         */
        @Transactional(rollbackFor = Exception.class)
        public ErrorCode save(MemberPriceVO memberPriceVO, SysAccountVO user){
                //TODO　是否需要前置校验逻辑
                //初始时候数据状态
                int saveStatus=0;
                doSave(memberPriceVO, user);
                //TODO　是否需要后置操作
                return ErrorCode.Success;
        }

        /**
         * 根据状态，等信息保存数据
         * @param memberPriceVO
         * @param user
         */
        private void doSave(MemberPriceVO memberPriceVO,SysAccountVO user) throws ShopException {
                //TODO 保存是否需要校验？
                preSaveCheck(memberPriceVO,user);
                MemberPriceDO memberPriceDO = getDO(memberPriceVO);
                Date now =new Date();
                if (null==memberPriceDO.getId()) {
                memberPriceDO.setDbCreateAuthor(user.getLoginName());
                memberPriceDO.setDbCreateTime(now);
                //TODO ...其他新增时候需要赋值的记录
                log.info("新增操作，memberPriceDO:{}",memberPriceDO);
                } else {
                memberPriceDO.setDbUpdateAuthor(user.getLoginName());
                log.info("编辑操作，memberPriceDO:{}", memberPriceDO);
                //TODO 之前的记录需要处理？例如删除关联信息
                }
                //TODO 状态处理,..　关联信息处理

                boolean isSuccess = this.merge(memberPriceDO) > 0;
                if (!isSuccess) {
                        throw new ShopException("保存记录失败");
                }
                //TODO　关联信息后置处理。。。
        }
        /**
         * 保存前信息校验
         */
        private void preSaveCheck(MemberPriceVO memberPriceVO, SysAccountVO user) throws ShopException {
                if (null == memberPriceVO) {
                        throw new ShopException(ErrorCode.IllegalArument.getDesc());
                }
                //TODO如果是提交操作或者某些状态下需要做校验吗？
        }

        @Transactional(rollbackFor = Exception.class)
        public int merge(MemberPriceDO dto) {
                if(null==dto.getId()){
                        return memberPriceMapper.insert(dto);
                }
                return memberPriceMapper.updateByPrimaryKeySelective(dto);
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
            return memberPriceMapper.batchDeleteByIds(ids);
        }

}
