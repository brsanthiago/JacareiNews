package br.com.brsantiago.jacareinews.presenter.contract;

import java.util.List;

import br.com.brsantiago.jacareinews.domain.entity.Noticia;

/**
 * Created by bruno.oliveira on 04/01/2017.
 */

public class NoticiaContract {

    public interface View {
        void setList(final List<Noticia> items);

        void showLoading();

        void showEmpty();

        void showList();
    }

    public interface Presenter {

        void initialize();

        void showSuccess(List<Noticia> list);

        void showLoading();

        void showError();

        void retry();

        void setView(NoticiaContract.View view);
    }

}
