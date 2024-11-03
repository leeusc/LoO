package model;

import model.constants.ChatStateEnum;

import java.util.List;

public class IndividualChat extends Chat {

    String friendUsername;

    public IndividualChat(List<Message> messages, List<ChatStateEnum> chatStates, String friendUsername) {
        super(messages, chatStates);
        this.friendUsername = friendUsername;
    }

    @Override
    public String getChatState() {
        StringBuilder sb = new StringBuilder("Individual Name: " + friendUsername + ", Chat States: " + chatStates);
        return sb.toString();
    }

    public String getChatName() {
        return friendUsername;
    }

    public void setFriendUsername(String friendUsername) {
        this.friendUsername = friendUsername;
    }

    @Override
    public String toString() {
        return "Individual Name: " + friendUsername + ", Last Seen: " + mostRecentTime();
    }
}
