package com.derysudrajat.customdialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_bottom_sheet.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listItemDialog = mutableListOf(
            ItemDialog(
                getString(R.string.img_url_ig),
                getString(R.string.txt_ig),
                getString(R.string.url_ig)
            ),
            ItemDialog(
                getString(R.string.img_url_github),
                getString(R.string.txt_github),
                getString(R.string.url_github)
            ),
            ItemDialog(
                getString(R.string.img_url_medium),
                getString(R.string.txt_mdium),
                getString(R.string.url_medium)
            ),
            ItemDialog(
                getString(R.string.img_url_wa),
                getString(R.string.txt_wa),
                getString(R.string.url_wa)
            )
        )

        Glide.with(this@MainActivity)
            .load(getString(R.string.img_url_avatar)).into(ivAvatar)

        btnShare.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.item_bottom_sheet, null)
            val dialogAdapter = DialogAdapter(this@MainActivity, listItemDialog)
            view.rvBottomSheet.apply {
                setHasFixedSize(true)
                itemAnimator = DefaultItemAnimator()
                adapter = dialogAdapter
            }
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(view)
            dialog.show()

        }
    }
}
