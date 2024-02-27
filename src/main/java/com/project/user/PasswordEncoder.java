package com.project.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface PasswordEncoder {

	/**
     * 비밀번호를 MD5 알고리즘으로 해싱
     * @param password 해싱할 비밀번호
     * @return 해싱된 비밀번호
     */
    public static String encode(String password) {
        try {
            // MD5 해시 함수를 사용하여 비밀번호를 해싱합니다.
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] byteData = md.digest();

            // 바이트 데이터를 16진수 문자열로 변환합니다.
            StringBuilder sb = new StringBuilder();
            for (byte b : byteData) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // 해당 알고리즘이 없는 경우에 대한 예외 처리
            e.printStackTrace();
            return null;
        }
    }
}
