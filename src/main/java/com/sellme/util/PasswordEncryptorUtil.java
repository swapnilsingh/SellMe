/**
 *
 */
package com.sellme.util;

import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 * @author Swapnil Singh
 *
 */
public class PasswordEncryptorUtil {

    private static StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

    public static String encrypt(String password){
        return passwordEncryptor.encryptPassword(password);
    }
    public static boolean check(String inputPassword,String encryptedPassword){
        return passwordEncryptor.checkPassword(inputPassword, encryptedPassword);
    }
}
