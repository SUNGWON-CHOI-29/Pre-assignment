package model;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface NaverService {

    @Headers({
            "X-Naver-Client-Id: " + Naverconsts.CLIENT_ID,
            "X-Naver-Client-Secret: " + Naverconsts.CLIENT_SECRET
    })
    @GET("/v1/search/movie.json")
    Single<MovieList> getSearchResult(@Query("query") String keyword);
}
