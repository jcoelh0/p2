import java.util.Scanner;


/**
 * Este programa permite a gestão (simples) de uma agenda de contactos.
 * 
 * @author Miguel Oliveira e Silva
 * @version 1.1, Jan/2008
 */

public class GestaoAgenda
{
	static Scanner in = new Scanner(System.in);

  /**
   * Programa principal.
   * 
   * @param args (não é utilizado pelo programa)
   */
  public static void main(String[] args)
  {
    int opcao;
    Agenda agenda = new Agenda();

    do
    {
      System.out.println();
      escreveMenu();
      System.out.println();
      do{
	System.out.print("Opção: ");
        opcao = in.nextInt();
      }while(opcao < 0 || opcao > 10);
      System.out.println();
      switch(opcao)
      {
        case 1:
          if (agendaCheia(agenda))
            System.out.print("ERRO: agenda cheia!");
          else
            adicionarContacto(agenda,lerContacto());
          break;
        case 2:
          escreveAgenda(agenda);
          break;
        case 3:
          limpaAgenda(agenda);
          break;
        case 4:
          {
	    System.out.print("Nome a procurar: ");
            String nome = in.nextLine();
            Contacto contacto = procuraContacto(agenda,nome);
            if(contacto == null)
              System.out.print("ERRO: contacto inexistente!");
            else
            {
              System.out.println("Contacto encontrado:");
              escreveContacto(contacto);
            }
          }
          break;
        case 5:
          {
	    System.out.print("Nome do contacto a apagar: ");
            String nome = in.nextLine();
            if(!nomeExiste(agenda,nome))
              System.out.print("ERRO: contacto inexistente!");
	    else
              apagaContacto(agenda,nome);
          }
          break;
      }

      if (opcao != 0)
{
	System.out.print("<Prima ENTER para continuar>");
        in.nextLine();
}
}while(opcao != 0);

    System.exit(0);
  }

  /**
   * Escreve o menu do programa.
   */
  public static void escreveMenu()
  {
    System.out.println("1 - Adiciona contacto");
    System.out.println("2 - Escreve agenda");
    System.out.println("3 - Apaga agenda");
    System.out.println("4 - Procura contacto");
    System.out.println("5 - Apaga contacto");
    System.out.println("0 - Termina");
  }


  /**
   * Serviços disponíveis sobre o "record" Agenda.
   */

  /**
   * [Agenda] Verifica se a agenda está cheia.
   *
   * <P><B>Pré-condição</B>: {@code agenda != null}
   * 
   * @param agenda agenda sobre a qual a operação se vai realizar
   */
  public static boolean agendaCheia(Agenda agenda)
  {
    assert agenda != null;

    return agenda.numeroPaginas == agenda.MAX_PAGINAS;
  }

  /**
   * [Agenda] Adiciona um contacto à agenda.
   *
   * <P><B>Pré-condição</B>: {@code agenda != null && !agendaCheia(agenda) && contacto != null}
   * 
   * @param agenda agenda sobre a qual a operação se vai realizar
   */
  public static void adicionarContacto(Agenda agenda,Contacto contacto)
  {
    assert agenda != null && !agendaCheia(agenda) && contacto != null;

    agenda.lista[agenda.numeroPaginas] = contacto;
    agenda.numeroPaginas++;
  }

  /**
   * [Agenda] Verifica se existe um nome na agenda.
   *
   * <P><B>Pré-condição</B>: {@code agenda != null && nome != null}
   * 
   * @param agenda agenda sobre a qual a operação se vai realizar
   */
  public static boolean nomeExiste(Agenda agenda,String nome)
  {
    assert agenda != null && nome != null;

    int p;

    for(p = 0;(p < agenda.numeroPaginas) && (!nome.equals(agenda.lista[p].nome));p++)
      ;

    return (p < agenda.numeroPaginas);
  }

  /**
   * [Agenda] Procura um contacto na agenda através de um nome (completo).
   *
   * <P><B>Pré-condição</B>: {@code agenda != null && nome != null}
   *
   * @param agenda agenda sobre a qual a operação se vai realizar
   * @param nome nome a procurar
   * @return {@code null} se o contacto não for encontrado, caso
   *         contrário devolve a referência para o contacto encontrado
   */
  public static Contacto procuraContacto(Agenda agenda,String nome)
  {
    assert agenda != null && nome != null;

    Contacto result = null;
    int p;

    for(p = 0;(p < agenda.numeroPaginas) && (!nome.equals(agenda.lista[p].nome));p++)
      ;
    if(p < agenda.numeroPaginas)
      result = agenda.lista[p];

    return result;
  }

  /**
   * [Agenda] Apaga um contacto (que tem de existir) da agenda.
   *
   * <P><B>Pré-condição</B>: {@code agenda != null && nome != null && nomeExiste(agenda,nome)}
   *
   * @param agenda agenda sobre a qual a operação se vai realizar
   * @param nome nome a procurar
   */
  public static void apagaContacto(Agenda agenda,String nome)
  {
    assert agenda != null && nome != null && nomeExiste(agenda,nome);

    int p;

    for(p = 0;!nome.equals(agenda.lista[p].nome);p++)
      ;
    agenda.numeroPaginas--;
    for(;p < agenda.numeroPaginas;p++)
      agenda.lista[p] = agenda.lista[p+1];
  }

  /**
   * [Agenda] Escreve o conteúdo da agenda.
   *
   * <P><B>Pré-condição</B>: {@code agenda != null}
   *
   * @param agenda agenda sobre a qual a operação se vai realizar
   */
  public static void escreveAgenda(Agenda agenda)
  {
    for(int p = 0;p < agenda.numeroPaginas;p++)
    {
      System.out.println("[Página " + (p+1) + "]");
      escreveContacto(agenda.lista[p]);
      System.out.println();
    }
  }

  /**
   * [Agenda] Apaga o conteúdo da agenda.
   *
   * <P><B>Pré-condição</B>: {@code agenda != null}
   *
   * @param agenda agenda sobre a qual a operação se vai realizar
   */
  public static void limpaAgenda(Agenda agenda)
  {
    assert agenda != null;

    agenda.numeroPaginas = 0;
  }


  /**
   * Serviços disponíveis sobre o "record" Contacto.
   */

  /**
   * [Contacto] Pede ao utilizador um contacto.
   * 
   * @return {@code Contacto} Devolve um novo contacto.
   */
  public static Contacto lerContacto()
  {
    Contacto result = new Contacto();

    do{
      System.out.print("Nome = ");
      result.nome = in.nextLine();
}
    while(result.nome.length() == 0);
    System.out.print("Telefone = ");
    result.telefone = in.nextLine();
    System.out.println("Data de nascimento:");
    result.dataNascimento = lerData();

    return result;
  }

  /**
   * [Contacto] Escreve um contacto.
   * 
   * @param contacto Contacto sobre o qual a operação se vai realizar
   */
  public static void escreveContacto(Contacto contacto)
  {
    assert contacto != null;

    System.out.println("Nome: " + contacto.nome);
    System.out.println("Telefone: " + contacto.telefone);
    System.out.print("Data de nascimento: ");
    escreveData(contacto.dataNascimento);
    System.out.println();
  }


  /**
   * Serviços disponíveis sobre o "record" Data.
   */

  /**
   * [Data] Pede ao utilizador uma data.
   * 
   * <P><B>Pós-condição</B>: {@code dataValida(result)}
   *
   * @return {@code Data} Devolve a data lida
   */
  public static Data lerData()
  {
    Data result = new Data();

    System.out.print("Ano = ");

    result.ano = in.nextInt();
    do{
      System.out.print("Mes = ");
      result.mes = in.nextInt();
}
    while(result.mes < 1 || result.mes > 12);
    do{
      System.out.print("Dia = ");
      result.dia = in.nextInt();
    }while(result.dia < 1 || result.dia > diasDoMes(result.mes,result.ano));

    assert dataValida(result);

    return result;
  }

  /**
   * [Data] Escreve uma data.
   * 
   * <P><B>Pré-condição</B>: {@code dataValida(data)}
   *
   * @param data Data sobre a qual a operação se vai realizar
   */
  public static void escreveData(Data data)
  {
    assert dataValida(data);

    System.out.printf("%02d-%02d-%04d",data.dia,data.mes,data.ano);
  }

  /**
   * [Data] Devolve o número de dias de um mês num determinado ano.
   * 
   * <P><B>Pré-condição</B>: {@code mesValido(mes)}
   * 
   * @param mes Mês sobre o qual a operação se vai realizar
   * @param ano Ano sobre o qual a operação se vai realizar
   */
  public static int diasDoMes(int mes,int ano)
  {
    assert mesValido(mes);

    int result = 0;

    switch(mes)
    {
      case 1: case 3: case 5: case 7: case 8: case 10: case 12:
        result = 31;
        break;
      case 4: case 6: case 9: case 11:
        result = 30;
        break;
      case 2:
        if (anoBissexto(ano))
          result = 29;
        else
          result = 28;
        break;
    }

    return result;
  }

  /**
   * [Data] Verifica se um ano é bissexto.
   * 
   * @param ano Ano sobre o qual a operação se vai realizar
   * @return {@code boolean} Resultado da consulta
   */
  public static boolean anoBissexto(int ano)
  {
    return (ano % 4 == 0) && ((ano % 400 == 0) || (ano % 100 != 0));
  }

  /**
   * [Data] Verifica se o valor de um mês é válido.
   * 
   * @param mes Mês sobre o qual a operação se vai realizar
   * @return {@code boolean} Resultado da consulta
   */
  public static boolean mesValido(int mes)
  {
    return mes >= 1 && mes <= 12;
  }

  /**
   * [Data] Verifica se os valores {@code dia/mes/ano} correspondem a uma data válida.
   * 
   * @param dia Dia sobre o qual a operação se vai realizar
   * @param mes Mês sobre o qual a operação se vai realizar
   * @param ano Ano sobre o qual a operação se vai realizar
   * @return {@code boolean} Resultado da consulta
   */
  public static boolean dataValida(int dia,int mes,int ano)
  {
    return mesValido(mes) &&
           dia >= 1 && dia <= diasDoMes(mes,ano);
  }

  /**
   * [Data] Verifica se uma data é válida.
   * 
   * @param data Data sobre o qual a operação se vai realizar
   * @return {@code boolean} Resultado da consulta
   */
  public static boolean dataValida(Data data)
  {
    return dataValida(data.dia,data.mes,data.ano);
  }
}

class Agenda
{
  static final int MAX_PAGINAS = 100;
  Contacto[] lista = new Contacto[100];
  int numeroPaginas = 0;
}

class Contacto
{
  String nome;
  String telefone;
  Data dataNascimento;
}

class Data
{
  int dia,mes,ano;
}

