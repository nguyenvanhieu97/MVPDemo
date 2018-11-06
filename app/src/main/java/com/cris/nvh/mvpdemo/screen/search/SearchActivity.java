package com.cris.nvh.mvpdemo.screen.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cris.nvh.mvpdemo.R;
import com.cris.nvh.mvpdemo.baselayer.BaseActivity;
import com.cris.nvh.mvpdemo.model.GithubUser;
import com.cris.nvh.mvpdemo.screen.listuser.ListUserActivity;

/**
 * Search Screen.
 */

public class SearchActivity extends BaseActivity implements SearchContract.View, View.OnClickListener {

	public static final String EXTRA_USER = "com.cris.nvh.mvpdemo.extra.EXTRA_USER";
	private SearchContract.Presenter mPresenter;
	private TextView mTextInput;
	private EditText mEditSearch;
	private Button mButtonSearch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		mTextInput = findViewById(R.id.text_input);
		mEditSearch = findViewById(R.id.edit_search);
		mButtonSearch = findViewById(R.id.button_search);
		mPresenter = new SearchPresenter();
		mPresenter.setView(this);
		mButtonSearch.setOnClickListener(this);
	}

	@Override
	public void onLoadDataSuccessfull(GithubUser githubUser) {
		startActivity(getUserIntent(this, githubUser));
		finish();
	}

	@Override
	public void onLoadDataFailed(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}


	@Override
	public void onClick(View view) {
		if (mEditSearch.getText().length() > 0) {
			String input = mEditSearch.getText().toString();
			StringBuilder url = new StringBuilder(getString(R.string.url));
			url.append(input);
			mPresenter.onGetData(url.toString());
			return;
		}
		Toast.makeText(getApplicationContext(),
				getString(R.string.verify_empty), Toast.LENGTH_SHORT).show();
	}

	public static Intent getUserIntent(Context context, GithubUser githubUser) {
		Intent intent = new Intent(context, ListUserActivity.class);
		intent.putExtra(EXTRA_USER, githubUser);
		return intent;
	}
}
