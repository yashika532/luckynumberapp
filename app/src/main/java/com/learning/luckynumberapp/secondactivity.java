package com.learning.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class secondactivity extends AppCompatActivity {
    TextView txt;
    TextView txtview;
    Button btn;
    Button back;
    EditText edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        btn=findViewById(R.id.button2);
        txt=findViewById(R.id.txt);
        txtview=findViewById(R.id.txtview);
        back=findViewById(R.id.back);
edit2=findViewById(R.id.editText2);

        Intent i=getIntent();
        String username=i.getStringExtra("name");
        edit2.setText(" "+username);
        int ran_num=gennum();
        txt.setText(" "+ran_num);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(username,ran_num);

            }
        });
back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        gotomain();
    }
});
    }
    public int gennum(){
        Random random = new Random();
        int limit =100;
        int num=random.nextInt(limit);
        return num;
    }
    public void shareData(String user,int rannum){
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT," "+user+"got lucky today");
        i.putExtra(Intent.EXTRA_TEXT,"lucky number is "+rannum);
        startActivity(Intent.createChooser(i,"choose a platform"));
    }
 public void gotomain(){
        Intent in=new Intent(this, MainActivity.class);
        startActivity(in);
 }
}