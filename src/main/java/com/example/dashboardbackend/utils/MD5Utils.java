package com.example.dashboardbackend.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @purpose: MD5 encryption tools
 */
public class MD5Utils {

    /**
     * MD5 encryption class
     @param str unencrypted str
     @return    encrypted str
     */
    public static String code(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str. getBytes());
            byte[]byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest [offset];
                if(i<0)
                    i += 256;
                if(i<16)
                    buf.append("'");
                buf.append(Integer.toHexString(i));
            }
            //32bit encryption
            return buf. toString();
            //16bit encryption
            //return buf. toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
