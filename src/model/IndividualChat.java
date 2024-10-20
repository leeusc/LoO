package model;

import model.enum_.ChatStateEnum;

public class IndividualChat extends Chat {

    String friendUsername;

    public IndividualChat(ChatStateEnum[] chatState, Message[] messages, String friendUsername) {
        super(chatState, messages);
        this.friendUsername = friendUsername;
    }

    public String getChatName(){
        return "(IC) " + friendUsername;
    }

    public String getFriendUsername() {
        return friendUsername;
    }

    public void setFriendUsername(String friendUsername) {
        this.friendUsername = friendUsername;
    }
}
