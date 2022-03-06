package com.example.yapilacaklarlistesibir.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.yapilacaklarlistesibir.databinding.CardTasarimBinding
import com.example.yapilacaklarlistesibir.entity.Yapilacaklar
import com.example.yapilacaklarlistesibir.fragment.AnasayfaFragmentDirections
import com.example.yapilacaklarlistesibir.viewmodel.AnasayfaFragmentViewModel
import com.google.android.material.snackbar.Snackbar

class YapilacaklarAdapter(var mContext: Context, var yapilacaklarListesi:List<Yapilacaklar>, var viewModel : AnasayfaFragmentViewModel) :
    RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root) {
        var tasarim: CardTasarimBinding

        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {

        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim =CardTasarimBinding.inflate(layoutInflater, parent, false)

        return CardTasarimTutucu(tasarim)

    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {

        val yapilacak =yapilacaklarListesi.get(position)
        val t = holder.tasarim
        t.yapilacaklarNesnesi = yapilacak

        t.satirCard.setOnClickListener {
            val gecis =AnasayfaFragmentDirections.yapilacaklarDetayGecis(yapilacaklar = yapilacak)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.imageViewSilResim.setOnClickListener {
            Snackbar.make(it, "${yapilacak.yapilacak_is} silinsin mi ?", Snackbar.LENGTH_LONG)
                .setAction("Evet") {
                    viewModel.sil(yapilacak.yapilacak_id)
                }
                .show()
        }


    }

    override fun getItemCount(): Int {

        return yapilacaklarListesi.size

    }
}