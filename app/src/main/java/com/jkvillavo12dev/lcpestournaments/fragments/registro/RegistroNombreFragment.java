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

    public static void destroyInstance() {
        instance = null;
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

        errores += ActivityUtils.validarEditTextWithInputLayout(getContext(), editTextNombres, textInputLayoutNombres);
        errores += ActivityUtils.validarEditTextWithInputLayout(getContext(), editTextApellidos, textInputLayoutApellidos);

        if (errores > 0) return false;
        return true;
    }
}
