package com.example.myapplication.Model;

import androidx.annotation.Nullable;

import com.stfalcon.chatkit.commons.models.IMessage;
import com.stfalcon.chatkit.commons.models.IUser;
import com.stfalcon.chatkit.commons.models.MessageContentType;

import java.util.Date;

public class Model_Message implements IMessage, MessageContentType.Image {
    private String id;
    private String text;
    private Date createdAt;
    private Model_User user;
    private Image image;
    private Voice voice;

    public Model_Message(String id, Model_User user, String text) {
        this(id, user, text, new Date());
    }

    public Model_Message(String id, Model_User user, String text, Date createdAt) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.createdAt = createdAt;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public Model_User getUser() {
        return this.user;
    }




    @Override
    public String getImageUrl() {
        return image == null ? null : image.url;
    }



    public String getStatus() {
        return "Sent";
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setImage(Image image) {
        this.image = image;
    }



    public static class Image {

        private String url;

        public Image(String url) {
            this.url = url;
        }
    }

    public static class Voice {

        private String url;
        private int duration;

        public Voice(String url, int duration) {
            this.url = url;
            this.duration = duration;
        }

        public String getUrl() {
            return url;
        }

        public int getDuration() {
            return duration;
        }
    }

}
