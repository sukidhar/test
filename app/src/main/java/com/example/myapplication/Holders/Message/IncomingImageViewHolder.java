package com.example.myapplication.Holders.Message;

import android.view.View;

import com.example.myapplication.Model.Model_Message;
import com.example.myapplication.R;
import com.stfalcon.chatkit.messages.MessageHolders;

public class IncomingImageViewHolder extends
        MessageHolders.IncomingImageMessageViewHolder<Model_Message> {
    private View onlineIndicator;
    public IncomingImageViewHolder(View itemView, Object payload) {
        super(itemView, payload);
        onlineIndicator =itemView.findViewById(R.id.onlineIndicator);
    }
    @Override
    public void onBind(Model_Message message){
        super.onBind(message);

        boolean isOnline = message.getUser().isOnline();
        if (isOnline) {
            onlineIndicator.setBackgroundResource(R.drawable.online_bubble);
        } else {
            onlineIndicator.setBackgroundResource(R.drawable.offline_buuble);
        }
    }
}
