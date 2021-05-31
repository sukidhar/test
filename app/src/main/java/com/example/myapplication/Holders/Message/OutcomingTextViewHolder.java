package com.example.myapplication.Holders.Message;

import android.view.View;

import com.example.myapplication.Model.Model_Message;
import com.stfalcon.chatkit.messages.MessageHolders;

public class OutcomingTextViewHolder extends MessageHolders.OutcomingTextMessageViewHolder<Model_Message> {
    public OutcomingTextViewHolder(View itemView, Object payload) {
        super(itemView, payload);
    }
    @Override
    public void onBind(Model_Message message) {
        super.onBind(message);

        time.setText(message.getStatus() + " " + time.getText());
    }
}
