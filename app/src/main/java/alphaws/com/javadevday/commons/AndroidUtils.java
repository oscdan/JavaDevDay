package alphaws.com.javadevday.commons;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AndroidUtils {

	private static Typeface robotoTypeFaceThin;
	private static Typeface robotoTypeFaceRegular;
	private static Typeface robotoTypeFaceItalic;
	private static Typeface robotoTypeFaceBold;

	public static void setRobotoFont(Context context, View view) {
		if (robotoTypeFaceItalic == null) {
			robotoTypeFaceItalic = Typeface.createFromAsset(
					context.getAssets(), "fonts/Roboto-Light.ttf");
		}
		setFont(view, robotoTypeFaceItalic);
	}

	public static void setRobotoFontThin(Context context, View view) {
		if (robotoTypeFaceThin == null) {
			robotoTypeFaceThin = Typeface.createFromAsset(context.getAssets(),
					"fonts/Roboto-Thin.ttf");
		}
		setFont(view, robotoTypeFaceThin);
	}

	public static void setRobotoFontBold(Context context, View view) {
		if (robotoTypeFaceBold == null) {
			robotoTypeFaceBold = Typeface.createFromAsset(context.getAssets(),
					"fonts/Roboto-Bold.ttf");
		}
		setFont(view, robotoTypeFaceBold);
	}

	public static void setRobotoFontRegular(Context context, View view) {
		if (robotoTypeFaceRegular == null) {
			robotoTypeFaceRegular = Typeface.createFromAsset(
					context.getAssets(), "fonts/Roboto-Regular.ttf");
		}
		setFont(view, robotoTypeFaceRegular);
	}

	private static void setFont(View view, Typeface robotoTypeFace) {
		if (view instanceof ViewGroup) {
			for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
				setFont(((ViewGroup) view).getChildAt(i), robotoTypeFace);
			}
		} else if (view instanceof TextView) {
			((TextView) view).setTypeface(robotoTypeFace);
		} else if (view instanceof Button) {
			((Button) view).setTypeface(robotoTypeFace);
		}
	}

	public static ImageView getHomeAndUpIndicator(View decorView) {
		ImageView res = null;

		int upId = Resources.getSystem().getIdentifier("up", "id", "android");
		if (upId > 0) {
			res = (ImageView) decorView.findViewById(upId);
		} else {
			if (android.os.Build.VERSION.SDK_INT <= 10) {
				ViewGroup acbOverlay = (ViewGroup) ((ViewGroup) decorView)
						.getChildAt(0);
				ViewGroup abcFrame = (ViewGroup) acbOverlay.getChildAt(0);
				ViewGroup actionBar = (ViewGroup) abcFrame.getChildAt(0);
				ViewGroup abLL = (ViewGroup) actionBar.getChildAt(0);
				ViewGroup abLL2 = (ViewGroup) abLL.getChildAt(1);
				res = (ImageView) abLL2.getChildAt(0);
			} else if (android.os.Build.VERSION.SDK_INT > 10
					&& android.os.Build.VERSION.SDK_INT < 16) {
				ViewGroup acbOverlay = (ViewGroup) ((ViewGroup) decorView)
						.getChildAt(0);
				ViewGroup abcFrame = (ViewGroup) acbOverlay.getChildAt(0);
				ViewGroup actionBar = (ViewGroup) abcFrame.getChildAt(0);
				ViewGroup abLL = (ViewGroup) actionBar.getChildAt(1);
				res = (ImageView) abLL.getChildAt(0);
			} else {
				ViewGroup acbOverlay = (ViewGroup) ((ViewGroup) decorView)
						.getChildAt(0);
				ViewGroup abcFrame = (ViewGroup) acbOverlay.getChildAt(1);
				ViewGroup actionBar = (ViewGroup) abcFrame.getChildAt(0);
				ViewGroup abLL = (ViewGroup) actionBar.getChildAt(0);
				ViewGroup abF = (ViewGroup) abLL.getChildAt(0);
				res = (ImageView) abF.getChildAt(0);
			}
		}
		return res;
	}

}
