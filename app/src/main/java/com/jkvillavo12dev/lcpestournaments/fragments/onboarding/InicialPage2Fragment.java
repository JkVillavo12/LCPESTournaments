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

/**
 * A simple {@link Fragment} subclass.
 */
public class InicialPage2Fragment extends Fragment {

    private ImageView imageView;

    private static InicialPage2Fragment instance;

    /**
     * Obtiene la instancia unica de la clase
     * Creado el 20/06/2016 a las 5:03 PM <br>
     *
     * @return instancia unica de la clase
     * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
     */
    public static InicialPage2Fragment getInstance() {

        if (instance == null) {
            instance = new InicialPage2Fragment();
        }
        return instance;
    }

    public InicialPage2Fragment() {
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
        View view = inflater.inflate(R.layout.fragment_inicial_page2, container, false);
        imageView = (ImageView) view.findViewById(R.id.fragmentInicial2_imageView);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Glide.with(this)
                .load(R.drawable.image_presenciales2)
                .into(imageView);
    }

    @Override
    public void onDetach() {

        super.onDetach();
    }

}
