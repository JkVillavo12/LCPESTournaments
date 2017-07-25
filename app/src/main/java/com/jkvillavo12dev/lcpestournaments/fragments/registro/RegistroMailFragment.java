package com.jkvillavo12dev.lcpestournaments.fragments.registro;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.jkvillavo12dev.lcpestournaments.R;
import com.jkvillavo12dev.lcpestournaments.utils.ActivityUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistroMailFragment extends Fragment {

    private TextInputLayout textInputLayoutMail;
    private EditText editTextMail;

    private static RegistroMailFragment instance;

    public static RegistroMailFragment getInstance() {

        if (instance == null) {
            instance = new RegistroMailFragment();
        }
        return instance;
    }


    public RegistroMailFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_registro_mail, container, false);
        textInputLayoutMail = (TextInputLayout) view.findViewById(R.id.registroMail_textInputLayoutMail);
        editTextMail = (EditText) view.findViewById(R.id.registroMail_editTextMail);
        return view;
    }

    public static void destroyInstance() {
        instance = null;
    }

    public boolean validate() {

        int errores = ActivityUtils.validarEditTextWithInputLayout(getContext(), editTextMail, textInputLayoutMail);
        if (errores == 0) {
            errores += ActivityUtils.isValidEmail(getContext(), editTextMail, textInputLayoutMail);
        }
        if (errores == 0) return true;
        return false;
    }

}
