package minicla03.coinquylife.FEATURE.Board.UI;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.DialogFragment;
import minicla03.coinquylife.R;
import minicla03.coinquylife.DATALAYER.database.entity.Survey;

public class SurveyDialogFragment extends DialogFragment {

    private EditText etPollQuestion;
    private Button btnSavePoll;
    private OnPollCreatedListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout._new_survey, null);

        etPollQuestion = view.findViewById(R.id.et_poll_domanda);
        btnSavePoll = view.findViewById(R.id.btn_save_poll);

        btnSavePoll.setOnClickListener(v -> {
            String question = etPollQuestion.getText().toString();

            // Crea un nuovo sondaggio e invialo al listener
            if (listener != null) {
                Survey poll = new Survey();
                listener.onPollCreated(poll);
            }

            dismiss();
        });

        return new android.app.AlertDialog.Builder(getActivity())
                .setView(view)
                .create();
    }

    public void setOnPollCreatedListener(OnPollCreatedListener listener) {
        this.listener = listener;
    }

    public interface OnPollCreatedListener {
        void onPollCreated(Survey poll);
    }
}
