package alphaws.com.javadevday.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import alphaws.com.javadevday.beans.Place;

/**
 * Created by Daniel on 23/07/2015.
 */
public class ControlPlace {
    Context context;

    public ControlPlace(Context context){
        this.context = context;
    }

    public ArrayList<Place> getPlaces(DataBaseHandler dh, String where){
        ArrayList<Place> places = new ArrayList<>();

        String select = "SELECT " +  DataBaseHandler.PLACE_IDPLACE + ", "
                + DataBaseHandler.PLACE_NAME + " FROM " + DataBaseHandler.PLACE;

        if(where != null){
            select += " WHERE " + where;
        }

        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(select, null);
        if(cursor.moveToFirst()) {
            do {
                Place place = new Place();
                place.setIdPlace(cursor.getInt(0));
                place.setName(cursor.getString(1));

                places.add(place);
            } while (cursor.moveToNext());
        }

        try{
            cursor.close();
            db.close();
        }catch(Exception e){
        }
        cursor = null;
        db = null;

        return  places;
    }
}
