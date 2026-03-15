package com.viswa2k.eyecare.ui.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.viswa2k.eyecare.data.db.entity.DailyStats
import com.viswa2k.eyecare.ui.theme.EyeCareTheme

@Composable
fun QuickStatsCard(
    todayStats: DailyStats?,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatItem(
                value = "${todayStats?.breaksTaken ?: 0}",
                label = "Breaks"
            )
            StatItem(
                value = "${todayStats?.totalCycles ?: 0}",
                label = "Cycles"
            )
            StatItem(
                value = "${todayStats?.breaksSkipped ?: 0}",
                label = "Skipped"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun QuickStatsCardPreview() {
    EyeCareTheme {
        QuickStatsCard(
            todayStats = DailyStats(
                date = "2026-03-15",
                breaksTaken = 5,
                breaksSkipped = 1,
                totalCycles = 6
            )
        )
    }
}

@Composable
private fun StatItem(
    value: String,
    label: String
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
