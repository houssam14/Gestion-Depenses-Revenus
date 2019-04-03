package com.spirit.force.gestion_des_depenses_revenus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Inscription extends AppCompatActivity {
    DataBaseHelper dbhelper=new DataBaseHelper(this);
    @BindView(R.id.btnEnr)
    Button  btnEn;
    @BindView(R.id.nom)
    EditText txtNom;
    @BindView(R.id.prenom)
    EditText  txtPrenom;
    @BindView(R.id.mail)
    EditText  txtmail;
    @BindView(R.id.pays)
    Spinner Spays;
    @BindView(R.id.devise)
    Spinner Sdevise;
    @BindView(R.id.password)
    EditText txtPassword;
    @BindView(R.id.conf)
    EditText txtconf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        //ButterKnife
        ButterKnife.bind(this);


        btnEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ArrayList<Utilisateur> arr;
                arr=dbhelper.read();
                dbhelper.insert(txtNom.getText().toString(),txtPrenom.getText().toString(),txtmail.getText().toString(),
                        Spays.getSelectedItem().toString(),Sdevise.getSelectedItem().toString(),txtPassword.getText().toString());
                Utilisateur Util=arr.get(arr.size()-1);
                Intent i=new Intent(getApplicationContext(),InfoUtilisateur.class);
                i.putExtra("extraName",Util.getNom());
                i.putExtra("extraPrenom",Util.getPrenom());
                i.putExtra("extraEmail",Util.getEmail());
                i.putExtra("extraMdp",Util.getMdp());
                i.putExtra("extraPays",Util.getPays());
                i.putExtra("extraDevise",Util.getDevise());

                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!txtconf.getText().toString().equals(txtPassword.getText().toString()))
        {
            btnEn.setClickable(false);
        }else{
            btnEn.setClickable(true);
        }

    }
}
