package com.example.simplecalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var inputone : EditText
    private lateinit var inputtwo : EditText
    private lateinit var btntambah : Button
    private lateinit var btnkurang : Button
    private lateinit var btnkali : Button
    private lateinit var texthasil : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputone = findViewById(R.id.input_satu)
        inputtwo = findViewById(R.id.input_dua)
        btntambah = findViewById(R.id.btn_tambah)
        btnkurang = findViewById(R.id.btn_kurang)
        btnkali = findViewById(R.id.btn_kali)
        texthasil = findViewById(R.id.text_hasil)

        btntambah.setOnClickListener(this)
        btnkurang.setOnClickListener(this)
        btnkali.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var kalkulasi: Double
        val inputsatu = inputone.text.toString().trim()
        val inputdua = inputtwo.text.toString().trim()
        if(inputsatu.isEmpty() || inputdua.isEmpty()){
            inputone.error = "Isi Field"
            inputtwo.error = "Isi Field"
        } else {
            kalkulasi = when(v?.id){
                R.id.btn_tambah -> inputsatu.toDouble() + inputdua.toDouble()
                R.id.btn_kurang -> inputsatu.toDouble() - inputdua.toDouble()
                R.id.btn_kali -> inputsatu.toDouble() * inputdua.toDouble()
                else -> 0.0
            }
            texthasil.text = kalkulasi.toString()
        }
    }
}