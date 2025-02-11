package com.rsstudio.machinecodinground.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.rsstudio.machinecodinground.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

object Fonts {
    val poppinsBold = FontFamily(
        Font(R.font.poppins_bold, FontWeight.Bold)
    )

    val poppinsRegular = FontFamily(
        Font(R.font.poppins_regular, FontWeight.Normal)
    )

    val poppinsMedium = FontFamily(
        Font(R.font.poppins_medium, FontWeight.Medium)
    )
    val poppinsSemiBold = FontFamily(
        Font(R.font.poppins_semibold, FontWeight.SemiBold)
    )
}

val Typography.ht1: TextStyle
    get() = TextStyle(
        fontFamily = Fonts.poppinsBold,
        fontSize = 28.sp,
        color = lightBlack
    )

val Typography.subTitle: TextStyle
    get() = TextStyle(
        fontFamily = Fonts.poppinsRegular,
        fontSize = 14.sp,
        color = black70
    )

val Typography.label: TextStyle
    get() = TextStyle(
        fontFamily = Fonts.poppinsMedium,
        fontSize = 14.sp,
        color = black70
    )
val Typography.ht2: TextStyle
    get() = TextStyle(
        fontFamily = Fonts.poppinsSemiBold,
        fontSize = 14.sp,
        color = gray70
    )