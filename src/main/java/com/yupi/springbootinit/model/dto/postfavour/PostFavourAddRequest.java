package com.yupi.springbootinit.model.dto.postfavour;

import java.io.Serializable;
import lombok.Data;


@Data
public class PostFavourAddRequest implements Serializable {

    /**
     * 帖子 id
     */
    private Long postId;

    private static final long serialVersionUID = 1L;
}