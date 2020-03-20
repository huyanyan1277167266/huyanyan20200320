package com.bw.huyanyan.activit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/*
 *@Auther:cln
 *@Date: 2020/3/20
 *@Time:13:55
 *@Description:
 * */public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), getLayoutId(), null);
        initView(view);
        getData();
        return view;
    }
    protected abstract int getLayoutId();
    protected abstract void initView(View view);
    protected abstract void getData();

}
