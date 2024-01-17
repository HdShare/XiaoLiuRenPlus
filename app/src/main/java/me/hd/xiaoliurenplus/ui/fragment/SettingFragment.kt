package me.hd.xiaoliurenplus.ui.fragment

import android.content.Intent
import androidx.lifecycle.ViewModel
import me.hd.xiaoliurenplus.BuildConfig
import me.hd.xiaoliurenplus.R
import me.hd.xiaoliurenplus.databinding.FragmentSettingBinding
import me.hd.xiaoliurenplus.ui.activity.logs.LogsActivity
import me.hd.xiaoliurenplus.ui.fragment.base.BaseFragment

class SettingFragment : BaseFragment<FragmentSettingBinding, ViewModel>(
    FragmentSettingBinding::inflate,
    null
) {
    override fun initFragment(
        binding: FragmentSettingBinding,
        viewModel: ViewModel?
    ) {
        binding.settingToolbar.title = getString(R.string.nav_setting_name)
        binding.tvDeveloper.text =
            getString(R.string.setting_developer).format(BuildConfig.Developer)
        binding.tvVersion.text = getString(R.string.setting_version).format(
            BuildConfig.VERSION_NAME,
            BuildConfig.VERSION_CODE
        )
        binding.llLogs.setOnClickListener {
            val intent = Intent(context, LogsActivity::class.java)
            startActivity(intent)
        }
    }
}