package com.xxxx.server.mapper;

import com.xxxx.server.pojo.MenuRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.MenuRole;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoubin
 * @since 2021-11-14
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    Integer insertRecord(Integer rid, Integer[] mids);
}
