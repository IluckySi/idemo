package com.ilucky.idemo.test;

import java.util.HashMap;
import java.util.Map;

public class FastJSONTest {

    public static void main(String[] args) {


        StringBuffer sb = new StringBuffer();
        sb.append("\n" + "axxxx");
        sb.append("\n" + "bxxxx");
       // sb.insert(0, "sdx");
        sb.insert(0, "");
        System.out.println(sb.toString());
//        Map<String, Object> request = new HashMap<String, Object>();
//        request.put("uri", "/login");
//        request.put("coll_time", System.currentTimeMillis());
//        request.put("current_time", System.currentTimeMillis());
//        Map<String, Object> copyMap = (Map<String, Object>)ObjectCopyUtils.copyDataByJsonSerialization(request);

    }

//    public static <T> T copyDataByJsonSerialization(T t) {
//        String luaDataListStr = JSON.toJSONString(t);
//        T copyData = (T)JSON.parseObject(luaDataListStr, new TypeReference<T>() {
//        }, new com.alibaba.fastjson.parser.Feature[0]);
//        return copyData;
//    }
}
