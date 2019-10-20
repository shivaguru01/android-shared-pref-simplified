package com.android.sharedpref

import android.content.Context
import android.content.SharedPreferences

class Repo(context: Context) {

    var sharedPreference: SharedPreferences = context.getSharedPreferences(
        context.packageName,
        Context.MODE_PRIVATE
    )

    companion object {
        const val KEY_NAME = "name"
    }

    private var name: String? by sharedPreference.string(KEY_NAME)

    fun saveName(name: String?) {
        this.name = name
    }

    fun getUserName() = name

}