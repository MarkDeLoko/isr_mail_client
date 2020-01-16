package com.example.mail.domain;

import org.springframework.stereotype.Component;

@Component
public class Mail {

    private Object text;
    private String from;
    private String subject;
    private Integer id;
    private String filename;
    public Mail() {
    }

    public Mail(Object text, String from, String subject, Integer id) {

        this.text = text;
        this.from = from;
        this.subject = subject;
        this.id = id;
    }
    public Object getText() {
        return text;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public String getFrom() {
        return from;
    }
    public String getSubject() {
        return subject;
    }
    public void setText(Object text) {
        this.text = text;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
