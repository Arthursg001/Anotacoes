package developer.android.santos.anotacoes.controller;

import java.util.ArrayList;
import java.util.List;

import developer.android.santos.anotacoes.model.Tarefa;

public class TarefaController {
    private List listaTarefa;

    public List getListaTarefa() {
        listaTarefa = new ArrayList<Tarefa>();

        listaTarefa.add(new Tarefa("Normal"));
        listaTarefa.add(new Tarefa("Alerta"));
        listaTarefa.add(new Tarefa("Urgente"));

        return listaTarefa;
    }

    public ArrayList<String> dadosSpinner(){
        ArrayList<String> dados = new ArrayList<>();

        for(int i = 0; i < getListaTarefa().size(); i++){
            Tarefa objeto = (Tarefa) getListaTarefa().get(i);
            dados.add(objeto.getUrgenciaTarefa());
        }
        return dados;
    }
}
