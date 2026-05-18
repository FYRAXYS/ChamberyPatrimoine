package com.example.chamberypatrimoine.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chamberypatrimoine.ui.screens.EcranDetail
import com.example.chamberypatrimoine.ui.screens.EcranAccueil
import com.example.chamberypatrimoine.ui.screens.EcranListe
import com.example.chamberypatrimoine.viewmodel.PatrimoineViewModel

@Composable
fun AppNavigation(viewModel: PatrimoineViewModel) {
    val navController = rememberNavController()

    // Le point de départ (startDestination) est maintenant "accueil"
    NavHost(navController = navController, startDestination = "accueil") {

        // Nouvelle Route : L'accueil avec les catégories
        composable("accueil") {
            EcranAccueil(
                onChoixCategorie = { categorie ->
                    // 1. On demande au ViewModel de filtrer la liste
                    viewModel.filterByCategory(categorie)
                    // 2. On passe à l'écran principal (la liste)
                    navController.navigate("liste")
                }
            )
        }

        // Route : La liste
        composable("liste") {
            EcranListe (
                viewModel = viewModel,
                onNavigateToDetail = { idElement ->
                    navController.navigate("detail/$idElement")
                },
                onNavigateBack = { navController.popBackStack() }
            )
        }

        // Route : Le détail
        composable("detail/{elementId}") { backStackEntry ->
            val idString = backStackEntry.arguments?.getString("elementId")
            val id = idString?.toIntOrNull()

            val elements by viewModel.elementsAffiches.collectAsState()
            val elementChoisi = elements.find { it.id == id }

            if (elementChoisi != null) {
                EcranDetail(
                    element = elementChoisi,
                    onNavigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}