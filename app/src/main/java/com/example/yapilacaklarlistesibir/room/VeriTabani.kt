package com.example.yapilacaklarlistesibir.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.yapilacaklarlistesibir.entity.Yapilacaklar

@Database(entities = [Yapilacaklar::class], version = 1)
abstract class VeriTabani : RoomDatabase() {

    abstract fun YapilacaklarDao() : YapilacaklarDao

        companion object {

            var INSTANCE: VeriTabani? = null

            fun veritabaniErisim(context: Context): VeriTabani? {

                if (INSTANCE == null) {
                    synchronized(VeriTabani::class) {

                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            VeriTabani::class.java,
                            "yapilacaklartarih.sqlite"
                        ).createFromAsset("yapilacaklartarih.sqlite").build()
                    }
                }

                return INSTANCE

            }
        }
}