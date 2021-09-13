package com.devsaidur.saidur.playnearnadmin.ui.allusers;

public class PlayHistory {
    String match_id;
    String match_type;
    String earn_lost;
    String match_result;

    public PlayHistory() {
    }

    public PlayHistory(String match_id, String match_type, String earn_lost, String match_result) {
        this.match_id = match_id;
        this.match_type = match_type;
        this.earn_lost = earn_lost;
        this.match_result = match_result;
    }

    public String getMatch_id() {
        return match_id;
    }

    public void setMatch_id(String match_id) {
        this.match_id = match_id;
    }

    public String getMatch_type() {
        return match_type;
    }

    public void setMatch_type(String match_type) {
        this.match_type = match_type;
    }

    public String getEarn_lost() {
        return earn_lost;
    }

    public void setEarn_lost(String earn_lost) {
        this.earn_lost = earn_lost;
    }

    public String getMatch_result() {
        return match_result;
    }

    public void setMatch_result(String match_result) {
        this.match_result = match_result;
    }
}
