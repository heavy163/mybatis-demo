package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.model.Test;
import com.example.mybatisdemo.service.TestService;
import com.gitee.sunchenbin.mybatis.actable.command.PageResultCommand;
import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseCRUDManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    BaseCRUDManager baseCRUDManager;

    @Override
    public Test findById(int id) {
        Test test = new Test();
        test.setId(id);
        return baseCRUDManager.selectByPrimaryKey(test);
    }

    @Override
    public Test insert(Test test) {
        return baseCRUDManager.insert(test);
    }

    @Override
    public boolean update(Test test) {
        return baseCRUDManager.updateByPrimaryKey(test);
    }

    @Override
    public boolean deleteById(int id) {
        Test test = new Test();
        test.setId(id);
        return baseCRUDManager.deleteByPrimaryKey(test) > 0;
    }

    @Override
    public List<Test> listAll() {
        return baseCRUDManager.selectAll(Test.class);
    }

    @Override
    public PageResultCommand<Test> page(int pageNum, int pageSize) throws NoSuchFieldException {
        LinkedHashMap<String,String> map = new LinkedHashMap();
        map.put(Test.class.getField("id").getName(), "asc");
        return baseCRUDManager.search(new Test(), 0, 50, map);
    }
}
