package dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jairochaves on 06/06/16.
 */
public class DataBaseHelper  extends SQLiteOpenHelper{
    private static  String BD_NAME = "ebazarbd";
    private static  int BD_VERSION = 1;

    //tabela que será criada
    private  static String  SQL_CADASTRO_ONG="CREATE TABLE cadastro_ong(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " nome TEXT NOT NULL," +
            " intuito TEXT NOT NULL," +
            " cidade TEXT NOT NULL," +
            " estado TEXT NOT NULL," +
            " login TEXT NOT NULL UNIQUE," +
            " senha TEXT NOT NULL);";

    //falta implementar
    private  static String  SQL_VESTUARIO="CREATE TABLE cadastro_vestuario(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " peca TEXT NOT NULL," +
            " tamanho TEXT NOT NULL," +
            " estado_conservacao TEXT NOT NULL," +
            " indicacao_ong TEXT NOT NULL," +
            " preco TEXT NOT NULL," +
            " cor TEXT NOT NULL);";

    public DataBaseHelper(Context context) {
        super(context, BD_NAME, null, BD_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //cria tabela
        db.execSQL(SQL_CADASTRO_ONG);
        db.execSQL(SQL_VESTUARIO);
        db.execSQL("INSERT INTO cadastro_ong (nome, intuito, cidade, estado, login, senha) VALUES('nometeste', 'intuitoteste', 'cidadeteste'," +
                " 'estadoteste', 'adm','123');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int novaVersao) {

    }
}
