package com.gzeinnumer.day4_4;

import java.util.ArrayList;
import java.util.Random;

//todo 1 set model
public class User {

    private String username;
    private String description;

    public User() {
    }

    public User(String username, String description) {
        this.username = username;
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public static ArrayList<User> generateDataItem(){
        ArrayList<User> datas = new ArrayList<>();
        for(int i=0;i<100;i++){
            User user = new User();
            user.username = getSaltString();
            user.description = getSaltString();
            datas.add(user);
        }
        User user = new User();
        user.setUsername("BCA");
        user.setDescription("The Biggest Financial Company in Indonesia");
        datas.add(user);
        return datas;
    }

    // Random data generator
    protected static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();

        return saltStr;
    }
}
