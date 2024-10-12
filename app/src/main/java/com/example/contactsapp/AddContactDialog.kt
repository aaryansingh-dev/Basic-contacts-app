package com.example.contactsapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat

@Composable
fun AddContactDialog(
    state: ContactState,
    onEvent: (ContactEvent) -> Unit,
    modifier: Modifier = Modifier)
    {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            onEvent(ContactEvent.HideDialog)
        },
        title = {
            Text(text = "Add Contact")
        },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // First Name Field
                TextField(
                    value = state.firstName,
                    onValueChange = {
                        onEvent(ContactEvent.SetFirstName(it))
                    },
                    label = { Text("First Name") }
                )

                // Last Name Field
                TextField(
                    value = state.lastName,
                    onValueChange = {
                        onEvent(ContactEvent.SetLastName(it))
                    },
                    label = { Text("Last Name") }
                )

                // Phone Number Field
                TextField(
                    value = state.phoneNumber,
                    onValueChange = {
                        onEvent(ContactEvent.SetPhoneNumber(it))
                    },
                    label = { Text("Phone Number") }
                )
            }
        },
        confirmButton = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Button(onClick = {
                    onEvent(ContactEvent.SaveContact)
                }) {
                    Text(text = "Save Contact")
                }
            }
        },
        dismissButton = {
            Button(onClick = {
                onEvent(ContactEvent.HideDialog)
            }) {
                Text(text = "Cancel")
            }
        }
    )
}