package com.tw.ratingscreendemo

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tw.ratingscreendemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var TAG: String = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.include.title.text = "Add Rating"
        binding.include.leftHeaderIcon.setOnClickListener { finish() }
        binding.include.ivHome.visibility = View.GONE


        binding.btnSubmit.setOnClickListener {
            if (validation()){
                successAlert(this@MainActivity, "Thank you for your feedback.")
            }
        }
    }


    private fun validation(): Boolean {

        if (binding.ratingBar.rating== 0.0.toFloat()){
            Toast.makeText(this@MainActivity, "Please select ratings.", Toast.LENGTH_SHORT).show()
            return false
        }else if (binding.etRemarks.text.toString().isEmpty()){
            Toast.makeText(this@MainActivity, "Please enter some comments.", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    fun successAlert(context: Context, msg: String) {
        val builder = AlertDialog.Builder(context)
        builder.setCancelable(false)
        builder.setTitle(context.resources.getString(R.string.app_name))
        builder.setMessage(msg)
        // builder.setInverseBackgroundForced(true)
        builder.setPositiveButton(context.resources.getString(R.string._ok)) { dialog: DialogInterface?, which: Int ->
            if (dialog != null) {
                dialog.dismiss()
                finish()

            }
        }
        val alert = builder.create()
        alert.show()
    }
}