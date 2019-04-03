package com.spirit.force.gestion_des_depenses_revenus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoUtilisateur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_utilisateur);
        Intent info=getIntent();
        String getUname=(String)info.getStringExtra("extraName");
        TextView txt=(TextView)findViewById(R.id.eName);
        txt.setText(getUname);
        String getUprenom=(String)info.getStringExtra("extraPrenom");
        TextView txt2=(TextView)findViewById(R.id.eDate);
        txt2.setText(getUprenom);
        String getUemail=(String)info.getStringExtra("extraEmail");
        TextView txt3=(TextView)findViewById(R.id.eLocation);
        txt3.setText(getUemail);

        String getUpays=(String)info.getStringExtra("extraPays");
        TextView txt5=(TextView)findViewById(R.id.eNotes);
        txt5.setText(getUpays);
        String getUdevise=(String)info.getStringExtra("extraDevise");
        TextView txt4=(TextView)findViewById(R.id.eParticipants);
        txt4.setText(getUdevise);
    }
}
