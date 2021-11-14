package com.example.myshop.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.myshop.R
import com.example.myshop.domain.ShopItem

class ShopListAdapter : ListAdapter<ShopItem, ShopListViewHolder>(ShopItemDiffCallback()) {

//    RecyclerView.Adapter<ShopListAdapter.ShopListViewHolder>()

//    var shopList = listOf<ShopItem>()
//    set(value) {
//        val callback = ShopListDiffCallback(shopList, value)
//        val diffResult = DiffUtil.calculateDiff(callback)
//        diffResult.dispatchUpdatesTo(this)
//        field = value
//    }

    var onShopItemLongClickListener : ((ShopItem) -> Unit)? = null
    var onShopItemClickListener : ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopListViewHolder {
        val layout = when (viewType) {
            VIEW_TYPE_ENABLED -> R.layout.item_shop_enabled
            VIEW_TYPE_DISABLED -> R.layout.item_shop_disabled
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopListViewHolder, position: Int) {
        val shopItem = getItem(position)
        holder.tvName.text = shopItem.name
        holder.tvCount.text = shopItem.count.toString()
        holder.itemView.setOnLongClickListener{
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }
        holder.itemView.setOnClickListener{
            onShopItemClickListener?.invoke(shopItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val shopItem = getItem(position)
        return if (shopItem.enabled){
            VIEW_TYPE_ENABLED
        }else{
            VIEW_TYPE_DISABLED
        }
    }

//    override fun onViewRecycled(holder: ShopListViewHolder) {
//        super.onViewRecycled(holder)
//        holder.tvName.text = ""
//        holder.tvCount.text = ""
//        holder.tvName.setTextColor(
//            ContextCompat.getColor(
//                holder.itemView.context,
//                android.R.color.white
//            )
//        )
//    }

//    override fun getItemCount(): Int {
//        return shopList.size
//    }

    companion object{
        const val VIEW_TYPE_ENABLED = 100
        const val VIEW_TYPE_DISABLED = 101
        const val MAX_POOL_SIZE = 30
    }
}