package com.example.rafael.e_bazar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

import dao.CadastroDAO;

public class CVestuario extends Activity {

    Button voltar;
    Spinner spTamanho, spOng, spEstCons;
    ArrayAdapter<String> adapter;
    CadastroDAO cadastroDAO;
    ArrayList<String> ongs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cvestuario);

        cadastroDAO=new CadastroDAO(this);

        voltar =  (Button) findViewById(R.id.btnVoltar);

        spTamanho=(Spinner) findViewById(R.id.spTamanho);
        spOng=(Spinner) findViewById(R.id.spOng);
        spEstCons=(Spinner) findViewById(R.id.spEstCons);

        adapter =new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.tamanho));
        spTamanho.setAdapter(adapter);

        adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.estado_conservacao));
        spEstCons.setAdapter(adapter);

        //teste
        ongs=new ArrayList<>();
        ongs.add("Selecione");
        ongs=cadastroDAO.getNome();
        adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, ongs);
        spOng.setAdapter(adapter);

        voltar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
    }
}
