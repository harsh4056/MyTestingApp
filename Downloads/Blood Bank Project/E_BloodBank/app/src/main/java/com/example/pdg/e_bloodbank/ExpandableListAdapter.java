package com.example.pdg.e_bloodbank;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by moon on 3/7/17.
 */

  class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<BankDetails> _bankLists;

    public ExpandableListAdapter(Context context, List<BankDetails>_bankLists) {
        this._context = context;
        this._bankLists = _bankLists;

    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._bankLists
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

       final BankDetails bankDetails= _bankLists.get(groupPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }

        TextView textViewAddress = (TextView) convertView
                .findViewById(R.id.tvAddress);
        TextView textViewPhone = (TextView) convertView
                .findViewById(R.id.tvPhone);
        textViewAddress.setText("Address : "+ bankDetails.getBankAddress());
        textViewPhone.setText("Phone : "+ bankDetails.getPhoneNo());
        Button button = (Button) convertView.findViewById(R.id.btnLocate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(_context,MapsActivity.class);
                i.putExtra("latitude",bankDetails.getLatitude());
                i.putExtra("longitude",bankDetails.getLongitude());
                _context.startActivity(i);
            }
        });
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._bankLists.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._bankLists.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        BankDetails bankDetails= _bankLists.get(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        TextView textViewName = (TextView) convertView
                .findViewById(R.id.tvBankName);
        TextView textViewUnits = (TextView) convertView
                .findViewById(R.id.tvUnits);
        textViewName.setTypeface(null, Typeface.BOLD);
        textViewName.setText(bankDetails.getBankName());
        textViewUnits.setText(""+bankDetails.getUnits());


        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
