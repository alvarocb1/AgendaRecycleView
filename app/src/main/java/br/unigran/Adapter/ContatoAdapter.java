package br.unigran.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.unigran.agenda.Contato;
import br.unigran.agenda.R;

public class ContatoAdapter extends RecyclerView.Adapter<ContatoAdapter.PessoaHolder> {

    List<Contato> dados;

    public ContatoAdapter(List<Contato> dados) {
        this.dados = dados;
    }
    @NonNull
    @Override
    public PessoaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.linha,parent,false);
        return new PessoaHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull PessoaHolder pessoaHolder, int position) {
        pessoaHolder.nome.setText(dados.get(position).getNome());
        pessoaHolder.telefone.setText(dados.get(position).getTelefone());
    }
    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class PessoaHolder extends RecyclerView.ViewHolder {
        public TextView nome;
        public TextView telefone;
        public Button editar;


        public PessoaHolder(@NonNull View itemView) {
            super(itemView);
            nome =itemView.findViewById(R.id.idNome);
            telefone =itemView.findViewById(R.id.idTelefone);
            editar =itemView.findViewById(R.id.idEditar);
        }
    }
}
