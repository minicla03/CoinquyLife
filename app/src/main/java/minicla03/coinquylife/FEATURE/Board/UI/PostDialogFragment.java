package minicla03.coinquylife.FEATURE.Board.UI;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import androidx.fragment.app.DialogFragment;

import minicla03.coinquylife.R;

public class PostDialogFragment extends DialogFragment {

    private EditText etPostTitle, etPostContent;
    private Button btnSavePost;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout._new_post, null);

        etPostTitle = view.findViewById(R.id.et_post_title);
        etPostContent = view.findViewById(R.id.et_post_content);
        btnSavePost = view.findViewById(R.id.btn_save_post);

        btnSavePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logica per salvare il post
                String title = etPostTitle.getText().toString();
                String content = etPostContent.getText().toString();

                // TODO: Aggiungi logica per salvare il post nei dati o nel database

                dismiss();
            }
        });

        return new android.app.AlertDialog.Builder(getActivity())
                .setView(view)
                .create();
    }

    public void setOnPostCreatedListener(OnPostCreatedListener listener) {
        this.listener = listener;
    }

    public interface OnPostCreatedListener {
        void onPostCreated(Post post);
    }
}
