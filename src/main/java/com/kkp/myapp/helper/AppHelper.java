/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kkp.myapp.helper;

import at.favre.lib.crypto.bcrypt.BCrypt;
import java.net.URL;

/**
 *
 * @author titan
 */
public class AppHelper {
    
    public static URL loadResource(String path) {
        return AppHelper.class.getResource(path);
    }

    public static String hashPassword(String password) {
        var crypt = BCrypt.withDefaults();

        return crypt.hashToString(5, password.toCharArray());
    }

    public static boolean verifyPassowrd(String password, String hash) {
        var verifyer = BCrypt.verifyer();
        var result = verifyer.verify(password.toCharArray(), hash.toCharArray());

        return result.verified;
    }
}
