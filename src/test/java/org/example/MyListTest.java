package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class MyListTest {

  private MyList<Double> initDoubleList (){
    MyList<Double> list = new MyList<>();
    list.add(1.8);
    list.add(2.0);
    list.add(3.7);
    return list;
  }

  private MyList<Integer> initIntegerList (){
    MyList<Integer> list = new MyList<>();
    list.add(34);
    list.add(-67);
    list.add(4567);
    return list;
  }


  @Test
  void should_add(){
    MyList<Double> doubleList = initDoubleList();
    doubleList.add(4.8);
    Assertions.assertEquals(4.8, doubleList.get(3));

    //add 8 values to check resize method
    MyList<Integer> integerList = initIntegerList();
    integerList.add(-56);
    integerList.add(4);
    integerList.add(-5);
    integerList.add(66);
    integerList.add(765);
    integerList.add(0);
    integerList.add(-56);
    integerList.add(34);
    Assertions.assertEquals(34, integerList.get(10));
  }

  @Test
  void should_get(){
    MyList<Double> doubleList = initDoubleList();
    Assertions.assertEquals(3.7, doubleList.get(2));
    Assertions.assertEquals(1.8, doubleList.get(0));

    MyList<Integer> integerList = initIntegerList();
    Assertions.assertEquals(-67, integerList.get(1));
    Assertions.assertEquals(34, integerList.get(0));
  }

  @Test
  void method_get_should_throw_exception_by_invalid_index(){
    MyList<Double> doubleList = initDoubleList();
    MyList<Integer> integerList = initIntegerList();

    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> doubleList.get(4));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> doubleList.get(100));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integerList.get(10));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integerList.get(-7));
  }


  @Test
  void should_remove(){
    MyList<Double> doubleList = initDoubleList();
    MyList<Integer> integerList = initIntegerList();
    double valueFromDoubleList = doubleList.remove(1);
    Assertions.assertEquals(2.0, valueFromDoubleList);
    Assertions.assertEquals(2, doubleList.size());

    valueFromDoubleList = doubleList.remove(0);
    Assertions.assertEquals(1.8, valueFromDoubleList);
    Assertions.assertEquals(1, doubleList.size());

    int valueFromIntegerList = integerList.remove(1);
    Assertions.assertEquals(-67, valueFromIntegerList);
    Assertions.assertEquals(2, integerList.size());

    valueFromIntegerList = integerList.remove(1);
    Assertions.assertEquals(4567, valueFromIntegerList);
    Assertions.assertEquals(1, integerList.size());


  }

  @Test
  void should_get_correct_size(){
    MyList<Double> doubleList = initDoubleList();
    MyList<Integer> integerList = initIntegerList();
    Assertions.assertEquals(3, doubleList.size());
    Assertions.assertEquals(3, integerList.size());

    doubleList.add(5.0);
    Assertions.assertEquals(4, doubleList.size());
    integerList.add(55);
    Assertions.assertEquals(4, integerList.size());

    doubleList.remove(2);
    Assertions.assertEquals(3, doubleList.size());
    integerList.remove(2);
    Assertions.assertEquals(3, integerList.size());

  }

  @Test
  void method_remove_should_throw_exception_by_invalid_index(){
    MyList<Double> doubleList = initDoubleList();
    MyList<Integer> integerList = initIntegerList();
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> doubleList.remove(4));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> doubleList.remove(100));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integerList.remove(-7));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integerList.remove(100));
  }

  @Test
  void should_transform_to_string_correctly(){
    MyList<Double> doubleList = initDoubleList();
    MyList<Integer> integerList = initIntegerList();

    String doubleListToString = doubleList.toString();
    String integerListToString = integerList.toString();

    Assertions.assertEquals("[1.8, 2.0, 3.7]", doubleListToString);
    Assertions.assertEquals("[34, -67, 4567]", integerListToString);
  }

  @Test
  void map_test(){
   MyList<Integer> integerList = initIntegerList();
   Function<Integer, Double> convertIntegerToDouble = x-> Double.valueOf(x);

   MyList<Double> integerListAfterConvert= integerList.map(convertIntegerToDouble);
   MyList<Double> expectedList = new MyList<>();
   expectedList.add(34.0);
   expectedList.add(-67.0);
   expectedList.add(4567.0);

   Assertions.assertEquals(expectedList, integerListAfterConvert);
  }


  @Test
  void should_have_equal_hashcode (){
    MyList<Double> doubleList = initDoubleList();
    MyList<Integer> integerList = initIntegerList();

    MyList<Double> equalListToDoubleList = new MyList<>();
    equalListToDoubleList.add(1.8);
    equalListToDoubleList.add(2.0);
    equalListToDoubleList.add(3.7);

    MyList<Integer> equalListToIntegerList = new MyList<>();
    equalListToIntegerList.add(34);
    equalListToIntegerList.add(-67);
    equalListToIntegerList.add(4567);

    int hashCodeOfDoubleList = doubleList.hashCode();
    int hashCodeOfIntegerList = integerList.hashCode();
    int hashCodeOfEqualList1 = equalListToDoubleList.hashCode();
    int hashCodeOfEqualList2 = equalListToIntegerList.hashCode();

    Assertions.assertEquals(hashCodeOfDoubleList, hashCodeOfEqualList1);
    Assertions.assertEquals(hashCodeOfIntegerList, hashCodeOfEqualList2);
  }

  @Test
  void should_not_have_equal_hashcode_value_reverse_order (){
    MyList<Double> doubleList = initDoubleList();
    MyList<Integer> integerList = initIntegerList();

    MyList<Double> reverseDoubleList = new MyList<>();
    reverseDoubleList.add(3.7);
    reverseDoubleList.add(2.0);
    reverseDoubleList.add(1.8);

    MyList<Integer> reverseIntegerList = new MyList<>();
    reverseIntegerList.add(4567);
    reverseIntegerList.add(-67);
    reverseIntegerList.add(34);

    int hashCodeOfDoubleList = doubleList.hashCode();
    int hashCodeOfIntegerList = integerList.hashCode();
    int hashCodeOfReverseDouble = reverseDoubleList.hashCode();
    int hashCodeOfReverseInteger = reverseIntegerList.hashCode();

    Assertions.assertNotEquals(hashCodeOfDoubleList, hashCodeOfReverseDouble);
    Assertions.assertNotEquals(hashCodeOfIntegerList, hashCodeOfReverseInteger);
  }

  @Test
  void should_be_equal_the_same_value(){
    MyList<Double> doubleList = initDoubleList();
    MyList<Integer> integerList = initIntegerList();

    MyList<Double> equalListToDoubleList = new MyList<>();
    equalListToDoubleList.add(1.8);
    equalListToDoubleList.add(2.0);
    equalListToDoubleList.add(3.7);

    MyList<Integer> equalListToIntegerList = new MyList<>();
    equalListToIntegerList.add(34);
    equalListToIntegerList.add(-67);
    equalListToIntegerList.add(4567);


    Assertions.assertTrue(doubleList.equals(equalListToDoubleList));
    Assertions.assertTrue(integerList.equals(equalListToIntegerList));
  }

  @Test
  void should_be_equal_the_same_object(){
    MyList<Double> doubleList = initDoubleList();
    MyList<Integer> integerList = initIntegerList();
    MyList<Double> theSameList1 = doubleList;
    MyList<Integer> theSameList2 = integerList;
    Assertions.assertTrue(doubleList.equals(theSameList1));
    Assertions.assertTrue(integerList.equals(theSameList2));
  }


  @Test
  void should_be_not_equal_diff_values(){
    MyList<Double> doubleList = initDoubleList();
    MyList<Integer> integerList = initIntegerList();

    MyList<Double> list1ForCompare = new MyList<>();
    list1ForCompare.add(4.8);
    list1ForCompare.add(6.0);
    list1ForCompare.add(8.7);

    MyList<Integer> list2ForCompare = new MyList<>();
    list2ForCompare.add(4);
    list2ForCompare.add(5);
    list2ForCompare.add(6);


    Assertions.assertFalse(doubleList.equals(list1ForCompare));
    Assertions.assertFalse(integerList.equals(list2ForCompare));
  }

  @Test
  void should_be_not_equal_null_object(){
    MyList<Double> doubleList = initDoubleList();
    MyList<Integer> integerList = initIntegerList();
    MyList<Double> list1Null = null;
    MyList<Integer> list2Null = null;
    Assertions.assertFalse(doubleList.equals(list1Null));
    Assertions.assertFalse(integerList.equals(list2Null));
  }

}
