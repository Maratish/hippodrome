import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {

    @Test
    void nullHippodromeTest() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            new Hippodrome(null);
        });
        assertEquals("Horses cannot be null.", ex.getMessage());
    }

    @Test
    void emptyHippodromeTest() {
        List<Horse> emptyList = new ArrayList<>();
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(emptyList));
        assertEquals("Horses cannot be empty.", ex.getMessage());
    }

    @Test
    void getHorsesTest() {
        List<Horse> horsesListTest = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            horsesListTest.add(new Horse("horse" + i, i, i));
        }
        Hippodrome hippodromeTest = new Hippodrome(horsesListTest);
        List<Horse> returnedHorses = hippodromeTest.getHorses();
        assertEquals(horsesListTest.size(), returnedHorses.size());
        for (int i = 0; i < returnedHorses.size(); i++) {
            assertEquals(horsesListTest.get(i), returnedHorses.get(i));
        }
    }

    @Test
    void moveTest() {
        List<Horse> mockedHorsesList = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            Horse mockedHorse = Mockito.mock(Horse.class);
            mockedHorsesList.add(mockedHorse);
        }
        Hippodrome hippodromeTest = new Hippodrome(mockedHorsesList);
        hippodromeTest.move();
        for (Horse horse : mockedHorsesList) {
            verify(horse, times(1)).move();
        }

    }

    @Test
    void getWinnerTest() {
        List<Horse> horsesListTest = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            Horse horseTest = new Horse("horse" + i, i, i);
            horsesListTest.add(horseTest);
        }
        Hippodrome hippodromeTest = new Hippodrome(horsesListTest);
        assertEquals(hippodromeTest.getWinner(), horsesListTest.get(49));
    }
}