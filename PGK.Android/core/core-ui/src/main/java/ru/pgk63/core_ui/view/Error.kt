package ru.pgk63.core_ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.pgk63.core_ui.theme.PgkTheme

@Composable
fun Error(message: String? = null) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BaseLottieAnimation(
            type = LottieAnimationType.ERROR,
            modifier = Modifier.fillMaxSize()
        )

        Spacer(modifier = Modifier.height(8.dp))

        if(message != null){
            Text(
                text = message,
                color = PgkTheme.colors.errorColor,
                fontFamily = PgkTheme.fontFamily.fontFamily,
                style = PgkTheme.typography.body,
                textAlign = TextAlign.Center
            )
        }
    }
}