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
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.yapilacaklarlistesibir.R
import com.example.yapilacaklarlistesibir.databinding.FragmentAnasayfaBinding
import com.example.yapilacaklarlistesibir.databinding.FragmentYapilacaklarDetayBinding
import com.example.yapilacaklarlistesibir.viewmodel.YapilacaklarDetayFragmentViewModel
import com.example.yapilacaklarlistesibir.viewmodel.YapilacaklarDetayVMF
import java.util.*

class YapilacaklarDetayFragment : Fragment() {

    private lateinit var tasarim : FragmentYapilacaklarDetayBinding
    private lateinit var viewModel : YapilacaklarDetayFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_yapilacaklar_detay, container, false)
        tasarim.yapilacaklarDetayFragment = this
        tasarim.yapilacaklarDetayToolbarBaslik = "Yapılacak İş Detay"

        val bundle : YapilacaklarDetayFragmentArgs by navArgs()
        val gelenYapilacak = bundle.yapilacaklar

        tasarim.yapilacaklarNesnesi = gelenYapilacak

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

        val tempViewModel : YapilacaklarDetayFragmentViewModel by viewModels() {
            YapilacaklarDetayVMF(requireActivity().application)
        }

        viewModel = tempViewModel

    }

    fun buttonGuncelleTikla(yapilacaklar_id : Int, yapilacaklar_is : String, yapilacaklar_tarih: String){

        viewModel.guncelle(yapilacaklar_id, yapilacaklar_is, yapilacaklar_tarih)

    }

}