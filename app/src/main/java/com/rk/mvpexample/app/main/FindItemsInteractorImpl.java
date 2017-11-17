/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.rk.mvpexample.app.main;

import android.os.Handler;
import android.util.Log;

import com.rk.mvpexample.app.service.MoviesApiCall;

import java.util.Arrays;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindItemsInteractorImpl implements FindItemsInteractor {

    MoviesApiCall moviesApiCall;

    @Override
    public void findItems(final OnFinishedListener listener) {
//        new Handler().postDelayed(new Runnable() {
//            @Override public void run() {
//                listener.onFinished(createArrayList());
//            }
//        }, 2000);

        moviesApiCall = new MoviesApiCall();
        getMovies(moviesApiCall, listener);
    }
/*
    private List<String> createArrayList() {
        return Arrays.asList(
                "Item 1",
                "Item 2",
                "Item 3",
                "Item 4",
                "Item 5",
                "Item 6",
                "Item 7",
                "Item 8",
                "Item 9",
                "Item 10"
        );
    }*/

    public void getMovies(MoviesApiCall moviesApiCall, final OnFinishedListener mListener) {
        moviesApiCall
                .getAPI()
                .getMoviesList()
                .enqueue(new Callback<com.rk.mvpexample.app.main.Response>() {
                    @Override
                    public void onResponse(Call<com.rk.mvpexample.app.main.Response> call, Response<com.rk.mvpexample.app.main.Response> response) {
                       List<ResultsItem>  result = response.body().getResults();

                        if (result != null)
                            mListener.onFinished(result);
                       // Log.v("test", result.get(0).getTitle().toString());
                    }

                    @Override
                    public void onFailure(Call<com.rk.mvpexample.app.main.Response> call, Throwable t) {
                        try {
                            throw new InterruptedException("Erro na comunicação com o servidor!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
