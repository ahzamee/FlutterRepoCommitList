package com.hussain.fluttercommitlist.model.commitListModel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Author(
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("gists_url")
    val gistsUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("repos_url")
    val reposUrl: String,
    @SerializedName("site_admin")
    val siteAdmin: Boolean,
    @SerializedName("type")
    val type: String
):Serializable