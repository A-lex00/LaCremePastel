package com.ispwproject.lacremepastel.model;

public class Notice {

    private int id;
    private String subject;
    private String content;
    private boolean read;

    public Notice(int id, String subject, String content, boolean read){
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.read = read;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
