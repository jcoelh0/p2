package Aula10;

import static java.lang.System.*;
import linkedlist.Stack; // Create stack module in linkedlist package
import linkedlist.Queue; // Create queue module in linkedlist package

public class p101
{
   public static void main(String[] args)
   {
      if (args.length != 1)
      {
         err.println("Usage: java -ea p101 <Number-Elements>");
         exit(1);
      }

      int n = 0;
      try
      {
         n = Integer.parseInt(args[0]);
      }
      catch(NumberFormatException e)
      {
         err.println("Error: invalid number "+args[0]);
         exit(2);
      }

      Stack<Integer> stack = new Stack<Integer>(); // illimited
      Queue<Integer> queue = new Queue<Integer>(); // illimited

      for(int i = 0; i < n; i++)
      {
         stack.push(i);
         queue.in(i);
      }

      out.print("Stack: ");
      stack.print();
      out.println();
      out.print("Queue: ");
      queue.print();
      out.println();

      while(!stack.isEmpty())
         stack.pop();
      while(!queue.isEmpty())
         queue.out();
   }
}

