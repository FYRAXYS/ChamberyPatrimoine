package com.example.chamberypatrimoine.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

// import des autres classes
import com.example.chamberypatrimoine.model.PatrimoineRepository
import com.example.chamberypatrimoine.model.CategoriePatrimoine



class PatrimoineViewModel : ViewModel() {

    private val repository = PatrimoineRepository()
    private val elements = repository.getAll() // Tout les éléments du repository

    private val _elementsAffiches = MutableStateFlow(elements) // valeur pour le ViewModel

    fun filterByCategory(categorie: CategoriePatrimoine?) {
        if (categorie == null) {
            // si pas de catégorie, on affiche tout
            _elementsAffiches.value = elements
        } else {
            // sinon on affiche selon la catégorie
            _elementsAffiches.value = elements.filter { it.categorie == categorie }
        }
    }
}