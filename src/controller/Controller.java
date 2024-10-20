package controller;

import model.Chat;
import model.GroupChat;
import model.IndividualChat;
import model.Message;
import model.User;
import model.enum_.ChatStateEnum;
import model.enum_.MessageAvalibilityEnum;
import view.SystemView;

import java.time.LocalDateTime;
import java.util.Arrays;

import static model.enum_.ChatStateEnum.*;
import static model.enum_.MessageAvalibilityEnum.AVAILABLE;
import static model.interface_.MessageStateInterface.READ;
import static model.interface_.MessageStateInterface.UNREAD;

public class Controller {

    public User[] users;
    SystemView view;

   Controller() {
       data();
       view = new SystemView();
       view.displayAppTitle();

       String username = view.getUsernameInput();
       String password = view.getPasswordInput();
       boolean login = false;
       User currentUser = null;
       for (User user : users) {
           if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
               currentUser = user;
               login = true;
               view.loggedIn();
           }
       }

       if (currentUser == null) {
           return;
       }

       while (true) {
           switch (view.choice()) {
               case "1. Show User Chats":
                   view.showUserChats(currentUser);
                   break;
               case "2. Change Chat State":
                   view.changeChatState(currentUser);
                   break;
               case "3. Send Message":
                   view.sendMessage(currentUser, users);
                   break;
               case "4. Show Message":
                   view.showMessage(currentUser);
                   break;
               case "5. Change User Profile":
                   view.changeUSerProfile(currentUser);
                   break;
               case "6. Show User Favorite Chats":
                   view.showUserFavoriteChats(currentUser);
                   break;
               default: return;
           }
       }
   }

    private void data(){
        Message[] ic_messages = new Message[10];
        ic_messages[0] = new Message("blue", LocalDateTime.of(2024, 3, 4, 5, 6), READ, AVAILABLE);
        ic_messages[1] = new Message("canon", LocalDateTime.of(2023, 3, 6, 5, 49), UNREAD, AVAILABLE);
        Chat ic = new IndividualChat(
                new ChatStateEnum[]{DELETED, UNPINNED, PINNED}, ic_messages, "kitty");

        Message[] ic2_messages = new Message[10];
        ic2_messages[0] = new Message("Event X", LocalDateTime.of(2021, 4, 5, 6, 7), UNREAD, AVAILABLE);
        ic2_messages[1] = new Message("Event Y", LocalDateTime.of(2025, 3, 4, 5, 3), READ, AVAILABLE);
        Chat ic2 = new IndividualChat(
                new ChatStateEnum[]{UNMUTED, UNMUTED, UNMUTED}, ic2_messages, "Molly");


        Message[] gc_messages = new Message[10];
        gc_messages[0] = new Message("Spring", LocalDateTime.of(2020, 2, 3, 3, 5), UNREAD, MessageAvalibilityEnum.DELETED);
        gc_messages[1] = new Message("Summer", LocalDateTime.of(2020, 3, 4, 5, 20), UNREAD, MessageAvalibilityEnum.DELETED);
        gc_messages[2] = new Message("Winter", LocalDateTime.of(2020, 4, 6, 10, 50), UNREAD, AVAILABLE);
        gc_messages[3] = new Message("Fall", LocalDateTime.of(2020, 12, 25, 0, 0), READ, AVAILABLE);
        Chat gc = new GroupChat(
                new ChatStateEnum[]{UNMUTED, UNPINNED, PINNED}, gc_messages,
                "Marry and Happy");

        Message[] gc2_messages = new Message[10];
        gc2_messages[0] = new Message("Fans-X", LocalDateTime.of(2021, 2, 3, 4, 5), UNREAD, AVAILABLE);
        gc2_messages[1] = new Message("Fans-Y", LocalDateTime.of(2021, 2, 4, 5, 6), UNREAD, MessageAvalibilityEnum.DELETED);
        GroupChat gc2 = new GroupChat(
                new ChatStateEnum[]{PINNED, UNMUTED, MUTED}, gc2_messages,"Fans POP");

        // USER DATA
        User andy = new User("andy", "123");
        andy.setChats(new Chat[]{ic2, gc, gc2, ic});

        User bob = new User("bob", "567");
        User claire = new User("claire", "345");
        claire.setChats(new Chat[]{gc2, ic2, ic2});

        users = new User[3];
        users[0] = andy; users[1] = bob; users[2] = claire;
   }

    public static void main(String[] args) {
        Controller main = new Controller();
    }
}