package com.example.fatusutama.implicitintent.app;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {
    EditText phoneNoET;
    EditText smsTextET;
    Button btnCall;
    Button btnSms;

    String PhoneNo;
    String TextToBeSent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        phoneNoET=(EditText)findViewById(R.id.phoneNoET);
        smsTextET=(EditText)findViewById(R.id.smsTextET);
        btnCall=(Button)findViewById(R.id.btnCall);
        btnSms=(Button)findViewById(R.id.btnSms);


        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneNo=phoneNoET.getText().toString();
                Intent callIntent=new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+PhoneNo));

                startActivity(callIntent);
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneNo=phoneNoET.getText().toString();
                TextToBeSent=smsTextET.getText().toString();

                Uri uri=Uri.parse("smsto:"+PhoneNo);
                Intent smsIntent=new Intent(Intent.ACTION_SENDTO,uri);

                smsIntent.putExtra("sms_body",TextToBeSent);
                startActivity(smsIntent);

            }
        });
    }
}
