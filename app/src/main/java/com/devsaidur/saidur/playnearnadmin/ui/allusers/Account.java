package com.devsaidur.saidur.playnearnadmin.ui.allusers;

public class Account {
    String current_bal;
    String wallet_bal;

    public Account(String current_bal, String wallet_bal) {
        this.current_bal = current_bal;
        this.wallet_bal = wallet_bal;
    }

    public Account() {
    }

    public String getCurrent_bal() {
        return current_bal;
    }

    public void setCurrent_bal(String current_bal) {
        this.current_bal = current_bal;
    }

    public String getWallet_bal() {
        return wallet_bal;
    }

    public void setWallet_bal(String wallet_bal) {
        this.wallet_bal = wallet_bal;
    }
}
