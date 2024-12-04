package Entity;

import java.util.ArrayList;

public class Classe {
    private int id;
    private String nome;
    private Docente docente;
    private ArrayList<Gita> gite=new ArrayList();

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Docente getDocente() { return docente; }
    public void setDocente(Docente docente) { this.docente = docente; }
    public ArrayList<Classe> getGite() { return gite; }
    public void setGite(ArrayList<Gita> gite) { this.gite = gite; }
    public void aggiungiGita(Gita gita) {
        gite.add(gita);
    }


}
