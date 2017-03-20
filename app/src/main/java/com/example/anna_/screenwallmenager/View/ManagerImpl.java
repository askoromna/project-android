//package com.example.anna_.screenwallmenager.View;
//
//
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.util.Log;
//import android.widget.Toast;
//
//import com.example.anna_.screenwallmenager.Model.Video;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import static android.R.attr.button;
//
//public class ManagerImpl implements Manager {
//
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.ManagerImpl);
//        new GetButton().execute();
//    }
//
//    protected void doInBackground(Void... arg0) {
//
//            try {
//
//                JSONObject jsonObj = new JSONObject(button);
//                JSONArray button = jsonObj.getJSONArray("button");
//                Video v = new Video();
//                for (int i = 0; i < button.length(); i++) {
//                    JSONObject b = button.getJSONObject(i);
//                    v idv=b.getString("idv");
//                    int mute =b.getInt("mute");
//                    int volume=b.getInt("volume");
//                    v.setID =  b.getString("ids");
////                    Tab scenario=b.getString("scenario");
////
////                    //JSONObject b = button.setJSONObject(i);
////                    jsonObj.put("idv",);
////                    b.setString("idv");
////                    int mute =b.setInt("mute");
////                    int volume=b.setInt("volume");
////                    String ids=b.setString("ids");
////                    Tab scenario=b.setString("scenario");
//                }
//            } catch(final JSONException e) {
//
//                Log.e(TAG, "Json parsing error: "+ e.getMessage());
//                runOnUiThread(new Runnable() {
//                    public void run(){
//                        Toast.makeText(getApplicationContext(),
//                                "Json parsing error: "+e.getMessage(),
//                                Toast.LENGTH_LONG).show();
//                    }
//                });
//                return null;
//            }
//}
//}
