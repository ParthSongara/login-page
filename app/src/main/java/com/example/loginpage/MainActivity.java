package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    Button btn_logot;
    TextView tx1;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth=FirebaseAuth.getInstance();
        btn_logot=findViewById(R.id.logout);
        tx1=findViewById(R.id.userinfo);
        user =auth.getCurrentUser();
        if(user==null)
        {
            Intent intent = new Intent(getApplicationContext(),login.class);
            startActivity(intent);
            finish();
        }
        else
        {
            tx1.setText((user.getEmail()));
        }
        btn_logot.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(),login.class);
                startActivity(intent);
                finish();
            }
        }));
    }
}