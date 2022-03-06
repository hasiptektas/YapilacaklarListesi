package com.example.yapilacaklarlistesibir.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.yapilacaklarlistesibir.entity.Yapilacaklar
import com.example.yapilacaklarlistesibir.repo.YapilacaklarRepository

class AnasayfaFragmentViewModel(application : Application) :AndroidViewModel(application) {

    var yapilacaklarListesi = MutableLiveData<List<Yapilacaklar>>()
    val yRepo = YapilacaklarRepository(application)

    init {
        yapilacaklariYukle()
        yapilacaklarListesi = yRepo.yapilacaklariGetir()
    }

    fun ara(aramaKelimesi : String) {
        yRepo.yapilacakAra(aramaKelimesi)
    }

    fun sil(yapilacak_id : Int) {
        yRepo.yapilacakSil(yapilacak_id)
    }

    fun yapilacaklariYukle() {
        yRepo.tumYapilacaklariAl()
    }
}