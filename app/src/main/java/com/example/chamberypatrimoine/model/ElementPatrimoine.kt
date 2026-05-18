package com.example.chamberypatrimoine.model

class ElementPatrimoine (
    val id: String,
    val nom: String,
    val description: String,
    val categorie: CategoriePatrimoine,
    val epoque: String,
    val lieu: String,

    // TODO: image
) {}