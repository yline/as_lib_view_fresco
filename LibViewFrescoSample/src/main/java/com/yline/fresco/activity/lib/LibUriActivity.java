package com.yline.fresco.activity.lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import com.yline.base.BaseAppCompatActivity;
import com.yline.view.fresco.FrescoManager;
import com.yline.fresco.activity.IApplication;
import com.yline.fresco.sample.R;
import com.yline.view.fresco.view.FrescoView;
import com.yline.test.UrlConstant;

public class LibUriActivity extends BaseAppCompatActivity {
    private static final int Duration = 5_000;

    private FrescoView frescoView;

    private TextView tvHint;

    private String uriStr;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 0:
                    uriStr = UrlConstant.getJpg_640_960();
                    break;
                case 1:
                    uriStr = UrlConstant.getPng_420_300();
                    break;
                case 2:
                    uriStr = IApplication.BenDiUrl;
                    break;
                case 3:
                    uriStr = UrlConstant.getWebp_Static();
                    break;
                case 4:
                    uriStr = UrlConstant.getGif();
                    break;
                case 5:
                    uriStr = UrlConstant.getWebp_Dynamic();
                    Log.i("xxx-", "handleMessage: stop");
                    break;
            }

            FrescoManager.setImageUri(frescoView, uriStr);
            tvHint.setText(uriStr);

            if (msg.what < 5) {
                sendEmptyMessageDelayed(msg.what + 1, Duration);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib_uri);

        frescoView = (FrescoView) findViewById(R.id.lib_uri_fresco_view);
        tvHint = (TextView) findViewById(R.id.lib_uri_tv_hint);

        mHandler.sendEmptyMessage(0);
    }

    public static void launcher(Context context) {
        if (null != context) {
            Intent intent = new Intent(context, LibUriActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }
            context.startActivity(intent);
        }
    }
}
