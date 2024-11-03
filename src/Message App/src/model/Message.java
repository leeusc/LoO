package model;

import model.constants.MessageAvailibiltyEnum;

import java.time.LocalDateTime;

public class Message {

    String content;
    LocalDateTime localDate;
    int messageState;
    MessageAvailibiltyEnum availibiltyEnum;

    public Message(String content, LocalDateTime localDate, int messageState, MessageAvailibiltyEnum availibiltyEnum) {
        this.content = content;
        this.localDate = localDate;
        this.messageState = messageState;
        this.availibiltyEnum = availibiltyEnum;
    }


    public LocalDateTime getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDateTime localDate) {
        this.localDate = localDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMessageState() {
        return messageState;
    }

    public void setMessageState(int messageState) {
        this.messageState = messageState;
    }

    public MessageAvailibiltyEnum getAvailibiltyEnum() {
        return availibiltyEnum;
    }

    public void setAvailibiltyEnum(MessageAvailibiltyEnum availibiltyEnum) {
        this.availibiltyEnum = availibiltyEnum;
    }

    @Override
    public String toString() {
        return "model.Message{" +
                "content='" + content + '\'' +
                ", localDate=" + localDate +
                ", messageState=" + messageState +
                ", availibiltyEnum=" + availibiltyEnum +
                '}';
    }
}
