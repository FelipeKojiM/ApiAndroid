package com.example.sub.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sub.R;
import com.example.sub.model.Paises;
import java.util.ArrayList;

public class AdapterPaises extends RecyclerView.Adapter<AdapterPaises.ViewHolder> {

    private ArrayList<Paises> listaPaises;
    private LayoutInflater inflater;

    public AdapterPaises(Context context, ArrayList<Paises> listaPaises) {
        this.inflater = LayoutInflater.from(context);
        this.listaPaises = listaPaises;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list_paises, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Paises pais = listaPaises.get(position);
        holder.tvCodigo.setText(String.valueOf(pais.getCodigo()));
        holder.tvDescricao.setText(pais.getDescricao());
    }

    @Override
    public int getItemCount() {
        return listaPaises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCodigo, tvDescricao;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCodigo = itemView.findViewById(R.id.tvCodigo);
            tvDescricao = itemView.findViewById(R.id.tvDescricao);
        }
    }
}