package ru.pgk63.core_ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp

data class PgkColors(
    val primaryText: Color,
    val primaryBackground: Color,
    val secondaryText: Color,
    val secondaryBackground: Color,
    val tintColor: Color,
    val drawerBackground: Color,
    val controlColor: Color,
    val errorColor: Color
)

data class PgkTypography(
    val heading: TextStyle,
    val body: TextStyle,
    val toolbar: TextStyle,
    val caption: TextStyle
)

data class PgkShape(
    val padding: Dp,
    val cornersStyle: Shape
)

data class PgkFontFamily(
    val fontFamily: FontFamily
)

object PgkTheme {
    val colors: PgkColors
        @Composable
        get() = LocalPgkHabitColors.current
    val typography: PgkTypography
        @Composable
        get() = LocalPgkHabitTypography.current
    val shapes: PgkShape
        @Composable
        get() = LocalPgkHabitShape.current
    val fontFamily:PgkFontFamily
        @Composable
        get() = LocalPgkFontFamily.current
}

enum class PgkStyle {
    Purple, Orange, Blue, Red, Green, Yellow
}

enum class PgkSize {
    Small, Medium, Big
}

enum class PgkCorners {
    Flat, Rounded
}

enum class PgkFont {
    Cursive, Serif, Default, Monospace, SansSerif
}

val LocalPgkHabitColors = staticCompositionLocalOf<PgkColors> {
    error("No colors provided")
}

val LocalPgkHabitTypography = staticCompositionLocalOf<PgkTypography> {
    error("No font provided")
}

val LocalPgkHabitShape = staticCompositionLocalOf<PgkShape> {
    error("No shapes provided")
}

val LocalPgkFontFamily = staticCompositionLocalOf<PgkFontFamily> {
    error("No font family provided")
}