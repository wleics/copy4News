package zwc.com.cloverstudio.zwc.controller;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zwc.com.cloverstudio.zwc.R;
import zwc.com.cloverstudio.zwc.databinding.LayoutNewsListBinding;
import zwc.com.cloverstudio.zwc.databinding.LayoutNewsRowDefBinding;

/**
 * 新闻列表fragment
 * Created by wlei on 2018/1/18.
 */

public class NewsListFragment extends Fragment {

    /**
     * 获取实例
     *
     * @return
     */
    public static NewsListFragment newInstance() {

        NewsListFragment fragment = new NewsListFragment();

        //初始化参数设置
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        //获取根目录
        LayoutNewsListBinding binding = DataBindingUtil.inflate(inflater, R.layout.layout_news_list,
                                                                container, false
                                                               );
        binding.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.mRecyclerView.setAdapter(new NewsItemAdapter());
        return binding.getRoot();
    }

    //创建viewHolder

    private class NewsItemHolder extends RecyclerView.ViewHolder {

        public NewsItemHolder(View itemView) {
            super(itemView);
        }
    }

    /**
     * 默认的新闻项展现样式
     */
    private class DefNewsItem extends NewsItemHolder {

        public DefNewsItem(View itemView) {
            super(itemView);
        }
    }

    //创建适配器

    private class NewsItemAdapter extends RecyclerView.Adapter<NewsItemHolder> {

        @Override
        public NewsItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            LayoutNewsRowDefBinding layoutNewsRowDefBinding = DataBindingUtil.inflate(
                    layoutInflater, R.layout.layout_news_row_def, parent, false);
            return new DefNewsItem(layoutNewsRowDefBinding.getRoot());
        }

        @Override
        public void onBindViewHolder(NewsItemHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }
}
