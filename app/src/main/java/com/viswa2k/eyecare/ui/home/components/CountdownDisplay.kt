package com.viswa2k.eyecare.ui.home.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.viswa2k.eyecare.domain.TimerState
import com.viswa2k.eyecare.ui.theme.EyeCareTheme

@Composable
fun CountdownDisplay(
    timerState: TimerState,
    modifier: Modifier = Modifier
) {
    val animatedProgress by animateFloatAsState(
        targetValue = timerState.progress,
        animationSpec = tween(durationMillis = 1000, easing = LinearEasing),
        label = "countdown_display"
    )

    val primaryColor = MaterialTheme.colorScheme.primary
    val primaryLight = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
    val surfaceVariantColor = MaterialTheme.colorScheme.surfaceVariant

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(240.dp)
    ) {
        Canvas(modifier = Modifier.size(240.dp)) {
            val strokeWidth = 16.dp.toPx()

            // Background track
            drawArc(
                color = surfaceVariantColor,
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )

            // Gradient progress arc
            drawArc(
                brush = Brush.sweepGradient(
                    colors = listOf(primaryLight, primaryColor)
                ),
                startAngle = -90f,
                sweepAngle = 360f * animatedProgress,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = String.format(
                    "%02d:%02d",
                    timerState.remainingMinutes,
                    timerState.remainingSecondsInMinute
                ),
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "until next break",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CountdownDisplayPreview() {
    EyeCareTheme {
        CountdownDisplay(
            timerState = TimerState(
                remainingMillis = 6 * 60 * 1000L + 25 * 1000L,
                totalMillis = 20 * 60 * 1000L,
                isRunning = true,
                cycleCount = 2
            )
        )
    }
}
