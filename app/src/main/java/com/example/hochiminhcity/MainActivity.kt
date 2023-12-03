package com.example.hochiminhcity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hochiminhcity.ui.CityApp
import com.example.hochiminhcity.ui.theme.HoChiMinhCityTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HoChiMinhCityTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowSize = calculateWindowSizeClass(activity = this)
                    CityApp(windowSize = windowSize.widthSizeClass)
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun HoChiMinhCityCompactPreview() {
    HoChiMinhCityTheme {
        CityApp(windowSize = WindowWidthSizeClass.Compact)
    }
}
@Preview(showBackground = true, widthDp = 700)
@Composable
fun HoChiMinhCityMediumPreview() {
    HoChiMinhCityTheme {
        CityApp(windowSize = WindowWidthSizeClass.Medium)
    }
}
@Preview(showBackground = true, widthDp = 1000)
@Composable
fun HoChiMinhCityExpandedPreview() {
    HoChiMinhCityTheme {
        CityApp(windowSize = WindowWidthSizeClass.Expanded)
    }
}