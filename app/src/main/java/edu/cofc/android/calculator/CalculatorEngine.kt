package edu.cofc.android.calculator
import android.os.Bundle
import android.util.Log
import java.text.DecimalFormat

/**
 * Operations that can be performed by the calculator.
 */
enum class Operation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE, EQUALS, CLEAR, CLEAR_ENTRY, NO_OP
}

class CalculatorEngine {
    private val maxDisplayLength : Int = 22
    private var accumulator : Double = 0.0
    private val displayBldr = StringBuilder(maxDisplayLength).append('0')
    private var savedOp     : Operation = Operation.NO_OP
    private var opPerformed : Boolean = false
    private val formatter   = DecimalFormat("0")

    init {
        formatter.maximumFractionDigits = maxDisplayLength - 2
    }

    /**
     * Clear the calculator.  The accumulator is set to 0.0, and the
     * display is set to "0".
     */
    fun clear() {
        clearEntry()
        accumulator = 0.0
        savedOp = Operation.NO_OP
        opPerformed = false
    }

    /**
     * Clear the display; that is, set the display to "0".
     */
    fun clearEntry() {
        displayBldr.clear().append('0')
    }

    /**
     * Append a new character to the end of the display.  The new character
     * must be either a digit or a decimal point, and the number of characters
     * in the display must be less than the maximum display length;  otherwise
     * this method has no effect, and the input character is ignored.
     *
     * @param c  the character to be appended to the end of the display.
     */
    fun insert(c: Char) {
        if (opPerformed || displayBldr.length < maxDisplayLength) {
            if (opPerformed) {
                clearEntry()
                opPerformed = false
            }

            if (Character.isDigit(c)) {
                if (displayBldr.length == 1 && displayBldr[0] == '0')
                    displayBldr.setLength(0)
                displayBldr.append(c)
            }
            else if (c == '.') {
                displayBldr.append(c)
            }
        }
    }

    /**
     * Toggles the sign (+/-) of the display.
     */
    fun toggleSign() {
        val leadingChar = displayBldr[0]
        if (displayValue != 0.0) {
            if (leadingChar == '-')
                displayBldr.deleteCharAt(0)
            else if (displayBldr.length < maxDisplayLength)
                displayBldr.insert(0, '-')
        }
    }

    /**
     * Returns a string representation of the display.
     */
    fun getDisplay(): String = displayBldr.toString()

    /**
     * Returns a double representation of the display.
     */
    private val displayValue: Double
        get() = displayBldr.toString().toDouble()

    /**
     * Perform the specified operation.
     */
    fun perform(op: Operation) {
        if (savedOp != Operation.NO_OP) {
            when (savedOp) {
                Operation.ADD      -> accumulator += displayValue
                Operation.SUBTRACT -> accumulator -= displayValue
                Operation.MULTIPLY -> accumulator *= displayValue
                Operation.DIVIDE   -> accumulator /= displayValue
                else -> {}
            }
            setDisplay(accumulator)
            savedOp = Operation.NO_OP
        }

        when (op) {
            Operation.ADD, Operation.SUBTRACT, Operation.MULTIPLY, Operation.DIVIDE -> {
                accumulator = displayValue
                savedOp = op
            }
            Operation.EQUALS -> setDisplay(accumulator)
            Operation.CLEAR -> clear()
            Operation.CLEAR_ENTRY -> clearEntry()
            Operation.NO_OP -> {}
        }

        opPerformed = true
    }

    /**
     * Sets display to a string version of the specified value.
     */
    private fun setDisplay(value: Double) {
        var valueStr = formatter.format(value)
        if (valueStr.length > maxDisplayLength || value.isInfinite() || value.isNaN())
            valueStr = value.toString()

        if (valueStr.length > maxDisplayLength) {
            clear()
            displayBldr.clear().append("Error")
            Log.i("CalculatorEngine.setDisplay", "valueStr=$valueStr")
        }
        else {
            displayBldr.clear().append(valueStr)
        }
    }

    /**
     * Returns the state of this calculator engine as a Bundle.
     */
    fun getState(): Bundle {
        val state = Bundle()
        state.putDouble("accumulator", accumulator)
        state.putString("display", displayBldr.toString())
        state.putInt("savedOp", savedOp.ordinal)
        state.putBoolean("opPerformed", opPerformed)
        return state
    }

    /**
     * Initialize the state of the calculator engine with the specified bundle.
     */
    fun setState(bundle: Bundle) {
        accumulator = bundle.getDouble("accumulator")
        displayBldr.clear().append(bundle.getString("display"))
        savedOp     = Operation.values()[bundle.getInt("savedOp")]
        opPerformed = bundle.getBoolean("opPerformed")
    }

    override fun toString(): String =
        "CalculatorEngine[accumulator=$accumulator, display=$displayBldr" +
                ", opPerformed=$opPerformed, savedOp=$savedOp]"
}

/**
 * Clear the string builder (extension).
 */
fun StringBuilder.clear(): StringBuilder {
    this.delete(0, this.length)
    return this
}