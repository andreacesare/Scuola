package Controller;

import Entity.Docente;
import Service.DocenteService;

import java.util.*;

public class DocenteController {
    Scanner scanner=new Scanner(System.in);
    DocenteService docenteService=new DocenteService();

    public void createDocente(){
        System.out.println("Inserisci nome del Docente");
        String nome=scanner.nextLine();
        System.out.println("Inserisci cognome del Docente");
        String cognome=scanner.nextLine();
        docenteService.createDocente(nome,cognome);
    }

    public void readDocente(){
        System.out.println("Ecco la lista dei docenti");
        ArrayList<Docente> docenti=docenteService.readDocente();
        for(Docente d:docenti){
            System.out.println(d.getId()+" "+d.getNome()+" "+d.getCognome());
        }
    }
}
