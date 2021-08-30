package com.example.interac.kits;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class calenderModel {
    public calenderModel(Map<String, String> event, Date d, Boolean has) {
        this.event = event;
        this.d = d;
        Has = has;
    }

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }

    Map<String, String> event;
    Date d;

    public calenderModel(Map<String, String> event, Boolean has) {
        this.event = event;
        Has = has;
    }

    public Map<String, String> getEvent() {
        return event;
    }

    public void setEvent(Map<String, String> event) {
        this.event = event;
    }

    public Boolean getHas() {
        return Has;
    }

    public void setHas(Boolean has) {
        Has = has;
    }

    Boolean Has ;
}
