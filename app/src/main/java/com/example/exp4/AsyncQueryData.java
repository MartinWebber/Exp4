package com.example.exp4;

import android.os.AsyncTask;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public abstract class AsyncQueryData extends AsyncTask<String, Integer, Answer<Data>> {

    private DataService dataService;
    private Call<Answer<Data>> call;

    interface DataService{
        @GET("/{folder}/select.php")
        Call<Answer<Data>> getTable(
                @Path("folder") String folder,
                @Query("table") String table);
        @GET("/{folder}/insert.php")
        Call<Answer<Data>> insert(
                @Path("folder") String folder,
                @Query("table") String table,
                @Query("insert_data") String insertData
        );
    }

    AsyncQueryData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.20")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        dataService = retrofit.create(DataService.class);
    }
    public void select(){
        call = dataService.getTable("sklad", "data");
        this.execute();
    }

    public void insert(){
        Data data = new Data("e",5,"E", 50, "Ee");
        Call <Answer<Data>> call  = dataService.insert("sklad", "data", data.getInsertData());
        this.execute();
    }
    @Override
    protected Answer<Data> doInBackground(String... strings){
        Answer<Data> answer = new Answer<>();
        try {
            Response<Answer<Data>> response = call.execute();
            answer = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

    @Override
    protected void onPostExecute(Answer<Data> answer){
        doInPostExecute(answer);
    }
    public abstract void doInPostExecute(Answer<Data> answer);
}

