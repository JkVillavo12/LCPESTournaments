package com.jkvillavo12dev.lcpestournaments.utils;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.jkvillavo12dev.lcpestournaments.fragments.dialogs.DialogMessage;

/**
 * Created by JkVillavo12Col on 31/08/16.
 */
public class MessagesUtils {

    private static ProgressDialog progressDialog;

    /**
     * Muestra un progress dialog con el mensaje que se ha enviado como parametro
     * Creado el 31/08/16 a las 2:22 PM <br>
     *
     * @param activity actividad de donde es llamado
     * @param mensaje  mensaje a mostrar
     * @author <a href="https://plus.google.com/u/1/+JuanCarlosMart%C3%ADnezOrjuela/">JkVillavo12COL</a></br>
     */
    public static void showProgressDialog(AppCompatActivity activity, String mensaje) {

        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage(mensaje);
        progressDialog.show();

    }

    /**
     * Oculta el progress dialog que se esta mostrando
     * Creado el 31/08/16 a las 2:21 PM <br>
     *
     * @author <a href="https://plus.google.com/u/1/+JuanCarlosMart%C3%ADnezOrjuela/">JkVillavo12COL</a></br>
     */
    public static void dismissProgressDialog() {

        progressDialog.dismiss();

    }

    /**
     * Muestra un mensaje de informacion por medio de un dialogFragment
     * Creado el 31/08/16 a las 2:59 PM <br>
     *
     * @param supportFragManager fragmentMannager
     * @param titulo             titulo del mensaje
     * @param mensaje            mensaje a mostrar
     * @author <a href="https://plus.google.com/u/1/+JuanCarlosMart%C3%ADnezOrjuela/">JkVillavo12COL</a></br>
     */
    public static void showDialogMessage(FragmentManager supportFragManager, String titulo, String mensaje) {

        DialogFragment newFragment = new DialogMessage();
        Bundle args = new Bundle();
        args.putString(DialogMessage.MENSAJE, mensaje);
        args.putString(DialogMessage.TITULO, titulo);
        newFragment.setArguments(args);
        newFragment.show(supportFragManager, "dialog");

    }

}
