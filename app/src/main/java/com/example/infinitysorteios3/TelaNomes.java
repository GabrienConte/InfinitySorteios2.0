package com.example.infinitysorteios3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import java.util.*;


import java.util.Arrays;

public class TelaNomes extends AppCompatActivity {

    private Button btnVoltarTNAM;
    private Button btnSortNome;
    private TextView txtListaNome;
    private TextView txtQtdNomes;
    private TextView lblResultNome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_nomes);

        txtListaNome = findViewById(R.id.txtListaNome);
        txtQtdNomes = findViewById((R.id.txtQtdNomes));
        lblResultNome = findViewById((R.id.lblResultNome));

        btnSortNome = findViewById(R.id.btnSortNome);
        btnSortNome.setOnClickListener(v -> {
            if(txtListaNome.getText() != "" && txtQtdNomes.getText() != ""){
                String result = GerarSorteioNome(txtListaNome.getText().toString(), Integer.parseInt(txtQtdNomes.getText().toString()));
                lblResultNome.setText(result);
            }else {
                lblResultNome.setText("Há campos vazios!");
            }
        });

        btnVoltarTNAM = findViewById(R.id.btnVoltarTNAM);
        btnVoltarTNAM.setOnClickListener(v -> {
            finish();
        });
    }

    private String GerarSorteioNome(String listaNomes, int qtdNomes){
        Random random = new Random();
        String[] nomes = listaNomes.split(",");
        List<Integer> listSelecionados = new ArrayList<Integer>();
        String result = "";

        if(qtdNomes < 1 ){
            return "Quantidade de nomes sorteados deve ser maior que 0";
        }
        if (qtdNomes > nomes.length){
            return "Quantidade de nomes sorteados deve ser menor que o número de nomes";
        }

        do {
            boolean adicionarLista = true;
            int indexSorteada = random.nextInt(nomes.length);
            for (int i : listSelecionados){
                if (i == indexSorteada) {
                    adicionarLista = false;
                    break;
                }
            }
            if (adicionarLista) {
                listSelecionados.add(indexSorteada);
                result = result + nomes[indexSorteada] + ", ";
            }
        } while (listSelecionados.size() < qtdNomes);

        StringBuilder resultFormatado = new StringBuilder(result);
        resultFormatado.deleteCharAt(resultFormatado.length()-2);

        return resultFormatado.toString();
    }
}