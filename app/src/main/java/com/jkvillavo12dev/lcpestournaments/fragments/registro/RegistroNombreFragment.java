package com.jkvillavo12dev.lcpestournaments.fragments.registro;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.jkvillavo12dev.lcpestournaments.R;
import com.jkvillavo12dev.lcpestournaments.fragments.onboarding.InicialPage1Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistroNombreFragment extends Fragment {

    private TextInputLayout textInputLayoutNombres, textInputLayoutApellidos;
    private EditText editTextNombres, editTextApellidos;

    private static RegistroNombreFragment instance;

    public static RegistroNombreFragment getInstance() {

        if (instance == null) {
            instance = new RegistroNombreFragment();
        }
        return instance;
    }


    public RegistroNombreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_registro_nombre, container, false);

        textInputLayoutNombres = (TextInputLayout) view.findViewById(R.id.registroNombre_textInputLayoutNombres);
        textInputLayoutApellidos = (TextInputLayout) view.findViewById(R.id.registroNombre_textInputLayoutApellidos);
        editTextNombres = (EditText) view.findViewById(R.id.registroNombre_editTextNombres);
        editTextApellidos = (EditText) view.findViewById(R.id.registroNombre_editTextApellidos);

        return view;

    }

    public boolean validate() {

        int errores = 0;

        if ("".equalsIgnoreCase(editTextNombres.getText().toString())) {
            errores++;
            textInputLayoutNombres.setErrorEnabled(true);
            textInputLayoutNombres.setError(getString(R.string.common_campoNecesario));
        } else {
            textInputLayoutNombres.setErrorEnabled(false);
            textInputLayoutNombres.setError(null);
        }

        if ("".equalsIgnoreCase(editTextApellidos.getText().toString())) {
            errores++;
            textInputLayoutApellidos.setErrorEnabled(true);
            textInputLayoutApellidos.setError(getString(R.string.common_campoNecesario));
        } else {
            textInputLayoutApellidos.setErrorEnabled(false);
            textInputLayoutApellidos.setError(null);
        }

        if (errores > 0) return false;
        return true;
    }
}
