package com.zhang.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zhang.model.entity.User;

/**
 * 用户服务
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
public interface InnerUserService {


        User getInvokeUser(String accessKey);

}
