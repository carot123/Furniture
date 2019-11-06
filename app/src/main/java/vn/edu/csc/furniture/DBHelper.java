package vn.edu.csc.furniture;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class DBHelper {
    String DATABASE_NAME = "FurnitureDB.db";
    private static final String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase db = null;

    Context context;

    public DBHelper(Context context) {
        this.context = context;

        processSQLite();
    }

    private void processSQLite() {
        File dbFile = context.getDatabasePath(DATABASE_NAME);
        if(!dbFile.exists()){
            try{
                CopyDatabaseFromAsset();
                Toast.makeText(context, "Copy successful !!!", Toast.LENGTH_SHORT).show();

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    private void CopyDatabaseFromAsset() {
        try{
            InputStream databaseInputStream = context.getAssets().open(DATABASE_NAME);

            String outputStream = getPathDatabaseSystem();

            File file = new File(context.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if(!file.exists()){
                file.mkdir();
            }

            OutputStream databaseOutputStream = new FileOutputStream(outputStream);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = databaseInputStream.read(buffer)) > 0){
                databaseOutputStream.write(buffer,0,length);
            }


            databaseOutputStream.flush();
            databaseOutputStream.close();
            databaseInputStream.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private String getPathDatabaseSystem() {
        return context.getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME;
    }

}
