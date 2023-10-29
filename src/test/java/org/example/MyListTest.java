package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MyListTest {

  MyList<Double> list1;
  MyList<Integer> list2;

  private MyList<Double> getList1 (){
    MyList<Double> list = new MyList<>();
    list.add(1.8);
    list.add(2.0);
    list.add(3.7);
    return list;
  }


  private MyList<Integer> getList2 (){
    MyList<Integer> list = new MyList<>();
    list.add(34);
    list.add(0);
    list.add(0);
    list.add(-56);
    list.add(-1);
    list.add(555555);
    list.add(76);
    list.add(34);
    list.add(3);
    list.add(496);
    return list;
  }


  @Test
  void should_add(){
    list1 = getList1();
    list1.add(4.8);
    Assertions.assertEquals(4.8, list1.get(3));

    list2 = getList2();
    list2.add(-56);
    Assertions.assertEquals(-56, list2.get(10));
  }

  @Test
  void should_get(){
    list1 = getList1();
    Assertions.assertEquals(3.7, list1.get(2));
    Assertions.assertEquals(1.8, list1.get(0));

    list2 = getList2();
    Assertions.assertEquals(496, list2.get(9));
    Assertions.assertEquals(34, list2.get(0));
  }

  @Test
  void method_get_should_throw_exception_by_invalid_index(){
    list1 = getList1();
    list2 = getList2();
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list1.get(4));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list1.get(100));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list2.get(10));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list2.get(100));
  }


  @Test
  void should_remove(){
    list1 = getList1();
    list2 = getList2();

  }

  @Test
  void should_get_correct_size(){
    list1 = getList1();
    list2 = getList2();
    Assertions.assertEquals(3, list1.size());
    Assertions.assertEquals(10, list2.size());

    list1.add(5.0);
    Assertions.assertEquals(4, list1.size());
    list2.add(55);
    Assertions.assertEquals(11, list2.size());

    list1.remove(2);
    Assertions.assertEquals(3, list1.size());
    list2.remove(2);
    Assertions.assertEquals(10, list2.size());

  }

  @Test
  void method_remove_should_throw_exception_by_invalid_index(){
    list1 = getList1();
    list2 = getList2();
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list1.remove(4));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list1.remove(100));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list2.remove(10));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list2.remove(100));
  }





}
