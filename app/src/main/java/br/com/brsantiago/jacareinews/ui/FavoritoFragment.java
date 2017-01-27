package br.com.brsantiago.jacareinews.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
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
import br.com.brsantiago.jacareinews.presenter.FavoritoPresenter;
import br.com.brsantiago.jacareinews.presenter.contract.FavoritoContract;
import br.com.brsantiago.jacareinews.ui.adapter.NoticiaAdapter;
import br.com.brsantiago.jacareinews.ui.base.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bruno.oliveira on 03/01/2017.
 */

public class FavoritoFragment extends BaseFragment implements FavoritoContract.View,SearchView.OnQueryTextListener {


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
        setHasOptionsMenu(true);
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_favorites,menu);
    }
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem search = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) search.getActionView();

        searchView.setOnQueryTextListener(this);
        MenuItemCompat.setOnActionExpandListener(search,
                new MenuItemCompat.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem item) {
                        //  adapter.setFilter(lugares);
                        return true;
                    }

                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item) {
                        return true;
                    }
                });

    }

/*

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final int id = item.getItemId();

        */
/*if (id == R.id.action_search) {
            System.out.println("Search Favoritos");
        }*//*

        return super.onOptionsItemSelected(item);
    }
*/

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return true;
    }
}
