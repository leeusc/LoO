package view;

import model.Chat;
import model.Message;
import model.User;
import model.enum_.ChatStateEnum;

import javax.swing.*;

import static model.enum_.ChatStateEnum.*;

public class SystemView{

    public void displayAppTitle(){ // appear ath te first page
        JOptionPane.showMessageDialog(null, "ICHAT", "ChatApp", JOptionPane.INFORMATION_MESSAGE);
    }

    // login app
    public String getUsernameInput(){
        return JOptionPane.showInputDialog(null, "Enter your username: ");
    }
    public String getPasswordInput(){
        return JOptionPane.showInputDialog(null, "Enter your password: ");
    }
    public void loggedIn() {
        JOptionPane.showMessageDialog(null, "You have logged in successfully");
    }

    public String choice(){

        String[] options = {
                "1. Show User Chats",
                "2. Change Chat State",
                "3. Send Message",
                "4. Show Message",
                "5. Change User Profile",
                "6. Show User Favorite Chats"};

        String selectedOptions = (String) JOptionPane.showInputDialog(null, "Select an action", "Chat Application Menu", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        return selectedOptions;
    }

    // number 1
    public void showUserChats(User user){
        JOptionPane.showMessageDialog(null, user.showUserChats(), "Show User Chats", JOptionPane.INFORMATION_MESSAGE);
    }

    // number 2
    public void changeChatState(User user){

        Chat currentChat = getCurrentChat(user);
        assert currentChat != null;
        // before change state
        JOptionPane.showMessageDialog(null, currentChat.getChatState(), "Before Chat State", JOptionPane.INFORMATION_MESSAGE);
        currentChat.changeChatState(changeChatStateOptions());
        // after change state
        JOptionPane.showMessageDialog(null, currentChat.getChatState(), "After Chat State", JOptionPane.INFORMATION_MESSAGE);
    }

    public ChatStateEnum changeChatStateOptions(){
        String[] options = {"1. PINNED", "2. UNPINNED", "3. MUTED", "4. UNMUTED", "5. HIDE", "6. DELETED"};
        ChatStateEnum[] chatStateEnums= {PINNED,UNPINNED, MUTED, UNMUTED, HIDE, DELETED};
        String selectedOptions = (String) JOptionPane.showInputDialog(null, "Change chat states", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        int selectedIndex = Integer.parseInt(selectedOptions.substring(0, 1));
        System.out.println("selected Index " +selectedIndex );
        return chatStateEnums[selectedIndex - 1];
    }

    public Chat getCurrentChat(User user){
        String[] options = new String[user.getChats().length];
        int i = 0;

        for (Chat chat : user.getChats()){
            options[i] = chat.getChatName();
            i++;
        }
        String selectedoptions = (String) JOptionPane.showInputDialog(null, "Select chat", "Change Chat State", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        Chat currentChat = null;
        for (Chat chat : user.getChats()){
            if (chat.getChatName().equals(selectedoptions)){
                currentChat = chat;
            }
        }
        return currentChat;
    }

    public String typeMessage(){
        return JOptionPane.showInputDialog(null, "Type content", "Type Here", JOptionPane.INFORMATION_MESSAGE);
    }

    public void sendMessage(User sender, User[] users){
        Chat currentchat = getCurrentChat(sender);
        String content = typeMessage();
        User receiver = sendMessageToUser(users);
        Message.sendMessages(content, currentchat, receiver);
        JOptionPane.showMessageDialog(null, currentchat.getMessages(), "Sender" + sender.getUsername() + "'s " + currentchat.getChatName() + "'s Messages" , JOptionPane.INFORMATION_MESSAGE);

        for (Chat chat : receiver.getChats()){
            JOptionPane.showMessageDialog(null, chat.getMessages(), "Receiver " + receiver.getUsername() + "'s " + chat.getChatName() + "'s Messages", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public User sendMessageToUser(User[] users){
        String[] options = new String[users.length];
        int i = 0;
        for (User user : users){
            options[i] = i + 1 + ".  " + user.getUsername();
            i++;
        }
        String selectedOption = (String) JOptionPane.showInputDialog(null, "Select User", "Select User", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        int index = Integer.parseInt(selectedOption.substring(0, 1));
        return users[index - 1];
    }

    public void showMessage(User user){
        Chat currentChat = getCurrentChat(user);

        JOptionPane.showMessageDialog(null, Message.showMessages(currentChat));
    }

    // number 5
    public void changeUSerProfile(User user){
        String[] options = {
                "Username", "Password", "Profile Name", "Birthdate", "Email", "Phone Number"
        };

        String selectedOption = (String) JOptionPane.showInputDialog(null, "Choose field to edit", "Change User Profile FIELD", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        String edit = JOptionPane.showInputDialog(null, "Change your " + selectedOption, "Change User Profile EDIT FIELD", JOptionPane.INFORMATION_MESSAGE);
        user.changeUserProfile(selectedOption, edit);
        JOptionPane.showMessageDialog(null, user.displayProfile());
    }

    public void showUserFavoriteChats(User user){
        JOptionPane.showMessageDialog(null, user.showUserFavoriteChats(), "Show User Favorite Chats ", JOptionPane.INFORMATION_MESSAGE);
    }


    public static void main(String[] args) {
        SystemView sv = new SystemView();
        sv.displayAppTitle();
    }
}
