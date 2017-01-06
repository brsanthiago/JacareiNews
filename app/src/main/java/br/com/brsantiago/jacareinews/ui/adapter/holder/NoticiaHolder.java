package br.com.brsantiago.jacareinews.ui.adapter.holder;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import br.com.brsantiago.jacareinews.R;
import br.com.brsantiago.jacareinews.domain.entity.Noticia;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bruno.oliveira on 04/01/2017.
 */

public class NoticiaHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    @BindView(R.id.tvTitulo)
    TextView tvTitulo;
    @BindView(R.id.tvContent)
    TextView tvContent;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.tvCategoria)
    TextView tvCategoria;
    @BindView(R.id.tvLink)
    TextView tvLink;
    private Activity context;
    private List<Noticia> noticias;

    public NoticiaHolder(final List<Noticia> noticias, final View view, final Activity context) {
        super(view);
        ButterKnife.bind(this, view);
        this.context = context;
        this.noticias = noticias;
    }

    @Override
    public void onClick(View v) {
        /*Intent intent = new Intent(context, NoticiaActivity.class);
        intent.putExtras(getItemBundle(getAdapterPosition()));
        context.startActivity(intent);*/
    }

    private Bundle getItemBundle(int position) {
        Noticia item = noticias.get(position);
        Bundle bundle = new Bundle();
        bundle.putParcelable("rss", item);
        return bundle;
    }

    public void setDados(final int position) {
        final Noticia noticia = noticias.get(position);
        tvCategoria.setText(noticia.category);
        tvData.setText(noticia.pubDate);
        tvLink.setText(noticia.link);
        tvTitulo.setText(noticia.title);
        tvContent.setText(noticia.description);
    }
}
