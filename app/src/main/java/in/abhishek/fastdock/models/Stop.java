package in.abhishek.fastdock.models;

import android.location.Location;

/**
 * Created by abhishek on 28/01/16 at 1:50 AM.
 */
public class Stop {

    private int mStopNo;
    private String mPlace;
    private String mDistance;
    private String mToStop;
    private String mStartCord;
    private String mEndCord;

    public Stop(int stopNo, String place, String distance, String toStop, StartLocation startCord, EndLocation endCord) {

        mStopNo = stopNo;
        mPlace = place;
        mDistance = distance;
        mToStop = toStop;
        mStartCord = startCord.getLat() + "," + startCord.getLng();
        mEndCord = endCord.getLat() + "," + endCord.getLng();
    }

    public int getStopNo() {
        return mStopNo;
    }

    public String getPlace() {
        return mPlace;
    }

    public String getDistance() {
        return mDistance;
    }

    public String getToStop() {
        return mToStop;
    }

    public String getStartCord() {
        return mStartCord;
    }

    public String getEndCord() {
        return mEndCord;
    }
}
