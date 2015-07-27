package com.qihoo.feiyang.internet;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.qihoo.feiyang.ui.HoujhFragment;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by houjianhua on 2015/7/24.
 */
public class HttpProcess {

    private ConnectTask connectTask;
    private Context context;
    private String username;
    private String password;

    public HttpProcess(Context context, String username, String password){
        this.context = context;
        this.username = username;
        this.password = password;
    }

    public void send(){
        connectTask = new ConnectTask(context, username, password);
        connectTask.execute();
    }

    private class ConnectTask extends AsyncTask{
        private String ip = "10.19.6.249";//10.18.61.102";
        private String port = "8001";
        private String uri = "http://"+ip+":"+port+"/feiyang/login";
        private Toast toast;
        private Context context;
        private String data;
        private String username;
        private String password;

        ConnectTask( Context context, String username, String password){
            this.context = context;
            this.username = username;
            this.password = password;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            toast.makeText(context, "Logining...", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Object doInBackground(Object[] params) {
            int statusCode = -1;
            try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpGet httpGet = new HttpGet(uri+"/username="+username+"/password="+password);
                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity httpEntity = httpResponse.getEntity();
                StatusLine statusLine = httpResponse.getStatusLine();
                //String statusString = statusLine.getReasonPhrase();
                statusCode = statusLine.getStatusCode();
                if(statusCode != 200){
                    return statusCode;
                }
                //publishProgress(statusCode);
                if (httpEntity != null) {
                    InputStream instreams = httpEntity.getContent();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                            instreams));
                    StringBuilder stringBuilder=new StringBuilder();
                    String line = null;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line + "\n");
                    }
                    System.out.println(stringBuilder.toString());
                    data = stringBuilder.toString();
                    httpGet.abort();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return statusCode;
        }

        /*@Override
        protected void onProgressUpdate(Object[] values) {
            super.onProgressUpdate(values);
        }*/

        @Override
        protected void onPostExecute(Object result) {
            super.onPostExecute(result);
            int res2int = Integer.parseInt(String.valueOf(result));
            if(res2int == 200){
                Intent intent = new Intent();
                intent.setClass(context, HoujhFragment.class);
                context.startService(intent);
                toast.makeText(context, "Login success.", Toast.LENGTH_SHORT).show();
            }else{
                toast.makeText(context, "Login fail.", Toast.LENGTH_SHORT).show();
            }

            /*if(comuniListener!=null){
                comuniListener.loadComlpete();
            }*/
        }
    }
}
