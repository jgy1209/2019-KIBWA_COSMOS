package org.techtown.location;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class LOST implements Parcelable
{
    private String name;
    private String tel;
    private ArrayList<String> menu;
    private String homepage;
    private String date;
    private int categorynum;

    public LOST(String name, String tel, String homepage, int categorynum)
    {
        this.name = name;
        this.tel = tel;
        this.homepage = homepage;
        this.categorynum = categorynum;
        menu = new ArrayList<String>();
    }


    protected LOST(Parcel in) {
        name = in.readString();
        tel = in.readString();
        menu = in.createStringArrayList();
        homepage = in.readString();
        date = in.readString();
        categorynum = in.readInt();
    }

    public static final Creator<LOST> CREATOR = new Creator<LOST>() {
        @Override
        public LOST createFromParcel(Parcel in) {
            return new LOST(in);
        }

        @Override
        public LOST[] newArray(int size) {
            return new LOST[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(tel);
        dest.writeStringList(menu);
        dest.writeString(homepage);
        dest.writeString(date);
        dest.writeInt(categorynum);
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public String getmenu1()
    {
        return menu.get(0);
    }
    /*
    public String getmenu2() { return menu.get(1); }
    public String getmenu3() { return menu.get(2); }
  */
    public String getHomepage() {
        return homepage;
    }

    public String getDate() {
        return date;
    }

    public int getCategorynum() {
        return categorynum;
    }

    public String printmenu(){
        String str = menu.get(0) + ", " + menu.get(1) + ", " +menu.get(2);
        return str;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setMenu(String item) {
        menu.add(item);
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCategorynum(int categorynum) {
        this.categorynum = categorynum;
    }

}

