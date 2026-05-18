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
fun ActivityNavigation(viewModel: PatrimoineViewModel) {
    val navController = rememberNavController()

    // Le point de départ de l'application est l'accueil (EcranAccueil.kt)
    NavHost(navController = navController, startDestination = "accueil") {

        // Route : L'accueil
        composable("accueil") {
            EcranAccueil(
                onChoixCategorie = { categorie ->
                    // on filtre en fonction des catégories
                    viewModel.filterByCategory(categorie)
                    // on passe à l'écran avec la liste des éléments
                    navController.navigate("liste")
                }
            )
        }

        // Route : La liste
        composable("liste") {
            EcranListe (
                viewModel = viewModel, // le ViewModel qui contient les éléments
                onNavigateToDetail = { idElement ->
                    navController.navigate("detail/$idElement")
                },
                onNavigateBack = { navController.popBackStack() } // on enlève la page de l'élément de la pile
            )
        }

        // Route : Le détail
        composable("detail/{elementId}") { backStackEntry ->
            val idString = backStackEntry.arguments?.getString("elementId") // on récupère l'ID de l'élément cliqué
            val id = idString?.toIntOrNull()

            val elements by viewModel.elementsAffiches.collectAsState()
            val elementChoisi = elements.find { it.id == id }

            if (elementChoisi != null) { // Si l'ID correspond bien à un élément
                EcranDetail(
                    element = elementChoisi,
                    onNavigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}