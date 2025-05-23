package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a@\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"hasFlag", BuildConfig.FLAVOR, "bits", BuildConfig.FLAVOR, "flag", "update", BuildConfig.FLAVOR, "Landroid/view/inputmethod/EditorInfo;", "text", BuildConfig.FLAVOR, "selection", "Landroidx/compose/ui/text/TextRange;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "contentMimeTypes", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "update-pLxbY9I", "(Landroid/view/inputmethod/EditorInfo;Ljava/lang/CharSequence;JLandroidx/compose/ui/text/input/ImeOptions;[Ljava/lang/String;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class EditorInfo_androidKt {
    private static final boolean hasFlag(int i5, int i6) {
        return (i5 & i6) == i6;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0185  */
    /* renamed from: update-pLxbY9I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m565updatepLxbY9I(EditorInfo editorInfo, CharSequence charSequence, long j5, ImeOptions imeOptions, String[] strArr) {
        int imeAction = imeOptions.getImeAction();
        ImeAction.Companion companion = ImeAction.INSTANCE;
        int i5 = 3;
        int i6 = 6;
        if (ImeAction.m2378equalsimpl0(imeAction, companion.m2382getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i6 = 0;
            }
        } else if (ImeAction.m2378equalsimpl0(imeAction, companion.m2386getNoneeUduSuo())) {
            i6 = 1;
        } else if (ImeAction.m2378equalsimpl0(imeAction, companion.m2384getGoeUduSuo())) {
            i6 = 2;
        } else if (ImeAction.m2378equalsimpl0(imeAction, companion.m2385getNexteUduSuo())) {
            i6 = 5;
        } else if (ImeAction.m2378equalsimpl0(imeAction, companion.m2387getPreviouseUduSuo())) {
            i6 = 7;
        } else if (ImeAction.m2378equalsimpl0(imeAction, companion.m2388getSearcheUduSuo())) {
            i6 = 3;
        } else if (ImeAction.m2378equalsimpl0(imeAction, companion.m2389getSendeUduSuo())) {
            i6 = 4;
        } else if (!ImeAction.m2378equalsimpl0(imeAction, companion.m2383getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction");
        }
        editorInfo.imeOptions = i6;
        imeOptions.getPlatformImeOptions();
        LocaleListHelper.INSTANCE.setHintLocales(editorInfo, imeOptions.getHintLocales());
        int keyboardType = imeOptions.getKeyboardType();
        KeyboardType.Companion companion2 = KeyboardType.INSTANCE;
        if (!KeyboardType.m2410equalsimpl0(keyboardType, companion2.m2421getTextPjHm6EE())) {
            if (!KeyboardType.m2410equalsimpl0(keyboardType, companion2.m2414getAsciiPjHm6EE())) {
                if (KeyboardType.m2410equalsimpl0(keyboardType, companion2.m2417getNumberPjHm6EE())) {
                    i5 = 2;
                } else if (!KeyboardType.m2410equalsimpl0(keyboardType, companion2.m2420getPhonePjHm6EE())) {
                    if (KeyboardType.m2410equalsimpl0(keyboardType, companion2.m2423getUriPjHm6EE())) {
                        i5 = 17;
                    } else if (KeyboardType.m2410equalsimpl0(keyboardType, companion2.m2416getEmailPjHm6EE())) {
                        i5 = 33;
                    } else if (KeyboardType.m2410equalsimpl0(keyboardType, companion2.m2419getPasswordPjHm6EE())) {
                        i5 = 129;
                    } else if (KeyboardType.m2410equalsimpl0(keyboardType, companion2.m2418getNumberPasswordPjHm6EE())) {
                        i5 = 18;
                    } else {
                        if (!KeyboardType.m2410equalsimpl0(keyboardType, companion2.m2415getDecimalPjHm6EE())) {
                            throw new IllegalStateException("Invalid Keyboard Type");
                        }
                        i5 = 8194;
                    }
                }
                editorInfo.inputType = i5;
                if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
                    editorInfo.inputType |= 131072;
                    if (ImeAction.m2378equalsimpl0(imeOptions.getImeAction(), companion.m2382getDefaulteUduSuo())) {
                        editorInfo.imeOptions |= 1073741824;
                    }
                }
                if (hasFlag(editorInfo.inputType, 1)) {
                    int capitalization = imeOptions.getCapitalization();
                    KeyboardCapitalization.Companion companion3 = KeyboardCapitalization.INSTANCE;
                    if (KeyboardCapitalization.m2398equalsimpl0(capitalization, companion3.m2402getCharactersIUNYP9k())) {
                        editorInfo.inputType |= 4096;
                    } else if (KeyboardCapitalization.m2398equalsimpl0(capitalization, companion3.m2406getWordsIUNYP9k())) {
                        editorInfo.inputType |= 8192;
                    } else if (KeyboardCapitalization.m2398equalsimpl0(capitalization, companion3.m2404getSentencesIUNYP9k())) {
                        editorInfo.inputType |= 16384;
                    }
                    if (imeOptions.getAutoCorrect()) {
                        editorInfo.inputType |= 32768;
                    }
                }
                editorInfo.initialSelStart = TextRange.m2285getStartimpl(j5);
                editorInfo.initialSelEnd = TextRange.m2280getEndimpl(j5);
                EditorInfoCompat.setInitialSurroundingText(editorInfo, charSequence);
                if (strArr != null) {
                    EditorInfoCompat.setContentMimeTypes(editorInfo, strArr);
                }
                editorInfo.imeOptions |= 33554432;
                if (StylusHandwriting_androidKt.isStylusHandwritingSupported() || KeyboardType.m2410equalsimpl0(imeOptions.getKeyboardType(), companion2.m2419getPasswordPjHm6EE()) || KeyboardType.m2410equalsimpl0(imeOptions.getKeyboardType(), companion2.m2418getNumberPasswordPjHm6EE())) {
                    EditorInfoCompat.setStylusHandwritingEnabled(editorInfo, false);
                } else {
                    EditorInfoCompat.setStylusHandwritingEnabled(editorInfo, true);
                    EditorInfoApi34.INSTANCE.setHandwritingGestures(editorInfo);
                    return;
                }
            }
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        }
        i5 = 1;
        editorInfo.inputType = i5;
        if (!imeOptions.getSingleLine()) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m2378equalsimpl0(imeOptions.getImeAction(), companion.m2382getDefaulteUduSuo())) {
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
        }
        editorInfo.initialSelStart = TextRange.m2285getStartimpl(j5);
        editorInfo.initialSelEnd = TextRange.m2280getEndimpl(j5);
        EditorInfoCompat.setInitialSurroundingText(editorInfo, charSequence);
        if (strArr != null) {
        }
        editorInfo.imeOptions |= 33554432;
        if (StylusHandwriting_androidKt.isStylusHandwritingSupported()) {
        }
        EditorInfoCompat.setStylusHandwritingEnabled(editorInfo, false);
    }

    /* renamed from: update-pLxbY9I$default, reason: not valid java name */
    public static /* synthetic */ void m566updatepLxbY9I$default(EditorInfo editorInfo, CharSequence charSequence, long j5, ImeOptions imeOptions, String[] strArr, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            strArr = null;
        }
        m565updatepLxbY9I(editorInfo, charSequence, j5, imeOptions, strArr);
    }
}
