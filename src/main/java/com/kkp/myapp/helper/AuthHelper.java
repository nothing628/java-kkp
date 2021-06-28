/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kkp.myapp.helper;

import com.kkp.myapp.exceptions.AuthenticationException;
import com.kkp.myapp.models.DBConnector;
import com.kkp.myapp.models.Users;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author titan
 */
public class AuthHelper {

    public static Users activeUser;

    static {
        activeUser = null;
    }

    public static boolean isLoggedIn() {
        return activeUser != null;
    }
    
    public static void logout()
    {
        activeUser = null;
    }

    public static void attemptLogin(String username, String password) throws AuthenticationException {
        Document user = DBConnector.userCollection.find(and(
                eq("username", username),
                eq("is_active", true)
        )).first();

        boolean is_user_exists = user != null;
        if (is_user_exists) {
            String user_password_hash = user.getString("password");
            boolean password_match = AppHelper.verifyPassowrd(password, user_password_hash);

            if (!password_match) {
                throw new AuthenticationException("Harap masukkan password yang benar");
            }

            activeUser = new Users();
            activeUser.setId(user.getObjectId("_id"));
            activeUser.load();
            return;
        }
        
        throw new AuthenticationException("User tidak ditemukan");
    }
}
