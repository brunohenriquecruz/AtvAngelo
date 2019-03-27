package com.example.brunohenrique.atvangelo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TelaConfirmDados extends AppCompatActivity {

    TextView nome, tel, email, end, curso, linguagens;
    Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_confirm_dados);

        Bundle bundle = getIntent().getExtras();

        nome = (TextView) findViewById(R.id.tvGetNome);
        email = (TextView) findViewById(R.id.tvGetEmail);
        tel = (TextView) findViewById(R.id.tvGetTel);
        end = (TextView) findViewById(R.id.tvGetEnd);
        curso = (TextView) findViewById(R.id.tvGetCurso);
        linguagens = (TextView) findViewById(R.id.tvLinguagens);

        voltar = (Button) findViewById(R.id.btnVoltar);

        nome.setText(bundle.getString("extraNome"));
        email.setText(bundle.getString("extraEmail"));
        tel.setText(bundle.getString("extraTel"));
        end.setText(bundle.getString("extraEnd"));
        curso.setText(bundle.getString("extraCurso"));
        linguagens.setText(bundle.getString("extraLinguagens"));

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
