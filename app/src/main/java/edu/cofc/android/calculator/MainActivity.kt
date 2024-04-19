package edu.cofc.android.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.cofc.android.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var calculatorEngine = CalculatorEngine()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.CButton.setOnClickListener{
        calculatorEngine.clear()
        binding.calcAnswerTextView.text  = calculatorEngine.getDisplay()
        }

        binding.CEButton.setOnClickListener{
        calculatorEngine.clearEntry()
        binding.calcAnswerTextView.text  = calculatorEngine.getDisplay()
        }

        binding.toggleButton.setOnClickListener{
            calculatorEngine.toggleSign()
            binding.calcAnswerTextView.text  = calculatorEngine.getDisplay()
        }
        binding.divideButton.setOnClickListener{
            calculatorEngine.perform(Operation.DIVIDE)
            binding.calcAnswerTextView.text  = calculatorEngine.getDisplay()

        }
        binding.addButton.setOnClickListener{
            calculatorEngine.perform(Operation.ADD)
            binding.calcAnswerTextView.text  = calculatorEngine.getDisplay()

        }

        binding.subButton.setOnClickListener{
            calculatorEngine.perform(Operation.SUBTRACT)
            binding.calcAnswerTextView.text  = calculatorEngine.getDisplay()

        }
        binding.multButton.setOnClickListener{
            calculatorEngine.perform(Operation.MULTIPLY)
            binding.calcAnswerTextView.text  = calculatorEngine.getDisplay()

        }
        binding.dotButton.setOnClickListener{
            calculatorEngine.insert('.')
            binding.calcAnswerTextView.text  = calculatorEngine.getDisplay()

        }
        binding.equalsButton.setOnClickListener{
            calculatorEngine.perform(Operation.EQUALS)
            binding.calcAnswerTextView.text  = calculatorEngine.getDisplay()
        }

        binding.num0Button.setOnClickListener{
            calculatorEngine.insert('0')
            binding.calcAnswerTextView.text  = calculatorEngine.getDisplay()
        }

        binding.num1Button.setOnClickListener{
         calculatorEngine.insert('1')
         binding.calcAnswerTextView.text  = calculatorEngine.getDisplay()


        }
        binding.num2Button.setOnClickListener{
            calculatorEngine.insert('2')
            binding.calcAnswerTextView.text  = calculatorEngine.getDisplay()
        }
        binding.num3Button.setOnClickListener{
            calculatorEngine.insert('3')
            binding.calcAnswerTextView.text  = calculatorEngine.getDisplay()

        }
        binding.num4Button.setOnClickListener{
            calculatorEngine.insert('4')
            binding.calcAnswerTextView.text  = calculatorEngine.getDisplay()

        }
        binding.num5Button.setOnClickListener{
            calculatorEngine.insert('5')
            binding.calcAnswerTextView.text  = calculatorEngine.getDisplay()

        }
        binding.num6Button.setOnClickListener{
            calculatorEngine.insert('6')
            binding.calcAnswerTextView.text  = calculatorEngine.getDisplay()

        }
        binding.num7Button.setOnClickListener{
            calculatorEngine.insert('7')
            binding.calcAnswerTextView.text  = calculatorEngine.getDisplay()
        }
        binding.num8Button.setOnClickListener{
            calculatorEngine.insert('8')
            binding.calcAnswerTextView.text  = calculatorEngine.getDisplay()
        }
        binding.num9Button.setOnClickListener{
            calculatorEngine.insert('9')
            binding.calcAnswerTextView.text  = calculatorEngine.getDisplay()
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putAll(calculatorEngine.getState())
        binding.calcAnswerTextView.text  = calculatorEngine.getDisplay()
    }


    override fun onRestoreInstanceState(inState: Bundle) {
        super.onRestoreInstanceState(calculatorEngine.getState())
        calculatorEngine.setState(inState)
        binding.calcAnswerTextView.text  = calculatorEngine.getDisplay()
    }
}
