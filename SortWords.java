/**
 * FUB Softwarepraktikum 2013
 * Uebung 1, Aufgabe 1
 *
 * Idee: Alle Wörter der Datei werden gelesen, mit ihrer Länge markiert.
 * und  in eine Prioritätswarteschlange eingefügt; Die Länge des Wortes 
 * dient dabei als Schlüssel. Anschließend wird die Reihenfolge durch 
 * einen Stack invertiert.
 *
 * @author Christoph van Heteren-Frese
 * @version 1.0
 */

import java.io.*;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Stack;

public class SortWords {
  // Innere Klasse um die Worte mit ihrer Länge zu markieren
  static class ComparableEntry implements Comparable<ComparableEntry> {
    // Instanzvariablen
    Integer key;
    String value;
    // Constructor
    public ComparableEntry(Integer k, String v) { key=k; value=v;}
    public Integer getKey() {return key;}
    public String getValue() {return value;}

    public int compareTo(ComparableEntry e) {
      if (this.getKey()==e.getKey()) return 0;
      else if (this.getKey()<e.getKey()) return -1;
      else return 1;
    }
  }

  public static void main (String[] args) throws IOException {
    // get file name 
    String file = args[0];
    Reader reader = null;
    // initialize priority queue and stack
    Stack<String> s = new Stack<String>();
    PriorityQueue<ComparableEntry> pq;
    pq = new PriorityQueue<ComparableEntry>();  
    try
    {
      reader = new FileReader(file);
      Scanner sc = new Scanner(reader);
      while(sc.hasNext()){
        String next = sc.next();
        pq.add(new ComparableEntry(new Integer(next.length()),next));
      }
    }
    catch ( IOException e ) {
      System.err.println( "Fehler beim Lesen der Datei!" );
    }
    finally {
      try { reader.close(); } catch ( Exception e ) { }
    }
    // as long as pq is not empty get next element and push it on s
    while(pq.size()>0) s.push(pq.poll().getValue());
    // as long as s is not empty pop elements an write to console
    while(!(s.empty())) System.out.println(s.pop());
  }
}
