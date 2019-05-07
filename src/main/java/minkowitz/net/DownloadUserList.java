package minkowitz.net;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class DownloadUserList {
    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        JsonPlaceholderAPI api = retrofit.create(JsonPlaceholderAPI.class);

        Disposable disposable = api.getPhotoList().subscribe(
                new Consumer<PhotoList>() {
                    @Override
                    public void accept(PhotoList photos) throws Exception {
                        System.out.println(photos);
                    }
                }
        );
    }
}
