package com.example.chamberypatrimoine.model

class ElementPatrimoine (
    val id: Int,
    val nom: String,
    val description: String,
    val categorie: CategoriePatrimoine,
    val epoque: String? = null,
    val lieu: String? = null,

    val idImageRessource: Int? = null
) {}