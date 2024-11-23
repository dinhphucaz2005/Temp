package com.example.temp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.temp.R


val Roboto = FontFamily(
    Font(R.font.roboto_black, FontWeight.Black),
    Font(R.font.roboto_black_italic, FontWeight.Black, FontStyle.Italic),
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.roboto_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.roboto_light, FontWeight.Light),
    Font(R.font.roboto_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.roboto_regular, FontWeight.Medium),
    Font(R.font.roboto_thin, FontWeight.Thin),
    Font(R.font.roboto_thin_italic, FontWeight.Thin, FontStyle.Italic)
)

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Black,
        fontSize = 28.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Black,
        fontSize = 20.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Black,
        fontSize = 16.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Black,
        fontSize = 14.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Black,
        fontSize = 12.sp
    )
)
