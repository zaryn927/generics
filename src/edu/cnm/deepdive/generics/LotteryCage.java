/**
 * 
 */
package edu.cnm.deepdive.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author Sky Link
 *
 */
public class LotteryCage<T extends Comparable<T>> implements ShufflerSorter<T> {
  
  private ArrayList<T> store;
  
  /**
   * 
   * @param coll
   */
  public LotteryCage(Collection<T> coll) {
    store = new ArrayList<>(coll);
  }
  @Override
  public Iterator<T> iterator() {
    return store.iterator();
  }

  @Override
  public void shuffle() {
    Collections.shuffle(store);
  }

  @Override
  public void sort() {
    mergeSort(0, store.size());
  }
  
  private void mergeSort(int start, int finish) {
    if (finish <= start + 1) {
      return;
    }
    int midpoint = (start + finish) / 2;
    mergeSort(start, midpoint);
    mergeSort(midpoint, finish);
    ArrayList<T> workArea = new ArrayList<>(finish - start);
    int position1 = start;
    int position2 = midpoint;
    while (position1 < midpoint && position2 < finish) {
      T item1 = store.get(position1);
      T item2 = store.get(position2);
      if (item1.compareTo(item2) <= 0) {
        workArea.add(item1);
        position1++;
      } else {
        workArea.add(item2);
        position2++;
      }
    }
    if (position1 == midpoint) {
      while (position2 < finish) {
        workArea.add(store.get(position2++));
      }
    } else {
      while (position1 < midpoint) {
        workArea.add(store.get(position1++));
      }
    }
    for (int position = 0; position < workArea.size(); position++) {
      store.set(start + position, workArea.get(position));
    }
  }

}
