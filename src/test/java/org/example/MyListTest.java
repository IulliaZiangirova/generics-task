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
    double valueFromList1 = list1.remove(1);
    Assertions.assertEquals(2.0, valueFromList1);
    Assertions.assertEquals(2, list1.size());

    valueFromList1 = list1.remove(0);
    Assertions.assertEquals(1.8, valueFromList1);
    Assertions.assertEquals(1, list1.size());

    int valueFromList2 = list2.remove(4);
    Assertions.assertEquals(-1, valueFromList2);
    Assertions.assertEquals(9, list2.size());

    valueFromList2 = list2.remove(8);
    Assertions.assertEquals(496, valueFromList2);
    Assertions.assertEquals(8, list2.size());


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

  @Test
  void should_transform_to_string_correctly(){
    list1 = getList1();
    list2 = getList2();

    String list1ToString = list1.toString();
    String list2ToString = list2.toString();

    Assertions.assertEquals("[1.8, 2.0, 3.7]", list1ToString);
    Assertions.assertEquals("[34, 0, 0, -56, -1, 555555, 76, 34, 3, 496]", list2ToString);
  }


  @Test
  void should_have_equal_hashcode (){
    list1 = getList1();
    list2 = getList2();

    MyList<Double> equalList1 = new MyList<>();
    equalList1.add(1.8);
    equalList1.add(2.0);
    equalList1.add(3.7);

    MyList<Integer> equalList2 = new MyList<>();
    equalList2.add(34);
    equalList2.add(0);
    equalList2.add(0);
    equalList2.add(-56);
    equalList2.add(-1);
    equalList2.add(555555);
    equalList2.add(76);
    equalList2.add(34);
    equalList2.add(3);
    equalList2.add(496);

    int hashCodeOfList1 = list1.hashCode();
    int hashCodeOfList2 = list2.hashCode();
    int hashCodeOfEqualList1 = equalList1.hashCode();
    int hashCodeOfEqualList2 = equalList2.hashCode();

    Assertions.assertEquals(hashCodeOfList1, hashCodeOfEqualList1);
    Assertions.assertEquals(hashCodeOfList2, hashCodeOfEqualList2);

  }

  @Test
  void should_not_have_equal_hashcode_value_reverse_order (){
    list1 = getList1();
    list2 = getList2();

    MyList<Double> reverseList1 = new MyList<>();
    reverseList1.add(3.7);
    reverseList1.add(2.0);
    reverseList1.add(1.8);

    MyList<Integer> reverseList2 = new MyList<>();
    reverseList2.add(496);
    reverseList2.add(3);
    reverseList2.add(34);
    reverseList2.add(76);
    reverseList2.add(555555);
    reverseList2.add(-1);
    reverseList2.add(-56);
    reverseList2.add(0);
    reverseList2.add(0);
    reverseList2.add(34);

    int hashCodeOfList1 = list1.hashCode();
    int hashCodeOfList2 = list2.hashCode();
    int hashCodeOfEqualList1 = reverseList1.hashCode();
    int hashCodeOfEqualList2 = reverseList2.hashCode();

    Assertions.assertNotEquals(hashCodeOfList1, hashCodeOfEqualList1);
    Assertions.assertNotEquals(hashCodeOfList2, hashCodeOfEqualList2);
  }

  @Test
  void should_be_equal_the_same_value(){
    list1 = getList1();
    list2 = getList2();

    MyList<Double> equalList1 = new MyList<>();
    equalList1.add(1.8);
    equalList1.add(2.0);
    equalList1.add(3.7);

    MyList<Integer> equalList2 = new MyList<>();
    equalList2.add(34);
    equalList2.add(0);
    equalList2.add(0);
    equalList2.add(-56);
    equalList2.add(-1);
    equalList2.add(555555);
    equalList2.add(76);
    equalList2.add(34);
    equalList2.add(3);
    equalList2.add(496);


    Assertions.assertTrue(list1.equals(equalList1));
    //Assertions.assertTrue(list2.equals(equalList2));
  }

  @Test
  void should_be_equal_the_same_object(){
    list1 = getList1();
    list2 = getList2();
    MyList<Double> theSameList1 = list1;
    MyList<Integer> theSameList2 = list2;
    Assertions.assertTrue(list1.equals(theSameList1));
    Assertions.assertTrue(list2.equals(theSameList2));
  }

  @Test
  void should_be_not_equal_diff_size_the_same_values(){
    list1 = getList1();
    list2 = getList2();

    MyList<Double> list1ForCompare = new MyList<>();
    list1ForCompare.add(1.8);
    list1ForCompare.add(2.0);

    MyList<Integer> list2ForCompare = new MyList<>();
    list2ForCompare.add(34);
    list2ForCompare.add(0);
    list2ForCompare.add(0);
    list2ForCompare.add(-56);
    list2ForCompare.add(-1);
    list2ForCompare.add(555555);
    list2ForCompare.add(76);
    list2ForCompare.add(34);
    list2ForCompare.add(3);

    Assertions.assertFalse(list1.equals(list1ForCompare));
    Assertions.assertFalse(list2.equals(list2ForCompare));

  }

  @Test
  void should_be_not_equal_diff_values(){
    list1 = getList1();
    list2 = getList2();

    MyList<Double> list1ForCompare = new MyList<>();
    list1ForCompare.add(4.8);
    list1ForCompare.add(6.0);
    list1ForCompare.add(8.7);

    MyList<Integer> list2ForCompare = new MyList<>();
    list2ForCompare.add(4);
    list2ForCompare.add(5);
    list2ForCompare.add(6);
    list2ForCompare.add(9);
    list2ForCompare.add(4);
    list2ForCompare.add(555556);
    list2ForCompare.add(4);
    list2ForCompare.add(999);
    list2ForCompare.add(2);
    list2ForCompare.add(54);

    Assertions.assertFalse(list1.equals(list1ForCompare));
    Assertions.assertFalse(list2.equals(list2ForCompare));


  }

  @Test
  void should_be_not_equal_null_object(){
    list1 = getList1();
    list2 = getList2();
    MyList<Double> list1Null = null;
    MyList<Integer> list2Null = null;
    Assertions.assertFalse(list1.equals(list1Null));
    Assertions.assertFalse(list2.equals(list2Null));

  }




}
