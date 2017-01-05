package br.com.brsantiago.jacareinews.presenter;

import java.util.ArrayList;
import java.util.List;

import br.com.brsantiago.jacareinews.domain.entity.Noticia;
import br.com.brsantiago.jacareinews.presenter.contract.NoticiaContract;

/**
 * Created by bruno.oliveira on 04/01/2017.
 */

public class NoticiaPresenter implements NoticiaContract.Presenter {
   private List<Noticia> noticias;

    private NoticiaContract.View view;
    @Override
    public void initialize() {
        noticias = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            Noticia noticia = new Noticia();
            noticia.code = Long.parseLong(i + "");
            noticia.content = "";
            noticia.link = "";
            noticias.add(noticia);
        }
        view.setList(noticias);
    }

    @Override
    public void showSuccess(List<Noticia> list) {
        this.noticias = list;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void retry() {

    }

    @Override
    public void setView(NoticiaContract.View view) {
        this.view = view;
    }
}
