package com.example.login;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.Shape;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.ArrayList;

public class DocumentAdapter extends BaseAdapter {

    private  LayoutInflater layoutInflater;
    private  ArrayList<Document> array;

    private DocumentAdapter (){};

    public DocumentAdapter(Context context, ArrayList<Document> array){
        this.array = array;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Object getItem(int position) {
        return array.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.document, parent, false);
        }

        Document document = array.get(position);

        TextView nameTextView = (TextView)view.findViewById(R.id.nameTextView);
        TextView dateTextView = (TextView)view.findViewById(R.id.dateTextView);
        TextView infoTextView = (TextView)view.findViewById(R.id.infoTextView);

        nameTextView.setText(document.getName());
        infoTextView.setText(document.getInfo());
        dateTextView.setText(document.getCreationDate().toString());


        Drawable border = view.getResources().getDrawable(R.drawable.document_border);



        return view;
    }
}
