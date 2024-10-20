package model;

import java.time.LocalDate;
import java.util.Arrays;

public class User {

    private String username;
    private String password;
    private String profileName;
    private LocalDate birthdate;
    private String email;
    private String phoneNumber;
    private Chat[] chats;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void changeUserProfile(String field, String edit){
        switch (field){
            case "Username": setUsername(edit); break;
            case "Password": setPassword(edit); break;
            case "Profile Name": setProfileName(edit); break;
            case "Birthdate": setBirthdate(edit); break;
            case "Email": setEmail(edit); break;
            case "Phone Number":setPhoneNumber(edit); break;
        }
    }

    public String displayProfile(){
        StringBuilder sb = new StringBuilder();
        sb.append("Username: " + username).append("\n");
        sb.append("Password: " + password).append("\n");
        sb.append("Birthdate: " + birthdate).append("\n");
        sb.append("Profile Name: " + profileName).append("\n");
        sb.append("Email: " + email).append("\n");
        sb.append("Phone Number: " + phoneNumber).append("\n");
        return sb.toString();
    }


    public String showUserChats(){
        StringBuilder sb = new StringBuilder();

        for (Chat chat : chats){
            if (chat instanceof GroupChat){
                sb.append("GroupChat name: " + ((GroupChat) chat).groupName);
            }else if (chat instanceof IndividualChat){
                sb.append("IndividualChat name: " + ((IndividualChat) chat).friendUsername);
            }
            sb.append("\nStatus chat: " + Arrays.toString(chat.getChatState()));
            sb.append("\nTotal unread Messages: " + chat.unreadMessages());
            sb.append("\nLast seen: " + chat.lastseen() + "\n\n");
        }
        return sb.toString();
    }


    public String showUserFavoriteChats(){
        StringBuilder sb = new StringBuilder();

        GroupChat gc = null;
        IndividualChat ic = null;


        int gc_counter = 0;
        int ic_counter = 0;

        if (chats[0] == null){
            return "Chat is empty";
        }

        for (int i = 0; i < chats.length; i++){
            if (chats[i] instanceof GroupChat){
                if (chats[i].totalMessage() > gc_counter){
                    gc_counter = chats[i].totalMessage();
                    gc = (GroupChat) chats[i];
                }
                else if (chats[i].totalMessage() == gc.totalMessage()){
                    if(chats[i].lastseen().isAfter(gc.lastseen())){
                        gc = (GroupChat) chats[i];
                    }
                }
            }else if (chats[i] instanceof IndividualChat){
                if (chats[i].totalMessage() > ic_counter){
                    ic_counter = chats[i].totalMessage();
                    ic = (IndividualChat) chats[i];
                }
                else if (chats[i].totalMessage() == ic.totalMessage()){
                    if(chats[i].lastseen().isAfter(ic.lastseen())){
                        ic = (IndividualChat) chats[i];
                    }
                }
            }
        }

        sb.append("GROUP CHAT: " + gc.getChatName() + " total = " + gc_counter).append("\n");
        sb.append("INDIVIDUAL CHAT: " + ic.getChatName() + " total = " + ic_counter);
        return sb.toString();
    }























    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Chat[] getChats() {
        return chats;
    }

    public void setChats(Chat[] chats) {
        this.chats = chats;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", profileName='" + profileName + '\'' +
                ", birthdate=" + birthdate +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
