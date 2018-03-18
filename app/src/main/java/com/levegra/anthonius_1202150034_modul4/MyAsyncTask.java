package com.levegra.anthonius_1202150034_modul4;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

//public class MyAsyncTask extends AsyncTask <Integer, ArrayList<HashMap<String, String>> > {
//
//    ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

//    @Override
//    protected ArrayList<HashMap<String, String>> doInBackground(String... params) {
//
//        JSONObject json = JSONfunctions.getJSONfromURL(params[0]);
//
//        try {
//            JSONArray ip = json.getJSONArray("ip");
//
//            for (int i=0;i<ip.length();i++) {
//                HashMap<String, String> map = new HashMap<String, String>();
//                JSONObject e = ip.getJSONObject(i);
//
//                map.put("id",  String.valueOf(i));
//                map.put("data1", e.getString("date"));
//                map.put("data2", "Location:" +  e.getString("location") + "   Status:" + e.getString("status"));
//                mylist.add(map);
//            }
//            return mylist
//        } catch (JSONException e) {
//            Log.e("log_tag", "Error parsing data "+e.toString());
//        }
//        return null;
//    }

//    @Override
//    protected void onPostExecute(ArrayList<HashMap<String, String>> result) {
//        ListAdapter adapter = new SimpleAdapter(MyAsyncTask.this, result , R.layout.activity_list,
//                new String[] { "data1", "data2" },
//                new int[] { R.id.item_title, R.id.item_subtitle });
//        YourActivity.this.setListAdapter(adapter); // If Activity extends ListActivity
//        final ListView lv = getListView();
//        lv.setTextFilterEnabled(true);
//
//    }

//}
