package alirezat775.lib.kesho

import androidx.annotation.LongDef

/**
 * Author:  Alireza Tizfahm Fard
 * Date:    2019-07-14
 * Email:   alirezat775@gmail.com
 */

@LongDef(
    Kesho.ONE_SECOND,
    Kesho.ONE_MINUTES,
    Kesho.ONE_HOURS,
    Kesho.ONE_DAYS,
    Kesho.ONE_WEEKS,
    Kesho.ONE_MONTH,
    Kesho.ONE_YEAR
)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
annotation class TimeType