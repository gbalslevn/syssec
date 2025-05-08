package androidx.compose.ui.text.input;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0000\u001a\u001c\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\f\u0010\u0011\u001a\u00020\u000b*\u00020\fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"DEBUG_CLASS", BuildConfig.FLAVOR, "hasFlag", BuildConfig.FLAVOR, "bits", BuildConfig.FLAVOR, "flag", "asExecutor", "Ljava/util/concurrent/Executor;", "Landroid/view/Choreographer;", "update", BuildConfig.FLAVOR, "Landroid/view/inputmethod/EditorInfo;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "updateWithEmojiCompat", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TextInputServiceAndroid_androidKt {
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    public static final Executor asExecutor(final Choreographer choreographer) {
        return new Executor() { // from class: w.d
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                TextInputServiceAndroid_androidKt.asExecutor$lambda$2(choreographer, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asExecutor$lambda$2(Choreographer choreographer, final Runnable runnable) {
        choreographer.postFrameCallback(new Choreographer.FrameCallback() { // from class: w.e
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j5) {
                runnable.run();
            }
        });
    }

    private static final boolean hasFlag(int i5, int i6) {
        return (i5 & i6) == i6;
    }

    public static final void update(EditorInfo editorInfo, ImeOptions imeOptions, TextFieldValue textFieldValue) {
        int imeAction = imeOptions.getImeAction();
        ImeAction.Companion companion = ImeAction.INSTANCE;
        int i5 = 6;
        if (ImeAction.m2378equalsimpl0(imeAction, companion.m2382getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i5 = 0;
            }
        } else if (ImeAction.m2378equalsimpl0(imeAction, companion.m2386getNoneeUduSuo())) {
            i5 = 1;
        } else if (ImeAction.m2378equalsimpl0(imeAction, companion.m2384getGoeUduSuo())) {
            i5 = 2;
        } else if (ImeAction.m2378equalsimpl0(imeAction, companion.m2385getNexteUduSuo())) {
            i5 = 5;
        } else if (ImeAction.m2378equalsimpl0(imeAction, companion.m2387getPreviouseUduSuo())) {
            i5 = 7;
        } else if (ImeAction.m2378equalsimpl0(imeAction, companion.m2388getSearcheUduSuo())) {
            i5 = 3;
        } else if (ImeAction.m2378equalsimpl0(imeAction, companion.m2389getSendeUduSuo())) {
            i5 = 4;
        } else if (!ImeAction.m2378equalsimpl0(imeAction, companion.m2383getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction");
        }
        editorInfo.imeOptions = i5;
        imeOptions.getPlatformImeOptions();
        int keyboardType = imeOptions.getKeyboardType();
        KeyboardType.Companion companion2 = KeyboardType.INSTANCE;
        if (KeyboardType.m2410equalsimpl0(keyboardType, companion2.m2421getTextPjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m2410equalsimpl0(keyboardType, companion2.m2414getAsciiPjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m2410equalsimpl0(keyboardType, companion2.m2417getNumberPjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m2410equalsimpl0(keyboardType, companion2.m2420getPhonePjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m2410equalsimpl0(keyboardType, companion2.m2423getUriPjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m2410equalsimpl0(keyboardType, companion2.m2416getEmailPjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m2410equalsimpl0(keyboardType, companion2.m2419getPasswordPjHm6EE())) {
            editorInfo.inputType = 129;
        } else if (KeyboardType.m2410equalsimpl0(keyboardType, companion2.m2418getNumberPasswordPjHm6EE())) {
            editorInfo.inputType = 18;
        } else {
            if (!KeyboardType.m2410equalsimpl0(keyboardType, companion2.m2415getDecimalPjHm6EE())) {
                throw new IllegalStateException("Invalid Keyboard Type");
            }
            editorInfo.inputType = 8194;
        }
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
        editorInfo.initialSelStart = TextRange.m2285getStartimpl(textFieldValue.getSelection());
        editorInfo.initialSelEnd = TextRange.m2280getEndimpl(textFieldValue.getSelection());
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textFieldValue.getText());
        editorInfo.imeOptions |= 33554432;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWithEmojiCompat(EditorInfo editorInfo) {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
    }
}
