package Controller;
import Entity.Docente;
import Entity.Gita;
import Service.DocenteService;
import Service.GitaService;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.time.*;
public class GitaController {
    Scanner scanner = new Scanner(System.in);
    GitaService gitaService = new GitaService();
    DocenteService docenteService = new DocenteService();
    DocenteController docenteController = new DocenteController();

    public void createGita() {
        System.out.println("Inserisici nome del gita");
        String nome = scanner.nextLine();
        LocalDate dataInserita = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean dataValida = false;
        while (!dataValida) {
            try {
                System.out.println("Inserisci data della gita");
                dataInserita = LocalDate.parse(scanner.nextLine(), formatter);
                dataValida = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato non valido,Riprova");
            }
        }
        docenteController.readDocente();
        ArrayList<Docente> docenti = docenteService.readDocente();
        System.out.println("Inserisci id del docente a cui affidare la gita");
        int id=scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<docenti.size();i++) {
            if(docenti.get(i).getId()==id) {
                Docente docente=docenti.get(i);
                gitaService.createGita(nome, dataInserita, docente);

            }
        }


    }

    public void readGita() {
        System.out.println("Ecco la lista delle gite");
        ArrayList<Gita> gite = gitaService.readGita();
        for (Gita g : gite) {
            System.out.println(g.getId() + " " + g.getNome() + " " + g.getData() + " " + g.getDocente().getNome() + " " + g.getDocente().getCognome());
        }
    }

    public void deleteGita() {
        readGita();
        System.out.println("Inserisic l'id della gita da eliminare");
        int id=scanner.nextInt();
        scanner.nextLine();
        gitaService.deleteGita(id);
    }

    public void updateGita() {
        readGita();
        System.out.println("Inserisci id della gita da modificare");
        int id=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserisci nuovo nome della gita");
        String nome = scanner.nextLine();
        LocalDate dataInserita=null;
        boolean dataValida = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (!dataValida) {
            try{
            System.out.println("Inserisci data della gita formato dd/mm/yyyy");
            String input = scanner.nextLine();
            dataInserita = LocalDate.parse(input, formatter);
            dataValida = true;

        }catch (DateTimeParseException e) {
                System.out.println("Formato non valido,Riprova");
            }
        }
        docenteController.readDocente();
        ArrayList<Docente> docenti = docenteService.readDocente();
        System.out.println("Inserisci id del docente a cui affidare la gita");
        int iddoc= scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<docenti.size();i++) {
            if(docenti.get(i).getId()==iddoc) {
                Docente docente=docenti.get(i);
                gitaService.updateGita(id,nome, dataInserita, docente);
            }
        }



    }
}

