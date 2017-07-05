/**
 *  TODO complete javadoc comments.
 */
package edu.cnm.deepdive.generics;

/**
 * @author Sky Link
 *
 */
public interface ShufflerSorter<T extends Comparable<T>> extends Iterable<T> {
  
  /**
   * 
   */
  void shuffle();
  
  /**
   * 
   */
  void sort();
}
