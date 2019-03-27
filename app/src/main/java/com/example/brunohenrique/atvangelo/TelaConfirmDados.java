package com.example.brunohenrique.atvangelo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TelaConfirmDados extends AppCompatActivity {

    TextView nome, tel, email, end, curso, linguagens, turno;
    Button voltar;
    Spinner area;
    ArrayAdapter<String> adapterArea;

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
        turno = (TextView) findViewById(R.id.tvGetTurno);

        voltar = (Button) findViewById(R.id.btnVoltar);

        nome.setText(bundle.getString("extraNome"));
        email.setText(bundle.getString("extraEmail"));
        tel.setText(bundle.getString("extraTel"));
        end.setText(bundle.getString("extraEnd"));
        curso.setText(bundle.getString("extraCurso"));
        linguagens.setText(bundle.getString("extraLinguagens"));
        turno.setText(bundle.getString("extraTurno"));

        String[] areas = {"Back-End", "API", "Front-End"};
        adapterArea = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, areas);
        area = (Spinner) findViewById(R.id.spArea);
        area.setAdapter(adapterArea);


        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
