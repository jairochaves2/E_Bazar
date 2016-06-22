package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rafael.e_bazar.Cadastro_Ong;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by jairochaves on 06/06/16.
 */
public class CadastroDAO {
    private static DataBaseHelper bdHelper=null;
    // class principal
    public CadastroDAO(Context context){
        if (bdHelper==null)
            bdHelper=new DataBaseHelper(context);

    }
    //insere os itens na tabela
    public void salvaCadastro(String nome, String intuito, String cidade, String estado, EditText etnome){

        String sql = "INSERT INTO cadastro_ong (nome, intuito, cidade, estado) VALUES('"+nome+"', '"+intuito+"', '"+cidade+"',"+
                "'"+estado+"')";
        SQLiteDatabase bd =bdHelper.getWritableDatabase();

        try {
            bd.execSQL(sql);
        }catch (Exception e){
            etnome.setError("ONG já cadastrada");
        }
        bd.close();
    }
    public ArrayList<String> getNome(){


        SQLiteDatabase db=bdHelper.getReadableDatabase();
        String sql="select nome from cadastro_ong";
        Cursor cursor=null;
        cursor= db.rawQuery(sql, null);

        ArrayList<String> itens=null;

        if (cursor != null && cursor.moveToFirst()){
            itens = new ArrayList<String>();
            itens.add("Selecione");
            do {

                    itens.add(cursor.getString(0));


            }while (cursor.moveToNext());
            return itens;
        }

        db.close();
        return null;
    }
    public ArrayList<String> getOng(){


        SQLiteDatabase db=bdHelper.getReadableDatabase();
        String sql="select * from cadastro_ong";
        Cursor cursor=null;
        cursor= db.rawQuery(sql, null);

        ArrayList<String> itens=null;

        if (cursor != null && cursor.moveToFirst()){
            itens = new ArrayList<String>();
            do {
                itens.add("Nome: "+cursor.getString(1));
                itens.add("\nItuito: "+cursor.getString(2));
                itens.add("\nCidade: "+cursor.getString(3));
                itens.add("\nEstado: "+cursor.getString(4));
                System.out.println("uma vez");
            }while (cursor.moveToNext());
            return itens;
        }

        db.close();
        return null;
    }
    public void deletaOng(String nome){
        SQLiteDatabase database;
        database=bdHelper.getWritableDatabase();
        String sql = "DELETE FROM cadastro_ong WHERE nome='"+nome+"';";
        try{
            database.execSQL(sql);
        }
        catch (Exception e){
            //tratar excessao
        }

    }

}



















//busca no banco de dados se existe algum usuario e senha igual ao que foi digitado
    /*public ArrayList<String> getUserPass(String usuario, String senha){


        SQLiteDatabase db=bdHelper.getReadableDatabase();
        String sql="select login, senha from cadastro_ong where login = ? and senha = ?";
        Cursor cursor;
        cursor= db.rawQuery(sql, new String[]{usuario, senha});

        ArrayList<String> itens=null;
        int cont=0;
        if (cursor != null && cursor.moveToFirst()){
            itens = new ArrayList<String>();

            do {
                itens.add(cursor.getString(cont));
                cont++;
            }while (cursor.moveToNext());
            return itens;
        }

        db.close();
        return null;
    }*/
