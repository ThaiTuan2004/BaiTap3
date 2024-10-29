package com.example.recview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recview.models.MessageModel


class MessageAdapter(val messages: List<MessageModel>): BaseAdapter() {
    override fun getCount(): Int= messages.size

    override fun getItem(position: Int): Any= messages[position]

    override fun getViewTypeCount(): Int {
        return 2
    }

    override fun getItemViewType(position: Int): Int {
        if (messages[position].username.equals("me"))
            return 1
        else
            return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val viewHolder: ViewHolder
        val itemView: View
        if(p1 == null){
            if (getItemViewType(p0)==0){
                itemView = LayoutInflater.from(p2?.context).inflate(R.layout.layout_item_left,p2,false)
            }
        }
    }
}