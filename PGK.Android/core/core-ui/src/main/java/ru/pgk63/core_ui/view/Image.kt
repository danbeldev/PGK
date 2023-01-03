package ru.pgk63.core_ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import ru.pgk63.core_ui.view.shimmer.rememberAnimationShimmer

@Composable
fun ImageCoil(
    url:Any?,
    modifier: Modifier = Modifier,
    contentDescription:String? = null
) {
    SubcomposeAsyncImage(
        model = url,
        contentDescription = contentDescription,
        modifier = modifier
    ) {
        val state = painter.state
        if (
            state is AsyncImagePainter.State.Loading ||
            state is AsyncImagePainter.State.Error
        ) {
            ImageShimmer(modifier = modifier)
        } else {
            SubcomposeAsyncImageContent()
        }
    }
}

@Composable
private fun ImageShimmer(
    modifier: Modifier
){
    val brush = rememberAnimationShimmer()

    Spacer(
        modifier = modifier.background(brush)
    )
}