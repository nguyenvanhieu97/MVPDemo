package com.cris.nvh.mvpdemo.screen.listuser;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cris.nvh.mvpdemo.model.GithubUser;
import com.cris.nvh.mvpdemo.R;
import com.cris.nvh.mvpdemo.adapter.GithubUserAdapter;
import com.cris.nvh.mvpdemo.baselayer.BaseActivity;

import static com.cris.nvh.mvpdemo.screen.search.SearchActivity.EXTRA_USER;

/**
 * ListUser Screen.
 */
public class ListUserActivity extends BaseActivity{

	private RecyclerView mRecyclerView;
	private RecyclerView.LayoutManager mLayoutManager;
	private GithubUserAdapter mGithubUserAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listuser);
		GithubUser githubUser = getIntent().getExtras().getParcelable(EXTRA_USER);
		mRecyclerView = findViewById(R.id.recycler_view);
		mLayoutManager = new LinearLayoutManager(this);
		mGithubUserAdapter = new GithubUserAdapter(githubUser);
		mRecyclerView.setLayoutManager(mLayoutManager);
		mRecyclerView.setAdapter(mGithubUserAdapter);
	}
}
