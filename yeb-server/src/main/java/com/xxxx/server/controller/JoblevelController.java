package com.xxxx.server.controller;


import com.xxxx.server.pojo.Joblevel;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.IJoblevelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
@RequestMapping("/system/basic/joblevel")
public class JoblevelController {
    @Autowired
    private IJoblevelService joblevelService;
    @ApiOperation(value = "获取所有职称")
    @GetMapping("/")
    public List<Joblevel> getAllJobLevel(){
            return joblevelService.list();
    }
    @ApiOperation(value = "添加职称")
    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody Joblevel joblevel){
        boolean b=joblevelService.save(joblevel);
        if(b){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }
    @ApiOperation(value = "修改职称")
    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody Joblevel joblevel){
        boolean b=joblevelService.updateById(joblevel);
        if(b){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }
    @ApiOperation(value = "删除一个职称")
    @DeleteMapping("/{id}")
    public RespBean deletedOneJobLevel(@PathVariable Integer id){
        boolean b=joblevelService.removeById(id);
        if(b){
            return RespBean.success("删除成功");
        }else{
            return RespBean.error("删除失败");
        }
    }
    @ApiOperation("批量删除职位信息")
    @DeleteMapping("/")
    public RespBean deletedAllJobLevel(Integer [] ids){
        boolean b=joblevelService.removeByIds(Arrays.asList(ids));
        if(b){
            return RespBean.success("删除成功");
        }else{
            return RespBean.success("删除失败");
        }
    }
}
