package com.tangcco.application22;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tangcco.application22.holder.BaseViewHolder;
import com.tangcco.application22.holder.VideoViewHolder;
import com.tangcco.application22.holder.ViewHolderFactory;
import com.tangcco.application22.model.BaseItem;
import com.tangcco.application22.util.ItemUtils;
import com.waynell.videolist.visibility.calculator.SingleListViewItemActiveCalculator;
import com.waynell.videolist.visibility.items.ListItem;
import com.waynell.videolist.visibility.scroll.ItemsProvider;
import com.waynell.videolist.visibility.scroll.RecyclerViewItemPositionGetter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Recyview extends AppCompatActivity {
    @Bind(R.id.recyview)
    RecyclerView mRecyclerView;
    private int mScrollState;

    private SingleListViewItemActiveCalculator mCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyview);
        ButterKnife.bind(this);
        final MyAdapter adapter = new MyAdapter();
        final LinearLayoutManager manager = new LinearLayoutManager(this);
        mCalculator = new SingleListViewItemActiveCalculator(adapter,
                new RecyclerViewItemPositionGetter(manager, mRecyclerView));
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                mCalculator.onScrolled(mScrollState);
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                mScrollState = newState;
                if (newState == RecyclerView.SCROLL_STATE_IDLE && adapter.getItemCount() > 0)
                    mCalculator.onScrollStateIdle();
            }
        });
    }

    private class MyAdapter extends RecyclerView.Adapter<BaseViewHolder<? extends BaseItem>>
            implements ItemsProvider {
        private List<? extends BaseItem> items;

        public MyAdapter() {
            this.items = ItemUtils.generateMockData();
        }

        @Override
        public BaseViewHolder<? extends BaseItem> onCreateViewHolder(ViewGroup parent, int viewType) {
            return ViewHolderFactory.buildViewHolder(parent, viewType);
        }

        @Override
        public void onBindViewHolder(BaseViewHolder holder, int position) {
            BaseItem baseItem = items.get(position);
            holder.onBind(position, baseItem);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        @Override
        public int getItemViewType(int position) {
            return items.get(position).getViewType();
        }

        @Override
        public ListItem getListItem(int position) {
            RecyclerView.ViewHolder holder = mRecyclerView.
                    findViewHolderForAdapterPosition(position);
            if (holder instanceof ListItem) {
                Log.i("dhdhhd", "jdjddj");
                return (ListItem) holder;
            }
            return null;
        }

        @Override
        public int listItemSize() {
            return getItemCount();
        }
    }
}
