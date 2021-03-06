package com.xxxx.server.controller;


import com.xxxx.server.pojo.Department;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.IDepartmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhoubin
 * @since 2021-11-14
 */
@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;
    @ApiOperation(value = "获取所有部门")
    @GetMapping("/")
    public List<Department> getAllDepartMent(){
      return departmentService.getAllDepartments();
    }
    @ApiOperation(value = "添加一个部门")
    @PostMapping("/")
    public RespBean addDep(@RequestBody  Department department){
        department.setEnabled(true);
       departmentService.addDep(department);
       if(1==department.getResult()){
           return RespBean.success("添加成功",department);
       }
       return RespBean.error("添加失败");
    }
    @ApiOperation(value = "删除一个部门")
    @DeleteMapping("/{id}")
    public RespBean deleteDep(@PathVariable Integer id){
        return departmentService.deleteDep(id);
    }

}
