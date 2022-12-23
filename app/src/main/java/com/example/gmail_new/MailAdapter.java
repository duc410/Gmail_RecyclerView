package com.example.gmail_new;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class MailAdapter extends RecyclerView.Adapter<MailViewHolder> {

    private List<EmailData> mEmailData;
    private Context mContext;

    public MailAdapter(Context mContext, List<EmailData> mEmailData) {
        this.mEmailData = mEmailData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_mail_item,
                parent, false);
        return new MailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MailViewHolder holder, int position) {
        holder.mIcon.setText(mEmailData.get(position).getmSender().substring(0, 1));
        holder.mSender.setText(mEmailData.get(position).getmSender());
        holder.mEmailTitle.setText(mEmailData.get(position).getmTitle());
        holder.mEmailDetails.setText(mEmailData.get(position).getmDetails());
        holder.mEmailTime.setText(mEmailData.get(position).getmTime());

        Random mRandom = new Random();
        int color = Color.argb(255, mRandom.nextInt(256), mRandom.nextInt(256), mRandom.nextInt(256));
        ((GradientDrawable) holder.mIcon.getBackground()).setColor(color);
        holder.mFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.mFavorite.getColorFilter() != null) {
                    holder.mFavorite.clearColorFilter();
                } else {
                    holder.mFavorite.setColorFilter(ContextCompat.getColor(mContext,
                            R.color.colorOrange));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mEmailData.size();
    }
}

class MailViewHolder extends RecyclerView.ViewHolder {

    TextView mIcon;
    TextView mSender;
    TextView mEmailTitle;
    TextView mEmailDetails;
    TextView mEmailTime;
    ImageView mFavorite;

    MailViewHolder(View itemView) {
        super(itemView);

        mIcon = itemView.findViewById(R.id.tvIcon);
        mSender = itemView.findViewById(R.id.tvEmailSender);
        mEmailTitle = itemView.findViewById(R.id.tvEmailTitle);
        mEmailDetails = itemView.findViewById(R.id.tvEmailDetails);
        mEmailTime = itemView.findViewById(R.id.tvEmailTime);
        mFavorite = itemView.findViewById(R.id.ivFavorite);
    }
}
