package com.data.entity;

public class Role {
    //list of priviligies , posibility to add and remove them
    private int userRoleId;
    private String userRoleName;
    private int userId;

    public Role(int userRoleId, String userRoleName, int userId) {
        this.userRoleId = userRoleId;
        this.userRoleName = userRoleName;
        this.userId = userId;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
