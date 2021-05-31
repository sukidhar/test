package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.example.myapplication.Fixtures.MessageFixture;
import com.example.myapplication.Holders.Message.IncomingImageViewHolder;
import com.example.myapplication.Holders.Message.IncomingTextViewHolder;
import com.example.myapplication.Holders.Message.OutcomingImageViewHolder;
import com.example.myapplication.Holders.Message.OutcomingTextViewHolder;
import com.example.myapplication.Model.Model_Message;
import com.squareup.picasso.Picasso;
import com.stfalcon.chatkit.commons.ImageLoader;


import com.stfalcon.chatkit.messages.MessageHolders;
import com.stfalcon.chatkit.messages.MessageInput;
import com.stfalcon.chatkit.messages.MessagesList;
import com.stfalcon.chatkit.messages.MessagesListAdapter;

import java.util.ArrayList;
import java.util.Date;

public class MessagesActivity extends AppCompatActivity implements  MessagesListAdapter.OnLoadMoreListener,MessageInput.InputListener,MessageInput.AttachmentsListener {

    public static void open(Context context){
        context.startActivity(new Intent(context,MessagesActivity.class));
    }
    private static final int Total_count =100;
    private String senderId ="1";
    private ImageLoader imageLoader;

    private MessagesListAdapter<Model_Message> messagesListAdapter;
    private MessagesList messagesList ;
    private Date lastLoadedDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_messages);
            messagesList = findViewById(R.id.messageList);

            MessageInput input = findViewById(R.id.messageInput);
            imageLoader = (imageView,url,payload) -> Picasso.get().load(url).into(imageView);
            input.setInputListener(this);
            input.setAttachmentsListener(this);

            start_adapter();
    }

    public void start_adapter(){
        IncomingTextViewHolder.Payload payload = new IncomingTextViewHolder.Payload();
        MessageHolders holdersConfig = new MessageHolders().setIncomingTextConfig(IncomingTextViewHolder.class,R.layout.item_text_message,payload).setOutcomingTextConfig(OutcomingTextViewHolder.class,R.layout.item_textout_message)
                .setIncomingImageConfig(IncomingImageViewHolder.class,R.layout.item_imagein_message).setOutcomingImageConfig(OutcomingImageViewHolder.class,R.layout.item_imageout_message);
        messagesListAdapter = new MessagesListAdapter<>(senderId,holdersConfig,imageLoader);
        messagesListAdapter.setLoadMoreListener(this);
        messagesList.setAdapter(messagesListAdapter);
    }

    @Override
    public void onAddAttachments() {
        messagesListAdapter.addToStart(MessageFixture.getImageMessage(),true);
    }

    @Override
    public boolean onSubmit(CharSequence input) {
        messagesListAdapter.addToStart(MessageFixture.getTextMessage(input.toString()), true);
        return true;
    }

    @Override
    public void onLoadMore(int page, int totalItemsCount) {
        if(totalItemsCount < Total_count)
        {
            loadMessages();
        }
    }
    protected void loadMessages(){
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                ArrayList<Model_Message> messages = MessageFixture.getMessages(lastLoadedDate);
                lastLoadedDate = messages.get(messages.size()-1).getCreatedAt();
                messagesListAdapter.addToEnd(messages,false);
            }
        },1000);
    }


}