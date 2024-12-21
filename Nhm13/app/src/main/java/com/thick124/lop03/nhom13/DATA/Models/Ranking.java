package com.thick124.lop03.nhom13.DATA.Models;

public class Ranking {
    private String username;
    private int point;

    private User usernameNavigation;

    public Ranking(String username, int point) {
        this.username = username;
        this.point = point;
    }

    public Ranking() {

    }

    public Ranking(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public User getUsernameNavigation() {
        return usernameNavigation;
    }

    public void setUsernameNavigation(User usernameNavigation) {
        this.usernameNavigation = usernameNavigation;
    }
}
