package com.example.jalber.ceroes3;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.GetDataCallback;
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
    ImageView i;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo=new ArrayList<ParseFile>();
        progressDialog = ProgressDialog.show(MainActivity.this, "", "Downloading Image...", true);
        // Locate the class table named "Footer" in Parse.com
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Logo");
        // Locate the objectId from the class
        query.getInBackground("YlV0NNT5Gy", new GetCallback<ParseObject>()
        {//lo que sigue hace parte del metodo GetCallback
            public void done(ParseObject object,ParseException e)
            {
                // TODO Auto-generated method stub
                // Locate the column named "ImageName" and set
                // the string
                ParseFile fileObject = (ParseFile) object.get("AppPhoto");
                fileObject.getDataInBackground(new GetDataCallback()
                {
                    public void done(byte[] data, ParseException e)
                    {
                        if (e == null)
                        {
                            Log.d("test", "We've got data in data.");
                            // Decode the Byte[] into
                            // Bitmap
                            Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
                            // Get the ImageView from main.xml
                            //ImageView image = (ImageView) findViewById(R.id.ad1);
                            ImageView ad1=(ImageView) findViewById(R.id.logoApp);
                            // Set the Bitmap into the
                            // ImageView
                            ad1.setImageBitmap(bmp);
                            // Close progress dialog
                            progressDialog.dismiss();
                        }
                        else
                        {
                            Log.d("test", "There was a problem downloading the data.");
                        }
                    }
                });
            }
        });
        /*ParseQuery<ParseObject> query=new ParseQuery<ParseObject>("Logo");
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
        );*/

        spinner= (Spinner) findViewById(R.id.spinnerInicial);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opcionesSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

}
