package com.example.sub.service;
import com.example.sub.dto.DtoPaises;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IPais {
    @GET("api/paises")
    Call<ArrayList<DtoPaises>> getPaisDtoCall();
}