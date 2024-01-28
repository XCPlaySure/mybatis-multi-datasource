package com.xchan.example.controller;

import com.google.gson.Gson;
import com.xchan.example.datasource1.service.ExampleService1;
import com.xchan.example.datasource2.service.ExampleService2;
import com.xchan.example.utils.CommonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
public class TestController {
    private static final Logger logger = LogManager.getLogger(TestController.class);

    private final ExampleService1 exampleService1;
    private final ExampleService2 exampleService2;
    private final CommonUtil commonUtil;

    @Autowired
    public TestController(ExampleService1 theExampleService1, ExampleService2 theExampleService2,CommonUtil theCommonUtil) {
        this.exampleService1 = theExampleService1;
        this.exampleService2 = theExampleService2;
        commonUtil = theCommonUtil;
    }

    @RequestMapping(value = "/testing", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<String> testing(HttpServletRequest request){
        Gson gson = commonUtil.GsonBuilder();
        String res = null;
        String message = null;
        HttpStatus status = HttpStatus.OK;
        boolean error = true;
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> result = new HashMap<>();

        try{
            List<HashMap<String, Object>> test = exampleService1.mainQuery();
            result.put("from ajsdb", test);
            List<HashMap<String, Object>> test2 = exampleService2.mainQuery();
            result.put("from ebmuat", test2);

            error = false;
            message = "request succeed";
        }catch (Exception ex){
            status = HttpStatus.NOT_FOUND;
            message = "something wrong";
            logger.error(String.format("Path: %s Error: %s", request.getServletPath(), ex));
        }

        map.put("error", error);
        map.put("message", message);
        map.put("result", result);
        res = gson.toJson(map);

        return new ResponseEntity<>(res, status);
    }

    @RequestMapping("/test")
    public ResponseEntity<String> test(){
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return new ResponseEntity<>("Check out the Logs to see the output...", HttpStatus.OK);
    }
}
