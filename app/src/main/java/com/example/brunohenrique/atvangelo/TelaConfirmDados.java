package com.example.brunohenrique.atvangelo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TelaConfirmDados extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    TextView nome, tel, email, end, curso, linguagens, turno, area;
    Button selecionar, adicionar;
    Spinner spnarea;
    ListView listhabilidades;
    ArrayAdapter<String> adapterArea;
    ArrayAdapter<String> adapterHabilidades;
    ArrayList<String> arrayHabilidades;

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


        selecionar = (Button) findViewById(R.id.btnSelecionar);
        selecionar.setOnClickListener(this);

        nome.setText(bundle.getString("extraNome"));
        email.setText(bundle.getString("extraEmail"));
        tel.setText(bundle.getString("extraTel"));
        end.setText(bundle.getString("extraEnd"));
        curso.setText(bundle.getString("extraCurso"));
        linguagens.setText(bundle.getString("extraLinguagens"));
        turno.setText(bundle.getString("extraTurno"));

        String[] areas = {"Back-End", "API", "Front-End"};
        adapterArea = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, areas);
        spnarea = (Spinner) findViewById(R.id.spArea);
        spnarea.setAdapter(adapterArea);

        arrayHabilidades = new ArrayList<String>();
        adapterHabilidades = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayHabilidades); //android.R - Component Legacy
        listhabilidades = (ListView) findViewById(R.id.lvHabilidades);
        listhabilidades.setAdapter(adapterHabilidades);
        listhabilidades.setOnItemClickListener(this);

        adicionar = (Button) findViewById(R.id.btnAdicionar);
        adicionar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnSelecionar:
                    area = (TextView) findViewById(R.id.tvGetArea);
                    area.setText("Area de atuação: " + spnarea.getSelectedItem().toString());
                    break;
                case R.id.btnAdicionar:
                    EditText edtHabilidades = (EditText) findViewById(R.id.edtHabilidades);
                    String tvHabilidades = edtHabilidades.getText().toString();
                    if(!tvHabilidades.isEmpty()){
                        arrayHabilidades.add(tvHabilidades);
                        adapterHabilidades.notifyDataSetChanged();
                    }
                    edtHabilidades.setText("");
                    break;
            }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        arrayHabilidades.remove(position);
        adapterHabilidades.notifyDataSetChanged();
    }
}

//        voltar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });

