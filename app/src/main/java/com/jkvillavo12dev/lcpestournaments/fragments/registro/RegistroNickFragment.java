package com.jkvillavo12dev.lcpestournaments.fragments.registro;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.jkvillavo12dev.lcpestournaments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistroNickFragment extends Fragment {

    private TextInputLayout textInputLayoutNick;
    private EditText editTextNick;

    private static RegistroNickFragment instance;

    public static RegistroNickFragment getInstance() {

        if (instance == null) {
            instance = new RegistroNickFragment();
        }
        return instance;
    }

    public static void destroyInstance() {
        instance = null;
    }


    public RegistroNickFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro_nick, container, false);

        textInputLayoutNick = (TextInputLayout) view.findViewById(R.id.registroNick_textInputLayoutNombres);
        editTextNick = (EditText) view.findViewById(R.id.registroNick_editTextNick);

        return view;
    }

    public boolean validate() {

//        int errores = 0;
//        errores += ActivityUtils.validarEditTextWithInputLayout(getContext(), editTextNick, textInputLayoutNick);
//        if (errores > 0) return false;

        return true;
    }
}
