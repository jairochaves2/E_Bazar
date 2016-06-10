package com.example.rafael.e_bazar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import dao.CadastroDAO;

public class Cadastro_Ong extends Activity {

    Button btnVoltar;
    Button btnCadastrar;

    Spinner spEstado;

    EditText etNome,etIntuito,etCidade;

    String nome,intuito,cidade, estado;

    CadastroDAO cadastro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_ong);

        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);



        etNome=(EditText) findViewById(R.id.eTNO);
        etIntuito=(EditText) findViewById(R.id.eTIntuito);
        etCidade=(EditText) findViewById(R.id.eTcidade);
        spEstado=(Spinner) findViewById(R.id.spEstado);


        cadastro=new CadastroDAO(this);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.estados));
        spEstado.setAdapter(adapter);


        btnVoltar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean validacao=true;

                nome=etNome.getText().toString();
                intuito=etIntuito.getText().toString();
                cidade=etCidade.getText().toString();
                estado=spEstado.getSelectedItem().toString();

                if (nome.equals("")||nome==null){
                    validacao=false;
                    etNome.setError("Campo obrigatório");

                }if (intuito.equals("")||intuito==null){
                    validacao=false;
                    etIntuito.setError("Campo obrigatório");

                }if (cidade.equals("")||cidade==null){
                    validacao=false;
                    etCidade.setError("Campo obrigatório");

                }if (estado.equals("Selecione")){
                    validacao=false;
                    Toast.makeText(Cadastro_Ong.this,"Escolha uma opção de Estado",Toast.LENGTH_LONG).show();

                }

                if (validacao) {
                    cadastro.salvaCadastro(nome, intuito, cidade, estado,etNome);
                    etNome.setText("");
                    etIntuito.setText("");
                    etCidade.setText("");
                }


            }
        });
    }
}
