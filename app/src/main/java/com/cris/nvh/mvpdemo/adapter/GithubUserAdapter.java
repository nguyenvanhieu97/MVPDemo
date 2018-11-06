package com.cris.nvh.mvpdemo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cris.nvh.mvpdemo.model.GithubItems;
import com.cris.nvh.mvpdemo.model.GithubUser;
import com.cris.nvh.mvpdemo.R;


/**
 * Created by nvh on 11/5/18.
 * Contact: toiyeuthethao1997@gmail.com
 */

public class GithubUserAdapter extends RecyclerView.Adapter<GithubUserAdapter.ViewHolder> {
	private GithubUser mGithubUser;

	public GithubUserAdapter(GithubUser githubUser) {
		mGithubUser = githubUser;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		View view = LayoutInflater
				.from(viewGroup.getContext())
				.inflate(R.layout.view_holder, viewGroup, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
		viewHolder.bindData(mGithubUser, i);
	}

	@Override
	public int getItemCount() {
		return mGithubUser.getGithubItems() == null ? 0 : mGithubUser.getGithubItems().size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		private TextView mTextTotalCount;
		private TextView mTextIncompleteResult;
		private TextView mTextLogin;
		private TextView mTextId;
		private ImageView mImageAvatar;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			mTextId = itemView.findViewById(R.id.text_id);
			mTextIncompleteResult = itemView.findViewById(R.id.text_incomplete_result);
			mTextLogin = itemView.findViewById(R.id.text_login);
			mTextTotalCount = itemView.findViewById(R.id.text_total_count);
			mImageAvatar = itemView.findViewById(R.id.image_avatar);
		}

		public void bindData(GithubUser githubUser, int i) {
			GithubItems item = githubUser.getGithubItems().get(i);
			mTextTotalCount.setText(String.valueOf(githubUser.getTotalCount()));
			mTextIncompleteResult.setText(String.valueOf(githubUser.isIncompleteResults()));
			mTextLogin.setText(item.getLogin());
			mTextId.setText(String.valueOf(item.getId()));
			Glide.with(itemView)
					.load(item.getAvatarUrl())
					.into(mImageAvatar);
		}
	}
}
