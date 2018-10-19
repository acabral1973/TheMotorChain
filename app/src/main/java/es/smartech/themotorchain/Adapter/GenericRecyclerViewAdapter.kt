package es.smartech.themotorchain.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import es.smartech.domain.Model.Aggregate
import es.smartech.domain.Model.Listable
import es.smartech.themotorchain.OrientationMode
import es.smartech.themotorchain.R

class GenericRecyclerViewAdapter<Z: Listable, T : Aggregate<Z>>(val content: T, val orientation: OrientationMode) : RecyclerView.Adapter<GenericRecyclerViewAdapter<Z, T>.ContentViewHolder>() {


    var onClickListener : View.OnClickListener? = null
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val cellLayout = if (orientation == OrientationMode.VERTICAL) {
            R.layout.generic_cell_vertical} else {R.layout.generic_cell_horizontal}
        val view = LayoutInflater.from(parent.context).inflate(cellLayout, parent, false)
        view.setOnClickListener(onClickListener)
        context = parent.getContext()
        return ContentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return content.count()
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {

        val contentImage= content.get(position).get_Image()
        val contentTitle = content.get(position).getTitle()
        val contentSubTitle = if (orientation == OrientationMode.VERTICAL) { content.get(position).getSubtitle() } else {""}

        holder?.bindShop(contentImage, contentTitle, contentSubTitle)
    }

    inner class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val contentimage = itemView.findViewById<ImageView>(R.id.content_image)
        val contentTitle = itemView.findViewById<TextView>(R.id.content_title)
        val contentSubtitle = itemView.findViewById<TextView>(R.id.content_subtitle)

        fun bindShop(image: String, title: String, subTitle: String) {

            // Si la imagen  no es vacía la muestro, si lo es quito el ImageView de la vista
            if (image != "") {
                Picasso.get().load(image).placeholder(R.drawable.loading).into(contentimage)

            } else {
                contentimage.visibility = View.GONE
            }
            contentTitle.text = title
            if (subTitle != "") { contentSubtitle.text = subTitle }
        }
    }
}