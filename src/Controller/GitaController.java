package Controller;
import Entity.Classe;
import Entity.Docente;
import Entity.Gita;
import Service.ClasseService;
import Service.DocenteService;
import Service.GitaService;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.time.*;
public class GitaController {


    public void createGita() {
        Scanner scanner = new Scanner(System.in);
        GitaService gitaService = new GitaService();
        DocenteService docenteService = new DocenteService();
        DocenteController docenteController = new DocenteController();
        ClasseController classeController = new ClasseController();
        ClasseService classeService = new ClasseService();
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
        ArrayList<Docente> lista = docenteService.readDocente();
        ArrayList<Classe> clista = classeService.readClasse();

        boolean flag=false;
        for(Docente d:lista){
            if(d.getGita()==null){
                flag=true;
            }
        }
        do {
            System.out.println("Inserisci id del docente da affidare a questa gita");
            int id = scanner.nextInt();
            scanner.nextLine();


            if(flag) {
                for (int i = 0; i < lista.size(); i++) {
                    if (lista.get(i).getId() == id) {
                        if (lista.get(i).getGita() == null) {
                            Docente docente = lista.get(i);
                            flag = false;
                            classeController.readClasse();
                            System.out.println("Inserisci id della classe che parteciperà a questa gita");
                            int idc = scanner.nextInt();
                            scanner.nextLine();
                            for(int j=0;j<clista.size();j++) {
                                if (clista.get(j).getId() == idc) {
                                    Classe classe = clista.get(j);
                                    gitaService.createGita(nome, dataInserita, docente, classe);
                                    break;
                                }
                            }

                        } else {
                            System.out.println("Docente impegnato");

                        }
                    }
                }
            }else{
                System.out.println("Tutti i docenti sono impegnati");
            }
        }while(flag);
    }

    public void readGita() {
        Scanner scanner = new Scanner(System.in);
        GitaService gitaService = new GitaService();
        DocenteService docenteService = new DocenteService();
        DocenteController docenteController = new DocenteController();
        ClasseController classeController = new ClasseController();
        ClasseService classeService = new ClasseService();
        System.out.println("Ecco la lista delle gite");
        ArrayList<Gita> gite = gitaService.readGita();
        for (Gita g : gite) {
            System.out.println(g.getId() + " " + g.getNome() + " " + g.getData() + " " + g.getDocente().getNome() + " " + g.getDocente().getCognome());
        }
    }

    public void deleteGita() {
        Scanner scanner = new Scanner(System.in);
        GitaService gitaService = new GitaService();
        DocenteService docenteService = new DocenteService();
        DocenteController docenteController = new DocenteController();
        ClasseController classeController = new ClasseController();
        ClasseService classeService = new ClasseService();
        readGita();
        System.out.println("Inserisic l'id della gita da eliminare");
        int id=scanner.nextInt();
        scanner.nextLine();
        gitaService.deleteGita(id);
    }

    public void updateGita() {
        Scanner scanner = new Scanner(System.in);
        GitaService gitaService = new GitaService();
        DocenteService docenteService = new DocenteService();
        DocenteController docenteController = new DocenteController();
        ClasseController classeController = new ClasseController();
        ClasseService classeService = new ClasseService();
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

