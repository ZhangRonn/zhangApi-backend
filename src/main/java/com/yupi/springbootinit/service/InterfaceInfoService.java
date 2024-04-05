package com.yupi.springbootinit.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.springbootinit.model.dto.interfaceinfo.InterfaceInfoQueryRequest;
import com.yupi.springbootinit.model.vo.InterfaceInfoVO;
import com.zhang.model.entity.InterfaceInfo;

import javax.servlet.http.HttpServletRequest;



public interface InterfaceInfoService extends IService<InterfaceInfo> {
    void validInterfaceInfo(InterfaceInfo interfaceinfo, boolean add);

    Page<InterfaceInfo> searchFromEs(InterfaceInfoQueryRequest interfaceinfoQueryRequest);

    /**
     * 获取帖子封装
     *
     * @param interfaceinfo
     * @param request
     * @return
     */
    InterfaceInfoVO getInterfaceInfoVO(InterfaceInfo interfaceinfo, HttpServletRequest request);
    
    QueryWrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceinfoQueryRequest);
    /**
     * 分页获取帖子封装
     *
     * @param interfaceinfoPage
     * @param request
     * @return
     */
    Page<InterfaceInfoVO> getInterfaceInfoVOPage(Page<InterfaceInfo> interfaceinfoPage, HttpServletRequest request);
}
