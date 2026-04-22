package com.example.connectparbhsni;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class TrainModel implements Parcelable {
    private final String trainNumber;
    private final String trainName;
    private final String fromStation;
    private final String toStation;
    private final String departureTime;
    private final String arrivalTime;
    private final List<String> stationList;

    public TrainModel(String trainNumber, String trainName, String fromStation, String toStation, String departureTime, String arrivalTime, List<String> stationList) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.stationList = stationList;
    }

    protected TrainModel(Parcel in) {
        trainNumber = in.readString();
        trainName = in.readString();
        fromStation = in.readString();
        toStation = in.readString();
        departureTime = in.readString();
        arrivalTime = in.readString();
        stationList = in.createStringArrayList();
    }

    public static final Creator<TrainModel> CREATOR = new Creator<TrainModel>() {
        @Override
        public TrainModel createFromParcel(Parcel in) {
            return new TrainModel(in);
        }

        @Override
        public TrainModel[] newArray(int size) {
            return new TrainModel[size];
        }
    };

    public String getTrainNumber() { return trainNumber; }
    public String getTrainName() { return trainName; }
    public String getFromStation() { return fromStation; }
    public String getToStation() { return toStation; }
    public String getDepartureTime() { return departureTime; }
    public String getArrivalTime() { return arrivalTime; }
    public List<String> getStationList() { return stationList; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(trainNumber);
        dest.writeString(trainName);
        dest.writeString(fromStation);
        dest.writeString(toStation);
        dest.writeString(departureTime);
        dest.writeString(arrivalTime);
        dest.writeStringList(stationList);
    }
}
