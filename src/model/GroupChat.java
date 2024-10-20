package model;

import model.enum_.ChatStateEnum;

import java.util.Arrays;

public class GroupChat extends Chat{

    String groupName;
    String[] groupMember;

    public GroupChat(ChatStateEnum[] chatState, Message[] messages, String groupName) {
        super(chatState, messages);
        this.groupName = groupName;
    }

    public String getChatName(){
        return "(GC) " + groupName;
    }

    public String getGroupName() {
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
        return "model.GroupChat{" +
                "groupName='" + groupName + '\'' +
                ", groupMember=" + Arrays.toString(groupMember) +
                '}';
    }
}
