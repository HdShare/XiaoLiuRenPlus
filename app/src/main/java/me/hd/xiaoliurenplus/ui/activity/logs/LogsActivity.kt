package me.hd.xiaoliurenplus.ui.activity.logs

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import me.hd.xiaoliurenplus.MainApp
import me.hd.xiaoliurenplus.R
import me.hd.xiaoliurenplus.databinding.ActivityLogsBinding
import me.hd.xiaoliurenplus.sql.entity.Logs
import me.hd.xiaoliurenplus.ui.adapter.LogsAdapter

class LogsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogsBinding
    private var logsList = mutableListOf<Logs>()
    private lateinit var adapter: LogsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initListener()
    }

    override fun onResume() {
        super.onResume()
        initData()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initView() {
        binding.logsToolbar.title = getString(R.string.setting_logs)
        binding.logsRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = LogsAdapter(logsList)
        binding.logsRecyclerView.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initListener() {
        binding.logsToolbar.setNavigationOnClickListener { finish() }
        binding.logsToolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.toolbar_clear -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("提示")
                        .setMessage("是否确定清空所有数据")
                        .setPositiveButton("确定") { _, _ ->
                            logsList.clear()
                            MainApp.logsDao.deleteAll()
                            adapter.notifyDataSetChanged()
                            Toast.makeText(this, "清空成功", Toast.LENGTH_SHORT).show()
                        }
                        .setNegativeButton("取消") { _, _ -> }
                        .show()
                }
            }
            false
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initData() {
        logsList.clear()
        logsList.addAll(MainApp.logsDao.queryAll())
        adapter.notifyDataSetChanged()
    }
}