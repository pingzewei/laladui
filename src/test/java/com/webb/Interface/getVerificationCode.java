package com.webb.Interface;

import com.webb.TestCase.LaladuiCase;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class getVerificationCode {
    private String url="";

    public String geturl() {
        return url;
    }

    public String getHttpRespone(String cityCode) throws IOException {
        String line = "";
        String httpResults = "";
        url=("http://10.32.100.15:8081/batch/get_code?mobile="+LaladuiCase.MobilePhoneNumber);
        try {
            HttpURLConnection connection = URLConnection
                    .getConnection(url);
            DataOutputStream out = null;
            // 建立实际的连接
            connection.connect();
            out = new DataOutputStream(connection.getOutputStream());
            out.flush();
            out.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                httpResults = httpResults + line.toString();
            }
            reader.close();
            // 断开连接
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpResults;
    }

}