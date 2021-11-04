package com.example.zhihu.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.zhihu.R;

import java.util.List;

public class contentAdapter extends RecyclerView.Adapter<contentAdapter.ViewHolder>{

    private List<Content> list;

    static class ViewHolder extends RecyclerView.ViewHolder{

        View contentview;
        TextView title;
        ImageView profile;
        TextView name;
        ImageView authentication;
        TextView information;
        ImageView picture;
        TextView comment;
        ImageView setting;

        public ViewHolder(View view){
            super(view);
            contentview=view;
            title = view.findViewById(R.id.content_title);
            profile = view.findViewById(R.id.content_profile);
            name = view.findViewById(R.id.content_name);
            authentication = view.findViewById(R.id.content_authentication);
            information = view.findViewById(R.id.content_picture);
            picture = view.findViewById(R.id.content_picture);
            comment = view.findViewById(R.id.content_comment);
            setting = view.findViewById(R.id.content_setting);
        }
    }
    public contentAdapter(List<Content> list){
        this.list=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_content_item,parent,false);
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
        holder.picture.setImageResource(content.getPicture());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
