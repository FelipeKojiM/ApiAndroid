package com.example.sub.dao;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.sub.helper.SQLiteDataHelper;
import com.example.sub.model.Paises;
import java.util.ArrayList;

public class DaoPaises {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase baseDados;
    private String[]colunas = {"CODIGO", "DESCRICAO"};
    private String tabela = "PAIS";
    private Context context;
    private static DaoPaises instancia;

    public static DaoPaises getInstancia(Context context){
        if(instancia == null){
            return instancia = new DaoPaises(context);
        }else{
            return instancia;
        }
    }
    private DaoPaises(Context context){
        this.context = context;
        openHelper = new SQLiteDataHelper(this.context, "PAIS", null, 1);
        baseDados = openHelper.getWritableDatabase();
    }

    public long insert(Paises obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[0], obj.getCodigo());
            valores.put(colunas[1], obj.getDescricao());
            return baseDados.insert(tabela, null, valores);
        }catch (SQLException ex){
            Log.e("PAIS", "ERRO: PAISDAO.insert() "+ex.getMessage());
        }
        return 0;

    }

    public long update(Paises obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[0], obj.getCodigo());
            valores.put(colunas[1], obj.getDescricao());
            return baseDados.insert(tabela, null, valores);
        }catch (SQLException ex){
            Log.e("PAIS", "ERRO: PAISDAO.update() "+ex.getMessage());
        }
        return 0;
    }

    public long delete(Paises obj) {
        try{
            String[]identificador = {String.valueOf(obj.getCodigo())};
            return baseDados.delete(tabela,
                    colunas[3]+"= ?", identificador);
        }catch (SQLException ex){
            Log.e("PAIS", "ERRO: PaisDao.delete() "+ex.getMessage());
        }
        return 0;
    }


    public ArrayList<Paises> getAll() {
        ArrayList<Paises> lista = new ArrayList<>();
        try{
            Cursor cursor = baseDados.query(tabela, colunas, null, null, null, null, colunas[0]+" desc");

            if(cursor.moveToFirst()){
                do{
                    Paises pais = new Paises();
                    pais.setCodigo(cursor.getInt(0));
                    pais.setDescricao(cursor.getString(1));
                    lista.add(pais);

                }while (cursor.moveToNext());
            }

        }catch (SQLException ex){
            Log.e("Pais", "ERRO: PaisDao.getAll() "+ex.getMessage());
        }

        return lista;
    }


    public Paises getById(int id) {
        try{
            String[]identificador = {String.valueOf(id)};
            Cursor cursor = baseDados.query(tabela, colunas, colunas[3]+"= ?", identificador, null, null, null);

            if(cursor.moveToFirst()){
                Paises pais = new Paises();
                pais.setCodigo(cursor.getInt(0));
                pais.setDescricao(cursor.getString(1));

                return pais;
            }

        }catch (SQLException ex){
            Log.e("PAIS", "ERRO: Pais.getById() "+ex.getMessage());
        }
        return null;
    }
}