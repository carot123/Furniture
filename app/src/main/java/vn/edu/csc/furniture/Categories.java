package vn.edu.csc.furniture;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Categories {
    String name;
    ArrayList<Furniture> arrayList;
    String image;


    public Categories(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public Categories(String name, ArrayList<Furniture> arrayList) {
        this.name = name;
        this.arrayList = arrayList;
    }

    public Categories(String name, ArrayList<Furniture> arrayList, String image) {
        this.name = name;
        this.arrayList = arrayList;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Furniture> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Furniture> arrayList) {
        this.arrayList = arrayList;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
