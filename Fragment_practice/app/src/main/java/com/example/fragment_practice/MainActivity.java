package com.example.fragment_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    AFragment fragmentA;
    BFragment fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //프래그먼트의 트랜젝션을 수행(프래그먼트를 추가/삭제/교체)을 수행하기 위해서는 FragmentTrasaction에서 가져온 API를 활용해야 한다.

        fragmentManager = getSupportFragmentManager();
        //FragmentTrasaction 객체를 얻기 위해서는 FragmentManager 참조 객체가 필요하다.
        //참조 객체를 얻기 위해서는 getFragmentManager() 함수 호출을 통해 가져올 수 있다.

        fragmentA = new AFragment();
        fragmentB = new BFragment();

        transaction = fragmentManager.beginTransaction();
        //FragmentTrasaction 참조 객체를 얻기 위해서는 FragmentManager의 beginTransaction() 함수를 통해 얻을 수 있다.

        transaction.replace(R.id.frameLayout, fragmentA).commitAllowingStateLoss();
        //FragmentTrasaction 의 replace() 함수를 통해 프래그먼트를 교체하는 게 가능하다.
        //첫 번째 인자는 액티비티의 레이아웃 상에서 교체되는 프래그먼트가 배치될 최상위 ViewGroup이다.
        // 레이아웃 리소스 ID값을 넘기며 위 예제에서는 FrameLayout이 해당된다. 두 번째 인자는 교체하고자 하는 Fragment 객체이다.
        //변경 내용이 적용되기 위해서는 commit 관련된 함수를 호출을 해야 변경 내용이 적용된다.
    }
    public void clickHandler(View view){    //button의 onClick 속성 정의하여 메소드 생성

        transaction = fragmentManager.beginTransaction();

        switch(view.getId())    // 위젯의 Id 속성값을 활용하여 switch~case 문을 통해 각 Button 별로 분기해서 작업 처리
        {
            case R.id.btn_fragmentA:
                transaction.replace(R.id.frameLayout, fragmentA).commitAllowingStateLoss();
                break;
            case R.id.btn_fragmentB:
                transaction.replace(R.id.frameLayout, fragmentB).commitAllowingStateLoss();
                break;
        }
    }
}