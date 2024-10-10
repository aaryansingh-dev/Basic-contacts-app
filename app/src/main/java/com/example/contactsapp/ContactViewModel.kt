package com.example.contactsapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ContactViewModel(val dao: ContactDao): ViewModel() {
    private val _state = MutableStateFlow(ContactState())
    private val _sortType = MutableStateFlow(SortType.FIRST_NAME)

    fun onEvent(event: ContactEvent)
    {
        when(event){
            is ContactEvent.DeleteContact ->
                {
                    viewModelScope.launch {
                        dao.deleteContact(event.contact)
                    }
                }
            ContactEvent.HideDialog ->
            {
                _state.update { it.copy(isAddingContact = false) }
            }
            ContactEvent.SaveContact ->
                {

                }
            is ContactEvent.SetFirstName -> {
                _state.update { it.copy(firstName = event.firstName) }
            }
            is ContactEvent.SetLastName -> {
                _state.update { it.copy(lastName = event.lastName) }
            }
            is ContactEvent.SetPhoneNumber -> {
                _state.update { it.copy(phoneNumber = event.phoneNumber) }
            }
            ContactEvent.ShowDialog -> {
                _state.update { it.copy(isAddingContact = true) }
            }
            is ContactEvent.SortContacts ->
                {
                    _sortType.value = event.sortType
                }
        }
    }
}