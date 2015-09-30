package com.example.jalber.ceroes3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.jalber.ceroes3.adapters.DocumentosAdapter;
import com.example.jalber.ceroes3.modelo.Documento;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class activity_documentos extends AppCompatActivity
{
    ListView l_documentos;
    ArrayList<Documento> data;
    DocumentosAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentos);

        l_documentos=(ListView) findViewById(R.id.lista_documentos);

        data=new ArrayList<>();
        adapter2= new DocumentosAdapter(this,data);
        l_documentos.setAdapter(adapter2);
        loadData();
    }

    public void loadData()
    {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Documento");
        //query.whereEqualTo("tiponombre",tipo);
        query.findInBackground(new FindCallback<ParseObject>()
        {
            @Override
            public void done(List<ParseObject> parseObjects, ParseException e)
            {
                if (e == null)
                {
                    for (ParseObject documents : parseObjects)
                    {
                        Documento d = new Documento();
                        d.setNombre(documents.getString("Nombre"));
                        data.add(d);
                        adapter2.notifyDataSetChanged();
                    }
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_documentos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
