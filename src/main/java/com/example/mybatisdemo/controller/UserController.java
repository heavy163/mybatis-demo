package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.generated.dao.UserMapper;
import com.example.mybatisdemo.model.Test;
import com.gitee.sunchenbin.mybatis.actable.command.PageResultCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserMapper userMapper;

}
