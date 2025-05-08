package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R$styleable;
import androidx.emoji2.viewsintegration.EmojiEditTextHelper;

/* loaded from: classes.dex */
class AppCompatEmojiEditTextHelper {
    private final EmojiEditTextHelper mEmojiEditTextHelper;
    private final EditText mView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatEmojiEditTextHelper(EditText editText) {
        this.mView = editText;
        this.mEmojiEditTextHelper = new EmojiEditTextHelper(editText, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyListener getKeyListener(KeyListener keyListener) {
        return isEmojiCapableKeyListener(keyListener) ? this.mEmojiEditTextHelper.getKeyListener(keyListener) : keyListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEmojiCapableKeyListener(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadFromAttributes(AttributeSet attributeSet, int i5) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i5, 0);
        try {
            int i6 = R$styleable.AppCompatTextView_emojiCompatEnabled;
            boolean z5 = obtainStyledAttributes.hasValue(i6) ? obtainStyledAttributes.getBoolean(i6, true) : true;
            obtainStyledAttributes.recycle();
            setEnabled(z5);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.mEmojiEditTextHelper.onCreateInputConnection(inputConnection, editorInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEnabled(boolean z5) {
        this.mEmojiEditTextHelper.setEnabled(z5);
    }
}
