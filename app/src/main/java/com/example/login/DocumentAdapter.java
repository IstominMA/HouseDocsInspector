package com.example.login;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DocumentAdapter extends BaseAdapter {

    private  LayoutInflater layoutInflater;
    private  ArrayList<Document> array;
    public final String DOCUMENT_EXTRA = "DocumentExtra";
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

        final Document document = array.get(position);

        TextView nameTextView = (TextView)view.findViewById(R.id.nameTextView);
        TextView dateTextView = (TextView)view.findViewById(R.id.dateTextView);
        TextView infoTextView = (TextView)view.findViewById(R.id.infoTextView);
        View borderView = view.findViewById(R.id.documentBorder);


        nameTextView.setText(document.getName());
        infoTextView.setText(document.getInfo());
        dateTextView.setText(document.getCreationDate().toString());
        borderView.setBackgroundColor(getColorForDate(document.getCreationDate()));



        return view;
    }



    private int getColorForDate(Date date){
        Calendar calendar = new GregorianCalendar();
        Date comparableDate;

        calendar.add(Calendar.DAY_OF_MONTH, -10);
        comparableDate = calendar.getTime();
        if (date.after(comparableDate)){
            return Colors.NEW_DOCUMENT;
        }

        calendar.add(Calendar.DAY_OF_MONTH, -10);
        comparableDate = calendar.getTime();
        if (date.after(comparableDate)){
            return Colors.PRE_EXPIRED_DOCUMENT;
        }

        if (date.before(comparableDate)){
            return Colors.EXPIRED_DOCUMENT;
        }

        return Colors.DOCUMENT;
    }

    public class Colors {

        public final static int NEW_DOCUMENT = 0xFF51D94A;
        public final static int EXPIRED_DOCUMENT = 0xFFFF2E2E;
        public final static int PRE_EXPIRED_DOCUMENT = 0xFFFFEA2E;
        public final static int DOCUMENT = 0xFF9C9C9C;

    }
}
