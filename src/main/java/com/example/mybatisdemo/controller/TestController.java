package com.example.mybatisdemo.controller;


import com.example.mybatisdemo.model.Test;
import com.example.mybatisdemo.service.TestService;
import com.gitee.sunchenbin.mybatis.actable.command.PageResultCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "test")
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/all")
    @ApiOperation("查看全部test")
    public List<Test> all() {
        return testService.listAll();
    }

    @GetMapping("/list/{page}/{size}")
    @ApiOperation("分页查看test")
    public PageResultCommand<Test> page(@PathVariable("page") int page, @PathVariable("size") int size) {
        try {
            return testService.page(page, size);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping
    @ApiOperation("创建新的Test")
    public Test create(@RequestParam("name") String myName, @RequestParam("desc") String description) {
        Test test = new Test();
        test.setName(myName);
        test.setDescription(description);
        test = testService.insert(test);
        return test;
    }

    @PutMapping("/{id}")
    @ApiOperation("更新Test")
    public Test update(@PathVariable("id")int id, @RequestBody Test test) {
        test.setId(id);
        if (testService.update(test)) {
            return test;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除Test")
    public boolean delete(@PathVariable("id") int id) {
        return testService.deleteById(id);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询Test")
    public Test findById(@PathVariable("id") int id) {
        return testService.findById(id);
    }
}