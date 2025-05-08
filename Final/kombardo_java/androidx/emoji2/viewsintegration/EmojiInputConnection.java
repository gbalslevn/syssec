package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes.dex */
final class EmojiInputConnection extends InputConnectionWrapper {
    private final EmojiCompatDeleteHelper mEmojiCompatDeleteHelper;
    private final TextView mTextView;

    /* loaded from: classes.dex */
    public static class EmojiCompatDeleteHelper {
        public boolean handleDeleteSurroundingText(InputConnection inputConnection, Editable editable, int i5, int i6, boolean z5) {
            return EmojiCompat.handleDeleteSurroundingText(inputConnection, editable, i5, i6, z5);
        }

        public void updateEditorInfoAttrs(EditorInfo editorInfo) {
            if (EmojiCompat.isConfigured()) {
                EmojiCompat.get().updateEditorInfo(editorInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiInputConnection(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new EmojiCompatDeleteHelper());
    }

    private Editable getEditable() {
        return this.mTextView.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i5, int i6) {
        return this.mEmojiCompatDeleteHelper.handleDeleteSurroundingText(this, getEditable(), i5, i6, false) || super.deleteSurroundingText(i5, i6);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i5, int i6) {
        return this.mEmojiCompatDeleteHelper.handleDeleteSurroundingText(this, getEditable(), i5, i6, true) || super.deleteSurroundingTextInCodePoints(i5, i6);
    }

    EmojiInputConnection(TextView textView, InputConnection inputConnection, EditorInfo editorInfo, EmojiCompatDeleteHelper emojiCompatDeleteHelper) {
        super(inputConnection, false);
        this.mTextView = textView;
        this.mEmojiCompatDeleteHelper = emojiCompatDeleteHelper;
        emojiCompatDeleteHelper.updateEditorInfoAttrs(editorInfo);
    }
}
