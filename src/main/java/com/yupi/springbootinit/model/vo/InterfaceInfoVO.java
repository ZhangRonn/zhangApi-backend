package com.yupi.springbootinit.model.vo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhang.model.entity.InterfaceInfo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
public class InterfaceInfoVO extends InterfaceInfo implements Serializable {

    private final static Gson GSON = new Gson();

    /**
     * id
     */
    private Long id;

    private Integer totalNum;

    private String title;

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    /**
     * 内容
     */
    private String content;

    /**
     * 点赞数
     */
    private Integer thumbNum;

    /**
     * 收藏数
     */
    private Integer favourNum;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 标签列表
     */
    private List<String> tagList;

    /**
     * 创建人信息
     */
    private UserVO user;

    /**
     * 是否已点赞
     */
    private Boolean hasThumb;

    /**
     * 是否已收藏
     */
    private Boolean hasFavour;



    /**
     * 包装类转对象
     *
     * @param interfaceinfoVO
     * @return
     */
    public static InterfaceInfo voToObj(InterfaceInfoVO interfaceinfoVO) {
        if (interfaceinfoVO == null) {
            return null;
        }
        InterfaceInfo interfaceinfo = new InterfaceInfo();
        BeanUtils.copyProperties(interfaceinfoVO, interfaceinfo);
        List<String> tagList = interfaceinfoVO.getTagList();
        if (tagList != null) {
            interfaceinfo.setTags(GSON.toJson(tagList));
        }
        return interfaceinfo;
    }

    /**
     * 对象转包装类
     *
     * @param interfaceinfo
     * @return
     */
    public static InterfaceInfoVO objToVo(InterfaceInfo interfaceinfo) {
        if (interfaceinfo == null) {
            return null;
        }
        InterfaceInfoVO interfaceinfoVO = new InterfaceInfoVO();
        BeanUtils.copyProperties(interfaceinfo, interfaceinfoVO);
        interfaceinfoVO.setTagList(GSON.fromJson(interfaceinfo.getTags(), new TypeToken<List<String>>() {
        }.getType()));
        return interfaceinfoVO;
    }
}
