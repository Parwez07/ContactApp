package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CreateContact extends AppCompatActivity {
    TextView etName;
    TextView etWeb;
    TextView etLoacation;
    TextView etNumber;
    ImageView emoji, call,location,web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        etName=findViewById(R.id.tvName);
        etWeb = findViewById(R.id.tvWeb);
        etLoacation =findViewById(R.id.tvLocation);
        etNumber = findViewById(R.id.tvNumber);
        emoji = findViewById(R.id.emoji);
        call = findViewById(R.id.imgCall);
        web = findViewById(R.id.imgWeb);
        location =findViewById(R.id.imgLocation);

        String name = getIntent().getStringExtra(MainActivity.nameKey);
        String Web = getIntent().getStringExtra(MainActivity.webKey);
        String Loction = getIntent().getStringExtra(MainActivity.LocKey);
        String Number = getIntent().getStringExtra(MainActivity.numKey);
        String emojiId = getIntent().getStringExtra(MainActivity.emojikey);

        etNumber.setText(Number);
        etName.setText(name);
        etWeb.setText(Web);
        etLoacation.setText(Loction);
        if(emojiId.equals("happy")){
            emoji.setImageResource(R.drawable.happy);
        }
        else if (emojiId.equals("sad")){
            emoji.setImageResource(R.drawable.sad);
        }else{
            emoji.setImageResource(R.drawable.veryhappy);
        }

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+Number.trim()));
                startActivity(intent);
            }
        });


        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+Loction.trim()));
                startActivity(intent);
            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://"+Web.trim()));
                startActivity(intent);
            }
        });
    }
}