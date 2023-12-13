package com.example.sub.activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.TextView;
import com.example.sub.R;
import com.example.sub.adapter.AdapterPaises;
import com.example.sub.controller.ControllerPaises;
import com.example.sub.model.Paises;
import java.util.ArrayList;

public class listaPaisesActivity extends AppCompatActivity {

    private TextView tvCodigo;
    private TextView tvDescricao;
    private ControllerPaises controller;
    private RecyclerView rvRelatorios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);

        rvRelatorios = findViewById(R.id.rvRelatorios);
        carregarListaAlunos();
    }

    private void carregarListaAlunos() {
        ArrayList<Paises> listaPais = controller.retornar(this);
        AdapterPaises adapter = new AdapterPaises(this, listaPais);

        rvRelatorios.setLayoutManager(new LinearLayoutManager(this));
        rvRelatorios.setAdapter(adapter);
    }
}