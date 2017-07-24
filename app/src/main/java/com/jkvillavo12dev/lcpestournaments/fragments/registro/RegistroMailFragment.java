package com.jkvillavo12dev.lcpestournaments.fragments.registro;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.jkvillavo12dev.lcpestournaments.R;

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

    public boolean validate() {

        if ("".equalsIgnoreCase(editTextMail.getText().toString())) {
            textInputLayoutMail.setErrorEnabled(true);
            textInputLayoutMail.setError(getString(R.string.common_campoNecesario));
            return false;
        } else {
            textInputLayoutMail.setErrorEnabled(false);
            textInputLayoutMail.setError(null);
        }

        return true;
    }

}
