package com.example.mybatisdemo.service.impl;


import com.example.mybatisdemo.generated.mapper.UserMapper;
import com.example.mybatisdemo.generated.model.User;
import com.example.mybatisdemo.generated.model.UserExample;
import com.example.mybatisdemo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo<User> page(int pageNum, int pageSize) throws NoSuchFieldException {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.selectByExample(new UserExample());
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }
}
