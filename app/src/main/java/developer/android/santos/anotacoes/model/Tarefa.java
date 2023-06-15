package developer.android.santos.anotacoes.model;

public class Tarefa {
    private String urgenciaTarefa;

    public Tarefa() {
    }

    public Tarefa(String urgenciaTarefa) {
        this.urgenciaTarefa = urgenciaTarefa;
    }

    public String getUrgenciaTarefa() {
        return urgenciaTarefa;
    }

    public void setUrgenciaTarefa(String urgenciaTarefa) {
        this.urgenciaTarefa = urgenciaTarefa;
    }
}
