package com.cris.nvh.mvpdemo.screen.search;

import android.os.AsyncTask;

import com.cris.nvh.mvpdemo.model.GithubUser;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Listens to user actions from the UI ({@link SearchActivity}), retrieves the data and updates
 * the UI as required.
 */

final class SearchPresenter implements SearchContract.Presenter {
	public static final String LOAD_DATA_FAILED = "Load data failed";
	private static final int CONNECTION_TIMEOUT = 15000;
	private static final int READ_TIMEOUT = 10000;
	private SearchContract.View mView;

	@Override
	public void setView(SearchContract.View view) {
		mView = view;
	}

	@Override
	public void onGetData(String url) {
		LoadDataAsyncTask asyncTask = new LoadDataAsyncTask();
		asyncTask.execute(url);
	}

	public class LoadDataAsyncTask extends AsyncTask<String, Integer, GithubUser> {

		@Override
		protected GithubUser doInBackground(String... strings) {
			String data = getJsonStringData(strings[0]);
			GithubUser githubUser = new Gson().fromJson(data, GithubUser.class);
			return githubUser;
		}

		@Override
		protected void onPostExecute(GithubUser githubUser) {
			mView.onLoadDataSuccessfull(githubUser);
		}

		public String getJsonStringData(String stringUrl) {
			StringBuilder builder = new StringBuilder();
			try {
				URL url = new URL(stringUrl);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.setConnectTimeout(CONNECTION_TIMEOUT);
				connection.setReadTimeout(READ_TIMEOUT);
				connection.connect();
				InputStreamReader inputStream = new InputStreamReader(
						connection.getInputStream());
				BufferedReader bufferedReader = new BufferedReader(inputStream);
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					builder.append(line + "\n");
				}
				bufferedReader.close();
				connection.disconnect();
			} catch (MalformedURLException e) {
				mView.onLoadDataFailed(LOAD_DATA_FAILED);
				this.cancel(true);
			} catch (IOException e) {
				mView.onLoadDataFailed(LOAD_DATA_FAILED);
				this.cancel(true);
			}
			return builder.toString();
		}
	}
}
