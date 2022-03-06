package com.example.yapilacaklarlistesibir.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.yapilacaklarlistesibir.repo.YapilacaklarRepository

class YapilacaklarKayitFragmentViewModel(application: Application) : AndroidViewModel(application) {

    val yRepo = YapilacaklarRepository(application)

    fun kayit(yapilacak_is : String, yapilacak_tarih: String) {

        yRepo.yapilacaklarKayit(yapilacak_is, yapilacak_tarih)

    }

}