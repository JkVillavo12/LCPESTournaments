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
import com.jkvillavo12dev.lcpestournaments.utils.ActivityUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistroDocumentoFragment extends Fragment {

    private TextInputLayout textInputLayoutDocumento;
    private EditText editTextDocumento;
    private TextView textViewSpinnerError;
    private Spinner spinnerTipoDocumento;

    private static RegistroDocumentoFragment instance;

    public static RegistroDocumentoFragment getInstance() {

        if (instance == null) {
            instance = new RegistroDocumentoFragment();
        }
        return instance;
    }

    public static void destroyInstance() {
        instance = null;
    }

    public RegistroDocumentoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_registro_documento, container, false);
        textInputLayoutDocumento = (TextInputLayout) view.findViewById(R.id.registroDocumento_textInputLayoutDocumento);
        editTextDocumento = (EditText) view.findViewById(R.id.registroDocumento_editTextDocumento);
        textViewSpinnerError = (TextView) view.findViewById(R.id.registroDocumento_textViewTipoDocError);
        spinnerTipoDocumento = (Spinner) view.findViewById(R.id.registroDocumento_spinnerTipoDoc);
        return view;
    }

    public boolean validate() {

        int errores = 0;
        errores += ActivityUtils.validarSpinnerWithTextView(getContext(), spinnerTipoDocumento, textViewSpinnerError);
        errores += ActivityUtils.validarEditTextWithInputLayout(getContext(), editTextDocumento, textInputLayoutDocumento);

        if (errores > 0) {
            return false;
        }

        return true;
    }
}
