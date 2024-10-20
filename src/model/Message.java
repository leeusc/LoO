package model;

import model.enum_.MessageAvalibilityEnum;

import java.time.LocalDateTime;

import static inteface.MessageStateInterface.UNREAD;
import static model.enum_.MessageAvalibilityEnum.AVAILABLE;
import static model.interface_.MessageStateInterface.READ;

public class Message {

    private String content;
    private LocalDateTime dateTime;
    private int messageState;
    private MessageAvalibilityEnum messageAvalibility;

    public Message(String content, LocalDateTime dateTime, int messageState, MessageAvalibilityEnum messageAvalibility) {
        this.content = content;
        this.dateTime = dateTime;
        this.messageState = messageState;
        this.messageAvalibility = messageAvalibility;
    }


    static public void sendMessages(String content, Chat chat, User user){
        // sender
        for (int i = 0; i < chat.getMessages().length; i++){
            if (chat.getMessages()[i + 1] == null){
                chat.getMessages()[i + 1] = new Message(content, LocalDateTime.now(), READ, AVAILABLE);
                break;
            }
        }

        // receiver
        for (Chat ch : user.getChats()){
            for (int i = 0; i < ch.getMessages().length; i++){
                if (ch.getMessages()[i + 1] == null){
                    ch.getMessages()[i + 1] = new Message(content, LocalDateTime.now(), UNREAD, AVAILABLE);
                    break;
                }
            }
        }
    }

    public static String showMessages(Chat chat){
        StringBuilder sb = new StringBuilder();

        for (Message message : chat.getMessages()){
            if (message != null)
                if (message.getMessageAvalibility() == AVAILABLE){
                    sb.append(message.displayMessage()).append("\n");
            }
        }
        return sb.toString();
    }

    public String displayMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("Content: " + content).append(" ");
        sb.append("Date Time: " + dateTime).append("\n");
        sb.append("Message State: " + getMessageState_string()).append(" ");
        sb.append("Availibility: " + messageAvalibility).append("\n\n");
        return sb.toString();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getMessageState() {
        return messageState;
    }

    public String getMessageState_string(){
        if (messageState == UNREAD){
            return "UNREAD";
        }else {
            return "READ";
        }
    }

    public void setMessageState(int messageState) {
        this.messageState = messageState;
    }

    public MessageAvalibilityEnum getMessageAvalibility() {
        return messageAvalibility;
    }

    public void setMessageAvalibility(MessageAvalibilityEnum messageAvalibility) {
        this.messageAvalibility = messageAvalibility;
    }


    public Chat chat(Chat chat){
        return chat;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Content: " + content).append(" ");
        sb.append(", Date Time: " + dateTime).append("\n");
        sb.append("Message State: " + getMessageState_string()).append(" ");
        sb.append(", Availibility: " + messageAvalibility).append("\n\n");
        return sb.toString();
    }
}
