package application.U5D3;

import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import application.U5D3.U5D3Application.*;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Value;

import java.util.Random;

import static java.lang.Math.max;
import static java.lang.Math.pow;
import static org.junit.jupiter.api.Assertions.*;

public class ExercizeTest {
    Random rnd = new Random();



    @ParameterizedTest
    @CsvSource({"3 , 4 , false" , "6 , 5 , true"})
    void maggioreOminoreDi(int a , int b , boolean expectedResult){
        boolean result = a >= b;
        assertEquals(expectedResult , result);

    }




    int divide(int a , int b){
        return a / b;
    }

    @ParameterizedTest
    @ValueSource(ints = {3 , 6 , 9 } )
    void testAritmeticExecption(int a){
       assertThrows(ArithmeticException.class, ( ) -> divide(a , 0));

    }





    @ParameterizedTest
    @CsvSource({"4 , 3 , 7 , 1 , 12" ,"1 , 1 , 2 , 0 , 1"})
    void testDiTreOperatoriAritmeticiBase(int a , int b , int sumResult  , int subtractionResult  , int multiplicationResult ){
        int result1 = a + b;
        int result2 = a - b;
        int result3 = a * b;


        assertAll(
                () -> assertEquals(sumResult , result1),
                () -> assertEquals(subtractionResult , result2),
                () ->assertEquals(multiplicationResult , result3)
        );

    }

    @ParameterizedTest
    @CsvSource({"4 , 4 ,24 , true" , "1 , 7 , 18 , false"})
    void rollTheDice(int times , int min, int max , boolean expectedResult){
        int result = 0;
        for (int i = 0 ; i < times ; i++ ){
            result += rnd.nextInt(1 , 7);
        }

        boolean isRight = min < result && result < max;
        assertEquals(expectedResult , isRight);





    }



    @ParameterizedTest
    @CsvSource({"4 , 3 , 7 , false" ,"3 , 4 , 5 , true"})
    void isARectangleTriangle(int a , int b , int c ,boolean expectedResult){
        boolean isIt = (Math.pow(a , 2) + Math.pow(b , 2) == Math.pow(c , 2))
                || Math.pow(b , 2) + Math.pow(c , 2) == Math.pow(a , 2)
                || Math.pow(a , 2) + Math.pow(c , 2) == Math.pow(b , 2);

        assertEquals(expectedResult , isIt);


    }











    }












