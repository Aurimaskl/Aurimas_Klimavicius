package com.example.VismaTask;
//object
public class Photo {
    //object content
    String photoURL;
    //object constructor (for data retrieval and making photo)
    public Photo(String mPhotoURL){
        this.photoURL = mPhotoURL;
    }
//getter for making String photoUSL = Photo.getPhotoURL();
    public String getPhotoURL() {
        return photoURL;
    }
}
