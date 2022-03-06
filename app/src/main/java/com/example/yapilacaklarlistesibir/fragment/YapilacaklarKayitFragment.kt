package com.example.yapilacaklarlistesibir.fragment

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.yapilacaklarlistesibir.R
import com.example.yapilacaklarlistesibir.databinding.FragmentYapilacaklarKayitBinding
import com.example.yapilacaklarlistesibir.viewmodel.YapilacaklarKayitFragmentViewModel
import com.example.yapilacaklarlistesibir.viewmodel.YapilacaklarKayitVMF
import java.util.*

class YapilacaklarKayitFragment : Fragment() {
    private lateinit var tasarim: FragmentYapilacaklarKayitBinding
    private lateinit var viewModel : YapilacaklarKayitFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_yapilacaklar_kayit, container,false)
        tasarim.yapilacaklarKayitFragment = this
        tasarim.yapilacaklarKayitToolbarBaslik = "Yapılacak İş Kayıt"

        tasarim.textViewYapilacakTarih.setOnClickListener {
            val calendar = Calendar.getInstance()
            val yil = calendar.get(Calendar.YEAR)
            val ay = calendar.get(Calendar.MONTH)
            val gun = calendar.get(Calendar.DAY_OF_MONTH)

            val dp = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener { d, y, a, g ->
                tasarim.textViewYapilacakTarih.setText("$g, $a, $y")


            },yil,ay,gun)

            dp.setButton(DialogInterface.BUTTON_POSITIVE, "Seç",dp)
            dp.setButton(DialogInterface.BUTTON_NEGATIVE, "İptal",dp)
            dp.show()
        }


        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel : YapilacaklarKayitFragmentViewModel by viewModels() {

            YapilacaklarKayitVMF(requireActivity().application)

        }
        viewModel = tempViewModel

    }

    fun buttonKaydetTikla(yapilacak_is : String, yapilacak_tarih: String){

        viewModel.kayit(yapilacak_is, yapilacak_tarih)

    }

}