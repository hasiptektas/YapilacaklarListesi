package com.example.yapilacaklarlistesibir.room

import androidx.room.*
import com.example.yapilacaklarlistesibir.entity.Yapilacaklar

@Dao
interface YapilacaklarDao {

    @Query("SELECT * FROM yapilacaklartarih")
    suspend fun tumYapilacaklar() : List<Yapilacaklar>

    @Insert
    suspend fun yapilacakEkle(yapilacak: Yapilacaklar)

    @Update
    suspend fun yapilacakGuncelle(yapilacak : Yapilacaklar)

    @Delete
    suspend fun yapilacakSil(yapilacak: Yapilacaklar)

    @Query("SELECT * FROM yapilacaklartarih WHERE yapilacak_is like '%'||:aramaKelimesi||'%'")
    suspend fun yapilacakArama(aramaKelimesi : String) : List<Yapilacaklar>

}