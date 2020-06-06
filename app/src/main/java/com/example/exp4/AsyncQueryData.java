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
                @Query("insert_data") String insertData);
        @GET("/{folder}/delete.php")
        Call<Answer<Data>> delete(
                @Path("folder") String folder,
                @Query("table") String table,
                @Query("id") Integer id);
        @GET("/{folder}/search.php")
        Call<Answer<Data>> search(
                @Path("folder") String folder,
                @Query("table") String table,
                @Query("search") String searchData);
        @GET("/{folder}/update.php")
        Call<Answer<Data>> update(
                @Path("folder") String folder,
                @Query("table") String table,
                @Query("update_data") Data updateData);
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

    public void insert(Data data){
        call  = dataService.insert("sklad", "data", data.getInsertData());
        this.execute();
    }
    public void delete(int id){
        call  = dataService.delete("sklad", "data", id);
        this.execute();
    }
    public void search(String search){
        call  = dataService.search("sklad", "data", search);
        this.execute();
    }
    public void update(Data updateData){
        call  = dataService.update("sklad", "data", updateData);
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

