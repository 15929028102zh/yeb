package com.xxxx.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxxx.server.pojo.Menu;
import com.xxxx.server.pojo.MenuRole;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.Role;
import com.xxxx.server.service.IMenuRoleService;
import com.xxxx.server.service.IMenuService;
import com.xxxx.server.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IMenuService menuService;
    @Autowired
    private IMenuRoleService menuRoleService;
    @ApiOperation(value = "获取所有角色")
    @GetMapping("/")
    public List<Role> getAllRole(){
        return roleService.list();
    }
    @ApiOperation(value = "添加一个角色")
    @PostMapping("/role")
    public RespBean addOneRole(@RequestBody  Role role){
        if(!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        if(roleService.save(role)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }
    @ApiOperation(value = "删除一个角色")
    @DeleteMapping("/{rid}")
    public RespBean deleteRole(@PathVariable  Integer rid){
        if(roleService.removeById(rid)){
            return  RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }
    @ApiOperation(value ="查询所有菜单")
    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }
    @ApiOperation(value = "根据角色id查询菜单列表")
    @GetMapping("/mid/{rid}")
    public List<Integer> getMenuWithRid(@PathVariable Integer rid){
    return menuRoleService.list(new QueryWrapper<MenuRole>()
                     .eq("rid",rid))
                     .stream()
                     .map(MenuRole::getMid)
                     .collect(Collectors.toList());
    }
    @ApiOperation(value = "更新角色菜单")
    @PutMapping("/")
    public RespBean updateMenuRole( Integer rid,Integer mids[]){
        return menuRoleService.updateMenuRole(rid,mids);
    }
}
