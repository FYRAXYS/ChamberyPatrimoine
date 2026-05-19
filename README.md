# Création d'une application mobile sur le Patrimoine Chambérien

## Présentation 
Ce projet vise à apprendre l'utilisation de Kotlin/Compose via la création d'une petite application mobile pour mettre en avant le patrimoine chambérien.

Il se compose de 3 écrans distincts.

- Accueil : Sélection d'une catégorie d'éléments (Monument historique, Spécialité culinaire, Œuvre d'art ou Objet historique).

- Liste : Affichage dynamique de tous les éléments appartenant à la catégorie sélectionnée.

- Détails : Fiche complète d'un élément (description complète, image, lieu, époque).

## Maquette
<img width="956" height="572" alt="image" src="https://github.com/user-attachments/assets/414e6725-fc03-43c9-9cd8-08a5e6767e92" />
<i>réalisé avec Whimsical</i>

## Responsive Design
L'application peut basculer librement en mode paysage ou portrait, et supporte les modes sombres et clairs.

## Stack Technique
- Langage : Kotlin

- UI : Jetpack Compose

- Architecture : MVVM

- Gestion d'état : StateFlow

- Navigation : Compose Navigation API

## Aroborescence du projet
```
app/src/main/
├── model/
│   ├── CategoriePatrimoine.kt
│   ├── ElementPatrimoine.kt
│   └── PatrimoineRepository.kt
├── navigation/
│   └── ActivityNavigation.kt
├── ui/
│   ├── screens/
│   │   ├── EcranAccueil.kt
│   │   ├── EcranDetails.kt
│   │   └── EcranListe.kt
│   └── themes/
│       ├── Color.kt
│       ├── Theme.kt
│       └── Type.kt
├── viewmodel/
│   └── PatrimoineViewModel.kt
└── MainActivity.kt
```
<i>réalisé avec un [outil](https://gitlab.com/nfriend/tree-online) développé par Nathan Friend</i>

## Mentions légales
Sauf mentions contraires (voir les points listés ci-dessous), toutes les images utilisés dans ce projet sont sous licence Creative Commons et proviennent de Wikimédia Commons.

- croix de savoie : ACB décors muraux
- pirogue carolingienne : Ipso Facto
- carillon de Chambéry : Sergio Palumbo
- truffe en chocolat : Vladislav Noseek
- icônes : Google Icons
