package minicla03.coinquylife.Board.UI;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import minicla03.coinquylife.DATALAYER.local.entity.Note;

import java.util.List;

public class BoardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    private static final int TYPE_POST = 0;
    private static final int TYPE_POLL = 1;

    private List<Note> boardItems;

    @Override
    public int getItemViewType(int position) {
        if (boardItems.get(position) instanceof Note) {
            return TYPE_POST;
        } else {
            return TYPE_POLL;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        /**if (viewType == TYPE_POST) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
            return new PostViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_poll, parent, false);
            return new PollViewHolder(view);
        }**/
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof PostViewHolder) {
            ((PostViewHolder) holder).bind((Note) boardItems.get(position));
        } else {
            //((PollViewHolder) holder).bind((Survey) boardItems.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return boardItems.size();
    }


    public static class PostViewHolder extends RecyclerView.ViewHolder {
        TextView tvPostTitle, tvPostContent;

        public PostViewHolder(View itemView) {
            super(itemView);
            //tvPostTitle = itemView.findViewById(R.id.tv_post_title);
            //tvPostContent = itemView.findViewById(R.id.tv_post_content);
        }

        public void bind(Note post) {

        }
    }

    // ViewHolder per i Poll
    public static class PollViewHolder extends RecyclerView.ViewHolder {
        TextView tvPollQuestion;

        public PollViewHolder(View itemView) {
            super(itemView);
            //tvPollQuestion = itemView.findViewById(R.id.tv_poll_question);
        }
        //public void bind(Poll poll) {
            //tvPollQuestion.setText(poll.getQuestion());
        }
}
