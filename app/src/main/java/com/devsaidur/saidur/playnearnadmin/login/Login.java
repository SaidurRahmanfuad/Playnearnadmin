package com.devsaidur.saidur.playnearnadmin.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.devsaidur.saidur.playnearnadmin.MainActivity;
import com.devsaidur.saidur.playnearnadmin.R;
import com.devsaidur.saidur.playnearnadmin.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    ActivityLoginBinding activityLoginBinding;
    FirebaseDatabase fdb;
    DatabaseReference dbr;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_login);
        setContentView(activityLoginBinding.getRoot());
        mAuth=FirebaseAuth.getInstance();
        fdb=FirebaseDatabase.getInstance();

        activityLoginBinding.loginBtn.setOnClickListener(v -> {
            LoginFun();
        });
    }

    private void LoginFun() {
        mAuth.signInWithEmailAndPassword(activityLoginBinding.loginEmail.getText().toString().trim(), activityLoginBinding.loginPassword.getText().toString().trim())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("log", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            // String uid = mAuth.getCurrentUser().getUid();
                            // access(user);
                            Intent gotomain = new Intent(Login.this, MainActivity.class);
                            startActivity(gotomain);
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("log", "signInWithEmail:failure", task.getException());
                            Toast.makeText(Login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            //reload();
            Intent gotomain = new Intent(Login.this, MainActivity.class);
            startActivity(gotomain);
            finish();
        }
    }
}