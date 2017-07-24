package com.jkvillavo12dev.lcpestournaments.fragments.registro;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jkvillavo12dev.lcpestournaments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistroNickFragment extends Fragment {

    private static RegistroNickFragment instance;

    public static RegistroNickFragment getInstance() {

        if (instance == null) {
            instance = new RegistroNickFragment();
        }
        return instance;
    }


    public RegistroNickFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro_nick, container, false);
    }

}
