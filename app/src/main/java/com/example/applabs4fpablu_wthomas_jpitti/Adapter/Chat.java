package com.example.applabs4fpablu_wthomas_jpitti.Adapter;

public class Chat {

    private final String username;
    private final String message;
    private final int profilePicture;
    private final String time;

    public Chat(String username, String message, int profilePicture, String time) {
        this.username = username;
        this.message = message;
        this.profilePicture = profilePicture;
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }

    public int getProfilePicture() {
        return profilePicture;
    }

    public String getTime() {
        return time;
    }

}
