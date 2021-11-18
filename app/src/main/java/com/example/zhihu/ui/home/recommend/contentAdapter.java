package com.example.zhihu.ui.home.recommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zhihu.R;

import java.util.List;

public class contentAdapter extends RecyclerView.Adapter<contentAdapter.ViewHolder>{

    private List<Content> list;

    static class ViewHolder extends RecyclerView.ViewHolder {

        View contentview;
        TextView title;
        ImageView profile;
        TextView name;
        TextView text;
        ImageView authentication;
        TextView information;
        ImageView picture;
        TextView comment;
        ImageView setting;

        public ViewHolder(View view) {
            super(view);
            contentview=view;
            title = view.findViewById(R.id.content_title);
            profile = view.findViewById(R.id.content_profile);
            name = view.findViewById(R.id.content_name);
            authentication = view.findViewById(R.id.content_authentication);
            information = view.findViewById(R.id.content_information);
            picture = view.findViewById(R.id.content_picture);
            comment = view.findViewById(R.id.content_comment);
            text = view.findViewById(R.id.content_text);
            setting = view.findViewById(R.id.content_setting);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
    }
    public contentAdapter(FragmentActivity activity, List<Content> list){
        this.list=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recommend_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.contentview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position= holder.getAdapterPosition();
                Content content=list.get(position);
                Toast.makeText(view.getContext(), "you clicked View" + content.getName(), Toast.LENGTH_SHORT).show();            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(contentAdapter.ViewHolder holder, int position) {
        Content content = list.get(position);
        holder.title.setText(content.getTitle());
        holder.profile.setImageResource(content.getProfile());
        holder.name.setText(content.getName());
        holder.authentication.setImageResource(content.getAuthentication());
        holder.information.setText(content.getInformation());
        holder.text.setText(content.getText());
        holder.picture.setImageResource(content.getPicture());
        holder.comment.setText(content.getComment());
        holder.setting.setImageResource(content.getSetting());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
