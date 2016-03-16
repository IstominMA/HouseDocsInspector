package com.example.login;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import java.util.ArrayList;

public class MenLo2Activity extends Activity {

    ListView listView;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_lo2);

        listView = (ListView)findViewById(R.id.listView);

        ArrayList<Document> array = DocumentDatabase.fetch();
        DocumentAdapter adapter = new DocumentAdapter(this, array);
        listView.setAdapter(adapter);


    }
}