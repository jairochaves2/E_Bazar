package com.example.rafael.e_bazar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import dao.CadastroDAO;

public class Configuracoes extends Activity {

    Button btnVoltar;
    Button btnExcOng;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);

        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnExcOng = (Button) findViewById(R.id.btnExcOng);

        btnVoltar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
              finish();
            }
        });
        btnExcOng.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                try {
                    Intent intent=new Intent();
                    intent.setClass(Configuracoes.this, ExcOng.class);
                    startActivity(intent);
                }catch (NullPointerException e){
                    Toast.makeText(getApplicationContext(),"Sem ONGs Cadastradas",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

}
