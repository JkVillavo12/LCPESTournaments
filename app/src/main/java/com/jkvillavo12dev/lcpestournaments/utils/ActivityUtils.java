package com.jkvillavo12dev.lcpestournaments.utils;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.view.WindowManager;
import android.widget.EditText;

import com.jkvillavo12dev.lcpestournaments.R;


/**
 * Created by JkVillavo12Col on 31/08/16.
 */
public class ActivityUtils {

    /**
     * Esconde el teclado
     * Creado el 1/09/16 a las 11:20 AM <br>
     *
     * @param activity actividad que hace llamado del método
     * @author <a href="https://plus.google.com/u/1/+JuanCarlosMart%C3%ADnezOrjuela/">JkVillavo12COL</a></br>
     */
    public static void esconderTeclado(Activity activity) {

        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }


    /**
     * Valida que haya informacion en el edittext de un textInputLayout <br>
     * pinta el campo si hace falta informacion
     * Creado el 31/08/º16 a las 2:11 PM <br>
     *
     * @param applicationContext contexto de la actividad
     * @param editText           editText perteneciente al textinputLayout
     * @param textInputLayout    textInputLayout
     * @return 0 si no hay errores, 1 si falta la info
     * @author <a href="https://plus.google.com/u/1/+JuanCarlosMart%C3%ADnezOrjuela/">JkVillavo12COL</a></br>
     */
    public static int validarEditTextWithInputLayout(Context applicationContext, EditText editText, TextInputLayout textInputLayout) {

        if ("".equalsIgnoreCase(editText.getText().toString().trim())) {
            textInputLayout.setErrorEnabled(true);
            textInputLayout.setError(applicationContext.getString(R.string.msg_campoObligatorio));
            return 1;
        } else {
            textInputLayout.setErrorEnabled(false);
            editText.setError(null);
        }
        return 0;
    }

}
