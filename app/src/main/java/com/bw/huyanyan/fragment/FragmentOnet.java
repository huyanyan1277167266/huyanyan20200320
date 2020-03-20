package com.bw.huyanyan.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;

import com.bw.huyanyan.R;
import com.bw.huyanyan.activit.BaseFragment;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

/*
 *@Auther:cln
 *@Date: 2020/3/20
 *@Time:13:56
 *@Description:
 * */public class FragmentOnet extends BaseFragment {

    private static final int DERMISSION_REQUEST_CODE = 100;
    private static final int SCAN_QR_REQUEST_CODE =DERMISSION_REQUEST_CODE+1 ;
    private ImageView iv;
    String str="二维码二维码二维码";
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    protected void initView(View view) {
        iv = view.findViewById(R.id.iv);
//        checkCameraprmission();
//        qingqiupermission();
//        dosan();

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (str!=null){
                    Toast.makeText(getActivity(), "二维码的信息"+str, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    protected void getData() {

    }




    //检测相机
    private boolean checkCameraprmission() {
        return PermissionChecker.checkCallingOrSelfPermission(getActivity(), Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED;
    }
    //请求相机
    private void qingqiupermission() {
        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CAMERA},DERMISSION_REQUEST_CODE);
    }
    private void dosan() {
        Intent intent = new Intent(getActivity(), CaptureActivity.class);
        startActivityForResult(intent,SCAN_QR_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==SCAN_QR_REQUEST_CODE){
            if (null!=data){
                Bundle bundle = data.getExtras();
             if (bundle==null){
                 return;
             }
             if (bundle.getInt(CodeUtils.RESULT_TYPE)==CodeUtils.RESULT_SUCCESS){
                 String string = bundle.getString(CodeUtils.RESULT_STRING);
                 Log.i("xxx",string);
             }else if (bundle.getInt(CodeUtils.RESULT_TYPE)==CodeUtils.RESULT_FAILED){
                 Toast.makeText(getActivity(), "不成功", Toast.LENGTH_SHORT).show();
             }
            }
        }
    }


}
