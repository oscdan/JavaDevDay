package alphaws.com.javadevday.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class Place implements Parcelable{
	private int idPlace;
	private String Name;
	
	public int getIdPlace() {
		return idPlace;
	}

	public void setIdPlace(int idPlace) {
		this.idPlace = idPlace;
	}

	public String getName() {
		return Name;
	}

	public void setName(String detail) {
		this.Name = detail;
	}

	public Place(){
		idPlace = 0;
		Name = "";
	}
	
	public Place(Parcel in){
		setIdPlace(in.readInt());
		setName(in.readString());
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(getIdPlace());
		dest.writeString(getName());
	}
	
	public static final Parcelable.Creator<Place> CREATOR = new Creator<Place>() {
		
		@Override
		public Place[] newArray(int size) {
			return new Place[size];
		}
		
		@Override
		public Place createFromParcel(Parcel source) {
			return new Place(source);
		}
	};
	
}
