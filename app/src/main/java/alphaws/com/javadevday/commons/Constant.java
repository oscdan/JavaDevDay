package alphaws.com.javadevday.commons;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/**
 * Created by Daniel on 23/07/2015.
 */
public class Constant {
    public static final int FAVOURITE = 1;
    public static final int NOT_FAVOURITE = 0;

    public static final int SECTION_AGENDA = 0;
    public static final int SECTION_SCHEDULE = 1;
    public static final int SECTION_SPEAKERS = 2;

    public static final String DETAIL_TAG = "Detail Tag";
    public static final String EVENT_DETAIL_TAG = "Detail Tag";

    public synchronized static Drawable getDrawable(Context context, String name) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier(name, "drawable",
                context.getPackageName());

        if(resourceId == 0)
            return null;

        return resources.getDrawable(resourceId);
    }

    public static  Bitmap getCircleBitmap(Bitmap bitmap) {
        final Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(output);

        final int color = Color.RED;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawOval(rectF, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }

}
