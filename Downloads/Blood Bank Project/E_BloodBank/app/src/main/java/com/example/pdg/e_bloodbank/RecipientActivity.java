package com.example.pdg.e_bloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Spinner;


public class RecipientActivity extends AppCompatActivity {
    Spinner spinnerBloodGroup;
    EditText etQuantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_recipient);
        spinnerBloodGroup= (Spinner) findViewById(R.id.spinnerBloodGroup);
        etQuantity= (EditText)findViewById(R.id.etQuantity);




    }

    public void check(View v){

        Intent i=new Intent(RecipientActivity.this,AvailableHospitalsActivity.class);
        i.putExtra("Group",spinnerBloodGroup.getSelectedItem().toString());
        i.putExtra("Quantity",etQuantity.getText().toString());
        startActivity(i);

    }

}
