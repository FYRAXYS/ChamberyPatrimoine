package com.example.chamberypatrimoine.model

class PatrimoineRepository {

    // Méthode qui remplace un appel à la base de données
    fun getAll(): List<ElementPatrimoine> {
        return listOf(
            ElementPatrimoine(
                id = 1,
                nom = "La Fontaine des Éléphants",
                description = "Monument emblématique de Chambéry érigé en 1838 en l'honneur du Général de Boigne.",
                categorie = CategoriePatrimoine.MONUMENT,
                epoque = "XIXe siècle",
                lieu = "Place des Éléphants",
                idImageRessource = null
            )
        )
    }
}