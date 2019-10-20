package com.android.sharedpref

import android.content.SharedPreferences
import androidx.core.content.edit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

abstract class SharedPreferenceDelegate<T> : ReadWriteProperty<Any, T> {

    abstract val sharedPreferences: SharedPreferences

}

class IntSharedPreference(
    override var sharedPreferences: SharedPreferences,
    private val key: String,
    private val default: Int = -1
) : SharedPreferenceDelegate<Int>() {
    override fun getValue(thisRef: Any, property: KProperty<*>): Int =
        sharedPreferences.getInt(key, default);

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Int) =
        sharedPreferences.edit { putInt(key, value) }
}

class StringSharedPreference(
    override var sharedPreferences: SharedPreferences,
    private val key: String,
    private val default: String? = null
) : SharedPreferenceDelegate<String?>() {
    override fun getValue(thisRef: Any, property: KProperty<*>): String = sharedPreferences.getString(key, default);

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String?) =
        sharedPreferences.edit { putString(key, value) }
}

class BooleanSharedPreference(
    override var sharedPreferences: SharedPreferences,
    private val key: String,
    private val default: Boolean = false
) : SharedPreferenceDelegate<Boolean>() {
    override fun getValue(thisRef: Any, property: KProperty<*>): Boolean =
        sharedPreferences.getBoolean(key, default);

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Boolean) =
        sharedPreferences.edit { putBoolean(key, value) }

}

class FloatSharedPreference(
    override val sharedPreferences: SharedPreferences,
    private val key: String,
    private val default: Float = 0.toFloat()
) : SharedPreferenceDelegate<Float>() {
    override fun getValue(thisRef: Any, property: KProperty<*>): Float =
        sharedPreferences.getFloat(key, default);

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Float) =
        sharedPreferences.edit { putFloat(key, value) }
}

class LongSharedPreference(
    override var sharedPreferences: SharedPreferences,
    private val key: String,
    private val default: Long = -1
) : SharedPreferenceDelegate<Long>() {
    override fun getValue(thisRef: Any, property: KProperty<*>): Long =
        sharedPreferences.getLong(key, default);

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Long) =
        sharedPreferences.edit { putLong(key, value) }
}

