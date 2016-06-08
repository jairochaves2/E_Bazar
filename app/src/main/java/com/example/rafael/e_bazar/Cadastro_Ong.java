package com.example.rafael.e_bazar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dao.CadastroDAO;

public class Cadastro_Ong extends Activity {

    Button btnVoltar;
    Button btnCadastrar;
    EditText etNome,etIntuito,etCidade,etEstado, etLogin,etSenha;
    String nome,intuito,cidade, estado,login, senha;
    CadastroDAO cadastro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_ong);

        etNome=(EditText) findViewById(R.id.eTNO);
        etIntuito=(EditText) findViewById(R.id.eTIntuito);
        etCidade=(EditText) findViewById(R.id.eTcidade);
        etEstado=(EditText) findViewById(R.id.eTEstado);
        etLogin=(EditText) findViewById(R.id.eTLogin);
        etSenha=(EditText) findViewById(R.id.eTSenha);

        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        cadastro=new CadastroDAO(this);


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
                estado=etEstado.getText().toString();
                login=etLogin.getText().toString();
                senha=etSenha.getText().toString();

                if (nome.equals("")||nome==null){
                    validacao=false;
                    etNome.setError("Campo obrigatório");

                }if (intuito.equals("")||intuito==null){
                    validacao=false;
                    etIntuito.setError("Campo obrigatório");

                }if (cidade.equals("")||cidade==null){
                    validacao=false;
                    etCidade.setError("Campo obrigatório");

                }if (estado.equals("")||estado==null){
                    validacao=false;
                    etEstado.setError("Campo obrigatório");

                }if (login.equals("")||login==null){
                    validacao=false;
                    etLogin.setError("Campo obrigatório");

                }if (senha.equals("")||senha==null){
                    validacao=false;
                    etSenha.setError("Campo obrigatório");

                }

                if (validacao) {
                    cadastro.salvaCadastro(nome, intuito, cidade, estado, login, senha, etLogin);
                    etNome.setText("");
                    etIntuito.setText("");
                    etCidade.setText("");
                    etEstado.setText("");
                    etLogin.setText("");
                    etSenha.setText("");
                }


            }
        });
    }
}
