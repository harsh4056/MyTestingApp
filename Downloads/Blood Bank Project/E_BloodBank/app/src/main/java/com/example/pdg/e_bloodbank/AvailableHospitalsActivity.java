package com.example.pdg.e_bloodbank;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AvailableHospitalsActivity extends AppCompatActivity {



    final String bloodgrp ="bloodgrp";
    final String quantity ="quantity";
    String bloodGrpValue="";
    String bloodGrpQuantityValue ="";
    final String url="http://192.168.225.133/php/banksByQuantity.php";
    String recieved;
    HashMap<String ,String> bloodGroupMap= new HashMap<>();
    private List<BankDetails> bankDetailsList ;

    private ExpandableListView expandableListView;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        bloodGrpColumnInitialize();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_hospitals);
        Intent i = getIntent();
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
       bankDetailsList= new ArrayList<>();
        bloodGrpQuantityValue= i.getStringExtra("Quantity");
        bloodGrpValue=bloodGroupMap.get( i.getStringExtra("Group"));

        expandableListView  = (ExpandableListView) findViewById(R.id.expandableListView);
            showpDialog();
        StringRequest str = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                recieved  = response;
                Log.d("Response --->",recieved);
                try {

                    JSONArray jsonArray = new JSONObject(recieved).getJSONArray("banks");
                    for(int i =0 ; i<jsonArray.length();i++){

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String bank_name = jsonObject.getString("bank_name");
                        String bank_address= jsonObject.getString("address");
                       int units= jsonObject.getInt(bloodGrpValue);
                        String latitude = jsonObject.getString("latitude");
                        String phoneNo= jsonObject.getString("phone_no");
                        String longitude = jsonObject.getString("longitude");
                        BankDetails bankDetails= new BankDetails(bank_name,bank_address,phoneNo,bloodGrpValue,latitude,longitude,units);

                        bankDetailsList.add(bankDetails);
                    }

                    setExpandableListView(bankDetailsList);





                } catch (JSONException e) {
                    hidepDialog();
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
                }

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                hidepDialog();
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();

            }
        }


        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put(bloodgrp,bloodGrpValue);
          params.put(quantity, bloodGrpQuantityValue);
                //params.put("password", p);
                return params;
            }
        };
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(str);


    }

    private void bloodGrpColumnInitialize(){


        bloodGroupMap.put("O+","o_pos");
        bloodGroupMap.put("A+","a_pos");
        bloodGroupMap.put("B+","b_pos");
        bloodGroupMap.put("AB+","ab_pos");
        bloodGroupMap.put("O-","o_neg");
        bloodGroupMap.put("A-","a_neg");
        bloodGroupMap.put("B-","b_neg");
        bloodGroupMap.put("AB-","ab_neg");








    }


    public  void setExpandableListView(List<BankDetails> bankDetailsList){

        ExpandableListAdapter adapter = new ExpandableListAdapter(AvailableHospitalsActivity.this,bankDetailsList);
        expandableListView.setAdapter(adapter);

    hidepDialog();




    }
    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }


}
