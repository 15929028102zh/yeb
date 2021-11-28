package com.xxxx.server.controller;

import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.AdminLoginParam;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * 登录
 *
 * @author zhoubin
 * @since 1.0.0
 */
@Api(tags = "LoginController")
@RestController
public class LoginController {

	@Autowired
	private IAdminService adminService;

	@ApiOperation(value = "登录之后返回token")
	@PostMapping("/login")
	public RespBean login(@RequestBody AdminLoginParam adminLoginParam, HttpServletRequest request){
		return adminService.login(adminLoginParam.getUsername(),adminLoginParam.getPassword(),adminLoginParam.getCode(),request);
	}


	@ApiOperation(value = "获取当前登录用户的信息")
	@GetMapping("/admin/info")
	public Admin getAdminInfo(HttpServletRequest request){

		String username = (String) request.getSession().getAttribute("username");
		Admin admin = adminService.getAdminByUserName(username);
		admin.setPassword(null);
		admin.setRoles(adminService.getRoles(admin.getId()));
		return admin;
	}

	@ApiOperation(value = "退出登录")
	@PostMapping("/logout")
	public RespBean logout(){
		return RespBean.success("注销成功！");
	}

}