package me.hd.xiaoliurenplus.ui.activity.logs

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.gson.reflect.TypeToken
import me.hd.xiaoliurenplus.MainApp
import me.hd.xiaoliurenplus.R
import me.hd.xiaoliurenplus.databinding.ActivityLogsDetailBinding
import me.hd.xiaoliurenplus.obj.bean.*
import me.hd.xiaoliurenplus.obj.desc.*
import me.hd.xiaoliurenplus.obj.util.*
import me.hd.xiaoliurenplus.sql.entity.Logs
import me.hd.xiaoliurenplus.ui.view.DiscView

class LogsDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogsDetailBinding
    private lateinit var logs: Logs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getIntExtra("id", -1)
        logs = MainApp.logsDao.queryById(id)
        initView()
        initListener()
        initData()
    }

    private fun initView() {
        binding.logsDetailToolbar.title = getString(R.string.logs_detail)
    }

    private fun initListener() {
        binding.logsDetailToolbar.setNavigationOnClickListener { finish() }
        binding.logsDetailToolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.toolbar_delete -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("提示")
                        .setMessage("是否确定删除这条数据")
                        .setPositiveButton("确定") { _, _ ->
                            MainApp.logsDao.delete(logs.id)
                            Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show()
                            finish()
                        }
                        .setNegativeButton("取消") { _, _ -> }
                        .show()
                }

                R.id.toolbar_save -> {
                    logs.何事 = binding.logsDetailEdtTitle.text.toString()
                    binding.logsDetailRgResult.checkedRadioButtonId.let {
                        when (it) {
                            R.id.logsDetailRbTrue -> {
                                logs.判断 = resources.getString(R.string.logs_true)
                            }

                            R.id.logsDetailRbFalse -> {
                                logs.判断 = resources.getString(R.string.logs_false)
                            }

                            else -> logs.判断 = resources.getString(R.string.logs_none)
                        }
                    }
                    logs.断语 = binding.logsDetailEdtAbout.text.toString()
                    logs.反馈 = binding.logsDetailEdtFeedback.text.toString()
                    MainApp.logsDao.update(logs)
                    Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show()
                }
            }
            false
        }
    }

    private fun initData() {
        binding.logsDetailEdtTitle.setText(logs.何事)
        when (logs.判断) {
            resources.getString(R.string.logs_true) -> {
                binding.logsDetailRbTrue.isChecked = true
            }

            resources.getString(R.string.logs_false) -> {
                binding.logsDetailRbFalse.isChecked = true
            }

            else -> binding.logsDetailRbNone.isChecked = true
        }
        binding.logsDetailEdtAbout.setText(logs.断语)
        binding.logsDetailEdtFeedback.setText(logs.反馈)

        val listType = object : TypeToken<List<排盘Bean>>() {}.type
        val 盘列表: List<排盘Bean> = MainApp.gson.fromJson(logs.排盘, listType)
        置盘(binding.logsDetailDiscView0, logs.类型, 盘列表[0], logs.日落宫, logs.时落宫)
        置盘(binding.logsDetailDiscView1, logs.类型, 盘列表[1], logs.日落宫, logs.时落宫)
        置盘(binding.logsDetailDiscView2, logs.类型, 盘列表[2], logs.日落宫, logs.时落宫)
        置盘(binding.logsDetailDiscView3, logs.类型, 盘列表[3], logs.日落宫, logs.时落宫)
        置盘(binding.logsDetailDiscView4, logs.类型, 盘列表[4], logs.日落宫, logs.时落宫)
        置盘(binding.logsDetailDiscView5, logs.类型, 盘列表[5], logs.日落宫, logs.时落宫)
    }

    @SuppressLint("SetTextI18n")
    private fun 置盘(
        discview: DiscView, type: Int,
        排盘: 排盘Bean, 日落宫: String, 时落宫: String
    ) {
        discview.binding.discGongwei.text = 排盘.宫位
        discview.binding.discGongwei.setTextColor(颜色Util.取宫位颜色(排盘.宫位))
        discview.binding.discDizhi.text = 排盘.地支 + "\n" + 排盘.五行
        discview.binding.discDizhi.setTextColor(颜色Util.取五行颜色(排盘.五行))
        discview.binding.discLuogong.text = when (type) {
            0 -> if (排盘.宫位 == 日落宫 && 排盘.宫位 == 时落宫) "日时" else if (排盘.宫位 == 日落宫) "日" else if (排盘.宫位 == 时落宫) "时" else ""
            1 -> if (排盘.宫位 == 日落宫 && 排盘.宫位 == 时落宫) "数时" else if (排盘.宫位 == 日落宫) "数" else if (排盘.宫位 == 时落宫) "时" else ""
            2 -> if (排盘.宫位 == 日落宫 && 排盘.宫位 == 时落宫) "时刻" else if (排盘.宫位 == 日落宫) "时" else if (排盘.宫位 == 时落宫) "刻" else ""
            else -> ""
        }
        discview.binding.discLuogong.setTextColor(颜色Util.取落宫颜色())
        discview.binding.discLiuqin.text = 排盘.六亲
        discview.binding.discLiuqin.setTextColor(颜色Util.取六亲颜色(排盘.六亲))
        discview.binding.discLiushen.text = 排盘.六神
        discview.binding.discLiushen.setTextColor(颜色Util.取六神颜色(排盘.六神))
        discview.binding.discWuxing.text = 排盘.五星
        discview.binding.discWuxing.setTextColor(颜色Util.取五星颜色(排盘.五星))

        val message = 排盘.toString() +
                "\n\n" + "宫位: \n${六宫Desc.信息[排盘.宫位]}" +
                "\n\n" + "地支: \n${地支Desc.信息[排盘.地支]}" +
                "\n\n" + "相合: \n${相合Desc.信息[排盘.地支]}" +
                "\n\n" + "五行: \n${五行Desc.信息[排盘.五行]}" +
                "\n\n" + "六亲: \n${六亲Desc.信息[排盘.六亲]}" +
                "\n\n" + "六神: \n${六神Desc.信息[排盘.六神]}" +
                "\n\n" + "五星: \n${五星Desc.信息[排盘.五星]}"
        discview.binding.discView.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle(排盘.宫位)
                .setMessage(message)
                .setNegativeButton("Decline") { _, _ -> }
                .setPositiveButton("Accept") { _, _ -> }
                .show()
        }
    }
}