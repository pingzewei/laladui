package com.webb.CreateAccount;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;

public class Create {
    private static HttpClient httpClient = new DefaultHttpClient();
    private static HttpPost httppost;
    private static HttpResponse response;

    public static final String ADD_URL = "http://47.96.109.7:8082/user/relationship";

    public static void main(String[] args) throws Exception{
        httppost = new HttpPost(ADD_URL);
        JSONObject jsonParam = new JSONObject();
        Long UserMobile ;
        Long ParentMobile ;
        int UserId ;

        String appUserMobile ;
        String appParentMobile ;
        String appUserId ;
        for(int i = 0 ; i < 10 ; i++ ){

            if(false){
                //不连贯创建
                UserMobile = 1980000000L ;
                ParentMobile = 1880000000L ;
                UserId = 100 ;

                appUserMobile = String.valueOf(UserMobile) + i;
                appParentMobile = String.valueOf(ParentMobile) + i;
                appUserId = String.valueOf(UserId) + i;
            }else{
                //连贯创建
                UserMobile = 12900000001L + i;
                ParentMobile = UserMobile - 1 ;
                UserId = 100 ;

                appUserMobile = String.valueOf(UserMobile) ;
                appParentMobile = String.valueOf(ParentMobile) ;
                appUserId = String.valueOf(UserId) + i;
            }


            System.out.println("下级："  + appUserMobile);
            System.out.println("上级："  + appParentMobile);
            System.out.println("UserId："  + appUserId);

            jsonParam.put("appKey","03CEC948-2E22-7E0D-C7BF-6B1DB772BBA6");
            jsonParam.put("appSecret","5hnwonmvqis5vs9yjnz5z5azkorszfj2");
            jsonParam.put("appUserMobile",appUserMobile);
            jsonParam.put("appParentMobile",appParentMobile);
            jsonParam.put("appUserId",appUserId);

            try {

                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");// 解决中文乱码问题
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httppost.setEntity(entity);
                response = httpClient.execute(httppost);

                String strResult = EntityUtils.toString(response.getEntity());
                System.out.println("查看返回的结果："  + strResult);
                System.out.println("————————————————这世道华丽的分割线————————————————");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        httppost.releaseConnection();
    }
}