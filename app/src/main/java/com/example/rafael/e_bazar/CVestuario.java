package com.example.rafael.e_bazar;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import dao.CadastroDAO;
import dao.VestuarioDAO;

public class CVestuario extends Activity {

    Button btnVoltar;
    Button btnCadastrar;
    RadioButton rbCalca, rbBlusa, rbVestido, rbSaia, rbMeia, rbCalcado;
    Spinner spTamanho, spOng, spEstCons;
    ArrayAdapter<String> adapter;
    EditText etPreco, etCor;

    CadastroDAO cadastroDAO;
    VestuarioDAO vestuarioDAO;

    ArrayList<String> ongs;
    String peca_roupa="";
    String tamanho="";
    String estCons="";
    String indOng="";
    String preco="";
    String cor="";
    boolean cadastrar=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cvestuario);
        //banco de dados

        cadastroDAO=new CadastroDAO(this);
        vestuarioDAO=new VestuarioDAO(this);
        //instancia dos componentes
        btnVoltar =  (Button) findViewById(R.id.btnVoltar);
        btnCadastrar=(Button) findViewById(R.id.btnCadastrar);

        spTamanho=(Spinner) findViewById(R.id.spTamanho);
        spOng=(Spinner) findViewById(R.id.spOng);
        spEstCons=(Spinner) findViewById(R.id.spEstCons);

        rbCalca=(RadioButton) findViewById(R.id.rbCalca);
        rbBlusa=(RadioButton) findViewById(R.id.rbBlusa);
        rbVestido=(RadioButton) findViewById(R.id.rbVestido);
        rbSaia=(RadioButton) findViewById(R.id.rbSaia);
        rbMeia=(RadioButton) findViewById(R.id.rbMeia);
        rbCalcado=(RadioButton) findViewById(R.id.rbCalcado);

        etPreco=(EditText) findViewById(R.id.eTPreco);
        etCor=(EditText) findViewById(R.id.eTCor);



    //preenchimento dos campos iniciais

        //tamanhos
        adapter =new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.tamanho));
        spTamanho.setAdapter(adapter);

        //estado de conservacao
        adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.estado_conservacao));
        spEstCons.setAdapter(adapter);

        //Nome das ongs cadastradas
        try {



            ongs=new ArrayList<>();

            ongs=cadastroDAO.getNome();

            adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, ongs);

            spOng.setAdapter(adapter);
            cadastrar=true;
        }catch (NullPointerException e){
            Toast.makeText(getApplicationContext(),"Sem ONG Cadastrada",Toast.LENGTH_LONG).show();
            cadastrar=false;
        }

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //peça
                if (cadastrar){
                    if (rbCalca.isChecked()){
                        peca_roupa="Calça";
                    }if (rbSaia.isChecked()){
                        peca_roupa="Saia";
                    }if (rbVestido.isChecked()){
                        peca_roupa="Vestido";
                    }if (rbBlusa.isChecked()){
                        peca_roupa="Blusa";
                    }if (rbMeia.isChecked()){
                        peca_roupa="Meia";
                    }if (rbCalcado.isChecked()){
                        peca_roupa="Calçado";
                    }
                    //tamanho
                    tamanho=spTamanho.getSelectedItem().toString();
                    estCons=spEstCons.getSelectedItem().toString();
                    indOng=spOng.getSelectedItem().toString();
                    preco=etPreco.getText().toString();
                    cor=etCor.getText().toString();


                    if (tamanho.equals("Selecione")||estCons.equals("Selecione")||indOng.equals("Selecione")||preco.equals("")||
                            preco==null||cor.equals("")||cor==null){
                        Toast.makeText(getApplicationContext(),"Verifique se os dados estão corretos", Toast.LENGTH_LONG).show();
                        etPreco.setError("");
                        etCor.setError("");
                    }else{
                        vestuarioDAO.salvarVestuario(peca_roupa, tamanho, estCons, indOng, preco, cor);
                        etPreco.setText("");
                        etCor.setText("");

                    }

                }else {
                    Toast.makeText(getApplicationContext(),"Não Existe ONG cadastrada, \nCadastre, e tente novamente",Toast.LENGTH_LONG).show();
                }


            }
        });
        btnVoltar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
    }
}
