package com.example.rafael.e_bazar;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    /* Declaração das variaveis usadas */
    EditText login;
    EditText password ;
    Button  btnCadastrar ;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        login = (EditText) findViewById(R.id.txtLogin);
        password = (EditText) findViewById(R.id.txtPassword);

        final Intent intent = new Intent();
        btnCadastrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                intent.setClass(MainActivity.this, Cadastrar.class);
                startActivity(intent);;
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(login.getText().toString().equalsIgnoreCase("login") &&
                        password.getText().toString().equalsIgnoreCase("Senha")){
                    intent.setClass(MainActivity.this, Home.class);
                    startActivity(intent);
                }
            }
        });
    }
}
