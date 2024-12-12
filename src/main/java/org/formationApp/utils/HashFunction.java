package org.formationApp.utils;

import java.io.UnsupportedEncodingException;
import java.util.HexFormat;

public class HashFunction {
    public  static String hashString (String s) throws UnsupportedEncodingException {

        String salt = "WAz7k8e39z6RUDMLxeCdPOqreMq+LYol5LR1wT0WL40=";
        //ahmed 38343339203930343820393438332038373837203837303020
        byte[] sBytes = s.getBytes("UTF-8");
        byte[] saltBytes = salt.getBytes();
        String hexString = HexFormat.of().formatHex(sBytes) + HexFormat.of().formatHex(saltBytes) ;


        StringBuilder hashS = new StringBuilder();
        int magic = 87;
        int addint =0;

        for (int i = 0; i < hexString.length(); i += 2) {
            int hex = Integer.parseInt(hexString.substring(i, i + 2), 16);
            hashS.append(Integer.toHexString(hex + (magic*addint)));// Append the result with a space for clarity
            addint+=magic*hex;
        }

        //System.out.println(hashS.toString().trim()+ " "+ hashS.toString().trim().length()); // Print the final result
        return hashS.toString().trim();
    }
    public static String hashPassword(int i, String password ) throws UnsupportedEncodingException {
        String newPassword = hashString(password) ;
        for (int j =0 ; j<i;j++){
            newPassword= hashString(newPassword);
        }
        return (newPassword);
    }


}

