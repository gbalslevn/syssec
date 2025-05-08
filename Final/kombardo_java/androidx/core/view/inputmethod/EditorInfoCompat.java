package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.core.os.BuildCompat;
import androidx.core.util.Preconditions;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public abstract class EditorInfoCompat {
    private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_SELECTION_END_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";
    private static final String CONTENT_SELECTION_HEAD_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";
    private static final String CONTENT_SURROUNDING_TEXT_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";
    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Api30Impl {
        static void setInitialSurroundingSubText(EditorInfo editorInfo, CharSequence charSequence, int i5) {
            editorInfo.setInitialSurroundingSubText(charSequence, i5);
        }
    }

    /* loaded from: classes.dex */
    private static class Api35Impl {
        static void setStylusHandwritingEnabled(EditorInfo editorInfo, boolean z5) {
            editorInfo.setStylusHandwritingEnabled(z5);
        }
    }

    private static boolean isCutOnSurrogate(CharSequence charSequence, int i5, int i6) {
        if (i6 == 0) {
            return Character.isLowSurrogate(charSequence.charAt(i5));
        }
        if (i6 != 1) {
            return false;
        }
        return Character.isHighSurrogate(charSequence.charAt(i5));
    }

    private static boolean isPasswordInputType(int i5) {
        int i6 = i5 & 4095;
        return i6 == 129 || i6 == 225 || i6 == 18;
    }

    public static void setContentMimeTypes(EditorInfo editorInfo, String[] strArr) {
        editorInfo.contentMimeTypes = strArr;
    }

    public static void setInitialSurroundingSubText(EditorInfo editorInfo, CharSequence charSequence, int i5) {
        Preconditions.checkNotNull(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setInitialSurroundingSubText(editorInfo, charSequence, i5);
            return;
        }
        int i6 = editorInfo.initialSelStart;
        int i7 = editorInfo.initialSelEnd;
        int i8 = i6 > i7 ? i7 - i5 : i6 - i5;
        int i9 = i6 > i7 ? i6 - i5 : i7 - i5;
        int length = charSequence.length();
        if (i5 < 0 || i8 < 0 || i9 > length) {
            setSurroundingText(editorInfo, null, 0, 0);
            return;
        }
        if (isPasswordInputType(editorInfo.inputType)) {
            setSurroundingText(editorInfo, null, 0, 0);
        } else if (length <= 2048) {
            setSurroundingText(editorInfo, charSequence, i8, i9);
        } else {
            trimLongSurroundingText(editorInfo, charSequence, i8, i9);
        }
    }

    public static void setInitialSurroundingText(EditorInfo editorInfo, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setInitialSurroundingSubText(editorInfo, charSequence, 0);
        } else {
            setInitialSurroundingSubText(editorInfo, charSequence, 0);
        }
    }

    public static void setStylusHandwritingEnabled(EditorInfo editorInfo, boolean z5) {
        if (BuildCompat.isAtLeastV()) {
            Api35Impl.setStylusHandwritingEnabled(editorInfo, z5);
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putBoolean("androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED", z5);
    }

    private static void setSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int i5, int i6) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence(CONTENT_SURROUNDING_TEXT_KEY, charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt(CONTENT_SELECTION_HEAD_KEY, i5);
        editorInfo.extras.putInt(CONTENT_SELECTION_END_KEY, i6);
    }

    private static void trimLongSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int i5, int i6) {
        int i7 = i6 - i5;
        int i8 = i7 > 1024 ? 0 : i7;
        int i9 = 2048 - i8;
        int min = Math.min(charSequence.length() - i6, i9 - Math.min(i5, (int) (i9 * 0.8d)));
        int min2 = Math.min(i5, i9 - min);
        int i10 = i5 - min2;
        if (isCutOnSurrogate(charSequence, i10, 0)) {
            i10++;
            min2--;
        }
        if (isCutOnSurrogate(charSequence, (i6 + min) - 1, 1)) {
            min--;
        }
        setSurroundingText(editorInfo, i8 != i7 ? TextUtils.concat(charSequence.subSequence(i10, i10 + min2), charSequence.subSequence(i6, min + i6)) : charSequence.subSequence(i10, min2 + i8 + min + i10), min2, i8 + min2);
    }
}
