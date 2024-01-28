package com.xchan.example.datasource2.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ExampleMapper2 {
    List<HashMap<String, Object>> mainQuery();
}
