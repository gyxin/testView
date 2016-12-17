package com.tangcco.application22.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tangcco.application22.R;
import com.tangcco.application22.model.PicItem;

import butterknife.Bind;

/**
 * @author Wayne
 */
public class PicViewHolder extends BaseViewHolder<PicItem> {

    @Bind(R.id.pic_image_view)
    ImageView mImageView;

    @Bind(R.id.pic_text_view)
    TextView mTextView;

    public PicViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void onBind(int position, PicItem iItem) {
        Glide.with(itemView.getContext())
                .load(iItem.getCoverUrl())
                .into(mImageView);

        mTextView.setText(String.format("PicItem %s", position));
    }
}
