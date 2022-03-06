package com.example.yapilacaklarlistesibir.repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.yapilacaklarlistesibir.entity.Yapilacaklar
import com.example.yapilacaklarlistesibir.room.VeriTabani
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class YapilacaklarRepository(var application: Application) {

    var yapilacaklarListesi : MutableLiveData<List<Yapilacaklar>>
    var vt : VeriTabani

    init {
        yapilacaklarListesi = MutableLiveData()
        vt = VeriTabani.veritabaniErisim(application)!!
    }

    fun yapilacaklariGetir() : MutableLiveData<List<Yapilacaklar>> {
        return yapilacaklarListesi
    }

    fun yapilacaklarKayit(yapilacak_is : String, yapilacak_tarih : String) {

        val job = CoroutineScope(Dispatchers.Main).launch {

            val yeniYapilacak =Yapilacaklar(0,yapilacak_is, yapilacak_tarih)
            vt.YapilacaklarDao().yapilacakEkle(yeniYapilacak)

        }
    }

    fun yapilacaklarGuncelle(yapilacak_id : Int, yapilacak_is: String, yapilacak_tarih: String) {

        val job = CoroutineScope(Dispatchers.Main).launch {

            val guncellenenYapilacak = Yapilacaklar(yapilacak_id, yapilacak_is, yapilacak_tarih)
            vt.YapilacaklarDao().yapilacakGuncelle(guncellenenYapilacak)

        }
    }

    fun yapilacakAra(aramaKelimesi : String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value = vt.YapilacaklarDao().yapilacakArama(aramaKelimesi)
        }
    }

    fun yapilacakSil(yapilacak_id: Int) {
        val job = CoroutineScope(Dispatchers.Main).launch {

        val guncellenenYapilacak = Yapilacaklar(yapilacak_id, "", "")
        vt.YapilacaklarDao().yapilacakSil(guncellenenYapilacak)
        tumYapilacaklariAl()
        }
    }

    fun tumYapilacaklariAl() {
        val job = CoroutineScope(Dispatchers.Main).launch {

        yapilacaklarListesi.value =vt.YapilacaklarDao().tumYapilacaklar()
        }
    }

}