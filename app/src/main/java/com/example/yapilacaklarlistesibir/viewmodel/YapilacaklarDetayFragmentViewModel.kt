package com.example.yapilacaklarlistesibir.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.yapilacaklarlistesibir.entity.Yapilacaklar
import com.example.yapilacaklarlistesibir.repo.YapilacaklarRepository

class YapilacaklarDetayFragmentViewModel(application: Application) : AndroidViewModel(application) {

    val yRepo = YapilacaklarRepository(application)

    fun guncelle(yapilacaklar_id : Int, yapilacaklar_is : String, yapilacaklar_tarih : String) {

        yRepo.yapilacaklarGuncelle(yapilacaklar_id, yapilacaklar_is, yapilacaklar_tarih)

    }

}