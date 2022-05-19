package com.hussain.fluttercommitlist.model.commitListModel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AuthorX(
    @SerializedName("date")
    val date: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String
): Serializable