package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.generated.model.User;
import com.example.mybatisdemo.service.UserService;
import com.gitee.sunchenbin.mybatis.actable.command.PageResultCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "user")
public class UserController {

    @Autowired
    UserService userService;
    
    @GetMapping("/all")
    @ApiOperation("查看全部test")
    public List<User> all() {
        return userService.listAll();
    }

    @GetMapping("/list/{page}/{size}")
    @ApiOperation("分页查看test")
    public PageResultCommand<User> page(@PathVariable("page") int page, @PathVariable("size") int size) {
        try {
            return userService.page(page, size);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping
    @ApiOperation("创建新的Test")
    public User create(@RequestParam("name") String myName,
                       @RequestParam("nick") String nick, @RequestParam("password")String password) {
        User user = new User();
        user.setUserName(myName);
        user.setNickName(nick);
        user.setPassword(password);
        user = userService.insert(user);
        return user;
    }

    @PutMapping("/{id}")
    @ApiOperation("更新Test")
    public User update(@PathVariable("id")long id, @RequestBody User User) {
        User.setId(id);
        if (userService.update(User)) {
            return User;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除Test")
    public boolean delete(@PathVariable("id") int id) {
        return userService.deleteById(id);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询Test")
    public User findById(@PathVariable("id") int id) {
        return userService.findById(id);
    }
    

}
