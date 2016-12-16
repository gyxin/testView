package com.tangcco.application22.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tangcco.application22.R;

/**
 * Created by gdd on 2016/12/15.
 */
public class UserFragment extends Fragment {
    private View view;
    private Context context;

    public UserFragment() {
    }

    public UserFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_user_fragment, container, false);
        return view;
    }
}
