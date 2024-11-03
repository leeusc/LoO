package model;

import model.constants.ChatStateEnum;

import java.util.Arrays;
import java.util.List;

public class GroupChat extends Chat{

    String groupName;
    String[] groupMember;

    public GroupChat(List<Message> messages, List<ChatStateEnum> chatStates, String groupName) {
        super(messages, chatStates);
        this.groupName = groupName;
    }

    @Override
    public String getChatState() {
        StringBuilder sb = new StringBuilder("GroupName: " + groupName + ", Chat States: " + chatStates);
        return sb.toString();
    }

    public String getChatName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String[] getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(String[] groupMember) {
        this.groupMember = groupMember;
    }

    @Override
    public String toString() {
        return "GroupName: " + groupName + ", Last Seen: " + mostRecentTime();
    }
}
