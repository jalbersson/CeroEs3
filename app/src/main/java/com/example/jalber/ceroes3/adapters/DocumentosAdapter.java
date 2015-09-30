package com.example.jalber.ceroes3.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.jalber.ceroes3.R;
import com.example.jalber.ceroes3.modelo.Documento;

import java.util.List;

/**
 * Created by Jalber on 29/09/2015.
 */
public class DocumentosAdapter extends BaseAdapter
{

    Context context;
    List<Documento> data;

    public DocumentosAdapter(Context context, List<Documento> data)
    {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount()
    {
        return data.size();
    }
    @Override
    public Object getItem(int position)
    {
        return data.get(position);
    }
    @Override
    public long getItemId(int position)
    {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = null;
        if (convertView == null)
        {
            v = View.inflate(context, R.layout.template_documentos, null);
        }
        else
        {
            v = convertView;
        }
        Documento g = (Documento) getItem(position);
        Button btn = (Button) v.findViewById(R.id.btn_sisben);
        btn.setText(g.getNombre());

        return v;
    }
}
