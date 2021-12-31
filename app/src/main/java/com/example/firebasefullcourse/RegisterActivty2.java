package com.example.firebasefullcourse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.amirarcane.lockscreen.activity.EnterPinActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivty2 extends AppCompatActivity {
    Button next;
    Button button1,button2,button3;
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activty2);
        Intent intent = EnterPinActivity.getIntent(RegisterActivty2.this, true);
        startActivity(intent);
        next = (Button)findViewById(R.id.nextregpage);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        text1 = (TextView)findViewById(R.id.pin);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (text1.getText().equals("ABC"))
                {
                    text1.setText("");
                }

                text1.append("R");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText().equals("ABC"))
                {
                    text1.setText("");
                }

                text1.append("G");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText().equals("ABC"))
                {
                    text1.setText("");
                }

                text1.append("B");
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).child("Level2Pin").setValue(text1.getText().toString()).
                        addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {

                                Toast.makeText(RegisterActivty2.this, "Level 2 Registered", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivty2.this,RegisterActivty3.class);
                                finish();
                                startActivity(intent);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(RegisterActivty2.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

    }
}
