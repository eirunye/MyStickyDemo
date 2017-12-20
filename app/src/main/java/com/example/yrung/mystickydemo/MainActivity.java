package com.example.yrung.mystickydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        SectionSupport<String> sectionSupport = new SectionSupport<String>() {
            @Override
            public int sectionHeaderLayoutId() {
                // TODO: 2017/12/20 修改头布局
                return R.layout.header;//头布局
            }

            @Override
            public int sectionTitleTextViewId() {
                // TODO: 2017/12/20 修改id
                return R.id.id_header_title; //title Id
            }

            /**
             * TODO: 2017/12/20 显示数据
             *
             * @param s
             * @return
             */
            @Override
            public String getTitle(String s) {
                return s.substring(0, 1);//直接显示时间
            }
        };

        /**
         *
         * R.layout.item_list item 布局
         *
         */
        mRecyclerView.setAdapter(new SectionAdapter<String>(this, R.layout.item_list, getDummyDataSet(), sectionSupport) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                holder.setText(R.id.id_item_list_title, s);
            }
        });
    }

    /**
     * 获取数据源
     *
     * @return
     */
    private List<String> getDummyDataSet() {
        return Arrays.asList(getResources().getStringArray(R.array.animals));
    }
}
