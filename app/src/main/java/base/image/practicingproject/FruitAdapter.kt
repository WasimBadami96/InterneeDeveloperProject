package base.image.practicingproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FruitAdapter(val lst: MutableList<FruitBO?>, val click: (input: FruitBO) -> Unit) : RecyclerView.Adapter<FruitAdapter.viewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_layout,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        holder.textvar1.text = lst[position]?.name
        holder.textvar2.text = lst[position]?.taste

        holder.itemView.setOnClickListener {
            lst[position]?.let { it1 -> click(it1) }

        }
        /*holder.itemView.setOnLongClickListener {
            dclick(lst[position])
        }*/
    }

    override fun getItemCount(): Int {
        return lst.size
    }
    class viewHolder(itemview : View) : RecyclerView.ViewHolder(itemview)
    {
        var textvar1 = itemview.findViewById<TextView>(R.id.text1)
        var textvar2 = itemview.findViewById<TextView>(R.id.text2)

        }

}