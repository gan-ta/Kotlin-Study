package com.example.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tabpager.*

class TabpagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabpager)
        //tablayout은 gradle에 import시켜 주워야 함

        tab_layout.addTab(tab_layout.newTab().setText("AddView"))
        tab_layout.addTab(tab_layout.newTab().setText("ListView"))
        //tab_layout.addTab(tab_layout.newTab().setText("RecyclerView"))

        val pagerAdapter = FragmentPageAdapter(supportFragmentManager,2)
        view_pager.adapter = pagerAdapter

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {//탭이 다시 선택될 때
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {//탭이 선택되어지지 않을 때
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {//탭이 선택될 떄
                view_pager.currentItem = tab!!.position
            }
        })

        //페이지가 이동했을 때 탭을 이동시키는 코드(연동작업)
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

    }
}


//tabpgaeLayout은 Adapter를 이용하여 구현이 되어짐
//각각의 tabPage는 클래스 객체를 만들어서 접근을 하는 형태
class FragmentPageAdapter(
    fragmentManager : FragmentManager,
    val tabCount : Int
): FragmentStatePagerAdapter(fragmentManager){
    override fun getItem(position : Int): Fragment {
        when(position){
            0->{
                return AddViewActivity()
            }
            1->{
                return ListViewActivity()
            }
            else -> return AddViewActivity()
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}
