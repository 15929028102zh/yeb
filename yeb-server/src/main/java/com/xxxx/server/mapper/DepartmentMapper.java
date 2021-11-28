package com.xxxx.server.mapper;

import com.xxxx.server.pojo.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoubin
 * @since 2021-11-14
 */
public interface DepartmentMapper extends BaseMapper<Department> {
    /**
     * 获取所有的部门列表
     * @param parentid
     * @return
     */
    List<Department> getAllDepartments(Integer parentid);

    /**
     * 添加一个部门
     * @param department
     * @return
     */
    void addDep(Department department);

    /**
     * 根据id删除一个部门
     * @param department
     */
    void deleteDep(Department department);
}
