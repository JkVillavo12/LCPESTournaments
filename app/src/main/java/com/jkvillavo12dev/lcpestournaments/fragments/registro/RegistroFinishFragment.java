package com.jkvillavo12dev.lcpestournaments.fragments.registro;


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
public class RegistroFinishFragment extends Fragment {

    private ImageView imageView;

    private static RegistroFinishFragment instance;

    public static RegistroFinishFragment getInstance() {

        if (instance == null) {
            instance = new RegistroFinishFragment();
        }
        return instance;
    }


    public RegistroFinishFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro_finish, container, false);
        imageView = (ImageView) view.findViewById(R.id.fragmentRegistroFinish_imageView);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Glide.with(this)
                .load(R.drawable.image_back_playstationbuttons)
                .into(imageView);
    }

}
