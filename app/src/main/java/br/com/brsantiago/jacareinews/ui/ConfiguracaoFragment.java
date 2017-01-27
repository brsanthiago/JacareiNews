package br.com.brsantiago.jacareinews.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.brsantiago.jacareinews.R;
import br.com.brsantiago.jacareinews.ui.base.BaseFragment;
import butterknife.ButterKnife;

/**
 * Created by bruno.oliveira on 03/01/2017.
 */

public class ConfiguracaoFragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_configuracao, container, false);
        ButterKnife.bind(this, view);
        setHasOptionsMenu(false);
        return view;
    }
}
