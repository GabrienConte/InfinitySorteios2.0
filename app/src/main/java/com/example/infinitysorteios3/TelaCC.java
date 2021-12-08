package com.example.infinitysorteios3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class TelaCC extends AppCompatActivity {

    private ImageView moedaView;
    private Button btnVoltarTCC;
    private Button btnCaraCoroa;
    private int numeroA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cc);

        moedaView= (ImageView) findViewById(R.id.moedaView);

        btnCaraCoroa = findViewById(R.id.btnCaraCoroa);
        btnCaraCoroa.setOnClickListener(v ->{
            SortearCaraouCoroa(moedaView);
        });


        btnVoltarTCC = findViewById(R.id.btnVoltarTCC);
        btnVoltarTCC.setOnClickListener(v -> {
            finish();
        });

    }

    public void SortearCaraouCoroa (ImageView view){
        numeroA = (int)(Math.random()*1000);

        if (numeroA %2 == 0){
            view.setImageResource(R.drawable.cara);
        }else {
            view.setImageResource(R.drawable.coroa);
        }

    }

}