package com.example.yrung.mystickydemo;

/**
 * Created by yrung on 2017/12/20.
 */

public interface SectionSupport<T>
{
    public int sectionHeaderLayoutId();

    public int sectionTitleTextViewId();

    public String getTitle(T t);
}
