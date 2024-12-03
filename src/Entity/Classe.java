package Entity;

import java.util.ArrayList;

public class Classe {
    private int id;
    private String nome;
    private Docente docente;
    private ArrayList<Classe> classi=new ArrayList();

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Docente getDocente() { return docente; }
    public void setDocente(Docente docente) { this.docente = docente; }
    public ArrayList<Classe> getClassi() { return classi; }
    public void setClassi(ArrayList<Classe> classi) { this.classi = classi; }

}
