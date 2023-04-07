package com.blissvine.dietapp.models

import android.graphics.Color
import android.graphics.drawable.Drawable

data class DietPlanModel (
    val name: String,
    val kcalValue: String,
    val preparationTime: String,
    val difficulty: String,
    val steps: String,
    val colorPrimary: Int,
    val colorSecondary: Int,
    val stepsColor: String,
//    val textEasyColor: Color,
//    val textMediumColor: Color,
    val image: String,

        )