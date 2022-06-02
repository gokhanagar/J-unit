package JunitMethods;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class J03_CompareArray {

   @ParameterizedTest
   @MethodSource("arrayProvider")
    void compareTwoArrays(boolean exp, Object[] a1, Object[] a2) {

       C03_CompareArray obj = new C03_CompareArray();
       assertEquals(exp,obj.compareTwoArrays(a1,a2));

   }

   static Stream<Arguments> arrayProvider(){
       String [] s1 = {"s","d" };
       String [] s2 = {"s","d" };

       String [] s3 = {"s","d" };
       String [] s4 = {"d","s" };

       Integer[] i1 ={1,2,3};
       Integer[] i2 ={1,3,2};

       return Stream.of(Arguments.of(true,s1,s2),
                 Arguments.of(true,s3,s4),
                 Arguments.of(true,i1,i2));
   }













}
