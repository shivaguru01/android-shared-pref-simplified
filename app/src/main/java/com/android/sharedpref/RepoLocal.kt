package com.android.sharedpref

import android.content.Context
import android.content.SharedPreferences

class RepoLocal(context: Context) {

    companion object {
        const val KEY_NAME = "name"
    }

    var sharedPreference: SharedPreferences = context.getSharedPreferences(
        context.packageName,
        Context.MODE_PRIVATE
    )

    var name: String? by sharedPreference.string(KEY_NAME)

}