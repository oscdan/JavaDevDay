package alphaws.com.javadevday.database;

/**
 * Created by Daniel on 23/07/2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import alphaws.com.javadevday.beans.Event;
import alphaws.com.javadevday.commons.Constant;

public class ControlEvent {
    Context context;

    public ControlEvent(Context context){
        this.context = context;
    }

    public ArrayList<Event> getEventsByIdPlace(DataBaseHandler dh, int idPlace){
        ArrayList<Event> events = new ArrayList<>();

        String select = "SELECT " + DataBaseHandler.EVENT_IDEVENT + ", " + DataBaseHandler.EVENT_IDPLACE + ", "
                + DataBaseHandler.EVENT_IDMEMBER + ", " + DataBaseHandler.EVENT_DETAIL
                + ", " + DataBaseHandler.START_HOUR + ", " + DataBaseHandler.FINAL_HOUR
                + ", " + DataBaseHandler.FAVOURITE + ", " + DataBaseHandler.EVENT_DESC + ", " + DataBaseHandler.EVENT_SPEAKERS +" FROM " + DataBaseHandler.EVENT
                + " WHERE " + DataBaseHandler.EVENT_IDPLACE + " = '" + idPlace + "' ORDER BY " + DataBaseHandler.START_HOUR + " ASC";

        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(select, null);
        if(cursor.moveToFirst()) {
            do {
                Event event = new Event();
                event.setIdEvent(cursor.getInt(0));
                event.setIdPlace(cursor.getInt(1));
                event.setIdMember(cursor.getInt(2));
                event.setDetail(cursor.getString(3));
                event.setStartHour(cursor.getString(4));
                event.setFinalHour(cursor.getString(5));
                event.setFavourite(cursor.getInt(6) == Constant.NOT_FAVOURITE ? false : true);
                event.setDescription(cursor.getString(7));
                event.setSpeakers(cursor.getString(8));

                events.add(event);
            } while (cursor.moveToNext());
        }

        try{
            cursor.close();
            db.close();
        }catch(Exception e){
        }
        cursor = null;
        db = null;

        return events;
    }

    public int updateEvent(DataBaseHandler dh, Event event, int favourite){
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataBaseHandler.EVENT_IDEVENT, event.getIdEvent());
        values.put(DataBaseHandler.EVENT_IDPLACE, event.getIdPlace());
        values.put(DataBaseHandler.EVENT_IDMEMBER, event.getIdMember());
        values.put(DataBaseHandler.EVENT_DETAIL, event.getDetail());
        values.put(DataBaseHandler.START_HOUR, event.getStartHour());
        values.put(DataBaseHandler.FINAL_HOUR, event.getFinalHour());
        values.put(DataBaseHandler.FAVOURITE, favourite);
        values.put(DataBaseHandler.EVENT_DESC, event.getDescription());
        values.put(DataBaseHandler.EVENT_SPEAKERS, event.getSpeakers());

        int count = db.update(DataBaseHandler.EVENT,
                values, DataBaseHandler.EVENT_IDEVENT + " = ? ",
                new String[] {String.valueOf(event.getIdEvent())});

        try{
            db.close();
        }catch(Exception e){
        }
        db = null;
        return count;
    }

    public ArrayList<Event> getEventsWhere(DataBaseHandler dh, String where){
        ArrayList<Event> events = new ArrayList<>();

        String select = "SELECT "  + DataBaseHandler.EVENT_IDEVENT + ", " + DataBaseHandler.EVENT_IDPLACE + ", "
                + DataBaseHandler.EVENT_IDMEMBER + ", " + DataBaseHandler.EVENT_DETAIL
                + ", " + DataBaseHandler.START_HOUR + ", " + DataBaseHandler.FINAL_HOUR
                + ", " + DataBaseHandler.FAVOURITE + ", " + DataBaseHandler.EVENT_DESC + ", "
                + DataBaseHandler.EVENT_SPEAKERS +" FROM " + DataBaseHandler.EVENT ;

        if(where != null){
            select += " WHERE " + where;
        }

        select += " ORDER BY " + DataBaseHandler.START_HOUR + " ASC";

        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(select, null);
        if(cursor.moveToFirst()) {
            do {
                Event event = new Event();
                event.setIdEvent(cursor.getInt(0));
                event.setIdPlace(cursor.getInt(1));
                event.setIdMember(cursor.getInt(2));
                event.setDetail(cursor.getString(3));
                event.setStartHour(cursor.getString(4));
                event.setFinalHour(cursor.getString(5));
                event.setFavourite(cursor.getInt(6) == Constant.NOT_FAVOURITE ? false : true);
                event.setDescription(cursor.getString(7));
                event.setSpeakers(cursor.getString(8));

                events.add(event);
            } while (cursor.moveToNext());
        }

        try{
            cursor.close();
            db.close();
        }catch(Exception e){
        }
        cursor = null;
        db = null;

        return events;
    }
}
