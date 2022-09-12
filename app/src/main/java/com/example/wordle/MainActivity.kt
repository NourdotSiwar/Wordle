package com.example.wordle
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.backgroundColor
import androidx.core.text.color
import androidx.core.text.scale
import androidx.fragment.app.Fragment
import layout.FourLetterWordList.getRandomFourLetterWord

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var strValue = ""
        val button = findViewById<Button>(R.id.Guess)
        var guess1 = findViewById<TextView>(R.id.Guess1Output)
        var guess1check = findViewById<TextView>(R.id.Check1Output)
        var guess2 = findViewById<TextView>(R.id.Guess2Output)
        var guess2check = findViewById<TextView>(R.id.Check2Output)
        var guess3 = findViewById<TextView>(R.id.Guess3Output)
        var guess3check = findViewById<TextView>(R.id.Check3Output)
        var simpleEditText = findViewById<EditText>(R.id.UserInput)
        var wordToGuess = getRandomFourLetterWord().toString()
        var correctWord = findViewById<TextView>(R.id.CorrectWord)
        var winOrLoss = findViewById<TextView>(R.id.WinOrLose)
        var restartBtn = findViewById<Button>(R.id.Restart)
        correctWord.visibility = View.INVISIBLE
        winOrLoss.visibility = View.INVISIBLE
        restartBtn.visibility = View.INVISIBLE

        button.setOnClickListener()
        {
            strValue = simpleEditText.text.toString().uppercase()
            guess1.text = strValue
            guess1check.text = checkGuess(wordToGuess, strValue)
            hideKeyboard();
            simpleEditText.text.clear()

            if(strValue == wordToGuess)
            {
                winOrLoss.text = "YOU WON!"
                winOrLoss.visibility = View.VISIBLE
                correctWord.text = wordToGuess
                correctWord.visibility = View.VISIBLE
                button.isClickable = false;
                button.isEnabled = false;
                restartBtn.visibility = View.VISIBLE
            }

            button.setOnClickListener()
            {
                strValue = simpleEditText.text.toString().uppercase()
                guess2.text = strValue
                guess2check.text = checkGuess(wordToGuess, strValue)
                hideKeyboard();
                simpleEditText.text.clear()

                if(strValue == wordToGuess)
                {
                    winOrLoss.text = "YOU WON!"
                    winOrLoss.visibility = View.VISIBLE
                    correctWord.text = wordToGuess
                    correctWord.visibility = View.VISIBLE
                    button.isClickable = false;
                    button.isEnabled = false;
                    restartBtn.visibility = View.VISIBLE
                }

                button.setOnClickListener()
                {
                    strValue = simpleEditText.text.toString().uppercase()
                    guess3.text = strValue
                    guess3check.text = checkGuess(wordToGuess, strValue)
                    hideKeyboard();
                    simpleEditText.text.clear()
                    if(strValue == wordToGuess)
                    {
                        winOrLoss.text = "YOU WON!"
                        winOrLoss.visibility = View.VISIBLE
                        correctWord.text = wordToGuess
                        correctWord.visibility = View.VISIBLE
                        button.isClickable = false;
                        button.isEnabled = false;
                        restartBtn.visibility = View.VISIBLE
                    }
                    else if(strValue != wordToGuess)
                    {
                        winOrLoss.text = "You lost :("
                        winOrLoss.visibility = View.VISIBLE
                        correctWord.text = wordToGuess
                        correctWord.visibility = View.VISIBLE
                        button.isClickable = false;
                        button.isEnabled = false;
                        restartBtn.visibility = View.VISIBLE

                    }
                }
            }
        }

        restartBtn.setOnClickListener()
        {
            restartBtn.visibility = View.INVISIBLE
            guess1.text = ""
            guess1check.text = ""
            guess2.text = ""
            guess2check.text = ""
            guess3.text = ""
            guess3check.text = ""
            button.isClickable = true;
            button.isEnabled = true;
            winOrLoss.visibility = View.INVISIBLE
            correctWord.visibility = View.INVISIBLE

            button.setOnClickListener()
            {
                strValue = simpleEditText.text.toString().uppercase()
                guess1.text = strValue
                guess1check.text = checkGuess(wordToGuess, strValue)
                hideKeyboard();
                simpleEditText.text.clear()

                if (strValue == wordToGuess) {
                    winOrLoss.text = "YOU WON!"
                    winOrLoss.visibility = View.VISIBLE
                    correctWord.text = wordToGuess
                    correctWord.visibility = View.VISIBLE
                    button.isClickable = false;
                    button.isEnabled = false;
                    restartBtn.visibility = View.VISIBLE
                }

                button.setOnClickListener()
                {
                    strValue = simpleEditText.text.toString().uppercase()
                    guess2.text = strValue
                    guess2check.text = checkGuess(wordToGuess, strValue)
                    hideKeyboard();
                    simpleEditText.text.clear()

                    if (strValue == wordToGuess) {
                        winOrLoss.text = "YOU WON!"
                        winOrLoss.visibility = View.VISIBLE
                        correctWord.text = wordToGuess
                        correctWord.visibility = View.VISIBLE
                        button.isClickable = false;
                        button.isEnabled = false;
                        restartBtn.visibility = View.VISIBLE
                    }

                    button.setOnClickListener()
                    {
                        strValue = simpleEditText.text.toString().uppercase()
                        guess3.text = strValue
                        guess3check.text = checkGuess(wordToGuess, strValue)
                        hideKeyboard();
                        simpleEditText.text.clear()
                        if (strValue == wordToGuess) {
                            winOrLoss.text = "YOU WON!"
                            winOrLoss.visibility = View.VISIBLE
                            correctWord.text = wordToGuess
                            correctWord.visibility = View.VISIBLE
                            button.isClickable = false;
                            button.isEnabled = false;
                            restartBtn.visibility = View.VISIBLE
                        } else if (strValue != wordToGuess) {
                            winOrLoss.text = "You lost :("
                            winOrLoss.visibility = View.VISIBLE
                            correctWord.text = wordToGuess
                            correctWord.visibility = View.VISIBLE
                            button.isClickable = false;
                            button.isEnabled = false;
                            restartBtn.visibility = View.VISIBLE

                        }
                    }
                }
            }
        }


    }


}

/**
 * Parameters / Fields:
 *   wordToGuess : String - the target word the user is trying to guess
 *   guess : String - what the user entered as their guess
 *
 * Returns a String of 'O', '+', and 'X', where:
 *   'O' represents the right letter in the right place
 *   '+' represents the right letter in the wrong place
 *   'X' represents a letter not in the target word
 */
private fun checkGuess(wordToGuess: String, guess: String) : String {

    var result = ""
    for (i in 0..3) {
        if (guess[i] == wordToGuess[i]) {
            result += "O"
        } else if (guess[i] in wordToGuess) {
            result += "+"
        } else {
            result += "X"
        }
    }
    return result
}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}
