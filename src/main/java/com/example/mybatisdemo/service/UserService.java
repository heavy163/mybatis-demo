package com.example.mybatisdemo.service;

import com.example.mybatisdemo.generated.model.User;
import com.gitee.sunchenbin.mybatis.actable.command.PageResultCommand;

import java.util.List;

public interface UserService {

    User findById(long id);
    User insert(User User);
    boolean update(User User);
    boolean deleteById(long id);
    List<User> listAll();
    PageResultCommand<User> page(int pageNum, int pageSize) throws NoSuchFieldException;
    
}
