package com.example.persistencia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.zip.Inflater;

import android.content.Context;


public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.ViewHolder> {

   //Itens que a Adapter precisa receber para poder inflar os componentes
    //visuais

    private List<Evento> eventos;  //lista de objetos a serem mostrados
    private Context context; //onde será mostrado


    public EventoAdapter(List<Evento> eventos, Context context) {
        this.eventos = eventos;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Criar o objeto que será responsável pela visualização
        //de cada evento
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.evento_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //obetr que elemento da lista terá que ser inflado
        Evento evento = eventos.get(position);
        holder.textViewId.setText(String.valueOf(evento.getId()));
        holder.textViewDescricao.setText(evento.getDescricao());
        holder.textViewCursoDoEvento.setText(evento.getCurso());
        holder.textViewUrl.setText(evento.getUrl());
    }

    @Override
    public int getItemCount() {
        //retornar a quantidade de elementos que o adapter terá que
        // inflar
        return eventos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        //Essa classe interna deve suportar os componentes visuais
        //que serão inflados em cada item a ser usado no Recycle

        TextView textViewId;
        TextView textViewDescricao;
        TextView textViewCursoDoEvento;
        TextView textViewUrl;
        View barrahorizontal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewId = itemView.findViewById(R.id.textViewId);
            this.textViewDescricao = itemView.findViewById(R.id.textViewDescricao);
            this.textViewCursoDoEvento = itemView.findViewById(R.id.textViewCursoDoEvento);
            this.textViewUrl = itemView.findViewById(R.id.textViewUrl);
            this.barrahorizontal = itemView.findViewById(R.id.divider);
        }
    }
}
