package com.example.myapplication.Model;

import com.stfalcon.chatkit.commons.models.IDialog;
import com.stfalcon.chatkit.commons.models.IMessage;
import com.stfalcon.chatkit.commons.models.IUser;

import java.util.ArrayList;
import java.util.List;

public class Model_Dialog implements IDialog<Model_Message> {
    private String id;
    private String dialogPhoto;
    private String dialogName;
    private ArrayList<Model_User> users;
    private Model_Message lastMessage;

    private int unreadCount;

    public Model_Dialog(String id, String name, String photo,
                  ArrayList<Model_User> users, Model_Message lastMessage, int unreadCount) {

        this.id = id;
        this.dialogName = name;
        this.dialogPhoto = photo;
        this.users = users;
        this.lastMessage = lastMessage;
        this.unreadCount = unreadCount;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getDialogPhoto() {
        return dialogPhoto;
    }

    @Override
    public String getDialogName() {
        return dialogName;
    }

    @Override
    public ArrayList<Model_User> getUsers() {
        return users;
    }

    @Override
    public Model_Message getLastMessage() {
        return lastMessage;
    }

    @Override
    public void setLastMessage(Model_Message lastMessage) {
        this.lastMessage = lastMessage;
    }

    @Override
    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }
}
