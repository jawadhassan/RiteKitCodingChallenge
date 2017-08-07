package com.example.hamid_pc.ritekitcodingchallenge;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class InfluencerAdapter extends RecyclerView.Adapter<InfluencerAdapter.ViewHolder> {
    private List<Influencer> mInfluencers;
    private Context mContext;
    private InfluencerItemListener mItemListener;

    public InfluencerAdapter(Context context, List<Influencer> influencers, InfluencerItemListener itemListener) {
        mInfluencers = influencers;
        mContext = context;
        mItemListener = itemListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.list_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(postView, this.mItemListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Influencer influencer = mInfluencers.get(position);
        TextView textView = holder.mTitleTagName;
        textView.setText(influencer.getUsername());
    }

    @Override
    public int getItemCount() {
        return mInfluencers.size();
    }

    public void updateHashTag(List<Influencer> influencers) {
        mInfluencers = influencers;
        notifyDataSetChanged();
    }

    private Influencer getItem(int adapterPosition) {
        return mInfluencers.get(adapterPosition);
    }

    public interface InfluencerItemListener {
        void onPostClick(String username);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mTitleTagName;
        public TextView mTitleTagExposure;
        InfluencerItemListener mItemListener;

        public ViewHolder(View itemView, InfluencerItemListener influencerItemListener) {
            super(itemView);
            mTitleTagName = (TextView) itemView.findViewById(R.id.text_view_tag_name);

            this.mItemListener = influencerItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Influencer influencer = getItem(getAdapterPosition());
            this.mItemListener.onPostClick(influencer.getUsername());
            notifyDataSetChanged();
        }
    }

}
