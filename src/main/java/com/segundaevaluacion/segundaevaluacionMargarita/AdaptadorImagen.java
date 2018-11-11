package com.segundaevaluacion.segundaevaluacionMargarita;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdaptadorImagen extends BaseAdapter {

    Context context;
    private List<Imagen> lstimagenes;
    Animation anim_zoomIN;
    Animation anim_zoomOut;
    Boolean es_zoomIN   =true;
    public AdaptadorImagen(Context context, List<Imagen> lstimagenes) {
        this.context = context;
        this.lstimagenes = lstimagenes;
        anim_zoomIN = AnimationUtils.loadAnimation(context,R.anim.zoom_in);
        anim_zoomIN.setDuration(1000);
        anim_zoomIN.setFillAfter(true);
        anim_zoomOut = AnimationUtils.loadAnimation(context,R.anim.zoom_out);
        anim_zoomOut.setDuration(1000);
        anim_zoomOut.setFillAfter(true);
    }

    @Override
    public int getCount() {
        return lstimagenes.size();
    }

    @Override
    public Object getItem(int position) {
        return lstimagenes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_imagen,parent,false);
        }
        final ImageView imagen = convertView.findViewById(R.id.imagen);
        TextView contador = convertView.findViewById(R.id.lblcontador);
        TextView ruta = convertView.findViewById(R.id.lblruta);
        Imagen img = (Imagen) getItem(position);
        contador.setText(String.valueOf(position+1));
        imagen.setImageBitmap(img.imagen);
        ruta.setText(img.ruta);

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(es_zoomIN) {
                    imagen.startAnimation(anim_zoomIN);
                }else{
                    imagen.startAnimation(anim_zoomOut);
                }
                es_zoomIN=!es_zoomIN;
            }
        });
        return convertView;
    }

}
