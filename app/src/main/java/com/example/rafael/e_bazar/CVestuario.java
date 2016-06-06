package com.example.rafael.e_bazar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CVestuario extends Activity {

    Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cvestuario);

        voltar =  (Button) findViewById(R.id.btnVoltar);

        voltar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
    }
}
