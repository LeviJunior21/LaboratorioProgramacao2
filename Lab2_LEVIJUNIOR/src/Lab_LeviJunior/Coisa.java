package Lab_LeviJunior;

public class Coisa {
  public static void main(String[] args) {
    registrarDescanso();
    System.out.println("-----");
    registrarTempoOnline();
    System.out.println("-----");
    controlarDisciplina();
    System.out.println("-----");
    registrarResumos();
    System.out.println("-----");
  }

  public static void registrarDescanso() {
    Descanso descanso = new Descanso();
    System.out.println(descanso.getStatusGeral());
    descanso.defineHorasDescanso(30);
    descanso.defineNumeroSemanas(1);
    System.out.println(descanso.getStatusGeral());
    descanso.defineHorasDescanso(26);
    descanso.defineNumeroSemanas(2);
    System.out.println(descanso.getStatusGeral());
    descanso.defineHorasDescanso(26);
    descanso.defineNumeroSemanas(1);
    System.out.println(descanso.getStatusGeral());
  }

  private static void registrarTempoOnline() {
    RegistroTempoOnline tempoLP2 = new RegistroTempoOnline("LP2", 30);
    tempoLP2.adicionaTempoOnline(10);
    System.out.println(tempoLP2.atingiuMetaTempoOnline());
    tempoLP2.adicionaTempoOnline(10);
    tempoLP2.adicionaTempoOnline(10);
    System.out.println(tempoLP2.atingiuMetaTempoOnline());
    tempoLP2.adicionaTempoOnline(2);
    System.out.println(tempoLP2.atingiuMetaTempoOnline());
    System.out.println(tempoLP2.toString());
    RegistroTempoOnline tempoP2 = new RegistroTempoOnline("P2");
    System.out.println(tempoP2.toString());
  }

  private static void controlarDisciplina() {
    
	/**  
	Disciplina prog2 = new Disciplina("PROGRAMACAO 2");
    prog2.cadastraHoras(4);
    prog2.cadastraNota(1, 5.0);
    prog2.cadastraNota(2, 6.0);
    prog2.cadastraNota(3, 7.0);
    System.out.println(prog2.aprovado());
    prog2.cadastraNota(4, 10.0);
    System.out.println(prog2.aprovado());
    System.out.println(prog2.toString());
    **/
    int[] pesosP2 = {6, 4};
    Disciplina prog2 = new Disciplina("PROGRAMACAO 2", 2, pesosP2);
    prog2.cadastraHoras(4);
    prog2.cadastraNota(1, 6.0);
    prog2.cadastraNota(2, 7.0);
    prog2.cadastraNota(1, 8.0);
    prog2.cadastraNota(2, 9.0);
    System.out.println(prog2.aprovado());
  System.out.println(prog2.toString());
    prog2.cadastraNota(1, 1.0);
    System.out.println(prog2.aprovado());
    System.out.println(prog2.toString());
    
    int[] pesosLP2 = {1, 2, 3, 4, 5, 6, 7}; //28
    Disciplina lp2 = new Disciplina("LABORATÓRIO DE PROGRAMAÇÃO 2", 7, pesosLP2);
    lp2.cadastraHoras(5);
    lp2.cadastraNota(1, 1); 
    lp2.cadastraNota(2, 2);
    lp2.cadastraNota(3, 3);
    lp2.cadastraNota(4, 4);
    lp2.cadastraNota(5, 5);
    lp2.cadastraNota(6, 6);
    lp2.cadastraNota(7, 7);
    System.out.println(lp2.aprovado());
    System.out.println(lp2.toString());
  }

  private static void registrarResumos() {
    RegistroResumos meusResumos = new RegistroResumos(2); 

    meusResumos.adiciona("Classe1", "Classes definem um tipo e a base de código para criação de objetos.");
    meusResumos.adiciona("Classe2", "Classes definem um tipo e a base de código para criação de objetos.");

    meusResumos.adiciona("Tipos1", "Identifica a semântica (operações e significados) de um conjunto de dados.");
    meusResumos.adiciona("Tipos2", "Identifica a semântica (operações e significados) de um conjunto de dados.");
    meusResumos.adiciona("Tipos3", "Identifica a semântica (operações e significados) de um conjunto de dados.");

    String[] resumos = meusResumos.pegaResumos();

    for (int i = 0; i < meusResumos.conta(); i++) {
      System.out.println(resumos[i]);
    }

    System.out.println();
    System.out.println("Resumos: ");
    System.out.println(meusResumos.imprimeResumos());
    System.out.println(meusResumos.temResumo("Classes"));
    System.out.println(meusResumos.temResumo("Objetos"));
  }

}
