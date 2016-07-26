package com.example.islam.mttproject.weather.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.islam.mttproject.R;
import com.example.islam.mttproject.common.Constants;

/**
 * Created by islam on 7/25/16.
 */
public class AddingCityDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        EditText editText = (EditText) getActivity().getLayoutInflater().inflate(R.layout.fragment_add_city, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getResources().getString(R.string.cities_dialog_Title));
        builder.setMessage(getResources().getString(R.string.cities_dialog_message));
        builder.setView(editText);
        builder.setPositiveButton(getResources().getString(R.string.cities_dialog_submit_button), (dialog, which) -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra(Constants.NEW_CITY,editText.getText().toString());
            getTargetFragment().onActivityResult(getTargetRequestCode(),getActivity().RESULT_OK, resultIntent);
        });

        return builder.create();
    }
}
