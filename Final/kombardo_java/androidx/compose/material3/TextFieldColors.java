package androidx.compose.material3;

import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b2\b\u0007\u0018\u00002\u00020\u0001Bß\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0002\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\u0006\u0010)\u001a\u00020\u0002\u0012\u0006\u0010*\u001a\u00020\u0002\u0012\u0006\u0010+\u001a\u00020\u0002\u0012\u0006\u0010,\u001a\u00020\u0002\u0012\u0006\u0010-\u001a\u00020\u0002\u0012\u0006\u0010.\u001a\u00020\u0002¢\u0006\u0004\b/\u00100J-\u00107\u001a\u00020\u00022\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u000201H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106J-\u00109\u001a\u00020\u00022\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u000201H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00106J-\u0010;\u001a\u00020\u00022\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u000201H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u00106J-\u0010=\u001a\u00020\u00022\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u000201H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u00106J-\u0010?\u001a\u00020\u00022\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u000201H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u00106J-\u0010A\u001a\u00020\u00022\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u000201H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u00106J-\u0010C\u001a\u00020\u00022\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u000201H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bB\u00106J-\u0010E\u001a\u00020\u00022\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u000201H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bD\u00106J-\u0010G\u001a\u00020\u00022\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u000201H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bF\u00106J-\u0010I\u001a\u00020\u00022\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u000201H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bH\u00106J\u001d\u0010\u000b\u001a\u00020\u00022\u0006\u00103\u001a\u000201H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bJ\u0010KJ\u001a\u0010M\u001a\u0002012\b\u0010L\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\bM\u0010NJ\u000f\u0010P\u001a\u00020OH\u0016¢\u0006\u0004\bP\u0010QR\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0003\u0010R\u001a\u0004\bS\u0010TR\u001d\u0010\u0004\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0004\u0010R\u001a\u0004\bU\u0010TR\u001d\u0010\u0005\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0005\u0010R\u001a\u0004\bV\u0010TR\u001d\u0010\u0006\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0006\u0010R\u001a\u0004\bW\u0010TR\u001d\u0010\u0007\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0007\u0010R\u001a\u0004\bX\u0010TR\u001d\u0010\b\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\b\u0010R\u001a\u0004\bY\u0010TR\u001d\u0010\t\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\t\u0010R\u001a\u0004\bZ\u0010TR\u001d\u0010\n\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\n\u0010R\u001a\u0004\b[\u0010TR\u001d\u0010\u000b\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u000b\u0010R\u001a\u0004\b\\\u0010TR\u001d\u0010\f\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\f\u0010R\u001a\u0004\b]\u0010TR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010^\u001a\u0004\b_\u0010`R\u001d\u0010\u000f\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u000f\u0010R\u001a\u0004\ba\u0010TR\u001d\u0010\u0010\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0010\u0010R\u001a\u0004\bb\u0010TR\u001d\u0010\u0011\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0011\u0010R\u001a\u0004\bc\u0010TR\u001d\u0010\u0012\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0012\u0010R\u001a\u0004\bd\u0010TR\u001d\u0010\u0013\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0013\u0010R\u001a\u0004\be\u0010TR\u001d\u0010\u0014\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0014\u0010R\u001a\u0004\bf\u0010TR\u001d\u0010\u0015\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0015\u0010R\u001a\u0004\bg\u0010TR\u001d\u0010\u0016\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0016\u0010R\u001a\u0004\bh\u0010TR\u001d\u0010\u0017\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0017\u0010R\u001a\u0004\bi\u0010TR\u001d\u0010\u0018\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0018\u0010R\u001a\u0004\bj\u0010TR\u001d\u0010\u0019\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0019\u0010R\u001a\u0004\bk\u0010TR\u001d\u0010\u001a\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u001a\u0010R\u001a\u0004\bl\u0010TR\u001d\u0010\u001b\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u001b\u0010R\u001a\u0004\bm\u0010TR\u001d\u0010\u001c\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u001c\u0010R\u001a\u0004\bn\u0010TR\u001d\u0010\u001d\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u001d\u0010R\u001a\u0004\bo\u0010TR\u001d\u0010\u001e\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u001e\u0010R\u001a\u0004\bp\u0010TR\u001d\u0010\u001f\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u001f\u0010R\u001a\u0004\bq\u0010TR\u001d\u0010 \u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b \u0010R\u001a\u0004\br\u0010TR\u001d\u0010!\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b!\u0010R\u001a\u0004\bs\u0010TR\u001d\u0010\"\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\"\u0010R\u001a\u0004\bt\u0010TR\u001d\u0010#\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b#\u0010R\u001a\u0004\bu\u0010TR\u001d\u0010$\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b$\u0010R\u001a\u0004\bv\u0010TR\u001d\u0010%\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b%\u0010R\u001a\u0004\bw\u0010TR\u001d\u0010&\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b&\u0010R\u001a\u0004\bx\u0010TR\u001d\u0010'\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b'\u0010R\u001a\u0004\by\u0010TR\u001d\u0010(\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b(\u0010R\u001a\u0004\bz\u0010TR\u001d\u0010)\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b)\u0010R\u001a\u0004\b{\u0010TR\u001d\u0010*\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b*\u0010R\u001a\u0004\b|\u0010TR\u001d\u0010+\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b+\u0010R\u001a\u0004\b}\u0010TR\u001d\u0010,\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b,\u0010R\u001a\u0004\b~\u0010TR\u001d\u0010-\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b-\u0010R\u001a\u0004\b\u007f\u0010TR\u001e\u0010.\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\r\n\u0004\b.\u0010R\u001a\u0005\b\u0080\u0001\u0010T\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0081\u0001"}, d2 = {"Landroidx/compose/material3/TextFieldColors;", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/Color;", "focusedTextColor", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "textSelectionColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "<init>", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", BuildConfig.FLAVOR, "enabled", "isError", "focused", "leadingIconColor-XeAY9LY$material3_release", "(ZZZ)J", "leadingIconColor", "trailingIconColor-XeAY9LY$material3_release", "trailingIconColor", "indicatorColor-XeAY9LY$material3_release", "indicatorColor", "containerColor-XeAY9LY$material3_release", "containerColor", "placeholderColor-XeAY9LY$material3_release", "placeholderColor", "labelColor-XeAY9LY$material3_release", "labelColor", "textColor-XeAY9LY$material3_release", "textColor", "supportingTextColor-XeAY9LY$material3_release", "supportingTextColor", "prefixColor-XeAY9LY$material3_release", "prefixColor", "suffixColor-XeAY9LY$material3_release", "suffixColor", "cursorColor-vNxB06k$material3_release", "(Z)J", "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "J", "getFocusedTextColor-0d7_KjU", "()J", "getUnfocusedTextColor-0d7_KjU", "getDisabledTextColor-0d7_KjU", "getErrorTextColor-0d7_KjU", "getFocusedContainerColor-0d7_KjU", "getUnfocusedContainerColor-0d7_KjU", "getDisabledContainerColor-0d7_KjU", "getErrorContainerColor-0d7_KjU", "getCursorColor-0d7_KjU", "getErrorCursorColor-0d7_KjU", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "getTextSelectionColors", "()Landroidx/compose/foundation/text/selection/TextSelectionColors;", "getFocusedIndicatorColor-0d7_KjU", "getUnfocusedIndicatorColor-0d7_KjU", "getDisabledIndicatorColor-0d7_KjU", "getErrorIndicatorColor-0d7_KjU", "getFocusedLeadingIconColor-0d7_KjU", "getUnfocusedLeadingIconColor-0d7_KjU", "getDisabledLeadingIconColor-0d7_KjU", "getErrorLeadingIconColor-0d7_KjU", "getFocusedTrailingIconColor-0d7_KjU", "getUnfocusedTrailingIconColor-0d7_KjU", "getDisabledTrailingIconColor-0d7_KjU", "getErrorTrailingIconColor-0d7_KjU", "getFocusedLabelColor-0d7_KjU", "getUnfocusedLabelColor-0d7_KjU", "getDisabledLabelColor-0d7_KjU", "getErrorLabelColor-0d7_KjU", "getFocusedPlaceholderColor-0d7_KjU", "getUnfocusedPlaceholderColor-0d7_KjU", "getDisabledPlaceholderColor-0d7_KjU", "getErrorPlaceholderColor-0d7_KjU", "getFocusedSupportingTextColor-0d7_KjU", "getUnfocusedSupportingTextColor-0d7_KjU", "getDisabledSupportingTextColor-0d7_KjU", "getErrorSupportingTextColor-0d7_KjU", "getFocusedPrefixColor-0d7_KjU", "getUnfocusedPrefixColor-0d7_KjU", "getDisabledPrefixColor-0d7_KjU", "getErrorPrefixColor-0d7_KjU", "getFocusedSuffixColor-0d7_KjU", "getUnfocusedSuffixColor-0d7_KjU", "getDisabledSuffixColor-0d7_KjU", "getErrorSuffixColor-0d7_KjU", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldColors {
    private final long cursorColor;
    private final long disabledContainerColor;
    private final long disabledIndicatorColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledPlaceholderColor;
    private final long disabledPrefixColor;
    private final long disabledSuffixColor;
    private final long disabledSupportingTextColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long errorContainerColor;
    private final long errorCursorColor;
    private final long errorIndicatorColor;
    private final long errorLabelColor;
    private final long errorLeadingIconColor;
    private final long errorPlaceholderColor;
    private final long errorPrefixColor;
    private final long errorSuffixColor;
    private final long errorSupportingTextColor;
    private final long errorTextColor;
    private final long errorTrailingIconColor;
    private final long focusedContainerColor;
    private final long focusedIndicatorColor;
    private final long focusedLabelColor;
    private final long focusedLeadingIconColor;
    private final long focusedPlaceholderColor;
    private final long focusedPrefixColor;
    private final long focusedSuffixColor;
    private final long focusedSupportingTextColor;
    private final long focusedTextColor;
    private final long focusedTrailingIconColor;
    private final SelectionColors textSelectionColors;
    private final long unfocusedContainerColor;
    private final long unfocusedIndicatorColor;
    private final long unfocusedLabelColor;
    private final long unfocusedLeadingIconColor;
    private final long unfocusedPlaceholderColor;
    private final long unfocusedPrefixColor;
    private final long unfocusedSuffixColor;
    private final long unfocusedSupportingTextColor;
    private final long unfocusedTextColor;
    private final long unfocusedTrailingIconColor;

    public /* synthetic */ TextFieldColors(long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, SelectionColors selectionColors, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, long j45, long j46, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, selectionColors, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, j37, j38, j39, j40, j41, j42, j43, j44, j45, j46);
    }

    /* renamed from: containerColor-XeAY9LY$material3_release, reason: not valid java name */
    public final long m913containerColorXeAY9LY$material3_release(boolean enabled, boolean isError, boolean focused) {
        return !enabled ? this.disabledContainerColor : isError ? this.errorContainerColor : focused ? this.focusedContainerColor : this.unfocusedContainerColor;
    }

    /* renamed from: cursorColor-vNxB06k$material3_release, reason: not valid java name */
    public final long m914cursorColorvNxB06k$material3_release(boolean isError) {
        return isError ? this.errorCursorColor : this.cursorColor;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof TextFieldColors)) {
            return false;
        }
        TextFieldColors textFieldColors = (TextFieldColors) other;
        return Color.m1487equalsimpl0(this.focusedTextColor, textFieldColors.focusedTextColor) && Color.m1487equalsimpl0(this.unfocusedTextColor, textFieldColors.unfocusedTextColor) && Color.m1487equalsimpl0(this.disabledTextColor, textFieldColors.disabledTextColor) && Color.m1487equalsimpl0(this.errorTextColor, textFieldColors.errorTextColor) && Color.m1487equalsimpl0(this.focusedContainerColor, textFieldColors.focusedContainerColor) && Color.m1487equalsimpl0(this.unfocusedContainerColor, textFieldColors.unfocusedContainerColor) && Color.m1487equalsimpl0(this.disabledContainerColor, textFieldColors.disabledContainerColor) && Color.m1487equalsimpl0(this.errorContainerColor, textFieldColors.errorContainerColor) && Color.m1487equalsimpl0(this.cursorColor, textFieldColors.cursorColor) && Color.m1487equalsimpl0(this.errorCursorColor, textFieldColors.errorCursorColor) && Intrinsics.areEqual(this.textSelectionColors, textFieldColors.textSelectionColors) && Color.m1487equalsimpl0(this.focusedIndicatorColor, textFieldColors.focusedIndicatorColor) && Color.m1487equalsimpl0(this.unfocusedIndicatorColor, textFieldColors.unfocusedIndicatorColor) && Color.m1487equalsimpl0(this.disabledIndicatorColor, textFieldColors.disabledIndicatorColor) && Color.m1487equalsimpl0(this.errorIndicatorColor, textFieldColors.errorIndicatorColor) && Color.m1487equalsimpl0(this.focusedLeadingIconColor, textFieldColors.focusedLeadingIconColor) && Color.m1487equalsimpl0(this.unfocusedLeadingIconColor, textFieldColors.unfocusedLeadingIconColor) && Color.m1487equalsimpl0(this.disabledLeadingIconColor, textFieldColors.disabledLeadingIconColor) && Color.m1487equalsimpl0(this.errorLeadingIconColor, textFieldColors.errorLeadingIconColor) && Color.m1487equalsimpl0(this.focusedTrailingIconColor, textFieldColors.focusedTrailingIconColor) && Color.m1487equalsimpl0(this.unfocusedTrailingIconColor, textFieldColors.unfocusedTrailingIconColor) && Color.m1487equalsimpl0(this.disabledTrailingIconColor, textFieldColors.disabledTrailingIconColor) && Color.m1487equalsimpl0(this.errorTrailingIconColor, textFieldColors.errorTrailingIconColor) && Color.m1487equalsimpl0(this.focusedLabelColor, textFieldColors.focusedLabelColor) && Color.m1487equalsimpl0(this.unfocusedLabelColor, textFieldColors.unfocusedLabelColor) && Color.m1487equalsimpl0(this.disabledLabelColor, textFieldColors.disabledLabelColor) && Color.m1487equalsimpl0(this.errorLabelColor, textFieldColors.errorLabelColor) && Color.m1487equalsimpl0(this.focusedPlaceholderColor, textFieldColors.focusedPlaceholderColor) && Color.m1487equalsimpl0(this.unfocusedPlaceholderColor, textFieldColors.unfocusedPlaceholderColor) && Color.m1487equalsimpl0(this.disabledPlaceholderColor, textFieldColors.disabledPlaceholderColor) && Color.m1487equalsimpl0(this.errorPlaceholderColor, textFieldColors.errorPlaceholderColor) && Color.m1487equalsimpl0(this.focusedSupportingTextColor, textFieldColors.focusedSupportingTextColor) && Color.m1487equalsimpl0(this.unfocusedSupportingTextColor, textFieldColors.unfocusedSupportingTextColor) && Color.m1487equalsimpl0(this.disabledSupportingTextColor, textFieldColors.disabledSupportingTextColor) && Color.m1487equalsimpl0(this.errorSupportingTextColor, textFieldColors.errorSupportingTextColor) && Color.m1487equalsimpl0(this.focusedPrefixColor, textFieldColors.focusedPrefixColor) && Color.m1487equalsimpl0(this.unfocusedPrefixColor, textFieldColors.unfocusedPrefixColor) && Color.m1487equalsimpl0(this.disabledPrefixColor, textFieldColors.disabledPrefixColor) && Color.m1487equalsimpl0(this.errorPrefixColor, textFieldColors.errorPrefixColor) && Color.m1487equalsimpl0(this.focusedSuffixColor, textFieldColors.focusedSuffixColor) && Color.m1487equalsimpl0(this.unfocusedSuffixColor, textFieldColors.unfocusedSuffixColor) && Color.m1487equalsimpl0(this.disabledSuffixColor, textFieldColors.disabledSuffixColor) && Color.m1487equalsimpl0(this.errorSuffixColor, textFieldColors.errorSuffixColor);
    }

    public final SelectionColors getTextSelectionColors() {
        return this.textSelectionColors;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((Color.m1493hashCodeimpl(this.focusedTextColor) * 31) + Color.m1493hashCodeimpl(this.unfocusedTextColor)) * 31) + Color.m1493hashCodeimpl(this.disabledTextColor)) * 31) + Color.m1493hashCodeimpl(this.errorTextColor)) * 31) + Color.m1493hashCodeimpl(this.focusedContainerColor)) * 31) + Color.m1493hashCodeimpl(this.unfocusedContainerColor)) * 31) + Color.m1493hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m1493hashCodeimpl(this.errorContainerColor)) * 31) + Color.m1493hashCodeimpl(this.cursorColor)) * 31) + Color.m1493hashCodeimpl(this.errorCursorColor)) * 31) + this.textSelectionColors.hashCode()) * 31) + Color.m1493hashCodeimpl(this.focusedIndicatorColor)) * 31) + Color.m1493hashCodeimpl(this.unfocusedIndicatorColor)) * 31) + Color.m1493hashCodeimpl(this.disabledIndicatorColor)) * 31) + Color.m1493hashCodeimpl(this.errorIndicatorColor)) * 31) + Color.m1493hashCodeimpl(this.focusedLeadingIconColor)) * 31) + Color.m1493hashCodeimpl(this.unfocusedLeadingIconColor)) * 31) + Color.m1493hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m1493hashCodeimpl(this.errorLeadingIconColor)) * 31) + Color.m1493hashCodeimpl(this.focusedTrailingIconColor)) * 31) + Color.m1493hashCodeimpl(this.unfocusedTrailingIconColor)) * 31) + Color.m1493hashCodeimpl(this.disabledTrailingIconColor)) * 31) + Color.m1493hashCodeimpl(this.errorTrailingIconColor)) * 31) + Color.m1493hashCodeimpl(this.focusedLabelColor)) * 31) + Color.m1493hashCodeimpl(this.unfocusedLabelColor)) * 31) + Color.m1493hashCodeimpl(this.disabledLabelColor)) * 31) + Color.m1493hashCodeimpl(this.errorLabelColor)) * 31) + Color.m1493hashCodeimpl(this.focusedPlaceholderColor)) * 31) + Color.m1493hashCodeimpl(this.unfocusedPlaceholderColor)) * 31) + Color.m1493hashCodeimpl(this.disabledPlaceholderColor)) * 31) + Color.m1493hashCodeimpl(this.errorPlaceholderColor)) * 31) + Color.m1493hashCodeimpl(this.focusedSupportingTextColor)) * 31) + Color.m1493hashCodeimpl(this.unfocusedSupportingTextColor)) * 31) + Color.m1493hashCodeimpl(this.disabledSupportingTextColor)) * 31) + Color.m1493hashCodeimpl(this.errorSupportingTextColor)) * 31) + Color.m1493hashCodeimpl(this.focusedPrefixColor)) * 31) + Color.m1493hashCodeimpl(this.unfocusedPrefixColor)) * 31) + Color.m1493hashCodeimpl(this.disabledPrefixColor)) * 31) + Color.m1493hashCodeimpl(this.errorPrefixColor)) * 31) + Color.m1493hashCodeimpl(this.focusedSuffixColor)) * 31) + Color.m1493hashCodeimpl(this.unfocusedSuffixColor)) * 31) + Color.m1493hashCodeimpl(this.disabledSuffixColor)) * 31) + Color.m1493hashCodeimpl(this.errorSuffixColor);
    }

    /* renamed from: indicatorColor-XeAY9LY$material3_release, reason: not valid java name */
    public final long m915indicatorColorXeAY9LY$material3_release(boolean enabled, boolean isError, boolean focused) {
        return !enabled ? this.disabledIndicatorColor : isError ? this.errorIndicatorColor : focused ? this.focusedIndicatorColor : this.unfocusedIndicatorColor;
    }

    /* renamed from: labelColor-XeAY9LY$material3_release, reason: not valid java name */
    public final long m916labelColorXeAY9LY$material3_release(boolean enabled, boolean isError, boolean focused) {
        return !enabled ? this.disabledLabelColor : isError ? this.errorLabelColor : focused ? this.focusedLabelColor : this.unfocusedLabelColor;
    }

    /* renamed from: leadingIconColor-XeAY9LY$material3_release, reason: not valid java name */
    public final long m917leadingIconColorXeAY9LY$material3_release(boolean enabled, boolean isError, boolean focused) {
        return !enabled ? this.disabledLeadingIconColor : isError ? this.errorLeadingIconColor : focused ? this.focusedLeadingIconColor : this.unfocusedLeadingIconColor;
    }

    /* renamed from: placeholderColor-XeAY9LY$material3_release, reason: not valid java name */
    public final long m918placeholderColorXeAY9LY$material3_release(boolean enabled, boolean isError, boolean focused) {
        return !enabled ? this.disabledPlaceholderColor : isError ? this.errorPlaceholderColor : focused ? this.focusedPlaceholderColor : this.unfocusedPlaceholderColor;
    }

    /* renamed from: prefixColor-XeAY9LY$material3_release, reason: not valid java name */
    public final long m919prefixColorXeAY9LY$material3_release(boolean enabled, boolean isError, boolean focused) {
        return !enabled ? this.disabledPrefixColor : isError ? this.errorPrefixColor : focused ? this.focusedPrefixColor : this.unfocusedPrefixColor;
    }

    /* renamed from: suffixColor-XeAY9LY$material3_release, reason: not valid java name */
    public final long m920suffixColorXeAY9LY$material3_release(boolean enabled, boolean isError, boolean focused) {
        return !enabled ? this.disabledSuffixColor : isError ? this.errorSuffixColor : focused ? this.focusedSuffixColor : this.unfocusedSuffixColor;
    }

    /* renamed from: supportingTextColor-XeAY9LY$material3_release, reason: not valid java name */
    public final long m921supportingTextColorXeAY9LY$material3_release(boolean enabled, boolean isError, boolean focused) {
        return !enabled ? this.disabledSupportingTextColor : isError ? this.errorSupportingTextColor : focused ? this.focusedSupportingTextColor : this.unfocusedSupportingTextColor;
    }

    /* renamed from: textColor-XeAY9LY$material3_release, reason: not valid java name */
    public final long m922textColorXeAY9LY$material3_release(boolean enabled, boolean isError, boolean focused) {
        return !enabled ? this.disabledTextColor : isError ? this.errorTextColor : focused ? this.focusedTextColor : this.unfocusedTextColor;
    }

    /* renamed from: trailingIconColor-XeAY9LY$material3_release, reason: not valid java name */
    public final long m923trailingIconColorXeAY9LY$material3_release(boolean enabled, boolean isError, boolean focused) {
        return !enabled ? this.disabledTrailingIconColor : isError ? this.errorTrailingIconColor : focused ? this.focusedTrailingIconColor : this.unfocusedTrailingIconColor;
    }

    private TextFieldColors(long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, SelectionColors selectionColors, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, long j45, long j46) {
        this.focusedTextColor = j5;
        this.unfocusedTextColor = j6;
        this.disabledTextColor = j7;
        this.errorTextColor = j8;
        this.focusedContainerColor = j9;
        this.unfocusedContainerColor = j10;
        this.disabledContainerColor = j11;
        this.errorContainerColor = j12;
        this.cursorColor = j13;
        this.errorCursorColor = j14;
        this.textSelectionColors = selectionColors;
        this.focusedIndicatorColor = j15;
        this.unfocusedIndicatorColor = j16;
        this.disabledIndicatorColor = j17;
        this.errorIndicatorColor = j18;
        this.focusedLeadingIconColor = j19;
        this.unfocusedLeadingIconColor = j20;
        this.disabledLeadingIconColor = j21;
        this.errorLeadingIconColor = j22;
        this.focusedTrailingIconColor = j23;
        this.unfocusedTrailingIconColor = j24;
        this.disabledTrailingIconColor = j25;
        this.errorTrailingIconColor = j26;
        this.focusedLabelColor = j27;
        this.unfocusedLabelColor = j28;
        this.disabledLabelColor = j29;
        this.errorLabelColor = j30;
        this.focusedPlaceholderColor = j31;
        this.unfocusedPlaceholderColor = j32;
        this.disabledPlaceholderColor = j33;
        this.errorPlaceholderColor = j34;
        this.focusedSupportingTextColor = j35;
        this.unfocusedSupportingTextColor = j36;
        this.disabledSupportingTextColor = j37;
        this.errorSupportingTextColor = j38;
        this.focusedPrefixColor = j39;
        this.unfocusedPrefixColor = j40;
        this.disabledPrefixColor = j41;
        this.errorPrefixColor = j42;
        this.focusedSuffixColor = j43;
        this.unfocusedSuffixColor = j44;
        this.disabledSuffixColor = j45;
        this.errorSuffixColor = j46;
    }
}
