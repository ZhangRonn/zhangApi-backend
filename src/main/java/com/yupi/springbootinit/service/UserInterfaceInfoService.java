package com.yupi.springbootinit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.springbootinit.model.entity.Post;
import com.zhang.model.entity.UserInterfaceInfo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;



public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    void validInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);
    boolean invokeCount(long interfaceInfoId, long userId);

}
