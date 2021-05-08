package com.example.dsapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.LinkedList;

    public class ClientList extends LinkedList<Client> implements Parcelable {

        public ClientList(Parcel in) {
            in.readList(this, Client.class.getClassLoader());
        }

        public final Parcelable.Creator<ClientList> CREATOR = new Parcelable.Creator<ClientList>() {
            @Override
            public ClientList createFromParcel(Parcel source) {
                return new ClientList(source);
            }

            @Override
            public ClientList[] newArray(int size) {
                return new ClientList[size];
            }
        };

        public ClientList() {
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeList(this);
        }

        @Override
        public int describeContents() {
            return 0;
        }

    }


