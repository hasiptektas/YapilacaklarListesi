package com.example.yapilacaklarlistesibir.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class YapilacaklarKayitVMF(var application: Application) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return YapilacaklarKayitFragmentViewModel(application) as T
    }

}