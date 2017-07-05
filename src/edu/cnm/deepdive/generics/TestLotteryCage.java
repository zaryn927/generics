/**
 * 
 */
package edu.cnm.deepdive.generics;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Sky Link
 *
 */
public class TestLotteryCage {

  /**
   * @param args
   */
  public static void main(String[] args) {
    ArrayList<Integer> pool = new ArrayList<>();
    Random rng = new Random();
    for (int i = 0; i < 100; i++) {
      pool.add(rng.nextInt());
    }
    LotteryCage<Integer> cage = new LotteryCage(pool);
    cage.sort();
    for (Integer i : cage) {
      System.out.println(i);
    }
    System.out.println();
    cage.shuffle();
    for (Integer i : cage) {
      System.out.println(i);
    }
  }

}
