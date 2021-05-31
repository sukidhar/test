package com.example.myapplication.Fixtures;


import com.example.myapplication.Model.Model_Dialog;
import com.example.myapplication.Model.Model_Message;
import com.example.myapplication.Model.Model_User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DialogFixtures extends FixturesData {
    private DialogFixtures() {
        throw new AssertionError();
    }

    public static ArrayList<Model_Dialog> getDialogs() {
        ArrayList<Model_Dialog> chats = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, -(i * i));
            calendar.add(Calendar.MINUTE, -(i * i));

            chats.add(getDialog(i, calendar.getTime()));
        }

        return chats;
    }

    private static Model_Dialog getDialog(int i, Date lastMessageCreatedAt) {
        ArrayList<Model_User> users = getUsers();
        return new Model_Dialog(
                getRandomId(),
                users.size() > 1 ? groupChatTitles.get(users.size() - 2) : users.get(0).getName(),
                users.size() > 1 ? groupChatImages.get(users.size() - 2) : getRandomAvatar(),
                users,
                getMessage(lastMessageCreatedAt),
                i < 3 ? 3 - i : 0);
    }

    private static ArrayList<Model_User> getUsers() {
        ArrayList<Model_User> users = new ArrayList<>();
        int usersCount = 1 + rnd.nextInt(4);

        for (int i = 0; i < usersCount; i++) {
            users.add(getUser());
        }

        return users;
    }

    private static Model_User getUser() {
        return new Model_User(
                getRandomId(),
                getRandomName(),
                getRandomAvatar(),
                getRandomBoolean()
        );
    }

    private static Model_Message getMessage(final Date date) {
        return new Model_Message(
                getRandomId(),
                getUser(),
                getRandomMessage(),
                date);
    }
}

