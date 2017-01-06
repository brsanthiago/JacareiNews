package br.com.brsantiago.jacareinews.presenter.contract;

import java.util.List;

import br.com.brsantiago.jacareinews.domain.entity.Noticia;

/**
 * Created by bruno.oliveira on 04/01/2017.
 */

public class FavoritoContract {

    public interface View {
        void setList(final List<Noticia> items);

        void showEmpty();

        void showList();
    }

    public interface Presenter {

        void initialize();

        void showSuccess(List<Noticia> list);

        void setView(FavoritoContract.View view);
    }

}
