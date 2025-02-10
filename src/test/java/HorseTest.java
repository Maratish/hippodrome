import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HorseTest {
        Horse testHorse = new Horse("Marpeh", 1,2);

        @Test
        void notNullNameTest(){
            IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->new Horse(null,1.2));
            assertEquals("Name cannot be null.", ex.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings ={""," ","  ","\t","\n","\r"})
        void notBlankNameTest(String name){
            IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->new Horse(name,1.2));
            assertEquals("Name cannot be blank.", ex.getMessage());
        }




    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("Marpeh", testHorse.getName());
    }

    @org.junit.jupiter.api.Test
    void getSpeed() {
        assertEquals(1, testHorse.getSpeed());
    }

    @org.junit.jupiter.api.Test
    void getDistance() {
        assertEquals(2, testHorse.getDistance());
    }

    @org.junit.jupiter.api.Test
    void move() {

    }
}