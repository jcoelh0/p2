package random;

import java.util.*;

/**
 *
 * @author jcoel
 */
public class medias {
    public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	notas nota = new notas();
	System.out.println("Nota global de um aluno de Programacao 2 (2014− 2015) na epoca normal");
	System.out.println("Introduza as notas do aluno:");
	nota.API1 = sc.nextDouble();
	nota.API2 = sc.nextDouble();
	nota.ATPI = sc.nextDouble();
	nota.APF = sc.nextDouble();
	double notafinal = nota.API1 * 0.20 + nota.API2 * 0.20 + nota.ATPI * 0.20 + nota.APF * 0.40;
	System.out.println("A nota final e " + notafinal);
    }
}

class notas {
    double API1, API2, ATPI, APF;
}
