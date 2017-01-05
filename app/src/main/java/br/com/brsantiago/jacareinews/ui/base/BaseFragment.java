package br.com.brsantiago.jacareinews.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by bruno.oliveira on 04/01/2017.
 */

public class BaseFragment extends Fragment {


    public static BaseFragment newInstance(int index) {
        BaseFragment fragment = new BaseFragment();
        Bundle b = new Bundle();
        b.putInt("index", index);
        fragment.setArguments(b);
        return fragment;
    }

}
