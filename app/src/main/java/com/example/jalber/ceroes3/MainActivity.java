package com.example.jalber.ceroes3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    Spinner spinner;
    ArrayList<ParseFile> logo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo=new ArrayList<ParseFile>();
        ParseQuery<ParseObject> query=new ParseQuery<ParseObject>("Logo");
        query.findInBackground(new FindCallback<ParseObject>()
                               {
                                   @Override
                                   public void done(List<ParseObject> list, ParseException e)
                                   {
                                       if (e == null)
                                       {
                                           for (ParseObject foto : list)
                                           {
                                               ParseFile p=foto.getParseFile("AppPhoto");
                                               logo.add(p);
                                           }
                                       }

                                   }
                               }

        );
        spinner= (Spinner) findViewById(R.id.spinnerInicial);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opcionesSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

}
