package org.formationApp.utils;

import java.io.UnsupportedEncodingException;
import java.util.HexFormat;

public class HashFunction {
    public  static String hashString (String s) throws UnsupportedEncodingException {

        String salt = "WAz7k8e39z6RUDMLxeCdPOqreMq+LYol5LR1wT0WL40=";
        //ahmed 38343339203930343820393438332038373837203837303020
        byte[] o = s.getBytes("UTF-8");
        byte[] ss = salt.getBytes();
        String hexString = HexFormat.of().formatHex(o) + HexFormat.of().formatHex(ss) ;


        StringBuilder bok = new StringBuilder();
        int magic = 87;
        int addint =0;

        for (int i = 0; i < hexString.length(); i += 2) {
            int hex = Integer.parseInt(hexString.substring(i, i + 2), 16);
            bok.append(Integer.toHexString(hex + (magic*addint)));// Append the result with a space for clarity
            addint+=magic*hex;
        }

        //System.out.println(bok.toString().trim()+ " "+ bok.toString().trim().length()); // Print the final result
        return bok.toString().trim();
    }
    public static String hashPassword(int i, String password ) throws UnsupportedEncodingException {
        String newPassword = hashString(password) ;
        for (int j =0 ; j<i;j++){
            newPassword= hashString(newPassword);
        }
        return (newPassword);
    }


}

