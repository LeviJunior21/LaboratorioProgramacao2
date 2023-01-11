package Lab_LeviJunior;

public class CoisaBonus {
	public static void main(String[] args) {
		descanso();
		System.out.println("----------");
		disciplina();
	}
	
	public static void descanso() {
	       Descanso descanso = new Descanso();
	       System.out.println(descanso.getStatusGeral());
	       descanso.defineHorasDescanso(30);
	       descanso.defineNumeroSemanas(1);
	       descanso.definirEmoji("ᕦʕ •ᴥ•ʔᕤ");
	       System.out.println(descanso.getStatusGeral());
	       descanso.defineHorasDescanso(35);
	       System.out.println(descanso.getStatusGeral());
	       descanso.definirEmoji("ʕ •ᴥ•ʔ");
	       descanso.defineHorasDescanso(26);
	       descanso.defineNumeroSemanas(2);
	       System.out.println(descanso.getStatusGeral());
	       descanso.definirEmoji("▼・ᴥ・▼");
	       descanso.defineHorasDescanso(30);
	       descanso.defineNumeroSemanas(1);
	       descanso.definirEmoji("▼・ᴥ・▼");
	       descanso.defineHorasDescanso(31);
	       System.out.println(descanso.getStatusGeral());
	   }
	
	private static void disciplina() {
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
	    
	    int[] pesosLP2 = {1, 2, 3, 4, 5, 6, 7};
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
}