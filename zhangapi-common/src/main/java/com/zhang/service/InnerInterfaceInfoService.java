package com.zhang.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zhang.model.entity.InterfaceInfo;
import com.zhang.model.entity.UserInterfaceInfo;

/**
* @author 张
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-10-14 23:11:12
*/
public interface InnerInterfaceInfoService  {
   InterfaceInfo getInterfaceInfo(String path, String method);
   void validInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);
}
