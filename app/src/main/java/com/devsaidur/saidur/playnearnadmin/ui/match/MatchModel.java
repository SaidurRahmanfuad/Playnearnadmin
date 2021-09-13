package com.devsaidur.saidur.playnearnadmin.ui.match;

public class MatchModel {
    //String match_name;
    String match_cat;
    String match_type;
    String match_fee;
    String match_prize;
    String match_seat;
    String match_styme;
    String match_id;
    Players player;


    public MatchModel() {
    }

    public MatchModel(String match_cat, String match_type, String match_fee, String match_prize, String match_seat, String match_styme, String match_id,Players player) {
        this.match_cat = match_cat;
        this.match_type = match_type;
        this.match_fee = match_fee;
        this.match_prize = match_prize;
        this.match_seat = match_seat;
        this.match_styme = match_styme;
        this.match_id = match_id;
        this.player = player;
    }

   /*    public String getMatch_name() {
        return match_name;
    }

    public void setMatch_name(String match_name) {
        this.match_name = match_name;
    }*/

    public String getMatch_cat() {
        return match_cat;
    }

    public void setMatch_cat(String match_cat) {
        this.match_cat = match_cat;
    }

    public String getMatch_type() {
        return match_type;
    }

    public void setMatch_type(String match_type) {
        this.match_type = match_type;
    }

    public String getMatch_fee() {
        return match_fee;
    }

    public void setMatch_fee(String match_fee) {
        this.match_fee = match_fee;
    }

    public String getMatch_styme() {
        return match_styme;
    }

    public void setMatch_styme(String match_styme) {
        this.match_styme = match_styme;
    }

    public String getMatch_id() {
        return match_id;
    }

    public void setMatch_id(String match_id) {
        this.match_id = match_id;
    }

    public String getMatch_prize() {
        return match_prize;
    }

    public void setMatch_prize(String match_prize) {
        this.match_prize = match_prize;
    }

    public String getMatch_seat() {
        return match_seat;
    }

    public void setMatch_seat(String match_seat) {
        this.match_seat = match_seat;
    }

    public Players getPlayer() {
        return player;
    }

    public void setPlayer(Players player) {
        this.player = player;
    }
}
