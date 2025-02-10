import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class HorseTest {
        Horse testHorse = new Horse("Marpeh", 1,2);

        @Test
        void nullNameTest(){
            IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->new Horse(null,1,2));
            assertEquals("Name cannot be null.", ex.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings ={""," ","  ","\t","\n","\r"})
        void blankNameTest(String name){
            IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->new Horse(name,1,2));
            assertEquals("Name cannot be blank.", ex.getMessage());
        }

        @Test
        void negativeSpeedTest(){
            IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->new Horse("Marpeh",-1,2));
            assertEquals("Speed cannot be negative.", ex.getMessage());
        }

        @Test
        void negativeDistanceTest(){
            IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->new Horse("Marpeh",1,-2));
            assertEquals("Distance cannot be negative.", ex.getMessage());
        }

        @Test
        void getRandomCall(){
            try (MockedStatic<Horse> mockedHorse = Mockito.mockStatic(Horse.class)){
                new Horse("Marpeh",1,2).move();
                mockedHorse.verify(()->Horse.getRandomDouble(0.2d,0.9d), Mockito.times(1));
            }
        }

        @ParameterizedTest
        @CsvSource({"0.1, 10",
                    "0.5, 50",
                    "0.8, 80"})
        void correctDistanceTest(double randomDouble, double expectedDistance){
            try(MockedStatic<Horse> mockedHorse = Mockito.mockStatic(Horse.class)){
                mockedHorse.when(()->Horse.getRandomDouble(0.2d,0.9d)).thenReturn(randomDouble);
                Horse testHorse= new Horse("Marpeh",100,0);
                testHorse.move();
                assertEquals(expectedDistance,testHorse.getDistance());
                }
            }




    @Test
    void getNameTest() {
        assertEquals("Marpeh", testHorse.getName());
    }

    @Test
    void getSpeedTest() {
        assertEquals(1, testHorse.getSpeed());
    }

    @Test
    void getDistanceTest() {
        assertEquals(2, testHorse.getDistance());
    }

    @Test
    void moveTest() {

    }
}