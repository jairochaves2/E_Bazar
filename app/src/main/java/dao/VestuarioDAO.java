package dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

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
    }

}
