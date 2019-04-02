package com.spirit.force.gestion_des_depenses_revenus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Inscription extends AppCompatActivity {
    @BindView(R.id.btnEnr)
    Button  btnEn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        //ButterKnife
        ButterKnife.bind(this);


        btnEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SaisieRev.class));
            }
        });


    }
}
