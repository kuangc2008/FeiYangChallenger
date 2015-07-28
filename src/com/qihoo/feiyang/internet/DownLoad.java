package com.qihoo.feiyang.internet;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;

import java.io.File;

/**
 * Created by Tristan_Hou on 2015/7/27.
 */
public class DownLoad {
    private Context context;
    private String uri = null;
    private String apkName = null;
    private String apkPath = null;

    public DownLoad(Context context,String uri){
        this.context = context;
        this.uri = uri;
        getApkName();
    }

    private void getApkName(){
        if(uri == null){
            return;
        }
        int lastIndex = uri.lastIndexOf("/");
        apkName = uri.substring(lastIndex);
    }

    //�ļ����ڣ�����true�������ڣ�false
    public boolean checkFileExit(){
        Boolean flag = false;
        apkPath = Environment.getExternalStorageDirectory().getAbsolutePath() + apkName;
        File apkFile = new File(apkPath);
        if(apkFile.exists()){
            flag = true;
        }
        return flag;
    }

    public void processDownLoad(){
        if(uri == null){
            return;
        }
        //apkPath�Ƿ���Ч·��
        if(apkPath == null){
            if(apkName == null){
                getApkName();
                apkPath = Environment.getExternalStorageDirectory().getAbsolutePath() + apkName;
            }else{
                apkPath = Environment.getExternalStorageDirectory().getAbsolutePath() + apkName;
            }
        }
        FinalHttp finalHttp = new FinalHttp();
        finalHttp.download(uri, apkPath, new AjaxCallBack<File>() {
            @Override
            public void onStart() {
                super.onStart();
                Toast.makeText(context, "begin download", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoading(long count, long current) {
                super.onLoading(count, current);
                /*int progress=0;
                if (current != count && current != 0) {
                    progress = (int) (current / (float) count * 100);
                } else {
                    progress = 100;
                }*/
                Toast.makeText(context, "downloading", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(File file) {
                super.onSuccess(file);
                Toast.makeText(context, "download success!", Toast.LENGTH_SHORT).show();
                //textView.setText(t==null?"null": t.getAbsoluteFile().toString());
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
                Toast.makeText(context, "download fail...", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
