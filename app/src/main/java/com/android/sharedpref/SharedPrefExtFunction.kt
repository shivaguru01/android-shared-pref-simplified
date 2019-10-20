package com.android.sharedpref

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty

fun SharedPreferences.int(key: String): ReadWriteProperty<Any, Int> =
    IntSharedPreference(sharedPreferences = this, key = key)

fun SharedPreferences.string(key: String): ReadWriteProperty<Any, String?> =
    StringSharedPreference(sharedPreferences = this, key = key)

fun SharedPreferences.float(key: String): ReadWriteProperty<Any, Float> =
    FloatSharedPreference(sharedPreferences = this, key = key)

fun SharedPreferences.long(key: String): ReadWriteProperty<Any, Long> =
    LongSharedPreference(sharedPreferences = this, key = key)

fun SharedPreferences.boolean(key: String): ReadWriteProperty<Any, Boolean> =
    BooleanSharedPreference(sharedPreferences = this, key = key)