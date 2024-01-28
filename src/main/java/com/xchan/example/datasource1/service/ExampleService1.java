package com.xchan.example.datasource1.service;

import com.xchan.example.datasource1.mapper.ExampleMapper1;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ExampleService1 {
    private final SqlSessionTemplate sqlSessionTemplate1;

    @Autowired
    public ExampleService1(@Qualifier("sqlSessionTemplate1") SqlSessionTemplate sqlSessionTemplate1) {
        this.sqlSessionTemplate1 = sqlSessionTemplate1;
    }

    private ExampleMapper1 getDao(){
        return sqlSessionTemplate1.getMapper(ExampleMapper1.class);
    }

    public List<HashMap<String, Object>> mainQuery() {
        return getDao().mainQuery();
    }
}
