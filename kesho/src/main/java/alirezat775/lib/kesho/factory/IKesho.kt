package alirezat775.lib.kesho.factory

import alirezat775.lib.kesho.Kesho
import alirezat775.lib.kesho.TimeType

/**
 * Author:  Alireza Tizfahm Fard
 * Date:    2019-07-14
 * Email:   alirezat775@gmail.com
 */

internal interface IKesho {

    fun push(key: String, value: String?, @TimeType timeToLife: Long = Kesho.NONE_EXPIRE_TIME)
    fun push(key: String, value: Boolean, @TimeType timeToLife: Long = Kesho.NONE_EXPIRE_TIME)
    fun push(key: String, value: Float, @TimeType timeToLife: Long = Kesho.NONE_EXPIRE_TIME)
    fun push(key: String, value: Int, @TimeType timeToLife: Long = Kesho.NONE_EXPIRE_TIME)
    fun push(key: String, value: Long, @TimeType timeToLife: Long = Kesho.NONE_EXPIRE_TIME)
    fun push(key: String, value: Any?, @TimeType timeToLife: Long = Kesho.NONE_EXPIRE_TIME)

    fun pull(key: String, defaultValue: String): String?
    fun pull(key: String, defaultValue: Boolean): Boolean
    fun pull(key: String, defaultValue: Float): Float
    fun pull(key: String, defaultValue: Int): Int
    fun pull(key: String, defaultValue: Long): Long
    fun pull(key: String, defaultValue: String, type: Any): Any?

    fun remove(key: String)
    fun clear()

    fun has(key: String): Boolean
    fun valid(key: String): Boolean
}