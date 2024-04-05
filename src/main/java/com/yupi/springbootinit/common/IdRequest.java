package com.yupi.springbootinit.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class IdRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}