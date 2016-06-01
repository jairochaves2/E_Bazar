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


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnConfiguracoes = (Button) findViewById(R.id.btnConfiguraçoes);
        btnCVestuario = (Button) findViewById(R.id.CV);
        btnLVestuario =  (Button) findViewById(R.id.LV);
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

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
