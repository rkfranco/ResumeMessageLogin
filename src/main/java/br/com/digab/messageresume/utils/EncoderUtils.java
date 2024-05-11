package br.com.digab.messageresume.utils;

import java.security.MessageDigest;

public abstract class EncoderUtils {

    private static final String ALGORITH = "SHA-512";
    
    public static String encode(String toEncode) throws Exception {
        return new String(MessageDigest.getInstance(ALGORITH).digest(toEncode.getBytes()));
    }
}
