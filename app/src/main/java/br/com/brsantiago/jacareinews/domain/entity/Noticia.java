package br.com.brsantiago.jacareinews.domain.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bruno.oliveira on 04/01/2017.
 */

public class Noticia implements Parcelable {

    public Long code;
    public String guid;
    public String title;
    public String content;
    public String link;
    public String pubDate;

    public Noticia() {

    }
    protected Noticia(Parcel in) {
        guid = in.readString();
        title = in.readString();
        content = in.readString();
        link = in.readString();
        pubDate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(guid);
        dest.writeString(title);
        dest.writeString(content);
        dest.writeString(link);
        dest.writeString(pubDate);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Noticia> CREATOR = new Creator<Noticia>() {
        @Override
        public Noticia createFromParcel(Parcel in) {
            return new Noticia(in);
        }

        @Override
        public Noticia[] newArray(int size) {
            return new Noticia[size];
        }
    };
}
