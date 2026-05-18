package com.example.chamberypatrimoine.model

class ElementPatrimoine (
    val id: Int,
    val nom: String,
    val description: String,
    val categorie: CategoriePatrimoine,
    val epoque: String,
    val lieu: String,

    val idImageRessource: Int? = null
) {}