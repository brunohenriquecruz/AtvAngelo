package com.example.brunohenrique.atvangelo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaIPrincipal extends AppCompatActivity {

    EditText nome;
    EditText telefone;
    EditText email;
    Button cadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        nome = (EditText) findViewById(R.id.edtNome);
        telefone = (EditText) findViewById(R.id.edtTelefone);
        email = (EditText) findViewById(R.id.edtEmail);
        cadastrar = (Button) findViewById(R.id.btnNextScreen);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaIPrincipal.this,TelaConfirmDados.class);
                i.putExtra("extraNome", nome.getText().toString());
                i.putExtra("extraEmail", email.getText().toString());
                i.putExtra("extraTel", nome.getText().toString());

                startActivity(i);

            }
        });

    }
}