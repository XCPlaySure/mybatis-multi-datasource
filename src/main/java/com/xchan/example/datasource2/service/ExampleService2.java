package com.xchan.example.datasource2.service;

import com.xchan.example.datasource2.mapper.ExampleMapper2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ExampleService2 {
    private final SqlSessionTemplate sqlSessionTemplate2;

    @Autowired
    public ExampleService2(@Qualifier("sqlSessionTemplate2") SqlSessionTemplate sqlSessionTemplate2) {
        this.sqlSessionTemplate2 = sqlSessionTemplate2;
    }

    private ExampleMapper2 getDao(){
        return sqlSessionTemplate2.getMapper(ExampleMapper2.class);
    }

    public List<HashMap<String, Object>> mainQuery() {
        return getDao().mainQuery();
    }
}
