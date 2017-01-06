package br.com.brsantiago.jacareinews.presenter;

import java.util.ArrayList;
import java.util.List;

import br.com.brsantiago.jacareinews.domain.entity.Noticia;
import br.com.brsantiago.jacareinews.presenter.contract.FavoritoContract;

/**
 * Created by bruno.oliveira on 04/01/2017.
 */

public class FavoritoPresenter implements FavoritoContract.Presenter {
    private List<Noticia> noticias;

    private FavoritoContract.View view;

    @Override
    public void initialize() {
        noticias = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Noticia noticia = new Noticia();
            noticia.code = Long.parseLong(i + "");
            noticia.content = "";
            noticia.link = "";
            noticias.add(noticia);
        }
        showSuccess(noticias);
    }

    @Override
    public void showSuccess(List<Noticia> list) {
        this.noticias = list;
        if (noticias.isEmpty()) {
            view.showEmpty();
        } else {
            view.setList(noticias);
        }
    }

    @Override
    public void setView(FavoritoContract.View view) {
        this.view = view;
    }
}
