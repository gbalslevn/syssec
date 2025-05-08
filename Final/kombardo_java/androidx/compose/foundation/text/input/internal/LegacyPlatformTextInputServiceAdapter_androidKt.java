package androidx.compose.foundation.text.input.internal;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import androidx.emoji2.text.EmojiCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t\"4\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b\r\u0010\u000e\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;", "createLegacyPlatformTextInputServiceAdapter", "()Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;", "Landroid/view/inputmethod/EditorInfo;", BuildConfig.FLAVOR, "updateWithEmojiCompat", "(Landroid/view/inputmethod/EditorInfo;)V", BuildConfig.FLAVOR, "DEBUG_CLASS", "Ljava/lang/String;", "Lkotlin/Function1;", "Landroid/view/View;", "Landroidx/compose/foundation/text/input/internal/InputMethodManager;", "inputMethodManagerFactory", "Lkotlin/jvm/functions/Function1;", "getInputMethodManagerFactory", "()Lkotlin/jvm/functions/Function1;", "setInputMethodManagerFactory", "(Lkotlin/jvm/functions/Function1;)V", "getInputMethodManagerFactory$annotations", "()V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LegacyPlatformTextInputServiceAdapter_androidKt {
    private static final String DEBUG_CLASS = "AndroidLegacyPlatformTextInputServiceAdapter";
    private static Function1<? super View, ? extends InputMethodManager> inputMethodManagerFactory = LegacyPlatformTextInputServiceAdapter_androidKt$inputMethodManagerFactory$1.INSTANCE;

    public static final /* synthetic */ void access$updateWithEmojiCompat(EditorInfo editorInfo) {
        updateWithEmojiCompat(editorInfo);
    }

    public static final LegacyPlatformTextInputServiceAdapter createLegacyPlatformTextInputServiceAdapter() {
        return new AndroidLegacyPlatformTextInputServiceAdapter();
    }

    public static final Function1<View, InputMethodManager> getInputMethodManagerFactory() {
        return inputMethodManagerFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWithEmojiCompat(EditorInfo editorInfo) {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
    }
}
