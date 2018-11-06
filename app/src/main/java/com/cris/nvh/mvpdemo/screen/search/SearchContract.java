package com.cris.nvh.mvpdemo.screen.search;

import com.cris.nvh.mvpdemo.model.GithubUser;
import com.cris.nvh.mvpdemo.baselayer.BasePresenter;
import com.cris.nvh.mvpdemo.baselayer.BaseView;

/**
 * This specifies the contract between the view and the presenter.
 */

interface SearchContract {
	/**
	 * View.
	 */
	interface View extends BaseView<Presenter> {
		void onLoadDataSuccessfull(GithubUser githubUser);
		void onLoadDataFailed(String message);
	}

	/**
	 * Presenter.
	 */
	interface Presenter extends BasePresenter<View> {
		void setView(View view);
		void onGetData(String url);
	}
}
