package minicla03.coinquylife.FEATURE.Board.UI;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.DialogFragment;
import minicla03.coinquylife.R;
import minicla03.coinquylife.Board.Model.Poll;

public class SurveyDialogFragment extends DialogFragment {

    private EditText etPollQuestion;
    private Button btnSavePoll;
    private OnPollCreatedListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout._new_survey, null);

        etPollQuestion = view.findViewById(R.id.et_poll_question);
        btnSavePoll = view.findViewById(R.id.btn_save_poll);

        btnSavePoll.setOnClickListener(v -> {
            String question = etPollQuestion.getText().toString();

            // Crea un nuovo sondaggio e invialo al listener
            if (listener != null) {
                Poll poll = new Poll(question);
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
        void onPollCreated(Poll poll);
    }
}
