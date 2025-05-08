package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.emoji2.viewsintegration.EmojiTextViewHelper;

/* loaded from: classes.dex */
class AppCompatEmojiTextHelper {
    private final EmojiTextViewHelper mEmojiTextViewHelper;
    private final TextView mView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatEmojiTextHelper(TextView textView) {
        this.mView = textView;
        this.mEmojiTextViewHelper = new EmojiTextViewHelper(textView, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputFilter[] getFilters(InputFilter[] inputFilterArr) {
        return this.mEmojiTextViewHelper.getFilters(inputFilterArr);
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
    public void setAllCaps(boolean z5) {
        this.mEmojiTextViewHelper.setAllCaps(z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEnabled(boolean z5) {
        this.mEmojiTextViewHelper.setEnabled(z5);
    }
}
