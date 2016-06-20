package com.example.rafael.e_bazar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends Activity {

    Button btnConfiguracoes;
    Button btnSair;
    Button btnCVestuario;
    Button btnLVestuario;
    Button btnCadOng;
    Button btnListOng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnConfiguracoes = (Button) findViewById(R.id.btnConfiguraçoes);
        btnCVestuario = (Button) findViewById(R.id.CV);
        btnLVestuario =  (Button) findViewById(R.id.LV);
        btnCadOng =  (Button) findViewById(R.id.btnCadOng);
        btnListOng =  (Button) findViewById(R.id.btnListOng);
        btnSair = (Button) findViewById(R.id.Sair);

        final Intent intent = new Intent();

        btnCVestuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setClass(Home.this, CVestuario.class);
                startActivity(intent);
            }
        });

        btnLVestuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setClass(Home.this, Lista_Vestuario.class);
                startActivity(intent);
            }
        });

        btnConfiguracoes.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                intent.setClass(Home.this, Configuracoes.class);
                startActivity(intent);
            }
        });
        btnCadOng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent();
                intent1.setClass(Home.this,Cadastro_Ong.class);
                startActivity(intent1);
            }
        });
        btnListOng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent();
                intent1.setClass(Home.this, Lista_Ongs.class);
                startActivity(intent1);
            }
        });


        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
