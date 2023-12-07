package com.example.my.a6_2less.ui

import android.content.ClipData.Item
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.my.a6_2less.data.repo.YouTubeApiRepo
import com.example.my.a6_2less.data.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val youTubeApiRepo: YouTubeApiRepo) : ViewModel() {

    private val _playlistsState = MutableLiveData<Resource<List<Item>>>()

    val playlistsState: LiveData<Resource<List<Item>>> = _playlistsState

//    val playlistsState = _playlistsState as LiveData<List<Item>>

    fun getPlaylists() {
        youTubeApiRepo.getPlaylist().also { res ->
            when (res) {
                is Resource.Error -> {
                    _playlistsState.value = Resource.Error(res.message!!)
                }

                is Resource.Loading -> {
                    _playlistsState.value = Resource.Loading()
                }

                is Resource.Success -> {
                    _playlistsState.value = Resource.Success(res.data!!)
                }
            }
        }
    }

}