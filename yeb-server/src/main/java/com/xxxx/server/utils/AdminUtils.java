package com.xxxx.server.utils;

import com.xxxx.server.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;



public class AdminUtils {

    public static Admin getCurrentAdmin() {

        return (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
