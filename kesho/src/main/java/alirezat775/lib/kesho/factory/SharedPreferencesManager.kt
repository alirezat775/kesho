package alirezat775.lib.kesho.factory

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

internal class SharedPreferencesManager(private val context: Context) : IKesho {

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

    override fun push(key: String, value: String?) {
        getSharedPreferences(context).edit().putString(key, value).apply()
    }

    override fun push(key: String, value: Boolean) {
        getSharedPreferences(context).edit().putBoolean(key, value).apply()
    }

    override fun push(key: String, value: Float) {
        getSharedPreferences(context).edit().putFloat(key, value).apply()
    }

    override fun push(key: String, value: Int) {
        getSharedPreferences(context).edit().putInt(key, value).apply()
    }

    override fun push(key: String, value: Long) {
        getSharedPreferences(context).edit().putLong(key, value).apply()
    }

    override fun pull(key: String, defaultValue: String): String? {
        return getSharedPreferences(context).getString(key, defaultValue)
    }

    override fun pull(key: String, defaultValue: Boolean): Boolean {
        return getSharedPreferences(context).getBoolean(key, defaultValue)
    }

    override fun pull(key: String, defaultValue: Float): Float {
        return getSharedPreferences(context).getFloat(key, defaultValue)
    }

    override fun pull(key: String, defaultValue: Int): Int {
        return getSharedPreferences(context).getInt(key, defaultValue)
    }

    override fun pull(key: String, defaultValue: Long): Long {
        return getSharedPreferences(context).getLong(key, defaultValue)
    }

    override fun remove(key: String) {
        getSharedPreferences(context).edit().remove(key).apply()
    }

}