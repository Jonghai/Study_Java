package work01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddNumberTest {

    @Test
    void add() {
        AddNumber addNumber = new AddNumber();
        assertEquals(addNumber.add(8,9),17);
    }

    @Test
    void testAdd() {
        AddNumber addNumber = new AddNumber();
        assertEquals(addNumber.add(2,3,4),9);
    }
}