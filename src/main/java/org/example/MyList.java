package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MyList <T extends Number>{

  private int defaultSize = 10;
  private int countOfElements = 0;
  private T [] array = new T [defaultSize];



  public void add(T t) {
    if (countOfElements >= array.length / 2){
      resize();
    }
    array[countOfElements] = t;
    countOfElements++;

  }

  public T get(int index) {
    if (index < array.length && index >= 0){
      return array[index];
    }else throw new ArrayIndexOutOfBoundsException();

  }

  private void resize() {
    int newSize = (int) (array.length * 1.5);
    array = Arrays.copyOf(array, newSize);
  }

  public T remove(int index) {
    if (index < array.length && index >= 0){
      T elementForRemoving = array[index];
      for (int i = index; i < countOfElements; i++) {
        array[i] = array[i + 1];
      }
      countOfElements--;
      return elementForRemoving;
    }else throw new ArrayIndexOutOfBoundsException();
  }

  public <R extends Number> MyList<R> map(Function <T, R> f) {
    MyList<R> myList = new MyList<>();
    for (int i = 0; i < countOfElements; i++) {
      myList.add(f.apply(this.get(i)));
    }
    return myList;
  }

  public int size() {
    return countOfElements;
  }
}
