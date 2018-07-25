package com.webb.Interface;

import java.io.IOException;



public class HttpCase {
    static getVerificationCode VerificationCode =new getVerificationCode();
    public static  String Code = "" ;
    public static void resultCheck() throws IOException{
        Code = VerificationCode.getHttpRespone(null);

    }

}
