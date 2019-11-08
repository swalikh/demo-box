package com.swalikh.jpa.base;
import com.swalikh.kernel.exception.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


/**
 * Copyright @2019 nlelpct.
 * @author: 黄磊
 * date:  2019/6/18  11:23
 * use to：针对JPA实现的公用基础类，常见的增删改查方法有的
 * modify：
 */
@Slf4j
public abstract class BaseController<T, S extends BaseService> {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected S baseServices;

    //增加和修改
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result add(@RequestBody T entity) {
        return Result.buildOk("添加成功", baseServices.addAndSave(entity));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result deleteByID(@PathVariable Long id) {
        baseServices.deleteById(id);
        return Result.ok("删除成功");
    }
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getByID(@PathVariable Long id) {
        return Result.buildOk("按ID查询成功", baseServices.getByID(id));
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public Result getAll() {
        return Result.buildOk("查询全部成功", baseServices.getAll());
    }


}
