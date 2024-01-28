package com.xchan.example.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CommonUtil {
    public CommonUtil(){}

    public Gson GsonBuilder(){
        Gson gson = new Gson();
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        gson = builder.create();
        return gson;
    }

    public String getDatetimeJava2() {
        Date date = new Date();
        String strDateFormat = "yyMMddHHmm";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate = dateFormat.format(date);
        return formattedDate;
    }
}
