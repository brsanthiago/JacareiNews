package br.com.brsantiago.jacareinews.ui.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.brsantiago.jacareinews.R;
import br.com.brsantiago.jacareinews.domain.entity.Noticia;
import br.com.brsantiago.jacareinews.ui.adapter.holder.NoticiaHolder;

/**
 * Created by bruno.oliveira on 03/11/2016.
 */

public class NoticiaAdapter extends RecyclerView.Adapter<NoticiaHolder> {


    private List<Noticia> noticias = new ArrayList<>();
    private Activity context;


    public NoticiaAdapter(Activity context, List<Noticia> noticias) {
        this.noticias = noticias;
        this.context = context;
    }

    @Override
    public NoticiaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.noticia_item, parent, false);
        NoticiaHolder viewHolder = new NoticiaHolder(noticias, view, context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NoticiaHolder holder, int position) {
        holder.setDados(position);
    }

    @Override
    public int getItemCount() {
        if (noticias == null) {
            return 0;
        }
        return noticias.size();
    }

}
