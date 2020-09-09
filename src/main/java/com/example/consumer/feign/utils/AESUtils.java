package com.example.consumer.feign.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @ClassName AESUtils
 * @User zhang
 * @Description 该工具类提供了简单的生成秘钥、加密、解密操作
 * <p>
 * 第一步： 使用方法静态方法keyGenerate生成秘钥，AES为对称加密，即：加密、解密都需要使用同一个秘钥
 * <p>
 * 第二步： 使用静态方法encrypt(秘钥, 原文)，工具方法将对原文进行加密，对加密后的数据进行Base64编码
 * <p>
 * 第三方： 使用静态方法decrypt(秘钥, 密文)，密文是加密方法加密后进行了Base64编码的数据
 * @Author Lucien
 * @Date 2020/9/9 16:17
 * @Version 1.0
 */
public class AESUtils {

    private static final String KEY_ALGORITHM = "AES";
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    /**
     * @param keyStr 进行了Base64编码的秘钥
     * @param data   需要进行加密的原文
     * @return String 数据密文，加密后的数据，进行了Base64的编码
     * @desc: AES对称-加密操作
     * @author: yong.li
     * @createTime: 2018年8月28日 上午10:25:50
     * @version: v0.0.1
     */
    public static String encrypt(String keyStr, String data) throws Exception {
        // 转换密钥
        Key key = new SecretKeySpec(Base64.getDecoder().decode(keyStr), KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        // 加密
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] result = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(result);
    }

    /**
     * @param keyStr 进行了Base64编码的秘钥
     * @param data   需要解密的数据<span style="color:red;">（数据必须是通过AES进行加密后，对加密数据Base64编码的数据）</span>
     * @return String 返回解密后的原文
     * @desc: AES对称-解密操作
     * @author: yong.li
     * @createTime: 2018年8月28日 上午10:22:47
     * @version: v0.0.1
     */
    public static String decrypt(String keyStr, String data) throws Exception {
        // 转换密钥
        Key key = new SecretKeySpec(Base64.getDecoder().decode(keyStr), KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        // 解密
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] result = cipher.doFinal(Base64.getDecoder().decode(data));
        return new String(result);
    }

    public static void main(String[] args) throws Exception {
        String keyStr = keyGenerate();
        System.out.println("秘钥:" + keyStr + "\n加密后的密码:" + AESUtils.encrypt(keyStr, "admin123") +
                "\n解密后的密码:" + AESUtils.decrypt(keyStr, AESUtils.encrypt(keyStr, "admin123")));
    }

    /**
     * @return String 对生成的秘钥进行了Base64编码的字符串
     * @desc: 生成AES的秘钥，秘钥进行了Base64编码的字符串
     * @author: yong.li
     * @createTime: 2018年8月28日 上午10:24:32
     * @version: v0.0.1
     */
    public static String keyGenerate() throws Exception {
        // 生成密钥
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        keyGenerator.init(new SecureRandom());
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] keyBytes = secretKey.getEncoded();
        return Base64.getEncoder().encodeToString(keyBytes);
    }
}
