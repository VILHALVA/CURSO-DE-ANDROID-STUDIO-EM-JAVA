package com.example.androidfirebase.Activity;

import static com.example.androidfirebase.R.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.androidfirebase.MainActivity;
import com.example.androidfirebase.Model.UserModel;
import com.example.androidfirebase.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText editEmail;
    private EditText editSenha;
    private Button btnLogin;
    private Button btnRegistrar;
    private FirebaseAuth mAuth;
    private ProgressBar loginProgressBar;
    private CheckBox mostrarSenha;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        loginProgressBar = findViewById(R.id.loginProgressBar);
        mostrarSenha = findViewById(R.id.mostrarSenha);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginEmail = editEmail.getText().toString();
                String loginSenha = editSenha.getText().toString();

                if (!TextUtils.isEmpty(loginEmail) || !TextUtils.isEmpty(loginSenha)) {
                    loginProgressBar.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(loginEmail,loginSenha)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                abrirTelaPrincipal();
                            }
                            else {
                                String error = task.getException().getMessage();
                                Toast.makeText(Login.this,""+error,Toast.LENGTH_SHORT).show();
                                loginProgressBar.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                }
            }
        });

        mostrarSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editSenha.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else {
                    editSenha.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Registro.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void abrirTelaPrincipal() {
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}