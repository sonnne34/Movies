package com.sonne.movies.presentation.main_activity;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sonne.movies.data.api.ApiFactory;
import com.sonne.movies.data.models.Movie;
import com.sonne.movies.data.models.MovieDoc;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

    private static final String TAG = "MainViewModel";
    private int page = 1;

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final MutableLiveData<List<Movie>> mutableLiveDataMovie = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);

    public LiveData<List<Movie>> getMovies() {
        return mutableLiveDataMovie;
    }

    public LiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public MainViewModel(@NonNull Application application) {
        super(application);
        loadMovies();
    }

    public void loadMovies() {
        Boolean loading = isLoading.getValue();
        if (loading != null && loading) {
            return;
        }
        Disposable disposable = ApiFactory.apiService.getMovieDoc(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Throwable {
                        isLoading.setValue(true);
                    }
                })
                .doAfterTerminate(new Action() {
                    @Override
                    public void run() throws Throwable {
                        isLoading.setValue(false);
                    }
                })
                .subscribe(new Consumer<MovieDoc>() {
                    @Override
                    public void accept(MovieDoc movieDocs) throws Throwable {
                        List<Movie> listMovie = mutableLiveDataMovie.getValue();
                        if (listMovie != null) {
                            listMovie.addAll(movieDocs.getMovieList());
                            mutableLiveDataMovie.setValue(listMovie);
                        } else {
                            mutableLiveDataMovie.setValue(movieDocs.getMovieList());
                        }
                        page++;
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        Log.d(TAG, throwable.toString());
                    }
                });
        compositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
