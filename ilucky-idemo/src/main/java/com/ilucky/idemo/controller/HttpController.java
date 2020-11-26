package com.ilucky.idemo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * http
 */
@RestController
@RequestMapping("/http")
public class HttpController {

    // httpclient get
    @RequestMapping(value="/httpclient/get")
    public String httpclient_get(@RequestParam("url") String url) {
        try {
            HttpClient httpClient = new HttpClient();
            GetMethod getMethod = new GetMethod(url);
            int status = httpClient.executeMethod(getMethod);
            if (status == HttpStatus.SC_OK) {
                return getMethod.getResponseBodyAsString();
            }
            return "httpclient/get(" + url + ") status="+status;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    // httpclient post
    @RequestMapping(value="/httpclient/post")
    public String httpclient_post(@RequestParam("url") String url) {
        try {
            HttpClient httpClient = new HttpClient();
            PostMethod postMethod = new PostMethod(url);
            int status = httpClient.executeMethod(postMethod);
            if (status == HttpStatus.SC_OK) {
                return postMethod.getResponseBodyAsString();
            }
            return "httpclient/post(" + url + ") status=" + status;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    // httpurlconnection: conn.getOutputStream()和conn.getInputStream()都有可能是耗时方法
    @RequestMapping(value="/httpurlconnection")
    public String httpurlconnection(@RequestParam("url") String url) {
        String result = null;
        PrintWriter out = null;
        BufferedReader in = null;
        long start = 0;
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            out = new PrintWriter(conn.getOutputStream());
            out.flush();

            // 获取返回数据
            start = System.currentTimeMillis();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            long end = System.currentTimeMillis();
            System.out.println("cost:" + (end - start));
            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            result = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            long end = System.currentTimeMillis();
            System.out.println("cost:" + (end - start));
            try{
                if(out != null) { out.close(); }
                if(in != null) { in.close(); }
            } catch(IOException ex){
               ex.printStackTrace();
            }
        }
        return result;
    }

    // TODO: okhttp

    // TODO: resttemplate

    // TODO: asynhttpclient

    // TODO:

}
