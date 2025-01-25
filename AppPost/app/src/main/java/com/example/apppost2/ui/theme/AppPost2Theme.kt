package com.example.apppost2.ui.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val LightColorPalette = lightColorScheme(
    primary = Color(0xFF2196F3),         
    onPrimary = Color.White,
    primaryContainer = Color(0xFFBBDEFB), 
    onPrimaryContainer = Color(0xFF1976D2), 
    secondary = Color(0xFF64B5F6),       
    onSecondary = Color.Black,
    background = Color(0xFFF5F5F5),      
    onBackground = Color(0xFF1E1E1E),    
    surface = Color.White,
    onSurface = Color(0xFF1E1E1E),     
    tertiary = Color(0xFF42A5F5),        
    onTertiary = Color.White
)

@Composable
fun AppPost2Theme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorPalette,
        typography = Typography,
        content = content
    )
}