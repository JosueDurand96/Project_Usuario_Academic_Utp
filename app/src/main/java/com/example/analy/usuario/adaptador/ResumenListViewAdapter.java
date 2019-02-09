package com.example.analy.usuario.adaptador;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.analy.usuario.Cajas.Incidencias;
import com.example.analy.usuario.R;

import java.util.List;

public class ResumenListViewAdapter  extends BaseAdapter {
    LayoutInflater inflater;
    List<Incidencias> items;
    private Context mContext;
    private String urlServer = "http://www.capacitasoft.com/site/Tesis/";
    public ResumenListViewAdapter(Activity context, List<Incidencias> items) {
        super();
        this.mContext = context;
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Incidencias item = items.get(position);

        if(convertView==null)
            convertView = inflater.inflate(R.layout.resumen, null);

//        ImageView imgThumbnail = (ImageView)convertView.findViewById(R.id.imageViewImagen);
        TextView txtgrado = (TextView)convertView.findViewById(R.id.txtgrado);
        TextView txtincidencia = (TextView)convertView.findViewById(R.id.txtincidencia);
        TextView txtaula = (TextView)convertView.findViewById(R.id.txtaula);
        TextView txtnroaula = (TextView)convertView.findViewById(R.id.txtnroaula);
//        ImageView btnmapaagencia = (ImageView)convertView.findViewById(R.id.btnmapaagencia);
//
//
//
        txtgrado.setText(item.desgrado);
        txtincidencia.setText(item.descripcion);
        txtaula.setText(item.Auladescripcion);
        txtnroaula.setText(item.nroaula);

        //final int latitud = Integer.parseInt(String.valueOf((item.latitud)));
        //  final int longitud = Integer.parseInt(String.valueOf((item.longitud)));


        return convertView;
    }
}
