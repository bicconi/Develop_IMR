
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    Calculator cal;


    @Test
    void setTarget() {
        cal = new Calculator();
        cal.setTarget(0);
        assertEquals("0", cal.getTarget());
        cal.setTarget(1);
        assertEquals("1", cal.getTarget());
        cal.setTarget(2);
        assertEquals("12", cal.getTarget());
    }

    @Test
    void point() {
        cal = new Calculator();
        cal.point();
        assertEquals("0.", cal.getTarget());
        cal.point();
        assertEquals("0.", cal.getTarget());
    }

    @Test
    void calLogin() {
        cal = new Calculator();
        assertEquals("0", cal.calLogic(1));
        cal.setTarget(1);
        assertEquals("1", cal.calLogic(1));
        cal.setTarget(2);
        assertEquals("3", cal.calLogic(1));
        assertEquals("4", cal.calLogic(1));
    }

    @Test
    void ac() {
        cal = new Calculator();
        cal.calLogic(1);
        cal.setTarget(1);
        cal.calLogic(1);
        cal.setTarget(2);
        cal.calLogic(1);
        cal.calLogic(1);
        cal.ac();
        assertEquals("0", cal.getResult());
        assertEquals("0", cal.getTarget());
        assertEquals(-1, cal.getOption());
    }

    @Test
    void result() {
        cal = new Calculator();

    }

    @Test
    void isInteger() {
        cal = new Calculator();
        assertTrue(cal.isInteger(3.0));
        assertFalse(cal.isInteger(3.1));
    }
}