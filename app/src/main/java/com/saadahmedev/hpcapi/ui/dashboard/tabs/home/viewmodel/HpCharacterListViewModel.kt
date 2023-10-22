package com.saadahmedev.hpcapi.ui.dashboard.tabs.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saadahmedev.hpcapi.domain.model.HpCharacter
import com.saadahmedev.hpcapi.domain.useCase.HpCharacterUseCase
import com.saadahmedev.hpcapi.util.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HpCharacterListViewModel @Inject constructor(private val hpCharacterUseCase: HpCharacterUseCase) : ViewModel() {

    private val _hpCharacterList = MutableLiveData<ResponseState<List<HpCharacter>>>()
    val hpCharacterList: LiveData<ResponseState<List<HpCharacter>>> = _hpCharacterList

    fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            hpCharacterUseCase.getCharacters().collect {
                when (it) {
                    is ResponseState.Loading -> _hpCharacterList.postValue(ResponseState.Loading())

                    is ResponseState.Success -> _hpCharacterList.postValue(ResponseState.Success(it.data))

                    is ResponseState.Error -> _hpCharacterList.postValue(ResponseState.Error(it.message))
                }
            }
        }
    }
}