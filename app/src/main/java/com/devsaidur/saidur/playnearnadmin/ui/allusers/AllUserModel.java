package com.devsaidur.saidur.playnearnadmin.ui.allusers;

public class AllUserModel {
    String id;
    String userName;
    String userPhone;
    String userEmail;
    String userImg;
    Account account;
    PlayHistory playHistory;

    public AllUserModel() {
    }

    public AllUserModel(String id, String userName, String userPhone,String userEmail, String userImg) {
        this.id = id;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userImg = userImg;
    }

    public AllUserModel(String id, String userName, String userPhone,String userEmail, String userImg, Account account, PlayHistory playHistory) {
        this.id = id;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userImg = userImg;
        this.account = account;
        this.playHistory = playHistory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public PlayHistory getPlayHistory() {
        return playHistory;
    }

    public void setPlayHistory(PlayHistory playHistory) {
        this.playHistory = playHistory;
    }
}
