package com.example.interac.kits;

import java.sql.Timestamp;

public class EventModel {
    String event, session;

    public EventModel(String event, String session, Timestamp date) {
        this.event = event;
        this.session = session;
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    Timestamp date;

}
