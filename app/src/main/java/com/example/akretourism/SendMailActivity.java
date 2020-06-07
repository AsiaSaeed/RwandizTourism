package com.example.akretourism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendMailActivity extends AppCompatActivity {
    Button send;
    EditText mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_mail);
        send = findViewById(R.id.send);
        mail=findViewById(R.id.mail);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));// only email apps should handle this
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, mail.getText().toString());
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                startActivity(intent);
            }
        });
    }
}
