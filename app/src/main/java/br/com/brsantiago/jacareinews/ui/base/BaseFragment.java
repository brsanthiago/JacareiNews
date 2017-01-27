package br.com.brsantiago.jacareinews.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;

import br.com.brsantiago.jacareinews.R;
import br.com.brsantiago.jacareinews.presenter.contract.MainContract;

/**
 * Created by bruno.oliveira on 04/01/2017.
 */

public class BaseFragment extends Fragment {
    private MainContract.View mainView;
    CoordinatorLayout.Behavior behavior;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainContract.View) {
            mainView = (MainContract.View) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " Deve implementar MainContract.View");
        }

       /* if(behavior != null)
            return;

        FrameLayout layout =(FrameLayout) getActivity().findViewById(R.id.frame_fragment_containers);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) layout.getLayoutParams();

        behavior = params.getBehavior();
        params.setBehavior(null);*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainView = null;
        if(behavior == null)
            return;
/*
        FrameLayout layout =(FrameLayout) getActivity().findViewById(R.id.frame_fragment_containers);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) layout.getLayoutParams();

        params.setBehavior(behavior);

        layout.setLayoutParams(params);

        behavior = null;*/
    }

    @Override
    public void onResume() {
        super.onResume();
        mainView.doSomethingImportant();
    }

}
