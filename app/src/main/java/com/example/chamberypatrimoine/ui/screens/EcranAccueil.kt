package com.example.chamberypatrimoine.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chamberypatrimoine.R
import com.example.chamberypatrimoine.ui.theme.YellowPale
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.res.stringResource
import com.example.chamberypatrimoine.model.CategoriePatrimoine
import com.example.chamberypatrimoine.ui.theme.YellowDark

@Composable
fun EcranAccueil(onChoixCategorie: (CategoriePatrimoine) -> Unit) {

    val configuration = LocalConfiguration.current
    val hauteurEcran = configuration.screenHeightDp.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState()) // Le scroll est bien là !
    ) {
        // --- PARTIE HAUTE (Jaune Pale) ---
        Column(
            modifier = Modifier
                // SUPPRESSION DU WEIGHT ICI
                .fillMaxWidth()
                .background(if (isSystemInDarkTheme()) YellowDark else YellowPale)
                .heightIn(min = hauteurEcran * 0.4f)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.accueil_titre),
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Black,
                    lineHeight = 40.sp,
                    modifier = Modifier.weight(1f) // Celui-ci est autorisé car il est horizontal (dans une Row) !
                )

                Image(
                    painter = painterResource(id = R.drawable.blason_chambery),
                    contentDescription = stringResource(id = R.string.cd_blason_savoie),
                    modifier = Modifier.size(120.dp)
                )
            }
        }

        // --- PARTIE BASSE ---
        Column(
            modifier = Modifier
                // SUPPRESSION DU WEIGHT ICI
                .fillMaxWidth()
                .padding(horizontal = 40.dp, vertical = 24.dp), // Ajout d'un padding vertical
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CategoriePatrimoine.entries.forEach { categorie ->
                Button(
                    onClick = { onChoixCategorie(categorie) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .height(56.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
                ) {
                    Text(
                        text = categorie.label,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

            Spacer(modifier = Modifier.height(48.dp)) // Un petit espace tout en bas pour ne pas coller à l'écran
        }
    }
}