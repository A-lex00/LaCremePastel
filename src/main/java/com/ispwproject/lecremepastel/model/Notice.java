package com.ispwproject.lecremepastel.model;

import java.util.Objects;

public class Notice {

    private int id;
    private String subject;
    private String content;
    private boolean read;

    public Notice(){
        this(-1,null,null,false);
    }
    public Notice(int id, String subject, String content, boolean read){
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.read = read;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notice notice = (Notice) o;
        return id == notice.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Notice{" +
                "subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", read=" + read +
                '}';
    }
}
