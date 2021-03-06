package com.jkvillavo12dev.lcpestournaments.fragments.onboarding;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jkvillavo12dev.lcpestournaments.R;

public class InicialPage1Fragment extends Fragment {

    private ImageView imageView;

    private static InicialPage1Fragment instance;

    /**
     * Obtiene la instancia unica de la clase
     * Creado el 20/06/2016 a las 5:03 PM <br>
     *
     * @return instancia unica de la clase
     * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
     */
    public static InicialPage1Fragment getInstance() {

        if (instance == null) {
            instance = new InicialPage1Fragment();
        }
        return instance;
    }

    public InicialPage1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicial_page1, container, false);
        imageView = (ImageView) view.findViewById(R.id.fragmentInicial1_imageView);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Glide.with(this)
                .load(R.drawable.image_online)
                .into(imageView);
    }

    @Override
    public void onDetach() {

        super.onDetach();
    }

}
