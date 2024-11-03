package model;

import model.constants.ChatStateEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static model.constants.ChatStateEnum.*;

public class User {

    String userName;
    String password;
    String profileName;
    LocalDate birthdate;
    String email;
    String phoneNumber;
    List<Chat> chatList;

    public User(String userName, String password, String profileName, LocalDate birthdate, String email, String phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.profileName = profileName;
        this.birthdate = birthdate;
        this.email = email;
        this.phoneNumber = phoneNumber;
//        this.chatList = chatList;
    }

    public String showUserChats(){
        StringBuilder sb = new StringBuilder();
        for (Chat chat : chats()){
            sb.append(chat.getChatName()).append("\n");
            sb.append(chat.getChatStates()).append("\n");
            sb.append("Total Unread Messages: ").append(chat.totalUnreadMessages()).append("\n");
            sb.append(chat.mostRecentTime()).append("\n\n");
        }
        return sb.toString();
    }

    public List<Chat> chats(){
        List<Chat>chats = new ArrayList<>();
        int index = 0;
        for (Chat chat : chatList){
            if (chat.getChatStates().get(0) == PINNED){
                chats.addFirst(chat);
                index++;
            }else if (chat.getChatStates().get(0) == HIDE || chat.getChatStates().get(0) == DELETED){
                chats.addLast(chat);
            }else {
                chats.add(index,chat);
            }
        }
        return chats;
    }

    public String showUserFavoriteChats(){
        StringBuilder sb = new StringBuilder();

        IndividualChat current_IndividualChat = null;
        GroupChat current_groupChat = null;

        for (Chat chat : chatList){
            if (chat instanceof  GroupChat){
                // if null || chat.size > current chat.size || (chat.size == currentchat.size && chat.time > currentchat.time)
                if (current_groupChat == null || chat.messages.size() > current_groupChat.messages.size() || (chat.messages.size() == current_groupChat.messages.size() && chat.mostRecentTime().isAfter(current_groupChat.mostRecentTime()))){
                    current_groupChat = (GroupChat) chat;
                }
            }else if (chat instanceof  IndividualChat){
                if (current_IndividualChat == null || chat.messages.size() > current_IndividualChat.messages.size() || (chat.messages.size() == current_IndividualChat.messages.size() && chat.mostRecentTime().isAfter(current_IndividualChat.mostRecentTime()))){
                    current_IndividualChat = (IndividualChat) chat;
                }
            }
        }

        sb.append(current_groupChat).append("\n");
        sb.append(current_IndividualChat).append("\n");
        return sb.toString();
    }


    public void changeUserProfile(String field, String updateValue){
        if (field.equalsIgnoreCase("UserName")){
            setUserName(updateValue);
        }else if (field.equalsIgnoreCase("Password")){
            setPassword(updateValue);
        } else if (field.equalsIgnoreCase("Profile Name")) {
            setProfileName(updateValue);
        } else if (field.equalsIgnoreCase("Birthdate")) {
            setBirthdate(updateValue);
        } else if (field.equalsIgnoreCase("email")) {
            setEmail(updateValue);
        }else if (field.equalsIgnoreCase("Phone Number")){
            setPhoneNumber(updateValue);
        }
    }

    public String displayUserProfile(){
        StringBuilder sb = new StringBuilder();
        sb.append("User Name: ").append(userName).append("\n");
        sb.append("Password: ").append(password).append("\n");
        sb.append("Profile Name: ").append(profileName).append("\n");
        sb.append("Birthdate: ").append(birthdate).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Phone Number: ").append(phoneNumber).append("\n");

        return sb.toString();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = LocalDate.parse(birthdate);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Chat> getChatList() {
        return chatList;
    }

    public void setChatList(List<Chat> chatList) {
        this.chatList = chatList;
    }

    @Override
    public String toString() {
        return "model.User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", profileName='" + profileName + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", chatList=" + chatList +
                '}';
    }
}
