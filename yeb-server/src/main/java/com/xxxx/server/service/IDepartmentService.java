package com.xxxx.server.service;

import com.xxxx.server.pojo.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 * @since 2021-11-14
 */
public interface IDepartmentService extends IService<Department> {

    List<Department> getAllDepartments();

    void addDep(Department department);

    RespBean deleteDep(Integer id);
}
