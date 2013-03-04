/**
 * FUB Softwarepraktikum 2013
 * Uebung 1, Aufgabe 1
 *
 * @author Christoph van Heteren-Frese
 * @version 1.0
 */

import java.io.*;
import java.util.Scanner;

public class SortWords {
  /**
   * reads file
   *
   */
  private static void ReadFile(String file) {
    Reader reader = null;
    try
    {
      reader = new FileReader(file);
      Scanner sc = new Scanner(reader);
      while(sc.hasNext()){
        // just for testing, has to be replaced with 
        // appropiate data structure (e.g. array list)
        System.out.println(sc.next());
      }
    }
    catch ( IOException e ) {
      System.err.println( "Fehler beim Lesen der Datei!" );
    }
    finally {
      try { reader.close(); } catch ( Exception e ) { }
    }
  }
  /**
   * sort file
   *
   */
  private static void SortFile() {

  }

  /**
   * main method for testing 
   */
  public static void main (String[] args) throws IOException {
    ReadFile("test_file");
  }
}

