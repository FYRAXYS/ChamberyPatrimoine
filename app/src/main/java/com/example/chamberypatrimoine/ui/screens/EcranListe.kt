package com.example.chamberypatrimoine.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.chamberypatrimoine.model.ElementPatrimoine
import com.example.chamberypatrimoine.viewmodel.PatrimoineViewModel

@Composable
fun EcranListe(
    viewModel: PatrimoineViewModel,
    onNavigateToDetail: (Int) -> Unit,
    onNavigateBack: () -> Unit
) {
    val elements by viewModel.elementsAffiches.collectAsState()


    // Astuce : On récupère le nom de la catégorie depuis le premier élément de la liste
    val nomCategorie = elements.firstOrNull()?.categorie?.label ?: "Tous les éléments"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background) // Le fond général devient Jaune Pâle
            .statusBarsPadding()
        //.verticalScroll(rememberScrollState())
    ) {
        // --- 1. L'EN-TÊTE (Header) ---
        Surface(
            color = MaterialTheme.colorScheme.surface,
            shadowElevation = 8.dp, // Ajoute une petite ombre sous la barre
            modifier = Modifier
                .fillMaxWidth()
                .zIndex(1f)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Le bouton avec les angles moins arrondis
                Button(
                    onClick = onNavigateBack,
                    shape = RoundedCornerShape(4.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text("Retour à l'accueil", fontWeight = FontWeight.Bold)
                }

                // La ligne de séparation verticale
                HorizontalDivider(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .height(32.dp)
                        .width(1.dp), thickness = DividerDefaults.Thickness, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
                )

                // Le titre de la catégorie
                Text(
                    text = nomCategorie,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        // --- 2. LA LISTE ---
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(elements) { element ->
                CartePatrimoine(element = element, onClick = { onNavigateToDetail(element.id) })
            }
        }
    }
}

@Composable
fun CartePatrimoine(element: ElementPatrimoine, onClick: () -> Unit) {
    // La carte est maintenant blanche avec une légère bordure grise
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(4.dp), // Coins légèrement arrondis comme la maquette
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)), // Bordure gris clair
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        // Remplacement de Column par Row pour mettre texte à gauche, image à droite
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top // Aligne le contenu en haut
        ) {

            // -- PARTIE GAUCHE (Textes) --
            Column(
                modifier = Modifier
                    .weight(1f) // Prend tout l'espace disponible avant l'image
                    .padding(end = 16.dp)
            ) {
                Text(
                    text = element.nom,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = element.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 3, // Coupe le texte s'il est trop long avec des "..."
                    overflow = TextOverflow.Ellipsis
                )
            }

            // -- PARTIE DROITE (Image carrée) --
            if (element.idImageRessource != null) {
                Image(
                    painter = painterResource(id = element.idImageRessource),
                    contentDescription = "Image de ${element.nom}",
                    modifier = Modifier
                        .size(100.dp) // Force l'image à être un carré parfait
                        .background(MaterialTheme.colorScheme.onSurface), // Fond gris si l'image a de la transparence
                    contentScale = ContentScale.Crop // Recadre l'image pour remplir le carré
                )
            } else {
                // Petit bloc gris de remplacement si l'élément n'a pas d'image
                // (correspond au carré vide de ta maquette)
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color(0xFFEAEAEA))
                ) {
                    // On pourrait ajouter une icône ici plus tard
                }
            }
        }
    }
}