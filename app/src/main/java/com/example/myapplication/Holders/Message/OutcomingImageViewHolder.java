package com.example.myapplication.Holders.Message;

import android.util.Pair;
import android.view.View;

import com.example.myapplication.Model.Model_Message;
import com.stfalcon.chatkit.messages.MessageHolders;

public class OutcomingImageViewHolder extends MessageHolders.OutcomingImageMessageViewHolder<Model_Message> {
    public OutcomingImageViewHolder(View itemView, Object payload) {
        super(itemView, payload);
    }

    @Override
    public void onBind(Model_Message message) {
        super.onBind(message);

        time.setText(message.getStatus() + " " + time.getText());
    }

    //Override this method to have ability to pass custom data in ImageLoader for loading image(not avatar).
    @Override
    protected Object getPayloadForImageLoader(Model_Message message) {
        //For example you can pass size of placeholder before loading
        return new Pair<>(100, 100);
    }
}
