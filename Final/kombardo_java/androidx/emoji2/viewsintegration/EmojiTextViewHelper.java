package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes.dex */
public final class EmojiTextViewHelper {
    private final HelperInternal mHelper;

    /* loaded from: classes.dex */
    static class HelperInternal {
        HelperInternal() {
        }

        abstract InputFilter[] getFilters(InputFilter[] inputFilterArr);

        abstract void setAllCaps(boolean z5);

        abstract void setEnabled(boolean z5);
    }

    /* loaded from: classes.dex */
    private static class HelperInternal19 extends HelperInternal {
        private final EmojiInputFilter mEmojiInputFilter;
        private boolean mEnabled = true;
        private final TextView mTextView;

        HelperInternal19(TextView textView) {
            this.mTextView = textView;
            this.mEmojiInputFilter = new EmojiInputFilter(textView);
        }

        private InputFilter[] addEmojiInputFilterIfMissing(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.mEmojiInputFilter) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.mEmojiInputFilter;
            return inputFilterArr2;
        }

        private SparseArray<InputFilter> getEmojiInputFilterPositionArray(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArray = new SparseArray<>(1);
            for (int i5 = 0; i5 < inputFilterArr.length; i5++) {
                InputFilter inputFilter = inputFilterArr[i5];
                if (inputFilter instanceof EmojiInputFilter) {
                    sparseArray.put(i5, inputFilter);
                }
            }
            return sparseArray;
        }

        private InputFilter[] removeEmojiInputFilterIfPresent(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> emojiInputFilterPositionArray = getEmojiInputFilterPositionArray(inputFilterArr);
            if (emojiInputFilterPositionArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - emojiInputFilterPositionArray.size()];
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                if (emojiInputFilterPositionArray.indexOfKey(i6) < 0) {
                    inputFilterArr2[i5] = inputFilterArr[i6];
                    i5++;
                }
            }
            return inputFilterArr2;
        }

        private TransformationMethod unwrapForDisabled(TransformationMethod transformationMethod) {
            return transformationMethod instanceof EmojiTransformationMethod ? ((EmojiTransformationMethod) transformationMethod).getOriginalTransformationMethod() : transformationMethod;
        }

        private void updateFilters() {
            this.mTextView.setFilters(getFilters(this.mTextView.getFilters()));
        }

        private TransformationMethod wrapForEnabled(TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof EmojiTransformationMethod) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new EmojiTransformationMethod(transformationMethod);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        InputFilter[] getFilters(InputFilter[] inputFilterArr) {
            return !this.mEnabled ? removeEmojiInputFilterIfPresent(inputFilterArr) : addEmojiInputFilterIfMissing(inputFilterArr);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void setAllCaps(boolean z5) {
            if (z5) {
                updateTransformationMethod();
            }
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void setEnabled(boolean z5) {
            this.mEnabled = z5;
            updateTransformationMethod();
            updateFilters();
        }

        void setEnabledUnsafe(boolean z5) {
            this.mEnabled = z5;
        }

        void updateTransformationMethod() {
            this.mTextView.setTransformationMethod(wrapTransformationMethod(this.mTextView.getTransformationMethod()));
        }

        TransformationMethod wrapTransformationMethod(TransformationMethod transformationMethod) {
            return this.mEnabled ? wrapForEnabled(transformationMethod) : unwrapForDisabled(transformationMethod);
        }
    }

    /* loaded from: classes.dex */
    private static class SkippingHelper19 extends HelperInternal {
        private final HelperInternal19 mHelperDelegate;

        SkippingHelper19(TextView textView) {
            this.mHelperDelegate = new HelperInternal19(textView);
        }

        private boolean skipBecauseEmojiCompatNotInitialized() {
            return !EmojiCompat.isConfigured();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        InputFilter[] getFilters(InputFilter[] inputFilterArr) {
            return skipBecauseEmojiCompatNotInitialized() ? inputFilterArr : this.mHelperDelegate.getFilters(inputFilterArr);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void setAllCaps(boolean z5) {
            if (skipBecauseEmojiCompatNotInitialized()) {
                return;
            }
            this.mHelperDelegate.setAllCaps(z5);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void setEnabled(boolean z5) {
            if (skipBecauseEmojiCompatNotInitialized()) {
                this.mHelperDelegate.setEnabledUnsafe(z5);
            } else {
                this.mHelperDelegate.setEnabled(z5);
            }
        }
    }

    public EmojiTextViewHelper(TextView textView, boolean z5) {
        Preconditions.checkNotNull(textView, "textView cannot be null");
        if (z5) {
            this.mHelper = new HelperInternal19(textView);
        } else {
            this.mHelper = new SkippingHelper19(textView);
        }
    }

    public InputFilter[] getFilters(InputFilter[] inputFilterArr) {
        return this.mHelper.getFilters(inputFilterArr);
    }

    public void setAllCaps(boolean z5) {
        this.mHelper.setAllCaps(z5);
    }

    public void setEnabled(boolean z5) {
        this.mHelper.setEnabled(z5);
    }
}
