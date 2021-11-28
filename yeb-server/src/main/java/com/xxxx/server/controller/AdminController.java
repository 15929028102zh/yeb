package com.xxxx.server.controller;


import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.IAdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhoubin
 * @since 2021-11-14
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @ApiOperation("添加用户")
    @PutMapping("/")
    public RespBean addAdmin(Admin admin){
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        if(adminService.save(admin)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }
}
