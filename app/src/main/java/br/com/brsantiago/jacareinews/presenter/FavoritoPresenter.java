package br.com.brsantiago.jacareinews.presenter;

import java.util.ArrayList;
import java.util.List;

import br.com.brsantiago.jacareinews.domain.entity.Noticia;
import br.com.brsantiago.jacareinews.presenter.contract.FavoritoContract;

/**
 * Created by bruno.oliveira on 04/01/2017.
 */

public class FavoritoPresenter implements FavoritoContract.Presenter {

    private FavoritoContract.View view;

    @Override
    public void initialize() {
        showSuccess(favoritos());
    }

    protected List<Noticia> favoritos() {
        List<Noticia> noticias = new ArrayList<>();
        Noticia noticia = new Noticia();
        noticia.title = "Novo presidente do SAAE visita áreas técnicas da autarquia";
        noticia.pubDate = "06/01/2017";
        noticia.category = " SAAE";
        noticia.link = "http://www.jacarei.sp.gov.br/";
        noticia.description = "O novo presidente do SAAE, Nelson Gonçalves Prianti Junior, iniciou suas atividades na autarquia na última segunda-feira (02), um dia após a posse oficial do prefeito Izaias Santana, do vice Edgard Sasaki e dos secretários municipais e presidentes de fundações e autarquias do município. Ao lado de seus diretores e gerentes, Prianti visitou todas as […]";
        noticias.add(noticia);
        noticia = new Noticia();
        noticia.title = "Banco do Povo muda de endereço a partir de segunda-feira (9)";
        noticia.description = "O Banco do Povo de Jacareí passa a funcionar em novo endereço a partir da segunda-feira (9). A mudança, será para o prédio do Posto de Atendimento ao Trabalhador (PAT), na Rua Barão de Jacareí, n. 839, região central da cidade. Com a mudança, o atendimento na antiga sede (Rua Lamartine Delamare, 153) será realizado […]";
        noticia.pubDate = "06/01/2017";
        noticia.category = " SAAE";
        noticia.link = "http://www.jacarei.sp.gov.br/";
        noticias.add(noticia);
        return noticias;
    }

    @Override
    public void showSuccess(List<Noticia> list) {
        if (list.isEmpty()) {
            view.showEmpty();
        } else {
            view.showList(list);
        }
    }

    @Override
    public void setView(FavoritoContract.View view) {
        this.view = view;
    }
}
