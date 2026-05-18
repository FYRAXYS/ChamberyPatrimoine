package com.example.chamberypatrimoine.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.chamberypatrimoine.model.ElementPatrimoine
import androidx.compose.ui.text.style.Hyphens
import androidx.compose.ui.text.style.LineBreak
import com.example.chamberypatrimoine.R

@Composable
fun EcranDetail(element: ElementPatrimoine) {

    // Fond global de l'écran
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
            .verticalScroll(rememberScrollState()) // Pour permettre le scroll
    ) {

        // Bandeau au sommet de l'écran
        Surface(
            color = MaterialTheme.colorScheme.surface,
            shadowElevation = 4.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {}, // TODO: gérer le retour
                    shape = RoundedCornerShape(4.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text("Retour à la liste", fontWeight = FontWeight.Bold)
                }

                HorizontalDivider(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .height(32.dp)
                        .width(1.dp), thickness = DividerDefaults.Thickness, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
                )

                Text(
                    text = element.categorie.label,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        // contenu principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                // Le Titre
                Text(
                    text = element.nom,
                    style = MaterialTheme.typography.titleLarge.copy(
                        lineBreak = LineBreak.Heading, // Gestion du retour à la ligne en cas de titre trop gros
                        hyphens = Hyphens.Auto
                    ),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 16.dp)
                )

                // L'Image
                if (element.idImageRessource != null) {
                    Image(
                        painter = painterResource(id = element.idImageRessource),
                        contentDescription = "Image de ${element.nom}",
                        modifier = Modifier
                            .size(130.dp)
                            .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    // carré gris si pas d'image
                    Box(
                        modifier = Modifier
                            .size(130.dp)
                            .background(Color(0xFFEAEAEA))
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = element.description,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                lineHeight = MaterialTheme.typography.bodyLarge.lineHeight * 1.2f
            )

            if (element.lieu != null || element.epoque != null) {
                Spacer(modifier = Modifier.height(32.dp))
                HorizontalDivider(Modifier, thickness = 1.dp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f))

                Spacer(modifier = Modifier.height(16.dp))

                if (element.lieu != null) {
                    // Row pour l'icone et le texte côte à côte
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.icon_location),
                            contentDescription = "Icône de lieu",
                            modifier = Modifier.size(20.dp)
                        )


                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Lieu : ${element.lieu}",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }

                if (element.epoque != null) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.icon_hourglass),
                            contentDescription = "Icône d'époque",
                            modifier = Modifier.size(20.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Époque : ${element.epoque}",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

        }
    }
}