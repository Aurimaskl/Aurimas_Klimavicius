package com.example.VismaTask;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONExtractor extends AsyncTaskLoader<List<Photo>> {
    private String[] mJson;

    public JSONExtractor(Context context, String[] json) {
        //constructor with context and json string
        super(context);
        mJson = json;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Photo> loadInBackground() {
        List<Photo> photos = new ArrayList<>();
        try {
            String partJSON = "";
            //loop for all String parts to be taken
            for (int im = 0; im < mJson.length; im++) {
                //one item from string array is given as unique string and starts the whole extraction process
                partJSON = mJson[im];
                //
                //not working tries for reading the files
                //Object obj = parser.parse(new)
//            InputStream is = new FileInputStream("D:\\Android2018\\MyApplication9\\app\\dog_urls.json");
//            int size = is.available();
//            byte[] buffer = new byte[size];
//            is.read(buffer);
//            is.close();
//            mJson = new String(buffer, "UTF-8");
//            Log.e("TAg", mJson);
                //JSONObject jsonObject = new JSONObject(IOUtils.toString(is, "UTF-8"));
                //new JSONObject(mJson);
                //
                JSONObject jsonObject = new JSONObject(partJSON);
                JSONArray jsonArray = jsonObject.getJSONArray("urls");
                for (int i = 0; i < jsonArray.length(); i++) {
                    //from array reading pictures one by one with loop and writing to photo object
                    String imageURL = jsonArray.getString(i);
                    //extract by one to photo object, later add to list photo
                    photos.add(new Photo(imageURL));
                }
            }
        } catch (JSONException e) {
            //in case something fails
            Log.e("Utils", "json problem", e);
        }
        //exceptions for those files reading
//         catch (FileNotFoundException er){
//             Log.e("Utils", "file problem", er);
//
//         }
//         catch(IOException err){
//             Log.e("Utils", "IO problem", err);
//
//         }

        return photos;
    }

}