package com.ispwproject.lecremepastel.model;

public class Notice {

    private int id;
    private String subject;
    private String content;
    private Boolean read;

    public Notice(int id, String subject, String content, Boolean read){
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

    public Boolean isRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Notice n){
            return this.subject.equals(n.subject) && this.content.equals(n.subject) && this.read == n.read;
        }
        return false;
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
