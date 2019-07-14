package alirezat775.lib.kesho.factory

import alirezat775.lib.kesho.Kesho
import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

internal class SharedPreferencesManager(private val context: Context) : IKesho {

    private val postFixTimeToLife = "timeToLife"

    private companion object {
        private val preferences: String? = null

        @Volatile
        private var sharedPreferences: SharedPreferences? = null

        fun getSharedPreferences(context: Context): SharedPreferences {
            return sharedPreferences ?: synchronized(this) {
                context.getSharedPreferences(preferences, Activity.MODE_PRIVATE).also { sharedPreferences = it }
            }
        }
    }

    override fun push(key: String, value: String?, timeToLife: Long) {
        addTimeToLife(key, timeToLife)
        getSharedPreferences(context).edit().putString(key, value).apply()
    }

    override fun push(key: String, value: Boolean, timeToLife: Long) {
        addTimeToLife(key, timeToLife)
        getSharedPreferences(context).edit().putBoolean(key, value).apply()
    }

    override fun push(key: String, value: Float, timeToLife: Long) {
        addTimeToLife(key, timeToLife)
        getSharedPreferences(context).edit().putFloat(key, value).apply()
    }

    override fun push(key: String, value: Int, timeToLife: Long) {
        addTimeToLife(key, timeToLife)
        getSharedPreferences(context).edit().putInt(key, value).apply()
    }

    override fun push(key: String, value: Long, timeToLife: Long) {
        addTimeToLife(key, timeToLife)
        getSharedPreferences(context).edit().putLong(key, value).apply()
    }

    override fun pull(key: String, defaultValue: String): String? {
        if (!valid(key)) {
            remove(key + postFixTimeToLife)
            remove(key)
            return defaultValue
        }
        return getSharedPreferences(context).getString(key, defaultValue)
    }

    override fun pull(key: String, defaultValue: Boolean): Boolean {
        if (!valid(key)) {
            remove(key + postFixTimeToLife)
            remove(key)
            return defaultValue
        }
        return getSharedPreferences(context).getBoolean(key, defaultValue)
    }

    override fun pull(key: String, defaultValue: Float): Float {
        if (!valid(key)) {
            remove(key + postFixTimeToLife)
            remove(key)
            return defaultValue
        }
        return getSharedPreferences(context).getFloat(key, defaultValue)
    }

    override fun pull(key: String, defaultValue: Int): Int {
        if (!valid(key)) {
            remove(key + postFixTimeToLife)
            remove(key)
            return defaultValue
        }
        return getSharedPreferences(context).getInt(key, defaultValue)
    }

    override fun pull(key: String, defaultValue: Long): Long {
        if (!valid(key)) {
            remove(key + postFixTimeToLife)
            remove(key)
            return defaultValue
        }
        return getSharedPreferences(context).getLong(key, defaultValue)
    }

    override fun remove(key: String) {
        getSharedPreferences(context).edit().remove(key).apply()
    }

    override fun clear() {
        getSharedPreferences(context).edit().clear().apply()
    }

    override fun has(key: String): Boolean {
        return getSharedPreferences(context).contains(key)
    }

    private fun addTimeToLife(key: String, timeToLife: Long) {
        if (timeToLife != Kesho.NONE_EXPIRE_TIME) {
            getSharedPreferences(context).edit()
                .putLong(key + postFixTimeToLife, System.currentTimeMillis() + timeToLife)
                .apply()
        }
    }

    override fun valid(key: String): Boolean {
        if (!has(key)) return false

        val timeToLife = getSharedPreferences(context).getLong(key + postFixTimeToLife, Kesho.EXPIRE_TIME)
        return if (timeToLife == Kesho.EXPIRE_TIME) {
            false
        } else {
            System.currentTimeMillis() < timeToLife
        }
    }
}