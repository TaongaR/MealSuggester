# 🍽️ Meal Suggester App

A native Android app built with Kotlin to help users quickly decide what to eat based on the time of day. Designed for simplicity and fun, this app offers meal suggestions using intuitive input and clean logic.

## 📱 Overview

Your friend Hera often struggles with meal decisions during busy days. This app solves that by suggesting meals based on user-input time periods like "Morning", "Afternoon", or "Dinner". It’s lightweight, engaging, and built with maintainability in mind.

## 🎯 Features

- **Text Input**: Users can enter a time of day (e.g., "Morning", "Afternoon", "Dinner").
- **Meal Suggestions**: Displays predefined meals based on input using simple `if` statements.
- **Reset Button**: Clears input and suggestion for a fresh start.
- **Error Handling**: Provides motivational feedback for invalid entries.
- **Responsive UI**: Clean layout using ConstraintLayout for modern Android design.

## 🍽️ Meal Logic

| Time of Day           | Suggested Meal                     |
|-----------------------|------------------------------------|
| Morning               | Pancakes, Smoothie                 |
| Mid-morning snack     | Fruit and yoghurt                  |
| Afternoon             | Sandwich, Salad                    |
| Afternoon snack       | Cookies and milk                   |
| Dinner                | Pasta, Stir Fry                    |
| After dinner snack    | Ice cream, Fruit salad             |

## 🛠️ Tech Stack

- **Language**: Kotlin  
- **IDE**: Android Studio  
- **Version Control**: Git + GitHub  
- **CI/CD**: GitHub Actions for automated builds and testing  
Respository
https://github.com/TaongaR/MealSuggester
  License
  This project is open-source under the MIT License
  Source code
  <?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="24dp">

    <EditText
        android:id="@+id/timeInput"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Enter time of day (e.g., Morning)"
        android:inputType="textPersonName"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"/>

    <Button
        android:id="@+id/suggestButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Suggest Meal"
        app:layout_constraintTop_toBottomOf="@+id/timeInput"
        app:layout_constraintStart_toStartOf="@+id/timeInput"
        android:layout_marginTop="16dp"/>

    <Button
        android:id="@+id/resetButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Reset"
        app:layout_constraintTop_toBottomOf="@+id/timeInput"
        app:layout_constraintEnd_toEndOf="@+id/timeInput"
        android:layout_marginTop="16dp"/>

    <TextView
        android:id="@+id/suggestionView"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="Your meal will appear here"
        android:textSize="18sp"
        android:gravity="center"
        android:paddingTop="32dp"
        app:layout_constraintTop_toBottomOf="@+id/suggestButton"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>
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
