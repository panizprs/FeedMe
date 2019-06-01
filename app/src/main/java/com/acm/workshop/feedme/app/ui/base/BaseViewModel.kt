package com.acm.workshop.feedme.app.ui.base

import androidx.lifecycle.ViewModel
import com.acm.workshop.feedme.domain.interactor.base.UseCase

abstract class BaseViewModel : ViewModel(){

    protected val useCases = mutableListOf<UseCase>()

    override fun onCleared() {

        useCases.forEach { useCase ->
            useCase.dispose()
        }
        super.onCleared()
    }
}