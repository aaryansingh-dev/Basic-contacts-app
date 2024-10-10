package com.example.contactsapp


/**
 * Contain different events. Event is a user action.
 */
sealed interface ContactEvent {
    object SaveContact: ContactEvent
    object ShowDialog: ContactEvent
    object HideDialog: ContactEvent

    data class SetFirstName(val firstName: String): ContactEvent
    data class SetLastName(val firstName: String): ContactEvent
    data class SetPhoneNumber(val firstName: String): ContactEvent
    data class SortContacts(val sortType: SortType): ContactEvent
    data class DeleteContact(val contact: Contact): ContactEvent
}