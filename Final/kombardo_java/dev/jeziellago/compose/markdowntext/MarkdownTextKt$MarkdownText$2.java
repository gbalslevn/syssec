package dev.jeziellago.compose.markdowntext;

import android.widget.TextView;
import io.noties.markwon.Markwon;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes2.dex */
final class MarkdownTextKt$MarkdownText$2 extends Lambda implements Function1<TextView, Unit> {
    final /* synthetic */ boolean $disableLinkMovementMethod;
    final /* synthetic */ String $markdown;
    final /* synthetic */ Markwon $markdownRender;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ Function1<Integer, Unit> $onTextLayout;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MarkdownTextKt$MarkdownText$2(Markwon markwon, String str, boolean z5, Function1<? super Integer, Unit> function1, int i5) {
        super(1);
        this.$markdownRender = markwon;
        this.$markdown = str;
        this.$disableLinkMovementMethod = z5;
        this.$onTextLayout = function1;
        this.$maxLines = i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0, reason: not valid java name */
    public static final void m3190invoke$lambda0(Function1 function1, TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "$textView");
        function1.invoke(Integer.valueOf(textView.getLineCount()));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
        invoke2(textView);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        this.$markdownRender.setMarkdown(textView, this.$markdown);
        if (this.$disableLinkMovementMethod) {
            textView.setMovementMethod(null);
        }
        final Function1<Integer, Unit> function1 = this.$onTextLayout;
        if (function1 != null) {
            textView.post(new Runnable() { // from class: dev.jeziellago.compose.markdowntext.a
                @Override // java.lang.Runnable
                public final void run() {
                    MarkdownTextKt$MarkdownText$2.m3190invoke$lambda0(Function1.this, textView);
                }
            });
        }
        textView.setMaxLines(this.$maxLines);
    }
}
