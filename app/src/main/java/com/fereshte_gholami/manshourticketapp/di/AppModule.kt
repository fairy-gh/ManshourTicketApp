package com.fereshte_gholami.manshourticketapp.di

import android.content.SharedPreferences
import com.fereshte_gholami.manshourticketapp.data.remote.reservation.ReservationApiService
import com.fereshte_gholami.manshourticketapp.data.remote.reservation.ReservationRepository
import com.fereshte_gholami.manshourticketapp.data.remote.reservation.ReservationRepositoryImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    private val baseUrl = "https://run.mocky.io/v3/"

    @Provides
    @Singleton
    internal fun provideReservationRepository(
       reservationApi: ReservationApiService
     ): ReservationRepository = ReservationRepositoryImpl(reservationApi)

    @Provides
    @Singleton
    internal fun provideReservationApiService(
        retrofit: Retrofit
    ): ReservationApiService = retrofit.create(ReservationApiService::class.java)


    @Provides
    @Singleton
    internal fun provideRetrofit(
        client: OkHttpClient,
        gson: Gson
    ): Retrofit =
        Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()

    @Provides
    @Singleton
    internal fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(50, TimeUnit.SECONDS)
            .protocols(mutableListOf(Protocol.HTTP_1_1))
            .build()

    @Provides
    @Singleton
    internal fun provideInterceptor(prefs: SharedPreferences) = Interceptor {
        val request = it.request()
            .newBuilder()
            .addHeader("Authorization", "Bearer " + prefs.getString("token", null).toString())
            .build()
        it.proceed(request)
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson = GsonBuilder().serializeNulls().setLenient().create()

}
