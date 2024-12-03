package Entity;
import java.time.*;
import java.util.ArrayList;

public class Gita {
    private int id;
    private String nome;
    private LocalDate data;
    private Docente docente;
    private ArrayList<Classe> classi=new ArrayList<>();

    public int getId(){return id;}
    public String getNome(){return nome;}
    public LocalDate getData(){return data;}
    public Docente getDocente(){return docente;}
    public ArrayList<Classe> getClassi(){return classi;}
    public void setId(int id){this.id=id;}
    public void setNome(String nome){this.nome=nome;}
    public void setData(LocalDate data){this.data=data;}
    public void setDocente(Docente docente){this.docente=docente;}
    public void setClassi(ArrayList<Classe> classi){this.classi=classi;}


}
