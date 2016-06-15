package dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jairochaves on 09/06/16.
 */
public class VestuarioDAO  {
    private static DataBaseHelper dataBaseHelper=null;
    SQLiteDatabase database=null;

    public VestuarioDAO(Context context){
        if (dataBaseHelper==null)
            dataBaseHelper=new DataBaseHelper(context);
    }
    public void salvarVestuario(String peca,String tamanho,String estCons,String indOng,String preco,String cor){
        String sql= "INSERT INTO cadastro_vestuario(peca, tamanho, estado_conservacao, indicacao_ong, preco, cor) VALUES(" +
                "'"+peca+"','"+tamanho+"','"+estCons+"','"+indOng+"','"+preco+"','"+cor+"')";

        database = dataBaseHelper.getWritableDatabase();

        try {
        database.execSQL(sql);
        }catch (Exception e){
        }
        database.close();
    }
    //faz a leitura do banco de dados
    public ArrayList<String> getAllVestuarios(){


        SQLiteDatabase db=dataBaseHelper.getReadableDatabase();
        String sql="select * from cadastro_vestuario";
        Cursor cursor=db.rawQuery(sql,null);
        ArrayList<String> itens=null;
        if (cursor != null&& cursor.moveToFirst()){
            itens = new ArrayList<String>();

            do {
                itens.add("Peça: "+cursor.getString(1)+
                        "\nTamanho: "+cursor.getString(2)+
                        "\nEstado de Conservação: "+cursor.getString(3)+
                        "\nIndicação de ONG: "+cursor.getString(4)+
                        "\nPreço: "+cursor.getString(5)+
                        "\nCor: "+cursor.getString(6));
            }while (cursor.moveToNext());

        }
        db.close();
        return itens;
    }

}
