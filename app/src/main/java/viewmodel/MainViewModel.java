package viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.watsonz.pre_assignment.MovieAdapter;
import com.example.watsonz.pre_assignment.R;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import model.MovieItem;
import model.MovieList;
import model.NaverClient;

public class MainViewModel extends ViewModel {
    public final ObservableField<String> input = new ObservableField<>();
    public final ObservableArrayList<MovieItem> movieList = new ObservableArrayList<>();

    private Disposable disposable;
    private NaverClient movieClient;
    private MovieAdapter adapter;

    public void init() {
        adapter = new MovieAdapter(R.layout.item_movie_list, this);
    }

    public MovieAdapter getAdapter() {
        return adapter;
    }

    public void setSearchMovie(){
        movieClient = new NaverClient();
        disposable = movieClient.getApi().getSearchResult(input.get())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( items -> adapter.updateItems(items));
    }
}
