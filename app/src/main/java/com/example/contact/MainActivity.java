package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etWeb;
    EditText etLoacation;
    EditText etNumber;
    ImageView emojiHappy,emojiSad,emojiVeryHappy;
    static String emojikey;
    String emojiId="happy";
    Button btnContact;
    static  String webKey="web",numKey ="num",LocKey="Loc",nameKey ="name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etWeb = findViewById(R.id.etWeb);
        etNumber = findViewById(R.id.etNumber);
        etLoacation = findViewById(R.id.etLoacation);
        btnContact = findViewById(R.id.btnContact);
        emojiHappy = findViewById(R.id.eHappy);
        emojiSad =findViewById(R.id.eSad);
        emojiVeryHappy =findViewById(R.id.eVeryHappy);
        emojiHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emojiId ="happy";
            }
        });
        emojiVeryHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emojiId = "VeryHappy";
            }
        });
        emojiSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emojiId ="sad";
            }
        });
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CreateContact.class);
                String name = etName.getText().toString();
                String web = etWeb.getText().toString();
                String Location = etLoacation.getText().toString();
                String contact = etNumber.getText().toString();
                intent.putExtra(webKey,web);
                intent.putExtra(nameKey,name);
                intent.putExtra(LocKey,Location);
                intent.putExtra(numKey,contact);
                intent.putExtra(emojikey,emojiId);
                Toast.makeText(MainActivity.this,"contact Saved....",Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });
    }
}