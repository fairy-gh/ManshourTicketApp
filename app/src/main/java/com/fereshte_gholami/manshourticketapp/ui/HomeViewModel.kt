package com.fereshte_gholami.manshourticketapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fereshte_gholami.manshourticketapp.data.local.HomeRepository
import com.fereshte_gholami.manshourticketapp.data.model.HomeUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {

    private val _seatStateList = MutableStateFlow(HomeUI())
    val seatStateList = _seatStateList.asStateFlow()

    init {
        getSeatReservationList()
    }

    private fun getSeatReservationList(){
        viewModelScope.launch(Dispatchers.Main) {
            _seatStateList.value = _seatStateList
                .value
                .copy(seatStateList= homeRepository.getSeatsReservationState())
        }
    }

    fun selectSeat(id: Int){
        _seatStateList.update {
            it.copy(
                seatStateList = it.seatStateList.map { seat ->
                    if (seat.id == id) {
                        seat.copy(isSelected = !seat.isSelected)
                    } else {
                        seat
                    }
                }
            )
        }
    }

}