package com.example.myapplication.Holders.Dialog;

import android.view.View;

import com.example.myapplication.Model.Model_Dialog;
import com.example.myapplication.R;
import com.stfalcon.chatkit.dialogs.DialogsListAdapter;

public class DialogViewHolder extends DialogsListAdapter.DialogViewHolder<Model_Dialog> {
    private View onlineIndicator;
    public DialogViewHolder(View itemView) {
        super(itemView);
        onlineIndicator = itemView.findViewById(R.id.onlineIndicator);
    }
    @Override
    public void onBind(Model_Dialog Dialog){
        super.onBind(Dialog);

        if(Dialog.getUsers().size() > 1){
            onlineIndicator.setVisibility(View.GONE);
        }
        else{
            boolean isOnline = Dialog.getUsers().get(0).isOnline();
            onlineIndicator.setVisibility(View.VISIBLE);
            if (isOnline){
                onlineIndicator.setBackgroundResource(R.drawable.online_bubble);
            }
            else{
                onlineIndicator.setBackgroundResource(R.drawable.offline_buuble);
                }
        }
    }
}
