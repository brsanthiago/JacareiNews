package br.com.brsantiago.jacareinews.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

import br.com.brsantiago.jacareinews.R;
import br.com.brsantiago.jacareinews.domain.entity.Noticia;
import br.com.brsantiago.jacareinews.presenter.NoticiaPresenter;
import br.com.brsantiago.jacareinews.presenter.contract.NoticiaContract;
import br.com.brsantiago.jacareinews.ui.adapter.NoticiaAdapter;
import br.com.brsantiago.jacareinews.ui.base.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bruno.oliveira on 03/01/2017.
 */

public class NoticiaFragment extends BaseFragment implements NoticiaContract.View {
    @BindView(R.id.emptyContainer)
    LinearLayout emptyContainer;

    @BindView(R.id.loadingContainer)
    LinearLayout loadingContainer;

    @BindView(R.id.successContainer)
    LinearLayout successContainer;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    private NoticiaPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_noticia, container, false);
        ButterKnife.bind(this, view);
        setHasOptionsMenu(true);
        presenter = new NoticiaPresenter();
        presenter.setView(this);
        presenter.initialize();

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_news, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final int id = item.getItemId();

        if (id == R.id.action_filter) {
            System.out.println("Filter NOtificias");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setList(List<Noticia> items) {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        NoticiaAdapter adapter = new NoticiaAdapter(getActivity(), items);
        recyclerview.setLayoutManager(manager);
        recyclerview.setAdapter(adapter);
    }

    @Override
    public void showLoading() {
        successContainer.setVisibility(View.GONE);
        loadingContainer.setVisibility(View.VISIBLE);
        emptyContainer.setVisibility(View.GONE);
    }

    @Override
    public void showEmpty() {
        successContainer.setVisibility(View.GONE);
        loadingContainer.setVisibility(View.GONE);
        emptyContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void showList() {
        successContainer.setVisibility(View.VISIBLE);
        loadingContainer.setVisibility(View.GONE);
        emptyContainer.setVisibility(View.GONE);
    }
}
