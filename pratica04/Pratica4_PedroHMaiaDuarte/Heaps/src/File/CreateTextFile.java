/*************************************************************************
* (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
* Pearson Education, Inc. All Rights Reserved.                           *
*                                                                        *
* DISCLAIMER: The authors and publisher of this book have used their     *
* best efforts in preparing the book. These efforts include the          *
* development, research, and testing of the theories and programs        *
* to determine their effectiveness. The authors and publisher make       *
* no warranty of any kind, expressed or implied, with regard to these    *
* programs or to the documentation contained in these books. The authors *
* and publisher shall not be liable in any event for incidental or       *
* consequential damages in connection with, or arising out of, the       *
* furnishing, performance, or use of these programs.                     *
*************************************************************************/
package File;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.FormatterClosedException;


public class CreateTextFile {
 
    // open file DadosOrdenados.txt
   public static void escrever(String str, String arquivo) 
   {
      try
      {
          FileWriter file = new FileWriter(arquivo+".txt",true);
          PrintWriter output = new PrintWriter(file);
          output.print(str);
          output.close();
          //output = new Formatter("ordemOrdenada.txt"); // open the file
      }
      catch (Exception e) 
      {
        e.getStackTrace();
      }
   }
}
