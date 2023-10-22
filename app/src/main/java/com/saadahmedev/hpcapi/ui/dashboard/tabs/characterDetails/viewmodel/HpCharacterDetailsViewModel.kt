package com.saadahmedev.hpcapi.ui.dashboard.tabs.characterDetails.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saadahmedev.hpcapi.domain.model.HpCharacterDetails
import com.saadahmedev.hpcapi.domain.useCase.HpCharacterUseCase
import com.saadahmedev.hpcapi.util.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HpCharacterDetailsViewModel @Inject constructor(private val hpCharacterUseCase: HpCharacterUseCase) : ViewModel() {

    private val _hpCharacterDetails = MutableLiveData<ResponseState<HpCharacterDetails>>()
    val hpCharacterDetails: LiveData<ResponseState<HpCharacterDetails>> = _hpCharacterDetails

    fun getHpCharacterDetails(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            hpCharacterUseCase.getCharacter(id).collect {
                when (it) {
                    is ResponseState.Loading -> _hpCharacterDetails.postValue(ResponseState.Loading())

                    is ResponseState.Success -> _hpCharacterDetails.postValue(ResponseState.Success(it.data))

                    is ResponseState.Error -> _hpCharacterDetails.postValue(ResponseState.Error(it.message))
                }
            }
        }
    }
}