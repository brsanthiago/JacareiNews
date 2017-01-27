package br.com.brsantiago.jacareinews.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import br.com.brsantiago.jacareinews.R;
import br.com.brsantiago.jacareinews.presenter.contract.MainContract;
import br.com.brsantiago.jacareinews.ui.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainContract.View {


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setToolbar();

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {

            final int itemId = item.getItemId();
            switch (itemId) {
                case R.id.favorite_item:
                    showFavoritos(R.id.favorite_item);
                    changeToolbar(R.string.favoritos);
                    break;
                case R.id.configuracao_item:
                    showConfig(R.id.configuracao_item);
                    changeToolbar(R.string.configuracoes);
                    break;
                default:
                    showNoticias(R.id.noticia_item);
                    changeToolbar(R.string.noticias);
                    break;
            }
            return false;
        });

        View view = bottomNavigationView.findViewById(R.id.noticia_item);
        view.performClick();
    }

    @Override
    public void setToolbar() {
        toolbar.setTitle(R.string.noticias);
        toolbar.setSubtitle(R.string.app_name);
        toolbar.setContentInsetsAbsolute(2, 2);
        setSupportActionBar(toolbar);
    }

    @Override
    public void changeToolbar(final int title) {
        toolbar.setTitle(title);
        changeLogo();
    }

    @Override
    public void changeLogo() {
        Drawable logo;
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            logo = getResources().getDrawable(R.mipmap.ic_logos, getTheme());
        } else {
            logo = getResources().getDrawable(R.mipmap.ic_logos);
        }

        toolbar.setLogo(logo);
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View child = toolbar.getChildAt(i);
            if (child != null)
                if (child.getClass() == ImageView.class) {
                    ImageView iv2 = (ImageView) child;
                    if (iv2.getDrawable() == logo) {
                        iv2.setAdjustViewBounds(true);
                        iv2.setMaxHeight(24);
                        iv2.setMaxWidth(24);
                    }
                }
        }
    }

    @Override
    public void doSomethingImportant() {

    }

    @Override
    public void showFavoritos(final int itemId) {
        initTransaction();
        transaction.replace(R.id.frame_fragment_containers, new FavoritoFragment());
        updateNavigationState(itemId);
        commitTransaction();
    }

    @Override
    public void showNoticias(final int itemId) {
        initTransaction();
        transaction.replace(R.id.frame_fragment_containers, new NoticiaFragment());
        updateNavigationState(itemId);
        commitTransaction();
    }

    @Override
    public void showConfig(final int itemId) {
        initTransaction();
        transaction.replace(R.id.frame_fragment_containers, new ConfiguracaoFragment());
        updateNavigationState(itemId);
        commitTransaction();
    }

    @Override
    public void updateNavigationState(int id) {
        Menu menu = bottomNavigationView.getMenu();
        for (int i = 0, size = menu.size(); i < size; i++) {
            MenuItem item = menu.getItem(i);
            item.setChecked(item.getItemId() == id);
        }
    }

    @Override
    public void initTransaction() {
        transaction = getSupportFragmentManager().beginTransaction();
    }

    @Override
    public void commitTransaction() {
        transaction.commit();
    }
}
