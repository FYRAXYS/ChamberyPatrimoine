package com.example.chamberypatrimoine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chamberypatrimoine.navigation.ActivityNavigation
import com.example.chamberypatrimoine.ui.theme.ChamberyPatrimoineTheme
import com.example.chamberypatrimoine.viewmodel.PatrimoineViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChamberyPatrimoineTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background //détermine la couleur du fond
                ) {

                    // créé ou récupère (si on change d'orientation) le ViewModel
                    val patrimoineViewModel: PatrimoineViewModel = viewModel()

                    // on passe le ViewModel à l'écran principal pour qu'il puisse observer les données
                    ActivityNavigation(viewModel = patrimoineViewModel)
                }
            }
        }
    }
}