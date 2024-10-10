package com.example.contactsapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Upsert
    suspend fun upsertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    // indexing by three ways: ordering by first name, last name and phone number
    // so 3 functions

    // flow makes the list observable. Observables have the ability to notify other elements where there is some change in them.

    @Query("SELECT * FROM contact ORDER BY firstName ASC")
    suspend fun getContactsOrderedByFirstName(): Flow<List<Contact>>


    @Query("SELECT * FROM contact SORTED ORDER BY lastName ASC")
    suspend fun getContactsOrderedByLastName(): Flow<List<Contact>>

    @Query("SELECT * FROM contact SORTED ORDER BY phoneNumber ASC")
    suspend fun getContactsOrderedByPhoneNumber(): Flow<List<Contact>>
}