package com.example.sub.controller;
import android.content.Context;
import com.example.sub.dao.DaoPaises;
import com.example.sub.dto.DtoPaises;
import com.example.sub.model.Paises;
import com.example.sub.retrofit.RetrofitConfig;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ControllerPaises {
    private static Context context;

    public static void getViaPais(Context context){
        try{
            retrofit2.Call<ArrayList<DtoPaises>> call = new RetrofitConfig().paisService().getPaisDtoCall();
            call.enqueue(new Callback<ArrayList<DtoPaises>>() {

                public void onResponse(Call<ArrayList<DtoPaises>> call, Response<ArrayList<DtoPaises>> response) {
                    ArrayList<DtoPaises> listaPais = response.body();

                    for (int i = 0 ; i <listaPais.size(); i++){
                        DtoPaises pais = listaPais.get(i);

                        salvar(pais.getCodigo(), pais.getDescricao(),context);
                    }
                }
                public void onFailure(Call<ArrayList<DtoPaises>> call, Throwable t) {
                }
            });
        }catch (Exception ex){}
    }

    public static String salvar(int codigo, String descricao, Context context){
        try {
            Paises pais = new Paises();
            pais.setCodigo(codigo);
            pais.setDescricao(descricao);
            DaoPaises.getInstancia(context).insert(pais);
        } catch (Exception ex) {
            return "Erro ao gravar pais." + ex.getMessage();
        }
        return null;
    }
    public static ArrayList<Paises> retornar(Context context){
        return DaoPaises.getInstancia(context).getAll();
    }
}