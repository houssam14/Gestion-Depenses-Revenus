package com.spirit.force.gestion_des_depenses_revenus;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btnSuiv1)
    Button btnSuiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textpropos = findViewById(R.id.propos);
        textpropos.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        //ButterKnife
        ButterKnife.bind(this);
        btnSuiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Inscription.class));
            }
        });


        textpropos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AproposDeLapp.class);
                startActivity(intent);
            }
        });
    }
}
