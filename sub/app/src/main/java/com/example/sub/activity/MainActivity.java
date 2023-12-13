package com.example.sub.activity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.sub.R;
import com.example.sub.controller.ControllerPaises;

public class MainActivity extends AppCompatActivity {

    private TextView tvBuscarPaisesApi;
    private TextView tvAbrirListaPaises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBuscarPaisesApi = findViewById(R.id.tvBuscarPaisesApi);
        tvAbrirListaPaises = findViewById(R.id.tvAbrirListaPaises);

        tvBuscarPaisesApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ControllerPaises.getViaPais(MainActivity.this);
            }
        });

        tvAbrirListaPaises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, listaPaisesActivity.class);
                startActivity(intent);
            }
        });
    }
}