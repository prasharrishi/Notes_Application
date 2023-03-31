package com.example.notesapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModal(application: Application):AndroidViewModel(application) {

    val allNote:LiveData<List<Note>>
    val repository: NoteRepository

    init {
        val dao = NoteDatabase.getDataBase(application).getNotesDao()
        repository = NoteRepository(dao)
        allNote = repository.allNotes

    }

    fun delete(note:Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }

    fun update(note:Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(note)
    }

    fun addNote(note:Note) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(note)
    }






}