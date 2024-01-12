package me.hd.xiaoliurenplus.ui.fragment

import android.annotation.SuppressLint
import android.view.View
import androidx.lifecycle.ViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import me.hd.xiaoliurenplus.R
import me.hd.xiaoliurenplus.databinding.FragmentHomeBinding
import me.hd.xiaoliurenplus.obj.bean.*
import me.hd.xiaoliurenplus.obj.desc.*
import me.hd.xiaoliurenplus.obj.util.*
import me.hd.xiaoliurenplus.ui.fragment.base.BaseFragment
import me.hd.xiaoliurenplus.ui.view.DiscView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class HomeFragment : BaseFragment<FragmentHomeBinding, ViewModel>(
    FragmentHomeBinding::inflate,
    null
) {
    private var type = 0
    private var day = 1
    private var hour = 0
    private var minute = 1
    private var year = 2023
    private var month = 1

    @SuppressLint("SetTextI18n")
    override fun initFragment(
        binding: FragmentHomeBinding,
        viewModel: ViewModel?
    ) {
        binding.homeToolbar.title = resources.getString(R.string.nav_home_name)
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.tab_date_name))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.tab_num_name))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.tab_time_name))
        binding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                type = tab.position
                when (tab.position) {
                    0 -> {
                        binding.includedLayoutDate.root.visibility = View.VISIBLE
                        binding.includedLayoutNum.root.visibility = View.GONE
                        binding.includedLayoutTime.root.visibility = View.GONE
                    }

                    1 -> {
                        binding.includedLayoutDate.root.visibility = View.GONE
                        binding.includedLayoutNum.root.visibility = View.VISIBLE
                        binding.includedLayoutTime.root.visibility = View.GONE
                    }

                    2 -> {
                        binding.includedLayoutDate.root.visibility = View.GONE
                        binding.includedLayoutNum.root.visibility = View.GONE
                        binding.includedLayoutTime.root.visibility = View.VISIBLE
                    }
                }
            }

            override fun onTabReselected(p0: TabLayout.Tab) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab) {
            }
        })
        initLayoutDate(binding)
        initLayoutNum(binding)
        initLayoutTime(binding)
    }

    @SuppressLint("SetTextI18n")
    private fun initLayoutDate(binding: FragmentHomeBinding) {
        binding.includedLayoutDate.tvDescTime.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val picker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(calendar.get(Calendar.HOUR_OF_DAY))
                .setMinute(calendar.get(Calendar.MINUTE))
                .setInputMode(MaterialTimePicker.INPUT_MODE_CLOCK)
                .build()
            picker.show(parentFragmentManager, picker.toString())
            picker.addOnNegativeButtonClickListener {}
            picker.addOnPositiveButtonClickListener {
                hour = picker.hour
                minute = picker.minute
                binding.includedLayoutDate.tvDescTime.text = "${hour}时${minute}分"
            }
        }
        binding.includedLayoutDate.tvDescDate.setOnClickListener {
            val picker = MaterialDatePicker.Builder.datePicker()
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()
            picker.show(parentFragmentManager, picker.toString())
            picker.addOnNegativeButtonClickListener {}
            picker.addOnPositiveButtonClickListener {
                year = SimpleDateFormat("yyyy", Locale.getDefault())
                    .format(Date(it)).toInt()
                month = SimpleDateFormat("MM", Locale.getDefault())
                    .format(Date(it)).toInt()
                day = SimpleDateFormat("dd", Locale.getDefault())
                    .format(Date(it)).toInt()
                binding.includedLayoutDate.tvDescDate.text = picker.headerText
            }
        }
        binding.includedLayoutDate.btnStart.setOnClickListener {
            val calendarInfo = 农历Util.solar2lunar(year, month, day)!!
            println(calendarInfo.toString())
            排盘(binding, calendarInfo.lDay, 地支Util.取时地支(hour))
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initLayoutNum(binding: FragmentHomeBinding) {
        binding.includedLayoutNum.tvDescTime.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val picker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(calendar.get(Calendar.HOUR_OF_DAY))
                .setMinute(calendar.get(Calendar.MINUTE))
                .setInputMode(MaterialTimePicker.INPUT_MODE_CLOCK)
                .build()
            picker.show(parentFragmentManager, picker.toString())
            picker.addOnNegativeButtonClickListener {}
            picker.addOnPositiveButtonClickListener {
                hour = picker.hour
                minute = picker.minute
                binding.includedLayoutNum.tvDescTime.text = "${hour}时${minute}分"
            }
        }
        binding.includedLayoutNum.btnStart.setOnClickListener {
            val dayStr = binding.includedLayoutNum.edtNum.text.toString()
            if (dayStr.isEmpty()) {
                binding.includedLayoutNum.edtLl.error = resources.getString(R.string.tv_num_error)
            } else {
                binding.includedLayoutNum.edtLl.error = null
                day = dayStr.toInt()
                排盘(binding, day, 地支Util.取时地支(hour))
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initLayoutTime(binding: FragmentHomeBinding) {
        binding.includedLayoutTime.tvDescTime.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val picker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(calendar.get(Calendar.HOUR_OF_DAY))
                .setMinute(calendar.get(Calendar.MINUTE))
                .setInputMode(MaterialTimePicker.INPUT_MODE_CLOCK)
                .build()
            picker.show(parentFragmentManager, picker.toString())
            picker.addOnNegativeButtonClickListener {}
            picker.addOnPositiveButtonClickListener {
                hour = picker.hour
                minute = picker.minute
                binding.includedLayoutTime.tvDescTime.text = "${hour}时${minute}分"
            }
        }
        binding.includedLayoutTime.btnStart.setOnClickListener {
            val 时地支 = 地支Util.取时地支(hour)
            val day = 地支Util.取时地支位置(时地支)
            val 刻地支 = 地支Util.取刻地支(hour, minute)
            binding.includedLayoutTime.tvDescTimeNl.text = "${时地支}时${刻地支}刻"
            排盘(binding, day, 刻地支)
        }
    }

    @SuppressLint("DiscouragedApi")
    private fun 排盘(binding: FragmentHomeBinding, 农历day: Int, 时地支: String) {
        val 日落宫 = 六宫Util.取日落宫(农历day)
        val 时落宫 = 六宫Util.取时落宫(农历day, 地支Util.取时地支位置(时地支))
        val 盘列表 = 排盘Util.取盘列表(日落宫, 时地支, 时落宫)
        置盘(binding.discView0, 盘列表[0], 日落宫, 时落宫)
        置盘(binding.discView1, 盘列表[1], 日落宫, 时落宫)
        置盘(binding.discView2, 盘列表[2], 日落宫, 时落宫)
        置盘(binding.discView3, 盘列表[3], 日落宫, 时落宫)
        置盘(binding.discView4, 盘列表[4], 日落宫, 时落宫)
        置盘(binding.discView5, 盘列表[5], 日落宫, 时落宫)
    }

    @SuppressLint("SetTextI18n")
    private fun 置盘(discview: DiscView, 排盘: 排盘Bean, 日落宫: String, 时落宫: String) {
        discview.binding.discGongwei.text = 排盘.宫位
        discview.binding.discDizhi.text = 排盘.地支 + "\n" + 排盘.五行
        discview.binding.discLuogong.text = when (type) {
            0 -> if (排盘.宫位 == 日落宫) "日" else if (排盘.宫位 == 时落宫) "时" else ""
            1 -> if (排盘.宫位 == 日落宫) "数" else if (排盘.宫位 == 时落宫) "时" else ""
            2 -> if (排盘.宫位 == 日落宫) "时" else if (排盘.宫位 == 时落宫) "刻" else ""
            else -> ""
        }
        discview.binding.discLiuqin.text = 排盘.六亲
        discview.binding.discLiushen.text = 排盘.六神
        discview.binding.discWuxing.text = 排盘.五星

        val message = 排盘.toString() +
                "\n\n" + "宫位: \n${六宫Desc.信息[排盘.宫位]}" +
                "\n\n" + "地支: \n${地支Desc.信息[排盘.地支]}" +
                "\n\n" + "五行: \n${五行Desc.信息[排盘.五行]}" +
                "\n\n" + "六亲: \n${六亲Desc.信息[排盘.六亲]}" +
                "\n\n" + "六神: \n${六神Desc.信息[排盘.六神]}" +
                "\n\n" + "五星: \n${五星Desc.信息[排盘.五星]}"
        discview.binding.discView.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(排盘.宫位)
                .setMessage(message)
                .setNegativeButton("Decline") { _, _ -> }
                .setPositiveButton("Accept") { _, _ -> }
                .show()
        }
    }
}