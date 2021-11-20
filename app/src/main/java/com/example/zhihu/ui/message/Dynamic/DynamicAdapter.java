package com.example.zhihu.ui.message.Dynamic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zhihu.R;
import com.example.zhihu.ui.home.recommend.Content;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DynamicAdapter extends RecyclerView.Adapter<DynamicAdapter.ViewHolder>{

    private List<Dynamic_context> list;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View dynamic;
        ImageView profile;
        TextView name;
        TextView state;
        TextView contextt;
        TextView information;
        ImageView picture;

        public ViewHolder(View view){
            super(view);
            dynamic=view;
            profile=view.findViewById(R.id.dynamic_profile);
            name=view.findViewById(R.id.dynamic_name);
            state=view.findViewById(R.id.dynamic_state);
            contextt=view.findViewById(R.id.dynamic_card_context);
            information=view.findViewById(R.id.dynamic_card_information);
            picture=view.findViewById(R.id.dynamic_card_picture);
        }
    }
    public DynamicAdapter(FragmentActivity activity, List<Dynamic_context> list){this.list=list;}
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_dynamic_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.contextt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position= holder.getAdapterPosition();
                Dynamic_context context=list.get(position);
                Toast.makeText(view.getContext(), "you clicked View" + context.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(DynamicAdapter.ViewHolder holder, int position) {
        Dynamic_context dynamic_context=list.get(position);
        holder.profile.setImageResource(dynamic_context.getProfile());
        holder.name.setText(dynamic_context.getName());
        holder.state.setText(dynamic_context.getState());
        holder.information.setText(dynamic_context.getInformation());
        holder.contextt.setText(dynamic_context.getContext());
        holder.picture.setImageResource(dynamic_context.getPicture());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
