package com.example.mybatisdemo.service.impl;


import com.example.mybatisdemo.generated.mapper.UserMapper;
import com.example.mybatisdemo.generated.model.User;
import com.example.mybatisdemo.generated.model.UserExample;
import com.example.mybatisdemo.service.UserService;
import com.gitee.sunchenbin.mybatis.actable.command.PageResultCommand;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User findById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User insert(User user) {
        long id = userMapper.insert(user);
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(User user) {
        long id = userMapper.updateByPrimaryKey(user);
        return id > 0;
    }

    @Override
    public boolean deleteById(long id) {
        return userMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<User> listAll() {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        return userMapper.selectByExample(example);
    }

    @Override
    public PageResultCommand<User> page(int pageNum, int pageSize) throws NoSuchFieldException {
        return null;
    }
}
