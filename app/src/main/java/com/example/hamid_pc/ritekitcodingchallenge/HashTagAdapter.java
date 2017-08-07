package com.example.hamid_pc.ritekitcodingchallenge;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class HashTagAdapter extends RecyclerView.Adapter<HashTagAdapter.ViewHolder> {

    private List<Tag> mTags;
    private Context mContext;
    private TagItemListener mItemListener;

    public HashTagAdapter(Context context, List<Tag> tags, TagItemListener itemListener) {
        mTags = tags;
        mContext = context;
        mItemListener = itemListener;
    }

    @Override
    public HashTagAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.list_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(postView, this.mItemListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HashTagAdapter.ViewHolder holder, int position) {

        Tag tag = mTags.get(position);
        TextView textView = holder.mTitleTagName;
        textView.setText(tag.getTag());
    }

    @Override
    public int getItemCount() {
        return mTags.size();
    }

    public void updateHashTag(List<Tag> tags) {
        mTags = tags;
        notifyDataSetChanged();
    }

    private Tag getItem(int adapterPosition) {
        return mTags.get(adapterPosition);
    }

    public interface TagItemListener {
        void onPostClick(long id);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mTitleTagName;
        public TextView mTitleTagExposure;
        TagItemListener mItemListener;

        public ViewHolder(View itemView, TagItemListener tagItemListener) {
            super(itemView);
            mTitleTagName = (TextView) itemView.findViewById(R.id.text_view_tag_name);

            this.mItemListener = tagItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Tag tag = getItem(getAdapterPosition());
            this.mItemListener.onPostClick(tag.getExposure());
            notifyDataSetChanged();
        }
    }
}
