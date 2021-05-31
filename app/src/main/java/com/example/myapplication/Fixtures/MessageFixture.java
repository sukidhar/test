package com.example.myapplication.Fixtures;

import com.example.myapplication.Model.Model_Message;
import com.example.myapplication.Model.Model_User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MessageFixture extends FixturesData {
    private MessageFixture() {
        throw new AssertionError();
    }

    public static Model_Message getImageMessage() {
        Model_Message message = new Model_Message(getRandomId(), getUser(), null);
        message.setImage(new Model_Message.Image(getRandomImage()));
        return message;
    }

    public static Model_Message getTextMessage() {
        return getTextMessage(getRandomMessage());
    }

    public static Model_Message getTextMessage(String text) {
        return new Model_Message(getRandomId(), getUser(), text);
    }

    public static ArrayList<Model_Message> getMessages(Date startDate) {
        ArrayList<Model_Message> messages = new ArrayList<>();
        for (int i = 0; i < 10/*days count*/; i++) {
            int countPerDay = rnd.nextInt(5) + 1;

            for (int j = 0; j < countPerDay; j++) {
                Model_Message message;
                if (i % 2 == 0 && j % 3 == 0) {
                    message = getImageMessage();
                } else {
                    message = getTextMessage();
                }

                Calendar calendar = Calendar.getInstance();
                if (startDate != null) calendar.setTime(startDate);
                calendar.add(Calendar.DAY_OF_MONTH, -(i * i + 1));

                message.setCreatedAt(calendar.getTime());
                messages.add(message);
            }
        }
        return messages;
    }

    private static Model_User getUser() {
        boolean even = rnd.nextBoolean();
        return new Model_User(
                even ? "0" : "1",
                even ? names.get(0) : names.get(1),
                even ? avatars.get(0) : avatars.get(1),
                true);
    }
}

