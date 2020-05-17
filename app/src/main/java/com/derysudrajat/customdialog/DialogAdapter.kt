package com.derysudrajat.customdialog

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_content.view.*

class DialogAdapter(
    private val context: Context,
    private val listDialog: MutableList<ItemDialog> = mutableListOf()
) : RecyclerView.Adapter<DialogAdapter.DialogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DialogViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_content, parent, false)
        return DialogViewHolder(view)
    }

    override fun getItemCount(): Int = listDialog.size

    override fun onBindViewHolder(holder: DialogViewHolder, position: Int) {
        val mData = listDialog[position]
        holder.itemView.tvItem.text = mData.text
        Glide.with(context).load(mData.img).into(holder.itemView.ivIconItem)
        holder.itemView.contentItem.setOnClickListener {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(mData.url)))
        }
    }

    class DialogViewHolder(view: View) : RecyclerView.ViewHolder(view)

}