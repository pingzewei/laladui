package com.webb.Interface;

import java.net.HttpURLConnection;
import java.net.URL;

public class URLConnection {

    public static HttpURLConnection getConnection(String url) {
        HttpURLConnection connection = null;
        try {
            // 打开和URL之间的连接
            URL postUrl = new URL(url);
            connection = (HttpURLConnection) postUrl.openConnection();
            // 设置通用的请求属性
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}