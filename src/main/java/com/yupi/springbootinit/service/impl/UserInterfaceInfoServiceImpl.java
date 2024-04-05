package com.yupi.springbootinit.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.yupi.springbootinit.common.ErrorCode;
import com.yupi.springbootinit.common.ResultUtils;
import com.yupi.springbootinit.exception.BusinessException;
import com.yupi.springbootinit.mapper.UserInterfaceInfoMapper;
import com.zhang.model.entity.User;
import com.zhang.model.entity.UserInterfaceInfo;

import com.yupi.springbootinit.service.UserInterfaceInfoService;
import com.zhang.service.InnerUserInterfaceInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;


@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {

    public void validInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);

        }
        if ( userInterfaceInfo.getLeftNum() <=0 ) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能小于零");

        }
        }
        // 有参数则校验
        @Override
        public boolean invokeCount(long interfaceInfoId, long userId) {
            QueryWrapper<UserInterfaceInfo> QueryWrapper = new QueryWrapper<>();
            QueryWrapper.eq("interfaceInfoId", interfaceInfoId);
            QueryWrapper.eq("userId", userId);
            UserInterfaceInfo one = null;
            one = this.getOne(QueryWrapper);

            if (Objects.isNull(one)) {
                UserInterfaceInfo userInterfaceInfo = new UserInterfaceInfo();
                userInterfaceInfo.setInterfaceInfoId(interfaceInfoId);
                userInterfaceInfo.setUserId(userId);
                userInterfaceInfo.setTotalNum(0);
                userInterfaceInfo.setLeftNum(50);
                userInterfaceInfo.setStatus(0);
                return    this.save(userInterfaceInfo);
            }
            UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("interfaceInfoId", interfaceInfoId);
            updateWrapper.eq("userId", userId);
            updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
            return this.update(updateWrapper);
        }




}





