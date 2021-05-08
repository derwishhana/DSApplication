package com.example.dsapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Client implements Parcelable  {

        private String name;

        private String firstName;

        private Date birthDate;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }



    public Date getBirthDate() {
        return birthDate;
    }

    public Client()
    {

    }
    public Client(String name, String firstName, Date birthDate) {
        this.name = name;
        this.firstName=firstName;
        this.birthDate=birthDate;
    }

    public Client(Parcel in) {
            name = in.readString();
            firstName = in.readString();
            birthDate = (Date) in.readSerializable();
        }

        public static final Parcelable.Creator<Client> CREATOR = new Parcelable.Creator<Client>() {
            @Override
            public Client createFromParcel(Parcel source) {
                return new Client(source);
            }

            @Override
            public Client[] newArray(int size) {
                return new Client[size];
            }
        };

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(name);
            dest.writeString(firstName);
            dest.writeSerializable(birthDate);

        }

        @Override
        public int describeContents() {
            return 0;
        }

    }
