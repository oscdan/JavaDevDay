package alphaws.com.javadevday.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class Member implements Parcelable{
	private int idMember;
	private String name;
	private String detail;
	
	public Member(){
		idMember = 0;
		name = "";
		detail = "";
	}
	
	public Member(Parcel in){
		setIdMember(in.readInt());
		setName(in.readString());
		setDetail(in.readString());
	}

	public int getIdMember() {
		return idMember;
	}

	public void setIdMember(int idSpeaker) {
		this.idMember = idSpeaker;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(getIdMember());
		dest.writeString(getName());
		dest.writeString(getDetail());
	}
	
	public static final Parcelable.Creator<Member> CREATOR = new Creator<Member>() {
		
		@Override
		public Member[] newArray(int size) {
			return new Member[size];
		}
		
		@Override
		public Member createFromParcel(Parcel source) {
			return new Member(source);
		}
	};
	
}
