package view;

import model.Chat;
import model.User;
import model.constants.ChatStateEnum;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class view {

    public String options(){
        String[] options = {"Show User Chats", "Change Chat State", "Change User Profile", "Show User Favorite Chats"};

        String option = (String) JOptionPane.showInputDialog(null, "Choose an option", "Chat App", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        return option;
    }

    public void showUserChats(User user){
        JOptionPane.showMessageDialog(null, user.showUserChats(),"Show User Chats", JOptionPane.INFORMATION_MESSAGE);
    }

    public Chat chat(User user){
        String[] options = new String[user.getChatList().size()];
        for (int i = 0; i < user.getChatList().size(); i++){
            String chatName = user.getChatList().get(i).getChatName();
            options[i] = ((i + 1) + ". " + chatName);
        }
        String option = (String) JOptionPane.showInputDialog(null, "Chats' ", "List of Chat", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        int opt = Integer.parseInt(option.substring(0, 1));
        return user.getChatList().get(opt - 1);
    }

    public void changeChatState(Chat chat){
        String[] options = {"PINNED", "UNPINNED", "MUTED", "UNMUTED", "HIDE", "DELETED"};

        String option = (String) JOptionPane.showInputDialog(null, "Choose State", "Change Chat State", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        chat.changeChatState(ChatStateEnum.valueOf(option));
    }

    public void displayChatState(Chat chat){
        JOptionPane.showMessageDialog(null, chat.getChatState(), "display Chat State", JOptionPane.INFORMATION_MESSAGE);
    }

    public String field(){
        String[] options = {"Username", "Password", "Profile Name", "Birthdate", "email", "PhoneNumber"};
        String option = (String) JOptionPane.showInputDialog(null, "Choose field to edit", "Change User Profile", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        return option;
    }

    public void updateField(User user){
        String field = field();
        String update = JOptionPane.showInputDialog(null, "Update " + field, "Update Profile field", JOptionPane.INFORMATION_MESSAGE);
        user.changeUserProfile(field, update);
    }

    public void displayUserProfile(User user){
        JOptionPane.showMessageDialog(null, user.displayUserProfile(), "After updating field", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showUserFavoriteChats(User user){
        JOptionPane.showMessageDialog(null, user.showUserFavoriteChats(), "Show User Favorite Chats", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {

        view  view = new view();
        view.options();
    }
}
