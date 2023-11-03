package org.example;

import java.util.*;
import java.util.function.Function;

public class MyList <T extends Number> implements Iterable<T>{


  private int size = 0;
  private Object [] array;
  private final static int DEFAULT_CAPACITY = 10;
  private final static double VALUE_FOR_RESIZE = 1.5;


  public MyList(){
    this.array = (T[]) new Number[DEFAULT_CAPACITY];
  }

  public void add(T t) {
    if (size == array.length ){
      resize();
    }
    array[size] = t;
    size++;
  }

  public T get(int index) {
    if(index >= size || index < 0){
      throw new IndexOutOfBoundsException();
    }
      return (T)array[index];
  }

  private void resize() {
    int newSize = (int) (array.length * VALUE_FOR_RESIZE);
    Object [] newArray =  (T[]) new Number[newSize];
    System.arraycopy(array, 0, newArray, 0, size);
    array = newArray;
  }


  public T remove(int index) {
    if(index >= size || index < 0){
      throw new IndexOutOfBoundsException();
    }
      T elementForRemoving = (T)array[index];
      for (int i = index; i < size - 1; i++) {
        array[i] = array[i + 1];
      }
      array[size - 1] = null;
      size--;
      return elementForRemoving;
  }

  public <R extends Number> MyList<R> map(Function <T, R> function) {
    MyList<R> myList = new MyList<>();
    for (int i = 0; i < size; i++) {
      myList.add(function.apply(this.get(i)));
    }
    return myList;
  }

  public int size() {
    return size;
  }


  @Override
  public int hashCode() {
    int hash = size();
    for (int i = 0; i < size; i++) {
      hash = hash * 31 + array[i].hashCode();
    }
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;

    MyList<T> otherList = (MyList<T>) obj;
    if (otherList.size() != size())
      return false;

    boolean result = true;
    for (int i = 0; i < size(); i++) {
      if(!get(i).equals(otherList.get(i))){
        result = false;
        break;
      }
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    for (int i = 0; i < size; i++) {
      sb.append(array[i]);
      if (i < size - 1) {
        sb.append(", ");
      }}
      sb.append("]");
      return sb.toString();
  }

  @Override
  public Iterator<T> iterator() {
    return new MyListIterator();
  }

  private class MyListIterator implements Iterator<T>{
    private int index = 0;

      @Override
      public boolean hasNext() {
          return index < size;
      }

      @Override
      public T next() {
        if (!hasNext()){
          throw new NoSuchElementException();
        }
          return (T)array[index++];
      }
  }



}
