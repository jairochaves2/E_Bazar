package com.example.rafael.e_bazar;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import dao.CadastroDAO;

public class ExcOng extends AppCompatActivity {

    Button btnVoltar;

    Spinner spNomeOng;
    ArrayList<String> ongs;
    ArrayAdapter adapter;

    CadastroDAO cadastroDAO;

    Button deletarOng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exc_ong);

        deletarOng=(Button) findViewById(R.id.btnDeletarOng);

        cadastroDAO = new CadastroDAO(this);
        btnVoltar = (Button) findViewById(R.id.btnVoltarexc);



        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Escolha Uma Ong, e clique no botão Deletar!");
        AlertDialog alerta=builder.create();
        alerta.show();



        spNomeOng=(Spinner) findViewById(R.id.spNomeOng);
        //Nome das ongs cadastradas
        nomeNoSpinner();

        deletarOng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome=spNomeOng.getSelectedItem().toString();
                cadastroDAO.deletaOng(nome);
                nomeNoSpinner();

            }
        });
        btnVoltar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
    }
    public void nomeNoSpinner(){
        ongs=new ArrayList<String>();
        ongs=cadastroDAO.getNome();


        adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, ongs);
        try {
            spNomeOng.setAdapter(adapter);

        }catch (NullPointerException e){
            Toast.makeText(getApplicationContext(),"Sem bancos cadastrados",Toast.LENGTH_SHORT).show();
        }
    }
}
