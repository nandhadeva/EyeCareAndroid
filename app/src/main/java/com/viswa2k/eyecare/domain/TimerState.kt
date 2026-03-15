package com.viswa2k.eyecare.domain

data class TimerState(
    val remainingMillis: Long = CYCLE_DURATION_MILLIS,
    val totalMillis: Long = CYCLE_DURATION_MILLIS,
    val isRunning: Boolean = false,
    val cycleCount: Int = 0
) {
    val remainingSeconds: Int get() = (remainingMillis / 1000).toInt()
    val remainingMinutes: Int get() = remainingSeconds / 60
    val remainingSecondsInMinute: Int get() = remainingSeconds % 60
    val progress: Float get() = if (totalMillis > 0) remainingMillis.toFloat() / totalMillis else 0f

    companion object {
        const val CYCLE_DURATION_MILLIS = 20 * 60 * 1000L // 20 minutes
    }
}
