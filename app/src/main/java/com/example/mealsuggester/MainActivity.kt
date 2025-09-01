package com.example.mealsuggester

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var timeInput: EditText
    private lateinit var suggestionView: TextView
    private lateinit var suggestButton: Button
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeInput = findViewById(R.id.timeInput)
        suggestionView = findViewById(R.id.suggestionView)
        suggestButton = findViewById(R.id.suggestButton)
        resetButton = findViewById(R.id.resetButton)

        suggestButton.setOnClickListener { suggestMeal() }
        resetButton.setOnClickListener { resetFields() }
    }

    private fun suggestMeal() {
        val input = timeInput.text.toString().trim().lowercase()
        val suggestion = when (input) {
            "morning" -> "Breakfast ideas: Pancakes or Smoothie"
            "mid-morning snack" -> "Light snack: Fruit and yoghurt"
            "afternoon" -> "Lunch options: Sandwich or Salad"
            "afternoon snack" -> "Quick bites: Cookies and milk"
            "dinner" -> "Main course: Pasta or Stir Fry"
            "after dinner snack" -> "Dessert: Ice cream or Fruit salad"
            else -> {
                suggestionView.text = "Please enter a valid time of day."
                return
            }
        }
        suggestionView.text = suggestion
    }

    private fun resetFields() {
        timeInput.text.clear()
        suggestionView.text = "Your meal will appear here"
    }
}