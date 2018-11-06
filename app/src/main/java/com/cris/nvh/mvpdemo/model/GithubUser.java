package com.cris.nvh.mvpdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nvh on 11/5/18.
 * Contact: toiyeuthethao1997@gmail.com
 */

public class GithubUser implements Parcelable {

	@SerializedName("total_count")
	@Expose
	private int mTotalCount;
	@SerializedName("incomplete_results")
	@Expose
	private boolean mIncompleteResults;

	@SerializedName("items")
	@Expose
	private List<GithubItems> mGithubItems = null;

	public final static Parcelable.Creator<GithubUser> CREATOR = new Creator<GithubUser>() {

		@SuppressWarnings({
				"unchecked"
		})
		public GithubUser createFromParcel(Parcel in) {
			return new GithubUser(in);
		}

		public GithubUser[] newArray(int size) {
			return (new GithubUser[size]);
		}

	};

	public int describeContents() {
		return 0;
	}

	protected GithubUser(Parcel in) {
		this.mGithubItems = in.readArrayList(GithubItems.class.getClassLoader());
		this.mTotalCount = in.readInt();
		this.mIncompleteResults = in.readInt() != 0 ? true : false;
	}

	public void writeToParcel(Parcel dest, int flags) {
		dest.writeList(mGithubItems);
		dest.writeInt(mTotalCount);
		dest.writeInt(mIncompleteResults ? 1 : 0);
	}

	public int getTotalCount() {
		return mTotalCount;
	}

	public void setTotalCount(int totalCount) {
		mTotalCount = totalCount;
	}

	public boolean isIncompleteResults() {
		return mIncompleteResults;
	}

	public void setIncompleteResults(boolean incompleteResults) {
		mIncompleteResults = incompleteResults;
	}

	public List<GithubItems> getGithubItems() {
		return mGithubItems;
	}

	public void setGithubItems(List<GithubItems> githubItems) {
		mGithubItems = githubItems;
	}

}
