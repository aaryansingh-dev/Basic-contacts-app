package com.example.contactsapp

import android.provider.MediaStore.Audio.Radio
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ContactScreen(
    state: ContactState,
    event: (ContactEvent) -> Unit
)
{
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                event(ContactEvent.ShowDialog)
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add contact")
            }
        }
    ){ padding->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            item {
                Row(
                    modifier = Modifier.fillMaxSize().horizontalScroll(rememberScrollState()),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    SortType.entries.forEach { sortType ->
                        Row(
                            modifier = Modifier.clickable{ event(ContactEvent.SortContacts(sortType))},
                            verticalAlignment = CenterVertically
                        ){
                            RadioButton(
                                selected = state.sortType == sortType,
                                onClick = {
                                    event(ContactEvent.SortContacts(sortType))
                                })
                            Text(text = sortType.name)
                        }
                    }
                }
            }
        }
    }
}


