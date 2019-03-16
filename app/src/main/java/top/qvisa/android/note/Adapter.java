package top.qvisa.android.note;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final Context mContext;

    private List<Note> mList;


    public Adapter(Context context, List<Note> noteList) {
        mContext = context;
        mList = noteList;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_note, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Note note = mList.get(i);
        viewHolder.mTv_item_title.setText(note.getTitle());
        viewHolder.mTv_item_content.setText(note.getTitle());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTv_item_title;
        TextView mTv_item_content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

}
