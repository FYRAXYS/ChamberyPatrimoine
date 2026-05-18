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
import androidx.compose.ui.res.stringResource
import com.example.chamberypatrimoine.R
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


    // on récupère le nom de la catégorie depuis le premier élément de la liste
    val nomCategorie = elements.firstOrNull()?.categorie?.label ?: stringResource(id = R.string.titre_tous_elements)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
    ) {
        // Bandeau au sommet de l'écran
        Surface(
            color = MaterialTheme.colorScheme.surface,
            shadowElevation = 8.dp,
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
                Button(
                    onClick = onNavigateBack,
                    shape = RoundedCornerShape(4.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(stringResource(id = R.string.btn_retour_accueil), fontWeight = FontWeight.Bold)
                }

                HorizontalDivider(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .height(32.dp)
                        .width(1.dp), thickness = DividerDefaults.Thickness, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
                )

                // titre de la catégorie
                Text(
                    text = nomCategorie,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        // Liste des éléments
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
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {

            Column(
                modifier = Modifier
                    .weight(1f)
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
                    maxLines = 3, // Coupe le texte s'il est trop long
                    overflow = TextOverflow.Ellipsis
                )
            }

            if (element.idImageRessource != null) {
                Image(
                    painter = painterResource(id = element.idImageRessource),
                    contentDescription = stringResource(id = R.string.cd_image_patrimoine, element.nom),
                    modifier = Modifier
                        .size(100.dp)
                        .background(MaterialTheme.colorScheme.onSurface), // fond gris si l'image est transparente
                    contentScale = ContentScale.Crop
                )
            } else {
                // Petit bloc gris de remplacement si l'élément n'a pas d'image
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color(0xFFEAEAEA))
                ) {}
            }
        }
    }
}