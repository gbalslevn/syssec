package androidx.compose.ui.text.android.selection;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0005"}, d2 = {"getWordEnd", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/android/selection/WordIterator;", "offset", "getWordStart", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class WordBoundary_androidKt {
    public static final int getWordEnd(WordIterator wordIterator, int i5) {
        int punctuationEnd = wordIterator.isAfterPunctuation(wordIterator.nextBoundary(i5)) ? wordIterator.getPunctuationEnd(i5) : wordIterator.getNextWordEndOnTwoWordBoundary(i5);
        return punctuationEnd == -1 ? i5 : punctuationEnd;
    }

    public static final int getWordStart(WordIterator wordIterator, int i5) {
        int punctuationBeginning = wordIterator.isOnPunctuation(wordIterator.prevBoundary(i5)) ? wordIterator.getPunctuationBeginning(i5) : wordIterator.getPrevWordBeginningOnTwoWordsBoundary(i5);
        return punctuationBeginning == -1 ? i5 : punctuationBeginning;
    }
}
