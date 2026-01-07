package com.hmw.decideease.ui.wheels

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.unit.dp
import com.hmw.decideease.domain.decisionwheel.model.WheelOption
import com.hmw.decideease.domain.decisionwheel.usecase.SpinWheelUseCase
import androidx.compose.animation.core.*
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun WheelComposable(
    options: List<WheelOption>,
    spinWheelUseCase: SpinWheelUseCase,
    onSpinComplete: (WheelOption) -> Unit
) {
    var targetRotation by remember { mutableStateOf(0f) }
    val rotationAnim by animateFloatAsState(
        targetValue = targetRotation,
        animationSpec = tween(durationMillis = 2500, easing = FastOutSlowInEasing)
    )

    val sliceColors = listOf(
        Color(0xFFFF5252), Color(0xFFFFC107), Color(0xFF4CAF50),
        Color(0xFF2196F3), Color(0xFF9C27B0), Color(0xFFFF9800),
        Color(0xFF00BCD4), Color(0xFFE91E63), Color(0xFF8BC34A),
        Color(0xFFFF5722), Color(0xFF3F51B5), Color(0xFFCDDC39)
    )

    var spinResult by remember { mutableStateOf<WheelOption?>(null) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(top = 32.dp)
    ) {
        // Pointer triangle (rotated 180°)
        Canvas(modifier = Modifier.size(32.dp)) {
            val path = Path().apply {
                moveTo(size.width / 2f, size.height) // bottom
                lineTo(0f, 0f) // top left
                lineTo(size.width, 0f) // top right
                close()
            }
            drawPath(path, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Wheel Canvas
        Box(
            modifier = Modifier.size(300.dp),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val radius = size.minDimension / 2f
                val sliceAngle = 360f / options.size

                options.forEachIndexed { index, option ->
                    val startAngle = index * sliceAngle + rotationAnim

                    // Draw slice
                    drawArc(
                        color = sliceColors[index % sliceColors.size],
                        startAngle = startAngle,
                        sweepAngle = sliceAngle,
                        useCenter = true
                    )

                    // Draw radial text
                    withTransform({
                        rotate(startAngle + sliceAngle / 2f, pivot = center)
                    }) {
                        val textRadius = radius * 0.65f
                        val x = center.x
                        val y = center.y - textRadius
                        drawContext.canvas.nativeCanvas.apply {
                            val paint = android.graphics.Paint().apply {
                                textSize = 32f
                                color = android.graphics.Color.BLACK
                                textAlign = android.graphics.Paint.Align.CENTER
                            }

                            // Flip text for bottom half
                            val angleForFlip = (startAngle + sliceAngle / 2f) % 360
                            save()
                            if (angleForFlip in 90f..270f) {
                                rotate(180f, x, y)
                            }
                            drawText(option.label, x, y, paint)
                            restore()
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Spin button
        Button(
            onClick = {
                val result = spinWheelUseCase.spin(options).selectedDecision
                spinResult = result
                onSpinComplete(result)

                // Rotate wheel so result lands under pointer
                val sliceAngle = 360f / options.size
                val targetIndex = options.indexOf(result)
                val extraSpins = 5
                targetRotation += extraSpins * 360f + targetIndex * sliceAngle
            },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text("Spin Wheel", color = Color.White)
        }

        // Show result below button
        spinResult?.let { result ->
            Text(
                text = "You got: ${result.label}",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

// TODO: Fix wheel styling so that the text is at an angle like this reference image: https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6fgbp-gWa-48guyVF1Jm7Uh0h6QnkYiTUfQ&s
// TODO: Fix so that that the wheel does not land on the center line between two sections on a spin
// TODO: Fix selection text so that is comes up after the wheel finishes spinning
// TODO: Lower triangle indicator by a small amount
// TODO (optional): Update UI so that is is more engaging (borders/lights)
