package alirezat775.lib.kesho

import alirezat775.lib.kesho.factory.IKesho
import alirezat775.lib.kesho.factory.SharedPreferencesManager
import alirezat775.lib.kesho.helper.CryptHelper
import android.content.Context
import android.content.SharedPreferences
import java.security.KeyException

/**
 * Author:  Alireza Tizfahm Fard
 * Date:    2019-07-14
 * Email:   alirezat775@gmail.com
 */

class Kesho(
    private val context: Context, @KeshoType type: String,
    private val encryptType: Encrypt = Encrypt.NONE_ENCRYPT,
    private val encryptKey: String = "SECRET_KEY_MUST_BE_24_CH"
) : IKesho {

    enum class Encrypt {
        NONE_ENCRYPT,
        DESEDE_ENCRYPT
    }

    companion object {

        const val SHARED_PREFERENCES_MANAGER: String = "SharedPreferencesManager"

        internal const val NONE_EXPIRE_TIME = 0L
        internal const val EXPIRE_TIME = -1L

        const val ONE_SECOND = 1000L
        const val ONE_MINUTES = 60 * ONE_SECOND
        const val ONE_HOURS = 60 * ONE_MINUTES
        const val ONE_DAYS = 24 * ONE_HOURS
        const val ONE_WEEKS = 7 * ONE_DAYS
        const val ONE_MONTH = 30 * ONE_DAYS
        const val ONE_YEAR = 365 * ONE_DAYS
    }

    private lateinit var kesho: IKesho

    init {
        when (type) {
            SHARED_PREFERENCES_MANAGER -> kesho = SharedPreferencesManager(context)
        }
        if (encryptType == Encrypt.DESEDE_ENCRYPT) {
            if (encryptKey == "SECRET_KEY_MUST_BE_24_CH" || encryptKey.length < 23) {
                throw KeyException("please set valid key with 24 character")
            }
            CryptHelper.setKey(encryptKey)
        }
    }

    override fun push(key: String, value: String?, @TimeType timeToLife: Long) {
        var mValue = value
        if (encryptType == Encrypt.DESEDE_ENCRYPT) {
            if (value == null)
                throw NullPointerException("value not be null when using encryption method")
            mValue = CryptHelper.encrypt(value)
        }
        kesho.push(key, mValue, timeToLife)
    }

    override fun push(key: String, value: Boolean, @TimeType timeToLife: Long) {
        kesho.push(key, value, timeToLife)
    }

    override fun push(key: String, value: Float, @TimeType timeToLife: Long) {
        kesho.push(key, value, timeToLife)
    }

    override fun push(key: String, value: Int, @TimeType timeToLife: Long) {
        kesho.push(key, value, timeToLife)
    }

    override fun push(key: String, value: Long, @TimeType timeToLife: Long) {
        kesho.push(key, value, timeToLife)
    }

    override fun push(key: String, value: Any?, @TimeType timeToLife: Long) {
        kesho.push(key, value, timeToLife)
    }

    override fun pull(key: String, defaultValue: String): String? {
        val value: String? = kesho.pull(key, defaultValue)
        if (encryptType == Encrypt.DESEDE_ENCRYPT) {
            return CryptHelper.decrypt(value!!)
        }
        return value
    }

    override fun pull(key: String, defaultValue: Boolean): Boolean {
        return kesho.pull(key, defaultValue)
    }

    override fun pull(key: String, defaultValue: Float): Float {
        return kesho.pull(key, defaultValue)
    }

    override fun pull(key: String, defaultValue: Int): Int {
        return kesho.pull(key, defaultValue)
    }

    override fun pull(key: String, defaultValue: Long): Long {
        return kesho.pull(key, defaultValue)
    }

    override fun pull(key: String, defaultValue: String, type: Any): Any? {
        return kesho.pull(key, defaultValue, type)
    }

    override fun remove(key: String) {
        kesho.remove(key)
    }

    override fun clear() {
        kesho.clear()
    }

    override fun registerChangeListener(changeListener: SharedPreferences.OnSharedPreferenceChangeListener) {
        kesho.registerChangeListener(changeListener)
    }

    override fun unRegisterChangeListener(changeListener: SharedPreferences.OnSharedPreferenceChangeListener) {
        kesho.unRegisterChangeListener(changeListener)
    }

    override fun has(key: String): Boolean {
        return kesho.has(key)
    }

    override fun valid(key: String): Boolean {
        return kesho.valid(key)
    }
}