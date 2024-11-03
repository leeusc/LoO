package controller;

import model.*;
import model.constants.ChatStateEnum;
import view.view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static model.constants.ChatStateEnum.*;
import static model.constants.MessageAvailibiltyEnum.AVAILABLE;
import static model.constants.MessageStateInterface.READ;
import static model.constants.MessageStateInterface.UNREAD;

public class Main {
    view view;

    public static void main(String[] args) {

        new Main();
    }

    Main(){
        User user = new User("mario", "121212", "Mario", LocalDate.parse("2020-10-11"), "mario@com", "62832920");

        Chat groupChat1 = new GroupChat(messages1(), chatStates1(), "HBB");
        Chat groupChat2 = new GroupChat(messages2(), chatState3(), "OK!");
        Chat individualChat1 = new IndividualChat(messages2(), chatState2(), "Kale");
        Chat individualChat2 = new IndividualChat(messages1(), chatStates1(), "Ken");
        List<Chat> chatList = new ArrayList<>();
        chatList.add(groupChat1);
        chatList.add(groupChat2);
        chatList.add(individualChat1);
        chatList.add(individualChat2);
        user.setChatList(chatList);

        view = new view();
        while (true) {
            String options = view.options();
            switch (options) {
                case "Show User Chats":
                    view.showUserChats(user);
                    break;
                case "Change Chat State":
                    Chat chat = view.chat(user);
                    view.changeChatState(chat);
                    view.displayChatState(chat);
                    break;
                case "Change User Profile":
                    view.updateField(user);
                    view.displayUserProfile(user);
                    break;
                case "Show User Favorite Chats":
                    view.showUserFavoriteChats(user);
                    break;
                default: return;
            }
        }
    }

    List<ChatStateEnum> chatStates1(){
        List<ChatStateEnum> chatStates = new ArrayList<>(2);
        chatStates.add(PINNED);
        chatStates.add(MUTED);
        return chatStates;
    }

    List<ChatStateEnum> chatState2(){
        List<ChatStateEnum> chatStates = new ArrayList<>(2);
        chatStates.add(UNPINNED);
        chatStates.add(UNMUTED);
        return chatStates;
    }

    List<ChatStateEnum> chatState3(){
        List<ChatStateEnum> chatStates = new ArrayList<>(1);
        chatStates.add(HIDE);
        return chatStates;
    }

    List<Message> messages1(){
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("Hello", LocalDateTime.of(2023, 2,2,2,2), UNREAD, AVAILABLE));
        messages.add(new Message("Hai", LocalDateTime.of(2023, 2,2,2,2), READ, AVAILABLE));
        return messages;
    }

    List<Message> messages2(){
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("Kitty", LocalDateTime.of(2023, 2,2,2,2), UNREAD, AVAILABLE));
        messages.add(new Message("Doggy", LocalDateTime.of(2023, 2,2,2,2), READ, AVAILABLE));
        messages.add(new Message("Baby", LocalDateTime.of(2023, 3,3,3,3), READ, AVAILABLE));
        return messages;
    }


}