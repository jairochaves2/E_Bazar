package com.example.rafael.e_bazar;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import dao.CadastroDAO;

public class MainActivity extends Activity {

    /* Declaração das variaveis usadas */
    EditText et_login;
    EditText et_senha ;
    Button  btnCadastrar ;
    Button btnLogin;
    public static CadastroDAO dataBaseManeger;
    public static String Slogin="";
    public static String Ssenha="";
    public static ArrayList<String> res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        et_login = (EditText) findViewById(R.id.etLogin);
        et_senha = (EditText) findViewById(R.id.etPassword);
        dataBaseManeger=new CadastroDAO(this);

        final Intent intent = new Intent();
        btnCadastrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                intent.setClass(MainActivity.this, Cadastro_Ong.class);
                startActivity(intent);;
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Slogin=et_login.getText().toString();
                Ssenha=et_senha.getText().toString();

                //res=dataBaseManeger.getUserPass(Slogin,Ssenha);


                if (res==null){
                    et_senha.setError("Senha incorreta");
                    et_login.setError("Usuário incorreto");
                }else{
                    Intent intent1= new Intent();
                    intent1.setClass(MainActivity.this,Home.class);
                    startActivity(intent1);
                }
            }
        });


    }
}
