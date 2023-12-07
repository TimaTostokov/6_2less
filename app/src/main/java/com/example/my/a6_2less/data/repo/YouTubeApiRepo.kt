package com.example.my.a6_2less.data.repo

import androidx.lifecycle.LiveData
import com.example.my.a6_2less.data.model.Item
import com.example.my.a6_2less.data.service.YoutubeApiService
import com.example.my.a6_2less.data.utils.Resource
import javax.inject.Inject

class YouTubeApiRepo @Inject constructor(private val service: YoutubeApiService) {

    fun getPlaylist(): LiveData<Resource<List<Item>>> = liveData() {
        return try {
            val responce = service.getPlaylist(
                "AIzaSyBQxS_Oxp53642D_nS9qsgLwhoXyrU8tyE",
                "snippet, contentDetails",
                "UCKNTZMRHPLXfqlbdOI7mCkg",
                "21"
            )
            if (responce.body() != null && responce.isSuccessful) {
                Resource.Success(responce.body()!!.items)
            } else {
                Resource.Error("ERROR SOMETHING WENT WRONG")
            }
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "ERROR SOMETHING WENT WRONG")
        }
    }

}

//        catch (e: Exception) {
//            Resource.Error(if (e.localizedMessage != null)
//                e.localizedMessage else "WRONG!")
//        }


//            .enqueue(
//            object : Callback<BaseYoutubeResponce> {
//                override fun onResponse(
//                    call: Call<BaseYoutubeResponce>,
//                    response: Response<BaseYoutubeResponce>
//                ) {
//                    if (response.isSuccessful && response.body() != null) {
//                        response.body()?.let {
//                            mResponse = it.items
//                        }
//                    }
//                }
//
//                override fun onFailure(call: Call<BaseYoutubeResponce>, t: Throwable) {
//                    Log.e("error", "onFailure: ${t.localizedMessage}")
//                }
//            }
//        )