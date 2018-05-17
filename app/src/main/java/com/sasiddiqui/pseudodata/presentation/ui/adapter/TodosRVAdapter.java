package com.sasiddiqui.pseudodata.presentation.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sasiddiqui.pseudodata.R;
import com.sasiddiqui.pseudodata.network.model.Todo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shahrukhamd on 17/05/18.
 */
public class TodosRVAdapter extends RecyclerView.Adapter<TodosRVAdapter.ViewHolder> {

    private List<Todo> todoList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.todo_list_item_icon)
        ImageView todoIcon;
        @BindView(R.id.todo_list_item_title)
        TextView todoText;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bindData(Todo todo) {
            todoText.setText(todo.getTitle());

            if (todo.isCompleted()) {
                todoIcon.setImageResource(R.drawable.ic_check_white_48px);
                todoIcon.setBackgroundResource(R.color.green);
            } else {
                todoIcon.setImageResource(R.drawable.ic_clear_white_48px);
                todoIcon.setBackgroundResource(R.color.red);
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_todo_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(todoList.get(position));
    }

    @Override
    public int getItemCount() {
        return todoList == null ? 0 : todoList.size();
    }

    public void updateList(List<Todo> todoList) {
        this.todoList = todoList;
        notifyDataSetChanged();
    }
}
