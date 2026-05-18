package com.example.chamberypatrimoine.model

import androidx.annotation.DrawableRes

class ElementPatrimoine (
    val id: Int,
    val nom: String,
    val description: String,
    val categorie: CategoriePatrimoine,
    val epoque: String? = null,
    val lieu: String? = null,

    @DrawableRes val idImageRessource: Int? = null
) {}