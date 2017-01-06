package br.com.brsantiago.jacareinews.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

import br.com.brsantiago.jacareinews.R;
import br.com.brsantiago.jacareinews.domain.entity.Noticia;
import br.com.brsantiago.jacareinews.presenter.FavoritoPresenter;
import br.com.brsantiago.jacareinews.presenter.contract.FavoritoContract;
import br.com.brsantiago.jacareinews.ui.adapter.NoticiaAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bruno.oliveira on 03/01/2017.
 */

public class FavoritoFragment extends Fragment implements FavoritoContract.View {


    @BindView(R.id.emptyContainer)
    LinearLayout emptyContainer;

    @BindView(R.id.successContainer)
    LinearLayout successContainer;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    private FavoritoPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorito, container, false);
        ButterKnife.bind(this, view);
        presenter = new FavoritoPresenter();
        presenter.setView(this);
        presenter.initialize();

        return view;
    }

    @Override
    public void showList(List<Noticia> items) {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        NoticiaAdapter adapter = new NoticiaAdapter(getActivity(), items);
        recyclerview.setLayoutManager(manager);
        recyclerview.setAdapter(adapter);
    }

    @Override
    public void showEmpty() {
        successContainer.setVisibility(View.GONE);
        emptyContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void showView() {
        successContainer.setVisibility(View.VISIBLE);
        emptyContainer.setVisibility(View.GONE);
    }
}
