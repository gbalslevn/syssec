package com.facebook.appevents.codeless.internal;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.sdk.growthbook.utils.Constants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u0012J\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u001f\u0010 J!\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0004\b\"\u0010#J\u001b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b%\u0010&J%\u0010*\u001a\u0004\u0018\u00010\u00042\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010)\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010\u0018J\u001b\u0010-\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020'2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u000eH\u0002¢\u0006\u0004\b1\u0010\u0003J\u001d\u00104\u001a\b\u0012\u0002\b\u0003\u0018\u0001032\u0006\u00102\u001a\u00020\u0019H\u0002¢\u0006\u0004\b4\u00105J\u001f\u00106\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b6\u00107R\u001c\u00109\u001a\n 8*\u0004\u0018\u00010\u00190\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u0010:R\u0014\u0010<\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u0010:R\u0014\u0010=\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b=\u0010:R\u0014\u0010>\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b>\u0010:R\u0014\u0010?\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b?\u0010@R\u001e\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006G"}, d2 = {"Lcom/facebook/appevents/codeless/internal/ViewHierarchy;", BuildConfig.FLAVOR, "<init>", "()V", "Landroid/view/View;", "view", "Landroid/view/ViewGroup;", "getParentOfView", "(Landroid/view/View;)Landroid/view/ViewGroup;", BuildConfig.FLAVOR, "getChildrenOfView", "(Landroid/view/View;)Ljava/util/List;", "Lorg/json/JSONObject;", "json", BuildConfig.FLAVOR, "updateBasicInfoOfView", "(Landroid/view/View;Lorg/json/JSONObject;)V", "getDictionaryOfView", "(Landroid/view/View;)Lorg/json/JSONObject;", BuildConfig.FLAVOR, "getClassTypeBitmask", "(Landroid/view/View;)I", BuildConfig.FLAVOR, "isAdapterViewItem", "(Landroid/view/View;)Z", BuildConfig.FLAVOR, "getTextOfView", "(Landroid/view/View;)Ljava/lang/String;", "getHintOfView", "getDimensionOfView", "Landroid/view/View$OnClickListener;", "getExistingOnClickListener", "(Landroid/view/View;)Landroid/view/View$OnClickListener;", "newListener", "setOnClickListener", "(Landroid/view/View;Landroid/view/View$OnClickListener;)V", "Landroid/view/View$OnTouchListener;", "getExistingOnTouchListener", "(Landroid/view/View;)Landroid/view/View$OnTouchListener;", BuildConfig.FLAVOR, "location", "RCTRootView", "getTouchReactView", "([FLandroid/view/View;)Landroid/view/View;", "isRCTRootView", "findRCTRootView", "(Landroid/view/View;)Landroid/view/View;", "getViewLocationOnScreen", "(Landroid/view/View;)[F", "initTouchTargetHelperMethods", "className", "Ljava/lang/Class;", "getExistingClass", "(Ljava/lang/String;)Ljava/lang/Class;", "isRCTButton", "(Landroid/view/View;Landroid/view/View;)Z", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "CLASS_RCTROOTVIEW", "CLASS_RCTVIEWGROUP", "CLASS_TOUCHTARGETHELPER", "METHOD_FIND_TOUCHTARGET_VIEW", "ICON_MAX_EDGE_LENGTH", "I", "Ljava/lang/ref/WeakReference;", "RCTRootViewReference", "Ljava/lang/ref/WeakReference;", "Ljava/lang/reflect/Method;", "methodFindTouchTargetView", "Ljava/lang/reflect/Method;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ViewHierarchy {
    private static final String CLASS_RCTROOTVIEW = "com.facebook.react.ReactRootView";
    private static final String CLASS_RCTVIEWGROUP = "com.facebook.react.views.view.ReactViewGroup";
    private static final String CLASS_TOUCHTARGETHELPER = "com.facebook.react.uimanager.TouchTargetHelper";
    private static final int ICON_MAX_EDGE_LENGTH = 44;
    private static final String METHOD_FIND_TOUCHTARGET_VIEW = "findTouchTargetView";
    private static Method methodFindTouchTargetView;
    public static final ViewHierarchy INSTANCE = new ViewHierarchy();
    private static final String TAG = ViewHierarchy.class.getCanonicalName();
    private static WeakReference<View> RCTRootViewReference = new WeakReference<>(null);

    private ViewHierarchy() {
    }

    public static final View findRCTRootView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        while (view != null) {
            try {
                if (!INSTANCE.isRCTRootView(view)) {
                    Object parent = view.getParent();
                    if (!(parent instanceof View)) {
                        break;
                    }
                    view = (View) parent;
                } else {
                    return view;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            }
        }
        return null;
    }

    public static final List<View> getChildrenOfView(View view) {
        int childCount;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if ((view instanceof ViewGroup) && (childCount = ((ViewGroup) view).getChildCount()) > 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    arrayList.add(((ViewGroup) view).getChildAt(i5));
                    if (i6 >= childCount) {
                        break;
                    }
                    i5 = i6;
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004b A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:6:0x000a, B:9:0x0017, B:11:0x001d, B:12:0x001f, B:14:0x0025, B:15:0x0027, B:17:0x002b, B:19:0x0031, B:21:0x0037, B:22:0x0047, B:24:0x004b, B:27:0x003a, B:29:0x003e, B:31:0x004e, B:33:0x0052, B:36:0x0057, B:38:0x005b, B:40:0x005f, B:42:0x0063, B:44:0x0066, B:46:0x006a), top: B:5:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int getClassTypeBitmask(View view) {
        int i5;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return 0;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            int i6 = view instanceof ImageView ? 2 : 0;
            if (view.isClickable()) {
                i6 |= 32;
            }
            if (isAdapterViewItem(view)) {
                i6 |= 512;
            }
            if (!(view instanceof TextView)) {
                if (!(view instanceof Spinner) && !(view instanceof DatePicker)) {
                    return view instanceof RatingBar ? i6 | 65536 : view instanceof RadioGroup ? i6 | 16384 : ((view instanceof ViewGroup) && INSTANCE.isRCTButton(view, RCTRootViewReference.get())) ? i6 | 64 : i6;
                }
                return i6 | 4096;
            }
            int i7 = i6 | 1025;
            if (view instanceof Button) {
                i7 = i6 | 1029;
                if (view instanceof Switch) {
                    i5 = i6 | 9221;
                } else if (view instanceof CheckBox) {
                    i5 = i6 | 33797;
                }
                return !(view instanceof EditText) ? i5 | 2048 : i5;
            }
            i5 = i7;
            if (!(view instanceof EditText)) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return 0;
        }
    }

    public static final JSONObject getDictionaryOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            if (Intrinsics.areEqual(view.getClass().getName(), CLASS_RCTROOTVIEW)) {
                RCTRootViewReference = new WeakReference<>(view);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                updateBasicInfoOfView(view, jSONObject);
                JSONArray jSONArray = new JSONArray();
                List<View> childrenOfView = getChildrenOfView(view);
                int size = childrenOfView.size() - 1;
                if (size >= 0) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5 + 1;
                        jSONArray.put(getDictionaryOfView(childrenOfView.get(i5)));
                        if (i6 > size) {
                            break;
                        }
                        i5 = i6;
                    }
                }
                jSONObject.put("childviews", jSONArray);
            } catch (JSONException e5) {
                Log.e(TAG, "Failed to create JSONObject for view.", e5);
            }
            return jSONObject;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    private final JSONObject getDimensionOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("top", view.getTop());
                jSONObject.put("left", view.getLeft());
                jSONObject.put("width", view.getWidth());
                jSONObject.put("height", view.getHeight());
                jSONObject.put("scrollx", view.getScrollX());
                jSONObject.put("scrolly", view.getScrollY());
                jSONObject.put("visibility", view.getVisibility());
            } catch (JSONException e5) {
                Log.e(TAG, "Failed to create JSONObject for dimension.", e5);
            }
            return jSONObject;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Class<?> getExistingClass(String className) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final View.OnClickListener getExistingOnClickListener(View view) {
        Field declaredField;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null) {
                return (View.OnClickListener) obj2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View.OnClickListener");
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    public static final View.OnTouchListener getExistingOnTouchListener(View view) {
        Field declaredField;
        try {
            if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
                return null;
            }
            try {
                try {
                    Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
                    if (declaredField2 != null) {
                        declaredField2.setAccessible(true);
                    }
                    Object obj = declaredField2.get(view);
                    if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener")) == null) {
                        return null;
                    }
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(obj);
                    if (obj2 != null) {
                        return (View.OnTouchListener) obj2;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.view.View.OnTouchListener");
                } catch (NoSuchFieldException e5) {
                    Utility utility = Utility.INSTANCE;
                    Utility.logd(TAG, e5);
                    return null;
                }
            } catch (ClassNotFoundException e6) {
                Utility utility2 = Utility.INSTANCE;
                Utility.logd(TAG, e6);
                return null;
            } catch (IllegalAccessException e7) {
                Utility utility3 = Utility.INSTANCE;
                Utility.logd(TAG, e7);
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    public static final String getHintOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            CharSequence hint = view instanceof EditText ? ((EditText) view).getHint() : view instanceof TextView ? ((TextView) view).getHint() : null;
            if (hint == null) {
                return BuildConfig.FLAVOR;
            }
            String obj = hint.toString();
            return obj == null ? BuildConfig.FLAVOR : obj;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    public static final ViewGroup getParentOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class) || view == null) {
            return null;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                return (ViewGroup) parent;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    public static final String getTextOfView(View view) {
        CharSequence valueOf;
        Object selectedItem;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            if (view instanceof TextView) {
                valueOf = ((TextView) view).getText();
                if (view instanceof Switch) {
                    valueOf = ((Switch) view).isChecked() ? "1" : "0";
                }
            } else if (view instanceof Spinner) {
                if (((Spinner) view).getCount() > 0 && (selectedItem = ((Spinner) view).getSelectedItem()) != null) {
                    valueOf = selectedItem.toString();
                }
                valueOf = null;
            } else if (view instanceof DatePicker) {
                int year = ((DatePicker) view).getYear();
                int month = ((DatePicker) view).getMonth();
                int dayOfMonth = ((DatePicker) view).getDayOfMonth();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                valueOf = String.format("%04d-%02d-%02d", Arrays.copyOf(new Object[]{Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(dayOfMonth)}, 3));
                Intrinsics.checkNotNullExpressionValue(valueOf, "java.lang.String.format(format, *args)");
            } else if (view instanceof TimePicker) {
                Integer currentHour = ((TimePicker) view).getCurrentHour();
                Intrinsics.checkNotNullExpressionValue(currentHour, "view.currentHour");
                int intValue = currentHour.intValue();
                Integer currentMinute = ((TimePicker) view).getCurrentMinute();
                Intrinsics.checkNotNullExpressionValue(currentMinute, "view.currentMinute");
                int intValue2 = currentMinute.intValue();
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                valueOf = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(intValue), Integer.valueOf(intValue2)}, 2));
                Intrinsics.checkNotNullExpressionValue(valueOf, "java.lang.String.format(format, *args)");
            } else if (view instanceof RadioGroup) {
                int checkedRadioButtonId = ((RadioGroup) view).getCheckedRadioButtonId();
                int childCount = ((RadioGroup) view).getChildCount();
                if (childCount > 0) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5 + 1;
                        View childAt = ((RadioGroup) view).getChildAt(i5);
                        if (childAt.getId() == checkedRadioButtonId && (childAt instanceof RadioButton)) {
                            valueOf = ((RadioButton) childAt).getText();
                            break;
                        }
                        if (i6 >= childCount) {
                            break;
                        }
                        i5 = i6;
                    }
                }
                valueOf = null;
            } else {
                if (view instanceof RatingBar) {
                    valueOf = String.valueOf(((RatingBar) view).getRating());
                }
                valueOf = null;
            }
            if (valueOf == null) {
                return BuildConfig.FLAVOR;
            }
            String obj = valueOf.toString();
            return obj == null ? BuildConfig.FLAVOR : obj;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    private final View getTouchReactView(float[] location, View RCTRootView) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            initTouchTargetHelperMethods();
            Method method = methodFindTouchTargetView;
            if (method != null && RCTRootView != null) {
                try {
                    if (method == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    Object invoke = method.invoke(null, location, RCTRootView);
                    if (invoke == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                    }
                    View view = (View) invoke;
                    if (view.getId() > 0) {
                        Object parent = view.getParent();
                        if (parent != null) {
                            return (View) parent;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                    }
                } catch (IllegalAccessException e5) {
                    Utility utility = Utility.INSTANCE;
                    Utility.logd(TAG, e5);
                } catch (InvocationTargetException e6) {
                    Utility utility2 = Utility.INSTANCE;
                    Utility.logd(TAG, e6);
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final float[] getViewLocationOnScreen(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            view.getLocationOnScreen(new int[2]);
            return new float[]{r3[0], r3[1]};
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final void initTouchTargetHelperMethods() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (methodFindTouchTargetView != null) {
                return;
            }
            try {
                Method declaredMethod = Class.forName(CLASS_TOUCHTARGETHELPER).getDeclaredMethod(METHOD_FIND_TOUCHTARGET_VIEW, float[].class, ViewGroup.class);
                methodFindTouchTargetView = declaredMethod;
                if (declaredMethod == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                declaredMethod.setAccessible(true);
            } catch (ClassNotFoundException e5) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, e5);
            } catch (NoSuchMethodException e6) {
                Utility utility2 = Utility.INSTANCE;
                Utility.logd(TAG, e6);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private static final boolean isAdapterViewItem(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return false;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof AdapterView) {
                return true;
            }
            ViewHierarchy viewHierarchy = INSTANCE;
            Class<?> existingClass = viewHierarchy.getExistingClass("android.support.v4.view.NestedScrollingChild");
            if (existingClass != null && existingClass.isInstance(parent)) {
                return true;
            }
            Class<?> existingClass2 = viewHierarchy.getExistingClass("androidx.core.view.NestedScrollingChild");
            if (existingClass2 != null) {
                return existingClass2.isInstance(parent);
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return false;
        }
    }

    private final boolean isRCTRootView(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return Intrinsics.areEqual(view.getClass().getName(), CLASS_RCTROOTVIEW);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    public static final void setOnClickListener(View view, View.OnClickListener newListener) {
        Field field;
        Field field2;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            Object obj = null;
            try {
                try {
                    field = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
                } catch (Exception unused) {
                    return;
                }
            } catch (ClassNotFoundException | NoSuchFieldException unused2) {
                field = null;
            }
            try {
                field2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
            } catch (ClassNotFoundException | NoSuchFieldException unused3) {
                field2 = null;
                if (field != null) {
                }
                view.setOnClickListener(newListener);
                return;
            }
            if (field != null || field2 == null) {
                view.setOnClickListener(newListener);
                return;
            }
            field.setAccessible(true);
            field2.setAccessible(true);
            try {
                field.setAccessible(true);
                obj = field.get(view);
            } catch (IllegalAccessException unused4) {
            }
            if (obj == null) {
                view.setOnClickListener(newListener);
            } else {
                field2.set(obj, newListener);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
        }
    }

    public static final void updateBasicInfoOfView(View view, JSONObject json) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                String textOfView = getTextOfView(view);
                String hintOfView = getHintOfView(view);
                Object tag = view.getTag();
                CharSequence contentDescription = view.getContentDescription();
                json.put("classname", view.getClass().getCanonicalName());
                json.put("classtypebitmask", getClassTypeBitmask(view));
                json.put(Constants.ID_ATTRIBUTE_KEY, view.getId());
                if (SensitiveUserDataUtils.isSensitiveUserData(view)) {
                    json.put("text", BuildConfig.FLAVOR);
                    json.put("is_user_input", true);
                } else {
                    json.put("text", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(textOfView), BuildConfig.FLAVOR));
                }
                json.put("hint", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(hintOfView), BuildConfig.FLAVOR));
                if (tag != null) {
                    json.put("tag", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(tag.toString()), BuildConfig.FLAVOR));
                }
                if (contentDescription != null) {
                    json.put("description", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(contentDescription.toString()), BuildConfig.FLAVOR));
                }
                json.put("dimension", INSTANCE.getDimensionOfView(view));
            } catch (JSONException e5) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, e5);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
        }
    }

    public final boolean isRCTButton(View view, View RCTRootView) {
        View touchReactView;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            if (!Intrinsics.areEqual(view.getClass().getName(), CLASS_RCTVIEWGROUP) || (touchReactView = getTouchReactView(getViewLocationOnScreen(view), RCTRootView)) == null) {
                return false;
            }
            return touchReactView.getId() == view.getId();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
