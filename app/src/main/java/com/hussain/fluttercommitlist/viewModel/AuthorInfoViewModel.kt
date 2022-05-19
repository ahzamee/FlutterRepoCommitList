package com.hussain.fluttercommitlist.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hussain.fluttercommitlist.api.ApiInstance.Companion.getApiInstance
import com.hussain.fluttercommitlist.api.ServiceInterface
import com.hussain.fluttercommitlist.model.authorReposModel.AuthorInfoModel
import com.hussain.fluttercommitlist.util.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthorInfoViewModel: ViewModel() {

    var liveDataList: MutableLiveData<AuthorInfoModel> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<AuthorInfoModel>{
        return liveDataList
    }

    fun makeApiCall(baseUrl: String){
        val apiInstance = getApiInstance(Constant.base_url_commit)
        val apiService = apiInstance.create(ServiceInterface::class.java)

        val call = apiService.getAuthorReposList(baseUrl.trim())

        call.enqueue(object : Callback<AuthorInfoModel>{
            override fun onResponse(
                call: Call<AuthorInfoModel>,
                response: Response<AuthorInfoModel>
            ) {
                liveDataList.postValue(response.body())
            }

            override fun onFailure(call: Call<AuthorInfoModel>, t: Throwable) {
                Log.d("aaaaaa",t.message.toString())
                liveDataList.postValue(null)
            }

        })
    }
}