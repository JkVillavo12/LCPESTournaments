package com.jkvillavo12dev.lcpestournaments.utils;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.jkvillavo12dev.lcpestournaments.R;

public class ActivityUtils {

    public static void esconderTeclado(Activity activity) {

        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    public static int validarEditTextWithInputLayout(Context applicationContext, EditText editText, TextInputLayout textInputLayout) {

        if ("".equalsIgnoreCase(editText.getText().toString().trim())) {
            textInputLayout.setErrorEnabled(true);
            textInputLayout.setError(applicationContext.getString(R.string.common_campoNecesario));
            return 1;
        } else {
            textInputLayout.setErrorEnabled(false);
            editText.setError(null);
        }
        return 0;
    }

    public static int validarSpinnerWithTextView(Context context, Spinner spinner, TextView textView) {

        if (spinner.getSelectedItemPosition() == 0) {
            textView.setVisibility(View.VISIBLE);
            textView.setText(context.getString(R.string.common_campoNecesario));
            return 1;
        }

        textView.setVisibility(View.GONE);
        return 0;
    }

    public static int isValidEmail(Context context, EditText target, TextInputLayout textInputLayoutMail) {

        if (!TextUtils.isEmpty(target.getText().toString()) &&
                !android.util.Patterns.EMAIL_ADDRESS.matcher(target.getText().toString()).matches()) {
            textInputLayoutMail.setErrorEnabled(true);
            textInputLayoutMail.setError(context.getString(R.string.common_correoNoValido));
            return 1;
        }

        textInputLayoutMail.setErrorEnabled(false);
        textInputLayoutMail.setError(null);
        return 0;
    }

    public static int isValidPasswordRules(Context context, EditText editTextPassword1, TextInputLayout textInputLayoutPassword1) {

        if (editTextPassword1.getText().toString().length() < 6) {
            textInputLayoutPassword1.setErrorEnabled(true);
            textInputLayoutPassword1.setError(context.getString(R.string.common_passwordNoValido));
            return 1;
        }
        textInputLayoutPassword1.setErrorEnabled(false);
        textInputLayoutPassword1.setError(null);
        return 0;
    }
}
