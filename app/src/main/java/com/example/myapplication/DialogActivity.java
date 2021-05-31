package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.Fixtures.DialogFixtures;
import com.example.myapplication.Holders.Dialog.DialogViewHolder;
import com.example.myapplication.Model.Model_Dialog;
import com.squareup.picasso.Picasso;
import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.dialogs.DialogsList;
import com.stfalcon.chatkit.dialogs.DialogsListAdapter;


public class DialogActivity extends AppCompatActivity implements DialogsListAdapter.OnDialogClickListener<Model_Dialog> {

    private DialogsList dialogList;
    protected ImageLoader imageLoader;
    DialogsListAdapter<Model_Dialog> dialogsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        dialogList = findViewById(R.id.dialogList);
        imageLoader = (imageView,url,payload) -> Picasso.get().load(url).into(imageView);

        start_adapter();
    }

    public void start_adapter(){
        dialogsListAdapter = new DialogsListAdapter<>(R.layout.item_dialog_view,DialogViewHolder.class,imageLoader);

        dialogsListAdapter.setItems(DialogFixtures.getDialogs());
        dialogsListAdapter.setOnDialogClickListener(this);

        dialogList.setAdapter(dialogsListAdapter);
    }


    @Override
    public void onDialogClick(Model_Dialog dialog) {
        MessagesActivity.open(this);
    }
}