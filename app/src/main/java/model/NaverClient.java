package model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

public class NaverClient {

    private final String BASE_URL = "https://openapi.naver.com/v1/search/movie.json/";
    private final class MovieDeserializer implements JsonDeserializer<MovieList> {
        @Override
        public MovieList deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException{
            MovieList movieList = new MovieList();
            JsonObject resultJsonObject = json.getAsJsonObject();

            JsonArray movieArray = resultJsonObject.getAsJsonArray("items");
            for(int i = 0; i < movieArray.size(); i++) {
                JsonObject movieJsonObject = movieArray.get(i).getAsJsonObject();
                MovieItem movie = new MovieItem();
                movie.title = movieJsonObject.get("title").getAsString();
                movie.link = movieJsonObject.get("link").getAsString();
                movie.image = movieJsonObject.get("image").getAsString();
                movie.pubDate = movieJsonObject.get("pubDate").getAsString();
                movie.director = movieJsonObject.get("director").getAsString();
                movie.actor = movieJsonObject.get("actor").getAsString();
                float rating = movieJsonObject.get("userRating").getAsFloat();
                if(rating != 0)
                    rating /= 2;
                movie.userRating = rating;
                movieList.movieList.add(movie);
                Log.d(TAG, "deserialize: "+movie.userRating);
            }

            return movieList;
        }
    }

    public NaverService getApi(){
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(MovieList.class, new MovieDeserializer())
                .create();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(new OkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(NaverService.class);
        }
}
