package com.example.yapilacaklarlistesibir.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "yapilacaklartarih")
data class Yapilacaklar(@PrimaryKey(autoGenerate = true)
                        @ColumnInfo(name = "yapilacak_id")    @NotNull var yapilacak_id : Int,
                        @ColumnInfo(name = "yapilacak_is")    @NotNull var yapilacak_is : String,
                        @ColumnInfo(name = "yapilacak_tarih") @NotNull var yapilacak_tarih : String
                        ) : Serializable {
}