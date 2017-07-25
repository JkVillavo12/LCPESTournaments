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
public class RegistroPasswordFragment extends Fragment {

    private TextInputLayout textInputLayoutPassword1, textInputLayoutPassword2;
    private EditText editTextPassword1, editTextPassword2;

    private static RegistroPasswordFragment instance;

    public static RegistroPasswordFragment getInstance() {

        if (instance == null) {
            instance = new RegistroPasswordFragment();
        }
        return instance;
    }

    public static void destroyInstance() {
        instance = null;
    }


    public RegistroPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_registro_password, container, false);

        textInputLayoutPassword1 = (TextInputLayout) view.findViewById(R.id.registroPassword_textInputLayoutPassword1);
        textInputLayoutPassword2 = (TextInputLayout) view.findViewById(R.id.registroPassword_textInputLayoutPassword2);
        editTextPassword1 = (EditText) view.findViewById(R.id.registroPassword_editTextPassword1);
        editTextPassword2 = (EditText) view.findViewById(R.id.registroPassword_editTextPassword2);

        return view;
    }

    public boolean validate() {

        int errores = 0;

        errores += ActivityUtils.validarEditTextWithInputLayout(getContext(), editTextPassword1, textInputLayoutPassword1);
        errores += ActivityUtils.validarEditTextWithInputLayout(getContext(), editTextPassword2, textInputLayoutPassword2);

        if (errores == 0) {
            errores += ActivityUtils.isValidPasswordRules(getContext(), editTextPassword1, textInputLayoutPassword1);
            errores += ActivityUtils.isValidPasswordRules(getContext(), editTextPassword2, textInputLayoutPassword2);
        }

        if (errores == 0) {
            if (editTextPassword1.getText().toString().equalsIgnoreCase(editTextPassword2.getText().toString())) {
                textInputLayoutPassword1.setErrorEnabled(false);
                textInputLayoutPassword2.setErrorEnabled(false);
                textInputLayoutPassword1.setError(null);
                textInputLayoutPassword2.setError(null);
            } else {
                textInputLayoutPassword1.setErrorEnabled(true);
                textInputLayoutPassword1.setError(getString(R.string.registroPassword_errorDistintos));
                textInputLayoutPassword2.setErrorEnabled(true);
                textInputLayoutPassword2.setError(getString(R.string.registroPassword_errorDistintos));
            }
        }

        if (errores > 0) {
            return false;
        }

        return true;
    }
}
