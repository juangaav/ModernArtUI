package course.labs.modernartui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Juan Villafane on 3/23/2015.
 */
public class DialogClass {

    static Context context;
    private static final String TAG = "Dialog";

    DialogClass(Context context){

        this.context = context;

    }

    // Show desired Dialog
    void showDialogFragment() {

        DialogFragment mDialog;

        // Create a new AlertDialogFragment
        mDialog = AlertDialogFragment.newInstance();

        try{

            // Show AlertDialogFragment
            mDialog.show(returnActivityReference().getFragmentManager(), "ModernArtUI");

            // Return the fragment manager

            // If using the Support lib.
            // return activity.getSupportFragmentManager();

        } catch (ClassCastException e) {
            Log.d(TAG, "Can't get the fragment manager with this");
        }
    }

    // Class that creates the AlertDialog
    public static class AlertDialogFragment extends DialogFragment {

        public static AlertDialogFragment newInstance() {
            return new AlertDialogFragment();
        }

        // Build AlertDialog using AlertDialog.Builder
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return new AlertDialog.Builder(getActivity())
                    .setMessage(returnActivityReference().getResources().getText(R.string.dialog_text).toString())

                            // User cannot dismiss dialog by hitting back button
                    .setCancelable(false)

                            // Set up No Button
                    .setNegativeButton(returnActivityReference().getResources().getText(R.string.dismiss_dialog_text).toString(),
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {

                                    //User dismisses dialog

                                }
                            })

                            // Set up Yes Button
                    .setPositiveButton(returnActivityReference().getResources().getText(R.string.visit_moma).toString(),
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        final DialogInterface dialog, int id) {

                                    visitMOMA();

                                }
                            }).create();
        }
    }

    private static void visitMOMA(){
        String moma_url = returnActivityReference().getResources().getText(R.string.moma_url).toString();
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(moma_url));
        returnActivityReference().startActivity(browserIntent);
    }

    private static Activity returnActivityReference(){
        final Activity activity = (Activity) context;
        return activity;
    }

}
