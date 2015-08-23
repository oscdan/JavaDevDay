package alphaws.com.javadevday.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import alphaws.com.javadevday.beans.Member;

/**
 * Created by Daniel on 23/07/2015.
 */
public class ControlMember {
    Context context;

    public ControlMember(Context context){
        this.context = context;
    }

    public Member getMemberById(DataBaseHandler dh, int idMember){
        Member member =null;

        String select = "SELECT " + DataBaseHandler.MEMBER_IDMEMBER + ", "
                + DataBaseHandler.MEMBER_NAME + ", " + DataBaseHandler.MEMBER_DETAIL
                + " FROM " + DataBaseHandler.MEMBER  + " WHERE " + DataBaseHandler.MEMBER_IDMEMBER
                + " = '" + idMember + "'";

        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(select, null);
        if(cursor.moveToFirst()) {
            do {
                member = new Member();
                member.setIdMember(cursor.getInt(0));
                member.setName(cursor.getString(1));
                member.setDetail(cursor.getString(2));
            } while (cursor.moveToNext());
        }

        try{
            cursor.close();
            db.close();
        }catch(Exception e){
        }
        cursor = null;
        db = null;

        return member;
    }

    public ArrayList<Member> getMembersWhere(DataBaseHandler dh, String where){
        ArrayList<Member> members = new ArrayList<>();

        String select = "SELECT " + DataBaseHandler.MEMBER_IDMEMBER + ", "
                + DataBaseHandler.MEMBER_NAME + ", " + DataBaseHandler.MEMBER_DETAIL
                + " FROM " + DataBaseHandler.MEMBER;
        if(where != null){
            select += " WHERE " + where;
        }

        SQLiteDatabase db = dh.getReadableDatabase();

            Cursor cursor = db.rawQuery(select, null);

            if (cursor.moveToFirst()) {
                do {
                    Member member = new Member();
                    member.setIdMember(cursor.getInt(0));
                    member.setName(cursor.getString(1));
                    member.setDetail(cursor.getString(2));

                    members.add(member);
                } while (cursor.moveToNext());
            }

            try {
                cursor.close();
                db.close();
            } catch (Exception e) {
            }
            cursor = null;
            db = null;

        return members;
    }
}
