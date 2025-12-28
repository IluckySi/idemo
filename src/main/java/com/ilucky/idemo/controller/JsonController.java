package com.ilucky.idemo.controller;

import java.util.HashMap;
import java.util.Map;
import org.mortbay.util.ajax.JSON;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * json
 */
@RestController
@RequestMapping("/json")
public class JsonController {

    @RequestMapping(value="/fastjson/parse")
    public String parse() {
        JSON.parse("{\"a\":\"1\"}");
        return "fastjson";
    }

    @RequestMapping(value="/fastjson/parse2")
    public String parse2() {
        JSON.parse("{\"a\",\"1\"");
        return "fastjson";
    }

    @RequestMapping(value="/fastjson/tostring")
    public String tostring() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        String result = JSON.toString(map);
        return result;
    }

    // TODO: Jackson

    // TODO: GSON
}

