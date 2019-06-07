package devanir.soaresjunior.challenge_jsonplaceholder.rvAdapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import devanir.soaresjunior.challenge_jsonplaceholder.R
import devanir.soaresjunior.challenge_jsonplaceholder.data.entities.AlbumEntity
import kotlinx.android.synthetic.main.rv_adaptr_layout.view.*

class AlbumAdapter(private val listener: OnItemClickedListener): ListAdapter<AlbumEntity, AlbumAdapter.ViewHolder>(DIFF_CALLBACK){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.rv_adaptr_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumAdapter.ViewHolder, position: Int) {
        val album = getItem(position)
        holder.apply {
            setContent(album)
            itemView.setOnClickListener { listener.onItemClicked(position) }
        }
    }

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
        fun setContent(album: AlbumEntity){
            view.apply {
                tvTitle.text = album.title
            }
        }
    }

    interface OnItemClickedListener{
        fun onItemClicked(position: Int)
    }

    companion object {
        val DIFF_CALLBACK : DiffUtil.ItemCallback<AlbumEntity> = object : DiffUtil.ItemCallback<AlbumEntity>(){
            override fun areItemsTheSame(oldItem: AlbumEntity, newItem: AlbumEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: AlbumEntity, newItem: AlbumEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}
