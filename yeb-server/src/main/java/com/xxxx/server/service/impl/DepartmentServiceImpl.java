package com.xxxx.server.service.impl;

import com.xxxx.server.pojo.Department;
import com.xxxx.server.mapper.DepartmentMapper;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhoubin
 * @since 2021-11-14
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    /**
     * 获取所有部门
     * @return
     */
    @Override
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartments(-1);
    }

    @Override
    public void addDep(Department department) {
        departmentMapper.addDep(department);
    }

    @Override
    public RespBean deleteDep(Integer id) {
        Department department=new Department();
        department.setId(id);
        departmentMapper.deleteDep(department);
        if(-2==department.getResult()){
            return RespBean.error("该部门下还有子部门，删除失败");
        }else if(-1==department.getResult()){
            return RespBean.error("该部门下还有员工,删除失败");
        }else if(1==department.getResult()){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
