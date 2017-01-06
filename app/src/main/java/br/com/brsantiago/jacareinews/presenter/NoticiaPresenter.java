package br.com.brsantiago.jacareinews.presenter;

import java.util.ArrayList;
import java.util.List;

import br.com.brsantiago.jacareinews.domain.entity.Noticia;
import br.com.brsantiago.jacareinews.presenter.contract.NoticiaContract;

/**
 * Created by bruno.oliveira on 04/01/2017.
 */

public class NoticiaPresenter implements NoticiaContract.Presenter {

    private NoticiaContract.View view;

    @Override
    public void initialize() {
        view.setList(noticias());
    }


    protected List<Noticia> noticias() {
        List<Noticia> noticias = new ArrayList<>();
        Noticia noticia = new Noticia();
        noticia.title = "Agita Férias oferece atividades recreativas para toda família";
        noticia.description = "A Secretaria de Esportes e Recreação de Jacareí inicia, a partir de segunda-feira (09), o “Projeto Verão” que oferece atividades recreativas em praças e espaços esportivos da cidade. O objetivo do projeto é oferecer a pais e filhos momentos de saúde e descontração no período de férias escolares. Segundo Marcelo Fortes, secretário de Esportes e […]";
        noticia.pubDate = "06/01/2017";
        noticia.category = "ESPORTES E RECREAÇÃO";
        noticia.link = "http://www.jacarei.sp.gov.br/";
        noticias.add(noticia);
        noticia = new Noticia();
        noticia.title = "Jacareí disponibiliza vacina contra HPV para meninos";
        noticia.description = "A Prefeitura de Jacareí, por meio da Secretaria de Saúde, disponibilizará, a partir desta quinta-feira (05), a vacina contra papilomavírus humano (HPV) para meninos entre 12 e 13 anos. Para receber a vacina basta apenas levar documentos pessoais. Nessa primeira fase da campanha serão disponibilizadas 1200 doses da vacina, em todas as Unidades de atendimento […]";
        noticia.pubDate = "06/01/2017";
        noticia.category = "SAÚDE";
        noticia.link = "http://www.jacarei.sp.gov.br/";
        noticias.add(noticia);
        noticia = new Noticia();
        noticia.title = "Secretaria de Finanças arrecada R$ 9,2 milhões com programa de anistia de multas e juros";
        noticia.description = "A Secretaria de Finanças arrecadou R$ 9,2 milhões com o programa de anistia de até 90% no pagamento de multas e juros no pagamento de tributos municipais em atraso. Foram cerca de 10 mil renegociações de contribuintes inadimplentes com o fisco municipal entre os dias 3 de novembro e 12 de dezembro, período de vigência […]";
        noticia.pubDate = "22/12/2016 ";
        noticia.category = "FINANÇAS";
        noticia.link = "http://www.jacarei.sp.gov.br/";
        noticias.add(noticia);
        return noticias;
    }


    @Override
    public void showSuccess(List<Noticia> list) {
        if (list.isEmpty()) {
            view.showEmpty();
        } else {
            view.setList(list);
        }
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
