package com.lazyman.pickupweb;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * Author chenxiaoqi on 2017/7/30.
 */

@MappedSuperclass
public class NamedEntity extends BaseEntity {

    @Column(length = 64)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
