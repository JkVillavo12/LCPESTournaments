package com.jkvillavo12dev.lcpestournaments.fragments.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.jkvillavo12dev.lcpestournaments.R;

/**
 * Created by JkVillavo12Col on 31/08/16.
 */
public class DialogMessage extends DialogFragment {

    public static final String MENSAJE = "mensaje";
    public static final String TITULO = "titulo";

    private String mensaje, titulo;
    private TextView textViewMessage, textViewTitulo;
    private Button buttonAceptar;
    private View rootView;

    public DialogMessage() {

    }

    public interface OnDialogConfirmationActionsListener {

        public void onDialogMessage(DialogFragment dialogFragment);

    }

    OnDialogConfirmationActionsListener mListener;

    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);
        try {
            mListener = (OnDialogConfirmationActionsListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnDialogConfirmationActionsListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.dialog_message, container);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mensaje = bundle.getString(MENSAJE);
            titulo = bundle.getString(TITULO);
        }

        obtenerComponentes(rootView);
        setListeners();
        textViewMessage.setText(mensaje);
        textViewTitulo.setText(titulo);

        this.rootView = rootView;
        return rootView;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;

    }

    private void obtenerComponentes(View view) {

        textViewMessage = (TextView) view.findViewById(R.id.dialogFragmentConfirmation_textViewTexto);
        textViewTitulo = (TextView) view.findViewById(R.id.dialogFragmentConfirmation_textViewTitulo);
        buttonAceptar = (Button) view.findViewById(R.id.dialogFragmentConfirmation_buttonAceptar);
    }

    private void setListeners() {

        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dismiss();
                mListener.onDialogMessage(DialogMessage.this);
            }
        });

    }
}



