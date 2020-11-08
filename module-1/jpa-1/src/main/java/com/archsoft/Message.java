package com.archsoft;

import javax.persistence.*;

@Entity
@Table(name = "TB001_MESSAGE")
public class Message {

    @Id
    @GeneratedValue
    @Column(name = "ID_MESSAGE")
    private Long id;

    @Column(name = "TEXT_MESSAGE", nullable = false, length = 50)
    private String text;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NEXT_MESSAGE_ID")
    private Message nextMessage;

    public Message() {
    }

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

    public Message getNextMessage() {
        return nextMessage;
    }

    public void setNextMessage(Message nextMessage) {
        this.nextMessage = nextMessage;
    }

    @Override
    public String toString() {
        return getId() + "-" + getText() + "-"
                + (getNextMessage() != null ? getNextMessage().getId() : "NULL");
    }
}
