package br.com.brsantiago.jacareinews.presenter.contract;

import java.util.List;

import br.com.brsantiago.jacareinews.domain.entity.Noticia;

/**
 * Created by bruno.oliveira on 04/01/2017.
 */

public class MainContract {

    public interface View {
        void showFavoritos(final int id);

        void showNoticias(final int id);

        void showConfig(final int id);

        void updateNavigationState(final int id);

        void initTransaction();

        void commitTransaction();

        void setToolbar();

        void changeToolbar(final int title);

        void changeLogo();
    }

    public interface Presenter {

        void showSuccess(List<Noticia> list);

        void showLoading();

        void showError();

        void retry();
    }

}
