package com.hussain.fluttercommitlist.model.commitListModel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Commit(
    @SerializedName("author")
    val author: AuthorX,
    @SerializedName("message")
    val message: String
):Serializable