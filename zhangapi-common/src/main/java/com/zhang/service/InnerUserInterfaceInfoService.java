package com.zhang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhang.model.entity.UserInterfaceInfo;

/**
* @author 张
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2024-03-21 19:39:27
*/
public interface InnerUserInterfaceInfoService  {

    boolean invokeCount(long interfaceInfoId, long userId);
}
