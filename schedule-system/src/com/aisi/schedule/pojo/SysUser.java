package com.aisi.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data //getter setter hashcode toString equals
@AllArgsConstructor //全参
@NoArgsConstructor  //无参
public class SysUser implements Serializable {

    private Integer uid;
    private String username;
    private String userPwd;
}
