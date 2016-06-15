package com.example.rafael.e_bazar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import dao.VestuarioDAO;

public class Lista_Vestuario extends Activity {

    Button btnVoltar;
    Button btnListar;
    ListView lvVestuario;
    ArrayList<String> itens=null;
    ArrayAdapter<String> adapter=null;
    VestuarioDAO vestuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista__vestuario);
        final Intent intent = new Intent();

        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnListar = (Button) findViewById(R.id.btnListar);

        lvVestuario=(ListView) findViewById(R.id.lvVestuario);

        vestuarioDAO=new VestuarioDAO(this);

        btnVoltar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itens=null;
                itens=vestuarioDAO.getAllVestuarios();
                if (itens==null){
                    Toast.makeText(getApplicationContext(),"Sem Vestuário Cadastrado",Toast.LENGTH_LONG).show();
                }else{
                    adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,itens);
                    lvVestuario.setAdapter(adapter);

                }
            }
        });

    }
}
