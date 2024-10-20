package model;

import model.enum_.ChatStateEnum;

import java.time.LocalDateTime;
import java.util.Arrays;

import static model.enum_.ChatStateEnum.*;
import static model.interface_.MessageStateInterface.UNREAD;

public class Chat {
    private ChatStateEnum[] chatState;
    private Message[] messages;

    public Chat(ChatStateEnum[] chatState, Message[] messages) {
        Arrays.sort(chatState);

        this.chatState = chatState;
        this.messages = messages;
    }

    public void changeChatState(ChatStateEnum state){

        for (int i = 0; i < chatState.length; i++){
            if (state == DELETED){
                chatState[i] = DELETED;
            }else if (state == HIDE){
                chatState[i] = HIDE;
            }
            else if (state == PINNED && chatState[i] == UNPINNED){
                chatState[i] = PINNED;
            }
            else if (state == UNPINNED && chatState[i] == PINNED){
                chatState[i] = PINNED;
            }
            else if (state == MUTED && chatState[i] == UNMUTED){
                chatState[i] = MUTED;
            }
            else if (state == UNMUTED && chatState[i] == MUTED){
                chatState[i] = UNMUTED;
            }
        }
    }


    public int unreadMessages(){
        int counter = 0;
        for (Message message: messages){
            if (message != null)
                if (message.getMessageState() == UNREAD){
                    counter += 1;
            }
        }
        return counter;
    }

    public LocalDateTime lastseen(){

        LocalDateTime lastseen = messages[0].getDateTime();
        for (int i = 1; i < messages.length; i++){
            if (messages[i] != null)
                if (messages[i].getDateTime().isAfter(lastseen)){
                    lastseen = messages[i].getDateTime();
            }
        }
        return lastseen;
    }

    public int totalMessage(){
        int i = 0;
        for (; i < messages.length; i++){
            if (messages[i + 1] == null){
                break;
            }
        }
        return i + 1;
    }































    public String getChatName(){
        return "";
    }

    public Message[] getMessages() {
        return messages;
    }

    public String displayMessages(){
        StringBuilder sb = new StringBuilder();
        for (Message message : messages){
            sb.append(message.displayMessage()).append("\n");
        }
        return sb.toString();
    }
    public void setMessages(Message[] messages) {
        this.messages = messages;
    }

    public ChatStateEnum[] getChatState() {
        Arrays.sort(chatState);
        ChatStateEnum stateEnum = null;
        for (ChatStateEnum chatState : chatState){
            if (chatState == HIDE){
                stateEnum = HIDE;
                break;
            }else if (chatState == DELETED){
                stateEnum = DELETED;
            }
        }

        if (stateEnum == HIDE || stateEnum == DELETED )
            Arrays.fill(chatState, stateEnum);
        return chatState;
    }

    public void setChatState(ChatStateEnum[] chatState) {
        this.chatState = chatState;
    }

    @Override
    public String toString() {
        return "model.Chat{" +
                "chatState=" + Arrays.toString(chatState) +
                '}';
    }
}
