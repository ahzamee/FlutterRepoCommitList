package com.hussain.fluttercommitlist.api

import com.hussain.fluttercommitlist.model.authorReposModel.AuthorReposListModel
import com.hussain.fluttercommitlist.model.commitListModel.CommitModel
import retrofit2.Call
import retrofit2.http.GET

interface ServiceInterface {
    @GET("commits")
    fun getCommitList(): Call<List<CommitModel>>

    @GET("repos")
    fun getAuthorReposList(): Call<List<AuthorReposListModel>>
}