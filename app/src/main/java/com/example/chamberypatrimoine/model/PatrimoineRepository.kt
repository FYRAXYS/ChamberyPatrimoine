package com.example.chamberypatrimoine.model

import com.example.chamberypatrimoine.R

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
                idImageRessource = R.drawable.monument_fontaine_elephants
            ),
            ElementPatrimoine(
                id = 2,
                nom = "Le Château des Ducs de Savoie",
                description = "Ancien château fort qui a évolué pour devenir la résidence des comtes et ducs de Savoie.",
                categorie = CategoriePatrimoine.MONUMENT,
                epoque = "Moyen Âge",
                lieu = "Centre historique",
                idImageRessource = R.drawable.monument_chateau_ducs
            ),
            ElementPatrimoine(
                id = 3,
                nom = "Le Gâteau de Savoie",
                description = "Pâtisserie très légère, inventée à Chambéry en 1358 pour un banquet impérial.",
                categorie = CategoriePatrimoine.CULINAIRE,
                epoque = "XIVe siècle",
                idImageRessource = R.drawable.culinaire_gateau_savoie
            ),
            ElementPatrimoine(
                id = 4,
                nom = "Cathédrale Saint-François-de-Sales",
                description = "Ancienne chapelle franciscaine devenue cathédrale. Elle abrite le plus vaste ensemble de peintures en trompe-l'œil d'Europe.",
                categorie = CategoriePatrimoine.MONUMENT,
                epoque = "XVe siècle",
                lieu = "Place de la Métropole",
                idImageRessource = R.drawable.monument_cathedrale_stn_francois
            ),
            ElementPatrimoine(
                id = 5,
                nom = "La Truffe en Chocolat",
                description = "Gourmandise inventée à Chambéry en 1895 par le pâtissier Louis Dufour, qui, manquant de provisions pour Noël, eut l'idée de mélanger de la crème fraîche, de la vanille, du cacao et de l'enrober de chocolat fondu.",
                categorie = CategoriePatrimoine.CULINAIRE,
                epoque = "1895",
                idImageRessource = R.drawable.culinaire_truffe
            ),
            ElementPatrimoine(
                id = 6,
                nom = "Maison des Charmettes",
                description = "Maison de campagne où le célèbre philosophe Jean-Jacques Rousseau a vécu avec Madame de Warens. C'est aujourd'hui un musée dédié à sa mémoire.",
                categorie = CategoriePatrimoine.MONUMENT,
                epoque = "XVIIIe siècle",
                lieu = "Vallon des Charmettes",
                idImageRessource = R.drawable.monument_maison_charmettes
            ),
            ElementPatrimoine(
                id = 7,
                nom = "Grand Carillon de la Tour Yolande",
                description = "L'un des plus grands carillons d'Europe avec ses 70 cloches en bronze. Il sonne régulièrement depuis le Château des Ducs de Savoie.",
                categorie = CategoriePatrimoine.OBJET,
                epoque = "1993 (cloches actuelles)",
                lieu = "Château des Ducs de Savoie",
                idImageRessource = R.drawable.objet_carillon
            ),
            ElementPatrimoine(
                id = 8,
                nom = "Le Vermouth de Chambéry",
                description = "Apéritif à base de vin blanc et d'une trentaine de plantes des Alpes. C'est le seul Vermouth en France à bénéficier d'une Appellation d'Origine Contrôlée (AOC).",
                categorie = CategoriePatrimoine.CULINAIRE,
                epoque = "XIXe siècle",
                idImageRessource = R.drawable.culinaire_vermouth
            ),
            ElementPatrimoine(
                id = 9,
                nom = "La Rotonde Ferroviaire",
                description = "Chef-d'œuvre de l'architecture métallique du début du XXe siècle, inspiré des travaux de Gustave Eiffel. C'est la plus grande rotonde de France avec une charpente articulée.",
                categorie = CategoriePatrimoine.MONUMENT,
                epoque = "1906",
                lieu = "La Cassine",
                idImageRessource = R.drawable.monument_rotonde
            ),
            ElementPatrimoine(
                id = 10,
                nom = "Peintures en Trompe-l'œil",
                description = "Œuvres spectaculaires de l'artiste Fabrizio Sevesi qui couvrent les murs et les voûtes de la cathédrale, donnant une parfaite illusion de sculptures et de reliefs.",
                categorie = CategoriePatrimoine.OEUVRE_ART,
                epoque = "1834",
                lieu = "Cathédrale de Chambéry",
                idImageRessource = R.drawable.oeuvre_trompe_oeil
            ),
            ElementPatrimoine(
                id = 11,
                nom = "Pirogue Carolingienne",
                description = "Embarcation monoxyle (creusée dans un seul tronc de chêne) datant du VIIIe siècle. Découverte dans les eaux du lac du Bourget, elle est l'une des pièces maîtresses du Musée Savoisien.",
                categorie = CategoriePatrimoine.OBJET,
                epoque = "Haut Moyen Âge",
                lieu = "Musée Savoisien",
                idImageRessource = R.drawable.objet_pirogue
            ),
            ElementPatrimoine(
                id = 12,
                nom = "La Sasson",
                description = "Statue monumentale en bronze du sculpteur Alexandre Falguière, érigée pour commémorer le rattachement de la Savoie à la France de 1792. Son nom signifie « grosse femme » en patois savoyard.",
                categorie = CategoriePatrimoine.OEUVRE_ART,
                epoque = "1892",
                lieu = "Place du Centenaire",
                idImageRessource = R.drawable.oeuvre_sasson
            ),
            ElementPatrimoine(
                id = 13,
                nom = "Portrait de jeune homme",
                description = "Ce tableau sur bois est l'un des joyaux du Musée des Beaux-Arts de Chambéry. Cette œuvre majeure de la Renaissance florentine a longtemps été attribuée au maître Paolo Uccello.",
                categorie = CategoriePatrimoine.OEUVRE_ART,
                epoque = "XVe siècle",
                lieu = "Musée des Beaux-Arts",
                idImageRessource = R.drawable.oeuvre_portrait_homme
            ),
            ElementPatrimoine(
                id = 14,
                nom = "Monnaies du Duché de Savoie",
                description = "Collection rare de pièces de monnaie frappées sous l'autorité des comtes puis des ducs de Savoie, témoignant de l'indépendance politique et de la puissance économique de la région avant son annexion.",
                categorie = CategoriePatrimoine.OBJET,
                epoque = "Moyen Âge / Renaissance",
                lieu = "Musée Savoisien",
                idImageRessource = R.drawable.objet_monnaie
            )
        )
    }
}