package br.unigran.agenda;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.unigran.Adapter.ContatoAdapter;
import br.unigran.bancoDados.ContatoDB;
import br.unigran.bancoDados.DBHelper;
import br.unigran.agenda.Contato;

public class MainActivity extends AppCompatActivity {

    DBHelper db;
    ContatoDB contatoDB;
    List dados;
    ContatoAdapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayoutManager=new LinearLayoutManager(this);

        dados= new LinkedList();
        db= new DBHelper(this);
        contatoDB = new ContatoDB(db);
        contatoDB.list(dados);
        adapter = new ContatoAdapter(dados);

        recyclerView = findViewById(R.id.idLista);
        //setar layout no recycleView
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }

    public void salvar(View view){
        Contato contato = new Contato();
        contato.setNome(((EditText)findViewById(R.id.nomeId)).getText().toString());
        contato.setTelefone(((EditText)findViewById(R.id.telefoneId)).getText().toString());
        ContatoDB contatoDB = new ContatoDB(db);
        contatoDB.inserir(contato);
        contatoDB.list(dados);

        adapter.notifyDataSetChanged();
    }
}