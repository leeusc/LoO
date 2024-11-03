package model;

import model.constants.ChatStateEnum;

import java.time.LocalDateTime;
import java.util.List;

import static model.constants.ChatStateEnum.*;
import static model.constants.MessageStateInterface.UNREAD;

public abstract class Chat {

    List<Message> messages;
    List<ChatStateEnum> chatStates;

    public int totalUnreadMessages(){
        int totalUnread = 0;
        for (Message message : messages){
            if (message.getMessageState() == UNREAD){
                totalUnread+=1;
            }
        }
        return totalUnread;
    }

    public LocalDateTime mostRecentTime(){
        LocalDateTime recentTime = messages.get(0).getLocalDate();

        for (int i = 1; i < messages.size(); i++){
            LocalDateTime currentTime = messages.get(i).getLocalDate();
            if (currentTime.isAfter(recentTime)){
                recentTime = currentTime;
            }
        }
        return recentTime;
    }

    public void changeChatState(ChatStateEnum updateChatState){
        if (updateChatState == DELETED){
            chatStates.clear();
            chatStates.add(DELETED);
            return;
        }else if (updateChatState == HIDE){
            chatStates.clear();
            chatStates.add(HIDE);
            return;
        }

        for (int i = 0; i < chatStates.size(); i++){

            if (chatStates.get(i) == PINNED && updateChatState == UNPINNED){
                chatStates.set(i, UNPINNED);
                return;
            }else if (chatStates.get(i) == UNPINNED && updateChatState == PINNED){
                chatStates.set(i, PINNED);
                return;
            }else if (chatStates.get(i) == MUTED && updateChatState == UNMUTED){
                chatStates.set(i, UNMUTED);
                return;
            }else if (chatStates.get(i) == UNMUTED && updateChatState == MUTED){
                chatStates.set(i, MUTED);
                return;
            }
        }
    }

    public abstract String getChatState();

    public Chat(List<Message> messages, List<ChatStateEnum> chatStates) {
        this.messages = messages;
        this.chatStates = chatStates;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<ChatStateEnum> getChatStates() {
        return chatStates;
    }

    public void setChatStates(List<ChatStateEnum> chatStates) {
        this.chatStates = chatStates;
    }

    public abstract String getChatName();
}
