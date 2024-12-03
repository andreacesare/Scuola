package Service;

import Entity.Classe;
import Entity.Docente;
import Repository.ClasseRepository;
import Repository.DocenteRepository;

import java.util.ArrayList;

public class ClasseService {
    ClasseRepository classeRepository = new ClasseRepository();

    public void createClasse(String nome, Docente docente){
        Classe classe=new Classe();
        classe.setNome(nome);
        classe.setDocente(docente);
        docente.setClasse(classe);
        classeRepository.createClasse(classe);

    }

    public ArrayList<Classe> readClasse(){
        return classeRepository.readClasse();
    }


}
