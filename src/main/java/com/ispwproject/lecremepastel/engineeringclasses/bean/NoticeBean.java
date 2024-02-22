package com.ispwproject.lecremepastel.engineeringclasses.bean;

import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;

import java.util.Objects;

public class NoticeBean {
    private int id;
    private String subject;
    private String content;
    private boolean read;

    public NoticeBean(int id, String subject, String content, boolean read) throws IncorrectParametersException{
        if(subject != null && content != null){
            this.subject = subject;
            this.read = read;
            this.content = content;
            this.id = id;
        }else{
            throw new IncorrectParametersException("NoticeBean: Parameters can't be Null!");
        }
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
        if(subject != null){
            this.subject = subject;
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if(content != null){
            this.content = content;
        }

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
        NoticeBean that = (NoticeBean) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
