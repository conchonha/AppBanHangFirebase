package com.sangtb.appbanhang_firebase.ui.fragment.dash_board

import androidx.fragment.app.viewModels
import com.sangtb.androidlibrary.base.BaseFragment
import com.sangtb.appbanhang_firebase.R
import com.sangtb.appbanhang_firebase.databinding.FragmentDashBoardBinding

class DashBoardFragment : BaseFragment<FragmentDashBoardBinding, DashBoardViewModel>() {
    override val layoutId = R.layout.fragment_dash_board
    override val viewModel: DashBoardViewModel by viewModels()
}