package com.example.yrung.mystickydemo;

/**
 * Created by yrung on 2017/12/20.
 */

public interface MultiItemTypeSupport<T> {

    int getLayoutId(int itemType);

    int getItemViewType(int position, T t);
}
