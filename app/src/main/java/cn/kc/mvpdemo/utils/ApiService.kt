package cn.kc.mvpdemo.utils

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * 作者： Abel .
 * 日期：2019/9/25
 * 说明：
 */
interface ApiService {
    /**
     * 用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    @GET("users/{username}")
    fun getUserInfo(@Path("username") username: String): Observable<ResponseBody>
}