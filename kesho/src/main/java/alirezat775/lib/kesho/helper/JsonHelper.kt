package alirezat775.lib.kesho.helper

import com.google.gson.Gson

/**
 * Author:  Alireza Tizfahm Fard
 * Date:    2019-07-14
 * Email:   alirezat775@gmail.com
 */

object JsonHelper {

    fun toJson(jsonObject: Any): String {
        return Gson().toJson(jsonObject)
    }

    fun <T> fromJson(jsonString: String, classType: Class<T>): T {
        return Gson().fromJson(jsonString, classType)
    }
}