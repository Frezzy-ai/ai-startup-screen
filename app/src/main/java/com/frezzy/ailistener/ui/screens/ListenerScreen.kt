package com.frezzy.ailistener.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.frezzy.ailistener.ui.theme.*

@Composable
fun ListenerScreen() {
    val infiniteTransition = rememberInfiniteTransition(label = "main")
    
    // Rotation animations for rings
    val rotation1 by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(12000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "ring1"
    )
    
    val rotation2 by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = -360f,
        animationSpec = infiniteRepeatable(
            animation = tween(14000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "ring2"
    )
    
    val rotation3 by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(18000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "ring3"
    )
    
    // Pulse animation for orb
    val orbScale by infiniteTransition.animateFloat(
        initialValue = 0.98f,
        targetValue = 1.03f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = EaseInOutQuad),
            repeatMode = RepeatMode.Reverse
        ),
        label = "orb_pulse"
    )
    
    // Core flicker
    val coreScale by infiniteTransition.animateFloat(
        initialValue = 0.96f,
        targetValue = 1.06f,
        animationSpec = infiniteRepeatable(
            animation = tween(2500, easing = EaseInOutQuad),
            repeatMode = RepeatMode.Reverse
        ),
        label = "core_flicker"
    )
    
    var latency by remember { mutableStateOf("12ms") }
    var signal by remember { mutableStateOf("98%") }
    var waveHeights by remember { mutableStateOf(List(15) { 12 }) }
    
    LaunchedEffect(Unit) {
        while (true) {
            kotlinx.coroutines.delay(1200)
            latency = (8..18).random().toString() + "ms"
            signal = (94..100).random().toString() + "%"
        }
    }
    
    LaunchedEffect(Unit) {
        while (true) {
            kotlinx.coroutines.delay(700)
            waveHeights = List(15) { (12..72).random() }
        }
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFF0a2d5d).copy(alpha = 0.15f),
                        DarkBg
                    ),
                    center = androidx.compose.ui.geometry.Offset(
                        0.5f * 1000,
                        0.35f * 1000
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(CyanNeon, PurpleNeon)
                                )
                            )
                            .shadow(8.dp, CircleShape)
                    )
                    Text(
                        "NEXA / AI LISTENER",
                        fontSize = 11.sp,
                        color = Color(0xFF94c5d8),
                        letterSpacing = 0.22.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                
                // Status indicator
                Row(
                    modifier = Modifier
                        .border(1.dp, Color(0xFF67f0ff).copy(alpha = 0.26f), RoundedCornerShape(999.dp))
                        .background(Color(0xFF081f27).copy(alpha = 0.45f), RoundedCornerShape(999.dp))
                        .padding(8.dp, 8.dp, 12.dp, 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(GreenNeon)
                            .shadow(7.dp, CircleShape)
                    )
                    Text(
                        "Online",
                        fontSize = 10.sp,
                        color = Color(0xFF94c5d8)
                    )
                }
            }
            
            // Center Scene - Orb with Rings
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier.size(300.dp),
                    contentAlignment = Alignment.Center
                ) {
                    // Ring 1
                    Box(
                        modifier = Modifier
                            .size(300.dp)
                            .border(1.dp, CyanNeon.copy(alpha = 0.35f), CircleShape)
                            .rotate(rotation1)
                    )
                    
                    // Ring 2
                    Box(
                        modifier = Modifier
                            .size(234.dp)
                            .border(1.dp, CyanNeon.copy(alpha = 0.35f), CircleShape)
                            .rotate(rotation2)
                    )
                    
                    // Ring 3
                    Box(
                        modifier = Modifier
                            .size(168.dp)
                            .border(1.dp, CyanNeon.copy(alpha = 0.35f), CircleShape)
                            .rotate(rotation3)
                    )
                    
                    // Main Orb
                    Box(
                        modifier = Modifier
                            .size(230.dp)
                            .clip(CircleShape)
                            .background(
                                brush = Brush.radialGradient(
                                    colors = listOf(
                                        Color.White.copy(alpha = 0.9f),
                                        CyanNeon.copy(alpha = 0.62f),
                                        BlueNeon.copy(alpha = 0.4f),
                                        Color.Black.copy(alpha = 0.15f)
                                    )
                                )
                            )
                            .border(1.dp, PurpleNeon.copy(alpha = 0.35f), CircleShape)
                            .shadow(30.dp, CircleShape)
                            .scaleAnimate(orbScale),
                        contentAlignment = Alignment.Center
                    ) {
                        // Core
                        Box(
                            modifier = Modifier
                                .size(96.dp)
                                .clip(CircleShape)
                                .background(
                                    brush = Brush.radialGradient(
                                        colors = listOf(
                                            Color.White.copy(alpha = 0.95f),
                                            CyanNeon.copy(alpha = 0.75f),
                                            BlueNeon.copy(alpha = 0.35f),
                                            Color.Black.copy(alpha = 0.15f)
                                        )
                                    )
                                )
                                .border(1.dp, Color.White.copy(alpha = 0.36f), CircleShape)
                                .shadow(15.dp, CircleShape)
                                .scaleAnimate(coreScale)
                        )
                    }
                }
                
                // Center Text
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Text(
                        "NEURAL INTERFACE",
                        fontSize = 11.sp,
                        color = Color(0xFF94c5d8),
                        letterSpacing = 0.5.sp
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    Text(
                        "Listening",
                        fontSize = 52.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFe7fbff),
                        letterSpacing = 0.18.sp
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        "Autonomous cognition online",
                        fontSize = 14.sp,
                        color = Color(0xFFa0d6e9).copy(alpha = 0.8f),
                        letterSpacing = 0.14.sp
                    )
                }
                
                // Data Dashboard
                Row(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DataPanel("Latency", latency)
                    Spacer(modifier = Modifier.width(18.dp))
                    DataPanel("Signal", signal)
                }
            }
            
            // Wave visualization
            Row(
                modifier = Modifier.height(80.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                waveHeights.forEachIndexed { index, height ->
                    Box(
                        modifier = Modifier
                            .width(7.dp)
                            .height(height.dp)
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(CyanNeon, BlueNeon)
                                ),
                                shape = RoundedCornerShape(999.dp)
                            )
                            .shadow(9.dp)
                    )
                    if (index < waveHeights.size - 1) {
                        Spacer(modifier = Modifier.width(6.dp))
                    }
                }
            }
            
            // Bottom Bar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Prompt
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .border(1.dp, CyanNeon.copy(alpha = 0.14f), RoundedCornerShape(12.dp))
                        .background(Color(0xFF0a1622).copy(alpha = 0.54f), RoundedCornerShape(12.dp))
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(">", color = Color(0xFF94c5d8), fontSize = 10.sp)
                    Text(
                        "Activate voice protocol / await command",
                        color = Color(0xFF94c5d8),
                        fontSize = 10.sp,
                        letterSpacing = 0.12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                
                Spacer(modifier = Modifier.width(12.dp))
                
                // Action Buttons
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .border(1.dp, CyanNeon.copy(alpha = 0.24f), RoundedCornerShape(999.dp))
                            .height(44.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF091e22).copy(alpha = 0.7f)
                        ),
                        shape = RoundedCornerShape(999.dp)
                    ) {
                        Text(
                            "Standby",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.18.sp,
                            color = Color(0xFFe7fbff)
                        )
                    }
                    
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .border(1.dp, CyanNeon.copy(alpha = 0.5f), RoundedCornerShape(999.dp))
                            .height(44.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF0a2d5d).copy(alpha = 0.18f)
                        ),
                        shape = RoundedCornerShape(999.dp)
                    ) {
                        Text(
                            "Engage",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.18.sp,
                            color = Color(0xFFe7fbff)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DataPanel(label: String, value: String) {
    Box(
        modifier = Modifier
            .border(1.dp, CyanNeon.copy(alpha = 0.2f), RoundedCornerShape(14.dp))
            .background(Color(0xFF081824).copy(alpha = 0.62f), RoundedCornerShape(14.dp))
            .padding(12.dp, 12.dp, 16.dp, 12.dp)
    ) {
        Column {
            Text(
                label,
                fontSize = 10.sp,
                color = Color(0xFF94c5d8),
                letterSpacing = 0.2.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp)
            )
            Text(
                value,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFe7fbff),
                letterSpacing = 0.06.sp,
                modifier = Modifier.padding(start = 16.dp, top = 6.dp)
            )
        }
    }
}

fun Modifier.scaleAnimate(scale: Float): Modifier =
    this.graphicsLayer(scaleX = scale, scaleY = scale)
