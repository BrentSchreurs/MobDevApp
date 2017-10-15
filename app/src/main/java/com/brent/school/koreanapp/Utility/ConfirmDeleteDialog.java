package com.brent.school.koreanapp.Utility;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.brent.school.koreanapp.R;

/**
 * Created by Brent on 15-10-2017.
 */

public class ConfirmDeleteDialog extends DialogFragment {

    ConfirmDeleteDialogListener mListener;

    // Override the Fragment.onAttach() method to instantiate the ConfirmDeleteDialogListener

    @Override

    public void onAttach(Activity activity) {

        super.onAttach(activity);

        // Verify that the host activity implements the callback interface

        try {

            // Instantiate the ConfirmDeleteDialogListener so we can send events to the host

            mListener = (ConfirmDeleteDialogListener) activity;

        } catch (ClassCastException e) {

            // The activity doesn't implement the interface, throw exception

            throw new ClassCastException(activity.toString()

                    + " must implement ConfirmDeleteDialogListener");

        }

    }

    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        String message = getArguments().getString("message");

        String positiveButton = getArguments().getString("positiveButton");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(message)

                .setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {

                    @Override

                    public void onClick(DialogInterface dialog, int id) {

                        // Activate method onDialogPositiveClick inside implementing class

                        mListener.onDialogPositiveClick(ConfirmDeleteDialog.this);

                    }

                })
                ///TODO: Make string resource
                .setNegativeButton("Cancel" , new DialogInterface.OnClickListener() {

                    @Override

                    public void onClick(DialogInterface dialog, int id) {

                        // Activate method onDialogNegativeClick inside implementing class

                        mListener.onDialogNegativeClick(ConfirmDeleteDialog.this);

                    }

                });

        return builder.create();

    }

    public interface ConfirmDeleteDialogListener {

        void onDialogPositiveClick(DialogFragment dialog);

        void onDialogNegativeClick(DialogFragment dialog);

    }
}
