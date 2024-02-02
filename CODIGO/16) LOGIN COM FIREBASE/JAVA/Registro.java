package com.example.androidfirebase.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseAuthWebException;

public class Registro extends AppCompatActivity {

    private EditText editNome;
    private EditText editSobrenome;
    private EditText editEmailRegistro;
    private EditText editSenhaResgistro;
    private EditText editSenhaConfirmar;
    private Button btnLogin;
    private Button btnLoginRegistro;
    private FirebaseAuth mAuth;
    private ProgressBar loginProgressBar;
    private CheckBox mostrarSenhaRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registro);
        mAuth = FirebaseAuth.getInstance();
        editNome = findViewById(R.id.editNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editEmailRegistro = findViewById(R.id.editEmailRegistro);
        editSenhaResgistro = findViewById(R.id.editSenhaResgistro);
        editSenhaConfirmar = findViewById(R.id.editSenhaConfirmar);
        btnLogin = findViewById(R.id.btnLogin);
        btnLoginRegistro = findViewById(R.id.btnLoginRegistro);
        loginProgressBar = findViewById(R.id.loginProgressBar);
        mostrarSenhaRegistro = findViewById(R.id.mostrarSenhaRegistro);

        mostrarSenhaRegistro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editSenhaResgistro.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    editSenhaConfirmar.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else {
                    editSenhaResgistro.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    editSenhaConfirmar.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        btnLoginRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserModel userModel = new UserModel();

                userModel.setEmail(editEmailRegistro.getText().toString());
                userModel.setNome(editNome.getText().toString());
                userModel.setSobrenome(editSobrenome.getText().toString());

                String senha = editSenhaResgistro.getText().toString();
                String confirmarSenha = editSenhaConfirmar.getText().toString();

                if (!TextUtils.isEmpty(userModel.getNome()) && !TextUtils.isEmpty(userModel.getSobrenome()) && !TextUtils.isEmpty(userModel.getEmail()) && !TextUtils.isEmpty(senha) && !TextUtils.isEmpty(confirmarSenha)) {
                    if (senha.equals(confirmarSenha)) {
                        loginProgressBar.setVisibility(View.VISIBLE);
                        mAuth.createUserWithEmailAndPassword(userModel.getEmail(), senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    userModel.setId(mAuth.getUid());
                                    userModel.salvar();
                                    abrirTelaPrincipal();
                                }
                                else {
                                    String error;
                                    try {
                                        throw task.getException();
                                    }
                                    catch (FirebaseAuthWeakPasswordException e) {
                                        error = "ERRO: A SENHA DEVE CONTER NO MINIMO 6 CARACTERES!";
                                    }
                                    catch (FirebaseAuthInvalidCredentialsException e) {
                                        error = "ERRO: EMAIL INVÁLIDO!";
                                    }
                                    catch (FirebaseAuthUserCollisionException e) {
                                        error = "ERRO: ESSE EMAIL JÁ EXISTE!";
                                    }
                                    catch (Exception e) {
                                        error = "OCORREU UM ERRO DESCONHECIDO!";
                                        e.printStackTrace();
                                    }
                                    Toast.makeText(Registro.this,error,Toast.LENGTH_SHORT).show();
                                }
                                loginProgressBar.setVisibility(View.INVISIBLE);
                            }
                        });
                    }
                    else {
                        Toast.makeText(Registro.this, "ERRO: A SENHA DEVE SER A MESMA EM TODOS OS CAMPOS! ", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(Registro.this, "ERRO: PREENCHA TODOS OS CAMPOS! ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registro.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void abrirTelaPrincipal() {
        Intent intent = new Intent(Registro.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
