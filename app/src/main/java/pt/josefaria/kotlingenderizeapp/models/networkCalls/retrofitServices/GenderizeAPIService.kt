package pt.josefaria.kotlingenderizeapp.models.networkCalls.retrofitServices

import io.reactivex.Observable
import pt.josefaria.kotlingenderizeapp.models.networkCalls.Model
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by jose.faria on 28-02-2018.
 */


interface GenderizeApiService {

    @GET("/")
    fun genderCheck(@Query("name") name: String):
            Observable<Model>

    companion object {
        fun create(): GenderizeApiService {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(
                            RxJava2CallAdapterFactory.create())
                    .addConverterFactory(
                            GsonConverterFactory.create())
                    .baseUrl("https://api.genderize.io")
                    .build()

            return retrofit.create(GenderizeApiService::class.java)
        }
    }

}