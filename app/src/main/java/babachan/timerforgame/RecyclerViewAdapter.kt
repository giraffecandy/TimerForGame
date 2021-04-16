package babachan.timerforgame

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter (private val context: Context): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    val items: MutableList<Data> = mutableListOf()
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val titleText: TextView = view.findViewById(R.id.titleTextView)
        val timeText: TextView = view.findViewById(R.id.time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.data_cell, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.titleText.text = item.title
        holder.timeText.text = item.time.toString()
    }

    fun addAll(items: List<Data>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}