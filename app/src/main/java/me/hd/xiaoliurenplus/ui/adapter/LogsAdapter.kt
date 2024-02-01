package me.hd.xiaoliurenplus.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.hd.xiaoliurenplus.R
import me.hd.xiaoliurenplus.databinding.ItemRvLogsBinding
import me.hd.xiaoliurenplus.sql.entity.Logs
import me.hd.xiaoliurenplus.ui.activity.logs.LogsDetailActivity

class LogsAdapter(private val list: List<Logs>) :
    RecyclerView.Adapter<LogsAdapter.LogsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogsViewHolder {
        val binding = ItemRvLogsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LogsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LogsViewHolder, position: Int) {
        val log = list[position]
        holder.itemView.apply {
            holder.binding.itemLogsTime.text = log.何时
            holder.binding.itemLogsType.text = when (log.类型) {
                0 -> resources.getString(R.string.tab_date_name)
                1 -> resources.getString(R.string.tab_num_name)
                2 -> resources.getString(R.string.tab_time_name)
                else -> resources.getString(R.string.tab_error_name)
            }
            holder.binding.itemLogsTitle.text = log.何事
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, LogsDetailActivity::class.java)
            intent.putExtra("id", log.id)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = list.size

    class LogsViewHolder(val binding: ItemRvLogsBinding) : RecyclerView.ViewHolder(binding.root)

}