package com.holwati.recyclerview_holwati

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.holwati.recyclerview_holwati.databinding.ActivityMainBinding
import com.holwati.recyclerview_holwati.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Marcelo Vieira da Silva",R.drawable.marcelo,"Belakang", "1,74 m", "Rio de Janeiro (Brasil)", "12/05/1988"))
        listPemain.add(Pemain("Sergio Ramos Garcia",R.drawable.ramos,"Belakang", "1,85 m", "Camas(Sevilla)", "30/03/1986"))
        listPemain.add(Pemain("Toni Kroos",R.drawable.kroos,"Gelandang", "1,83 m", "Greifswald (Jerman)", "04/01/1990"))
        listPemain.add(Pemain("Luka Modric",R.drawable.modric,"Gelandang", "1,72 m", "Zadar (Kroasia)", "09/09/1985"))
        listPemain.add(Pemain("Karim Benzema",R.drawable.bangben,"Penyerang", "1,85 m", "Lyon (Perancis)", "08/06/1995"))
        listPemain.add(Pemain("Ferland Mendy",R.drawable.mangmendy,"Belakang", "1,80 m", "Meulan-en-Yvelines (Perancis)", "08/06/1995"))

        binding.List.adapter = AdapterTeamBola(this,listPemain,object : AdapterTeamBola.OnClickListener {
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)
                    val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                    val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }
        })



    }
}