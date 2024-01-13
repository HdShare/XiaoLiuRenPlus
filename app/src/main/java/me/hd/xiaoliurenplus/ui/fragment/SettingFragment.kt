package me.hd.xiaoliurenplus.ui.fragment

import androidx.lifecycle.ViewModel
import me.hd.xiaoliurenplus.BuildConfig
import me.hd.xiaoliurenplus.R
import me.hd.xiaoliurenplus.databinding.FragmentSettingBinding
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
        binding.tvAbout.text = getString(R.string.setting_about).format(
            BuildConfig.VERSION_NAME,
            BuildConfig.VERSION_CODE
        )
    }
}