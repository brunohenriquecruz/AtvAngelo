package com.example.brunohenrique.atvangelo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class TelaIPrincipal extends AppCompatActivity implements View.OnClickListener {

    EditText nome, curso, telefone, email, end;
    Button cadastrar;
    CheckBox java, javascript, cobol, csharp, python, php;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        nome = (EditText) findViewById(R.id.edtNome);
        telefone = (EditText) findViewById(R.id.edtTelefone);
        email = (EditText) findViewById(R.id.edtEmail);
        end = (EditText) findViewById(R.id.edtEnd);
        curso = (EditText) findViewById(R.id.edtCurso);
        java = (CheckBox) findViewById(R.id.cbJava);
        javascript = (CheckBox) findViewById(R.id.cbJavaScript);
        cobol = (CheckBox) findViewById(R.id.cbCobol);
        csharp = (CheckBox) findViewById(R.id.cbCsharp);
        python = (CheckBox) findViewById(R.id.cbPy);
        php = (CheckBox) findViewById(R.id.cbPHP);


        cadastrar = (Button) findViewById(R.id.btnNextScreen);
        cadastrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String linguagens = getLinguagens();

        Intent i = new Intent(TelaIPrincipal.this, TelaConfirmDados.class);
        i.putExtra("extraNome", nome.getText().toString());
        i.putExtra("extraEmail", email.getText().toString());
        i.putExtra("extraTel", telefone.getText().toString());
        i.putExtra("extraEnd", end.getText().toString());
        i.putExtra("extraCurso", curso.getText().toString());
        i.putExtra("extraLinguagens", linguagens);

        startActivity(i);
    }

    public String getLinguagens() {

        String linguagens = "Linguagens conhecidas: ";

        if (php.isChecked()) {
            linguagens += php.getText().toString() + ", ";
        }
        if (csharp.isChecked()) {
            linguagens += csharp.getText().toString() + ", ";
        }
        if (python.isChecked()) {
            linguagens += python.getText().toString() + ", ";
        }
        if (cobol.isChecked()) {
            linguagens += cobol.getText().toString() + ", ";
        }
        if (java.isChecked()) {
            linguagens += java.getText().toString() + ", ";
        }
        if (javascript.isChecked()) {
            linguagens += javascript.getText().toString() + ", ";
        }

        return linguagens;
    }

}
