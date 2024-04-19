package edu.cofc.android.calculator

import org.junit.Test
import org.junit.Assert.*

/**
 * Test various functions of the calculator engine.
 */
class CalculatorEngineTest {
    @Test
    fun testCalculatorEngine() {
        val calcEngine = CalculatorEngine()
        assertEquals(calcEngine.getDisplay(), "0")

        // inserting digits 1, 2, and 3
        calcEngine.insert('1')
        calcEngine.insert('2')
        calcEngine.insert('3')
        assertEquals("123", calcEngine.getDisplay())

        // performing ADD
        calcEngine.perform(Operation.ADD)
        assertEquals("123", calcEngine.getDisplay())

        // inserting digits 4, 5, and 6
        calcEngine.insert('4')
        calcEngine.insert('5')
        calcEngine.insert('6')
        assertEquals("456", calcEngine.getDisplay())

        // performing ADD
        calcEngine.perform(Operation.ADD)
        assertEquals("579", calcEngine.getDisplay())

        // Inserting digits 1, 1, and 0
        calcEngine.insert('1')
        calcEngine.insert('1')
        calcEngine.insert('0')
        assertEquals("110", calcEngine.getDisplay())

        // performing EQUALS
        calcEngine.perform(Operation.EQUALS)
        assertEquals("689", calcEngine.getDisplay())

        // inserting eleven digits and then toggling the sign
        calcEngine.insert('1')
        calcEngine.insert('2')
        calcEngine.insert('3')
        calcEngine.insert('4')
        calcEngine.insert('5')
        calcEngine.insert('6')
        calcEngine.insert('7')
        calcEngine.insert('8')
        calcEngine.insert('9')
        calcEngine.insert('0')
        calcEngine.insert('1')
        calcEngine.toggleSign()
        assertEquals("-12345678901", calcEngine.getDisplay())

        // toggling the sign once again
        calcEngine.toggleSign()
        assertEquals("12345678901", calcEngine.getDisplay())

        // clearing the calculator
        calcEngine.clear()
        assertEquals("0", calcEngine.getDisplay())

        // inserting 13 '9' digits
        calcEngine.insert('9')
        calcEngine.insert('9')
        calcEngine.insert('9')
        calcEngine.insert('9')
        calcEngine.insert('9')
        calcEngine.insert('9')
        calcEngine.insert('9')
        calcEngine.insert('9')
        calcEngine.insert('9')
        calcEngine.insert('9')
        calcEngine.insert('9')
        calcEngine.insert('9')
        calcEngine.insert('9')
        assertEquals("9999999999999", calcEngine.getDisplay())

        // clearing the calculator
        calcEngine.clear()
        assertEquals("0", calcEngine.getDisplay())

        // inserting 123456.789
        calcEngine.insert('1')
        calcEngine.insert('2')
        calcEngine.insert('3')
        calcEngine.insert('4')
        calcEngine.insert('5')
        calcEngine.insert('6')
        calcEngine.insert('.')
        calcEngine.insert('7')
        calcEngine.insert('8')
        calcEngine.insert('9')
        assertEquals("123456.789", calcEngine.getDisplay())

        // performing MULTIPLY
        calcEngine.perform(Operation.MULTIPLY)
        assertEquals("123456.789", calcEngine.getDisplay())
        // CalculatorEngine[accumulator=123456.789, display=123456.789, opPerformed=true, savedOp=MULTIPLY, hasErrors=false]

        // inserting digit 2
        calcEngine.insert('2')
        assertEquals("2", calcEngine.getDisplay())

        // performing EQUALS
        calcEngine.perform(Operation.EQUALS)
        assertEquals("246913.578", calcEngine.getDisplay())

        // performing ADD
        calcEngine.perform(Operation.ADD)
        assertEquals("246913.578", calcEngine.getDisplay())

        // inserting .1
        calcEngine.insert('.')
        calcEngine.insert('1')
        assertEquals("0.1", calcEngine.getDisplay())

        // performing EQUALS
        calcEngine.perform(Operation.EQUALS)
        assertEquals("246913.678", calcEngine.getDisplay())

        // clearing the calculator
        calcEngine.clear()
        assertEquals("0", calcEngine.getDisplay())

        // inserting 1
        calcEngine.insert('1')
        assertEquals("1", calcEngine.getDisplay())

        // performing DIVIDE
        calcEngine.perform(Operation.DIVIDE)
        assertEquals("1", calcEngine.getDisplay())

        // inserting 3
        calcEngine.insert('3')
        assertEquals("3", calcEngine.getDisplay())

        // performing EQUALS
        calcEngine.perform(Operation.EQUALS)
        assertEquals("0.3333333333333333", calcEngine.getDisplay())

        // clearing the calculator ...
        calcEngine.clear()
        assertEquals("0", calcEngine.getDisplay())

        // inserting 200
        calcEngine.insert('2')
        calcEngine.insert('0')
        calcEngine.insert('0')
        assertEquals("200", calcEngine.getDisplay())

        // performing DIVIDE
        calcEngine.perform(Operation.DIVIDE)
        assertEquals("200", calcEngine.getDisplay())

        // inserting 3
        calcEngine.insert('3')
        assertEquals("3", calcEngine.getDisplay())

        // performing EQUALS
        calcEngine.perform(Operation.EQUALS)
        assertEquals("66.66666666666667", calcEngine.getDisplay())

        // clearing the calculator
        calcEngine.clear()
        assertEquals("0", calcEngine.getDisplay())

        // inserting 1.3333333333333
        calcEngine.insert('1')
        calcEngine.insert('.')
        calcEngine.insert('3')
        calcEngine.insert('3')
        calcEngine.insert('3')
        calcEngine.insert('3')
        calcEngine.insert('3')
        calcEngine.insert('3')
        calcEngine.insert('3')
        calcEngine.insert('3')
        calcEngine.insert('3')
        calcEngine.insert('3')
        calcEngine.insert('3')
        calcEngine.insert('3')
        assertEquals("1.333333333333", calcEngine.getDisplay())

        // performing TIMES
        calcEngine.perform(Operation.MULTIPLY)
        assertEquals("1.333333333333", calcEngine.getDisplay())

        // inserting 2
        calcEngine.insert('2')
        assertEquals("2", calcEngine.getDisplay())

        // performing EQUALS
        calcEngine.perform(Operation.EQUALS)
        assertEquals("2.666666666666", calcEngine.getDisplay())
    }
}