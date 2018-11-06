package com.cris.nvh.mvpdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nvh on 11/5/18.
 * Contact: toiyeuthethao1997@gmail.com
 */

public class GithubItems implements Parcelable{

	@SerializedName("login")
	@Expose
	private String mLogin;
	@SerializedName("id")
	@Expose
	private int mId;
	@SerializedName("avatar_url")
	@Expose
	private String mAvatarUrl;
	@SerializedName("site_admin")
	@Expose
	private boolean mSiteAdmin;
	@SerializedName("score")
	@Expose
	private double mScore;

	protected GithubItems(Parcel in) {
		this.mLogin = in.readString();
		this.mId = in.readInt();
		this.mAvatarUrl = in.readString();
		this.mSiteAdmin = in.readInt() !=0 ? true : false;
		this.mScore = in.readDouble();
	}

	public static final Creator<GithubItems> CREATOR = new Creator<GithubItems>() {
		@Override
		public GithubItems createFromParcel(Parcel in) {
			return new GithubItems(in);
		}

		@Override
		public GithubItems[] newArray(int size) {
			return new GithubItems[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int i) {
		dest.writeString(mLogin);
		dest.writeInt(mId);
		dest.writeString(mAvatarUrl);
		dest.writeInt(mSiteAdmin ? 1 : 0);
		dest.writeDouble(mScore);
	}

	public int getId() {
		return mId;
	}

	public void setId(int id) {
		mId = id;
	}

	public String getAvatarUrl() {
		return mAvatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		mAvatarUrl = avatarUrl;
	}

	public boolean isSiteAdmin() {
		return mSiteAdmin;
	}

	public void setSiteAdmin(boolean siteAdmin) {
		mSiteAdmin = siteAdmin;
	}

	public double getScore() {
		return mScore;
	}

	public void setScore(double score) {
		mScore = score;
	}

	public String getLogin() {

		return mLogin;
	}

	public void setLogin(String login) {
		mLogin = login;
	}
}
