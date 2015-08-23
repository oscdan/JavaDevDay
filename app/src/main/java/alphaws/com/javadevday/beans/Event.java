package alphaws.com.javadevday.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class helps with Java Dev Day Events
 */
public class Event implements Parcelable {

    private int idEvent;
    private int idPlace;
    private int idMember;
    private String detail;
    private String startHour;
    private String finalHour;
    private boolean favourite;
    private String description;
    private String speakers;

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Event() {
        idEvent = 0;
        idPlace = 0;
        idMember = 0;
        detail = "";
        startHour = "";
        finalHour = "";
        favourite = false;
        description = "";
        speakers = "";
    }

    public Event(String detail, String startHour, String finalHour, String description, String speakers, boolean favourite) {
        this.detail = detail;
        this.startHour = startHour;
        this.finalHour = finalHour;
        this.description = description;
        this.speakers = speakers;
        this.favourite = favourite;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getFinalHour() {
        return finalHour;
    }

    public void setFinalHour(String finalHour) {
        this.finalHour = finalHour;
    }

    public String getSpeakers() {
        return speakers;
    }

    public void setSpeakers(String speakers) {
        this.speakers = speakers;
    }

    public Event(Parcel in) {
        setIdEvent(in.readInt());
        setIdPlace(in.readInt());
        setIdMember(in.readInt());
        setDetail(in.readString());
        setStartHour(in.readString());
        setFinalHour(in.readString());
        setFavourite(in.readByte() != 0);
        setDescription(in.readString());
        setSpeakers(in.readString());
    }

    public int getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(int idPlace) {
        this.idPlace = idPlace;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idSpeaker) {
        this.idMember = idSpeaker;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getIdEvent());
        dest.writeInt(getIdPlace());
        dest.writeInt(getIdMember());
        dest.writeString(getDetail());
        dest.writeString(getStartHour());
        dest.writeString(getFinalHour());
        dest.writeByte((byte) (isFavourite() ? 1 : 0));
        dest.writeString(getDescription());
        dest.writeString(getSpeakers());
    }

    public static final Parcelable.Creator<Event> CREATOR = new Creator<Event>() {

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }

        @Override
        public Event createFromParcel(Parcel source) {
            return new Event(source);
        }
    };

}
