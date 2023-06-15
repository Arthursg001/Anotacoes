package developer.android.santos.anotacoes.view;

import androidx.appcompat.app.AppCompatActivity;

import developer.android.santos.anotacoes.R;
import developer.android.santos.anotacoes.controller.AnotacoesController;
import developer.android.santos.anotacoes.controller.TarefaController;
import developer.android.santos.anotacoes.model.Anotacoes;
import static developer.android.santos.anotacoes.R.layout.activity_main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    AnotacoesController controller;
    TarefaController tarefaController;

    Anotacoes anotacao;
    List<String> urgenciaTarefa;

    EditText editTitulo;
    EditText editDescricao;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new AnotacoesController(MainActivity.this);
        controller.toString();

        tarefaController = new TarefaController();

        urgenciaTarefa = tarefaController.dadosSpinner();

        anotacao = new Anotacoes();
        controller.procurar(anotacao);

        editTitulo = findViewById(R.id.editTitulo);
        editDescricao = findViewById(R.id.editDescricao);

        spinner = findViewById(R.id.spinner);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tarefaController.dadosSpinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinner.setAdapter(adapter);

        editTitulo.setText(anotacao.getTitulo());
        editDescricao.setText(anotacao.getDescricao());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Informações Limpadas", Toast.LENGTH_LONG).show();
                editTitulo.setText("");
                editDescricao.setText("");
                controller.limpar();
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte Sempre !", Toast.LENGTH_SHORT).show();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anotacao.setTitulo(editTitulo.getText().toString());
                anotacao.setDescricao(editDescricao.getText().toString());

                Toast.makeText(MainActivity.this, "Dados salvos com sucesso" + anotacao.toString(), Toast.LENGTH_LONG).show();

                controller.salvar(anotacao);
            }
        });
    }
}