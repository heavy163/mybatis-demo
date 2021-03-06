package com.example.mybatisdemo.service;

import com.example.mybatisdemo.model.Test;
import com.gitee.sunchenbin.mybatis.actable.command.PageResultCommand;

import java.util.List;

public interface TestService {

    Test findById(int id);
    Test insert(Test test);
    boolean update(Test test);
    boolean deleteById(int id);
    List<Test> listAll();
    PageResultCommand<Test> page(int pageNum, int pageSize) throws NoSuchFieldException;
}
