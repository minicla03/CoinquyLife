package minicla03.coinquylife.FEATURE.Board.UI;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import minicla03.coinquylife.R;

public class BoardActivity extends AppCompatActivity {

    private RecyclerView rvBoard;
    private Button btnNewPost, btnPoll;
    private BoardAdapter boardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_board);

        rvBoard = findViewById(R.id.rv_board);
        btnNewPost = findViewById(R.id.btn_new_post);
        btnPoll = findViewById(R.id.btn_poll);

        boardAdapter = new BoardAdapter(null);
        rvBoard.setLayoutManager(new LinearLayoutManager(this));
        rvBoard.setAdapter(boardAdapter);

        btnNewPost.setOnClickListener(v -> {
            PostDialogFragment postDialog = new PostDialogFragment();
            postDialog.show(getSupportFragmentManager(), "POST_DIALOG");

        });

        btnPoll.setOnClickListener(v -> {
            SurveyDialogFragment sureyDialog = new SurveyDialogFragment();
            sureyDialog.show(getSupportFragmentManager(), "POLL_DIALOG");
        });
    }
}
