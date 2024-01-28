package com.xchan.example.datasource1.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ExampleMapper1 {
    List<HashMap<String, Object>> mainQuery();
}
