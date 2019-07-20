package alirezat775.lib.kesho.helper


import android.annotation.SuppressLint
import android.util.Base64
import android.util.Log
import androidx.annotation.Size
import java.io.UnsupportedEncodingException
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.security.spec.InvalidKeySpecException
import javax.crypto.Cipher
import javax.crypto.NoSuchPaddingException
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESedeKeySpec

/**
 * Author:  Alireza Tizfahm Fard
 * Date:    2019-07-20
 * Email:   alirezat775@gmail.com
 */

object CryptHelper {

    private val TAG = CryptHelper::class.java.name
    private val DESEDE_ENCRYPTION_SCHEME = "DESede"
    private val UNICODE_FORMAT = "UTF8"
    private var secretKey: SecretKey? = null
    private var cipher: Cipher? = null

    /**
     * @param key
     */
    @SuppressLint("GetInstance")
    fun setKey(@Size(min = 24) key: String) {
        val myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME
        try {
            val arrayBytes = key.toByteArray(charset(UNICODE_FORMAT))
            val ks = DESedeKeySpec(arrayBytes)
            val skf = SecretKeyFactory.getInstance(myEncryptionScheme)
            cipher = Cipher.getInstance(myEncryptionScheme)
            secretKey = skf.generateSecret(ks)
        } catch (e: UnsupportedEncodingException) {
            Log.w(TAG, e)
        } catch (e: NoSuchPaddingException) {
            Log.w(TAG, e)
        } catch (e: NoSuchAlgorithmException) {
            Log.w(TAG, e)
        } catch (e: InvalidKeySpecException) {
            Log.w(TAG, e)
        } catch (e: InvalidKeyException) {
            Log.w(TAG, e)
        }
    }

    /**
     * @param s
     * @return
     */
    private fun decode(s: String): ByteArray {
        return Base64.decode(s.toByteArray(), Base64.DEFAULT)
    }

    /**
     * @param bytes
     * @return
     */
    private fun encode(bytes: ByteArray): String {
        return Base64.encodeToString(bytes, Base64.DEFAULT)
    }

    /**
     * @param unencryptedString
     * @return
     */
    fun encrypt(unencryptedString: String): String? {
        var encryptedString: String? = null
        try {
            cipher!!.init(Cipher.ENCRYPT_MODE, secretKey)
            val plainText = unencryptedString.toByteArray(charset(UNICODE_FORMAT))
            val encryptedText = cipher!!.doFinal(plainText)
            encryptedString = encode(encryptedText)
        } catch (e: Exception) {
            Log.w(TAG, e)
        }
        return encryptedString
    }

    /**
     * @param encryptedString
     * @return
     */
    fun decrypt(encryptedString: String): String? {
        var decryptedText: String? = null
        try {
            cipher!!.init(Cipher.DECRYPT_MODE, secretKey)
            val encryptedText = decode(encryptedString)
            val plainText = cipher!!.doFinal(encryptedText)
            decryptedText = String(plainText)
        } catch (e: Exception) {
            Log.w(TAG, e)
        }
        return decryptedText
    }

}