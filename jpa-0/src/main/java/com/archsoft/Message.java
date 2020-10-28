package com.archsoft;

import javax.persistence.*;

@Entity
@Table(name = "TB001_MESSAGE")
public class Message {

    @Id
    @GeneratedValue
    @Column(name = "ID_MESSAGE")
    private Long id;

    @Column(name = "TEXT_MESSAGE", nullable = false, length = 100)
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
