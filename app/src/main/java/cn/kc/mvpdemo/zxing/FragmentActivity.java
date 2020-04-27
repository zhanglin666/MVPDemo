package cn.kc.mvpdemo.zxing;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import cn.kc.mvpdemo.R;

public class FragmentActivity extends AppCompatActivity {

    private ScanFragment scanFragment = new ScanFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        initView();
    }

    private void initView() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container, scanFragment).commit();


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1111) {
            if (data != null) {

                String content = data.getStringExtra("codedContent");
                Log.i("扫描结果为:", content);

                scanFragment.onActivityResult(requestCode, resultCode, data);

            }
        }

    }
}
