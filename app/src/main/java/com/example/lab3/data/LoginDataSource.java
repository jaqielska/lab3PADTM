package com.example.lab3.data;

import android.util.Log;
import android.widget.Toast;

import com.example.lab3.data.model.LoggedInUser;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Handler;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    Handler handler;
    HashMap<String,String> loginRepo=new HashMap<String,String>();

    public LoginDataSource()
    {
        loginRepo.put("michal@wp.pl","michal");
    }
    public Result<LoggedInUser> login(String username, String password) {

            for (HashMap.Entry<String, String> entry : loginRepo.entrySet()) {
                if (username.equals(entry.getKey())) {
                    if (password.equals(entry.getValue())) {
                        return new Result.Success<>(new LoggedInUser(java.util.UUID.randomUUID().toString(), username));
                    } else
                    {
                        return new Result.Error(new IOException("Bad password",new Exception("Bad password")));
                    }
                }
            }
            loginRepo.put(username, password);
            return new Result.Register<>( "Proba utworzenia konta: "+username);


       /* try {
            // TODO: handle loggedInUser authentication
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }*/
    }

    public void logout() {
        // TODO: revoke authentication
    }

}
