package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
    public void salvaCadastro(String nome, String intuito, String cidade, String estado, String login, String senha, TextView etLogin){
        String sql = "INSERT INTO cadastro (nome, intuito, cidade, estado, login, senha) VALUES('"+nome+"', '"+intuito+"', '"+cidade+"',"+
                "'"+estado+"', '"+login+"','"+senha+"')";
        SQLiteDatabase bd =bdHelper.getWritableDatabase();

        try {
            bd.execSQL(sql);
        }catch (Exception e){
            etLogin.setError("Usuário já Existente");
        }
        bd.close();
    }

    //busca no banco de dados se existe algum usuario e senha igual ao que foi digitado
    public ArrayList<String> getUserPass(String usuario, String senha){


        SQLiteDatabase db=bdHelper.getReadableDatabase();
        String sql="select login, senha from cadastro where login = ? and senha = ?";
        Cursor cursor;
        cursor= db.rawQuery(sql, new String[]{usuario, senha});

        ArrayList<String> itens=null;

        if (cursor != null && cursor.moveToFirst()){
            itens = new ArrayList<String>();

            do {
                itens.add(cursor.getString(0));
                itens.add(cursor.getString(1));
            }while (cursor.moveToNext());
            return itens;
        }
        db.close();
        return null;
    }
}
