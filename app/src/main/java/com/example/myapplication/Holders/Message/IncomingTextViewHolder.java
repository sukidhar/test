package com.example.myapplication.Holders.Message;

import android.view.View;

import com.example.myapplication.Model.Model_Message;
import com.example.myapplication.R;
import com.stfalcon.chatkit.messages.MessageHolders;



public class IncomingTextViewHolder
        extends MessageHolders.IncomingTextMessageViewHolder<Model_Message>{
    private View onlineIndicator;
    public IncomingTextViewHolder(View itemView, Object payload) {
        super(itemView, payload);
        onlineIndicator = itemView.findViewById(R.id.onlineIndicator);
    }
    @Override
    public void onBind(Model_Message message) {
        super.onBind(message);

        boolean isOnline = message.getUser().isOnline();
        if (isOnline) {
            onlineIndicator.setBackgroundResource(R.drawable.online_bubble);
        } else {
            onlineIndicator.setBackgroundResource(R.drawable.offline_buuble);
        }

        //We can set click listener on view from payload
        final Payload payload = (Payload) this.payload;
        userAvatar.setOnClickListener(view -> {
            if (payload != null && payload.avatarClickListener != null) {
                payload.avatarClickListener.onAvatarClick();
            }
        });
    }

    public static class Payload {
        public OnAvatarClickListener avatarClickListener;
    }

    public interface OnAvatarClickListener {
        void onAvatarClick();
    }
}

