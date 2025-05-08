package dev.jeziellago.compose.markdowntext;

import android.view.View;
import dev.jeziellago.compose.markdowntext.MarkdownTextKt$createMarkdownRender$1;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.LinkResolver;
import io.noties.markwon.MarkwonConfiguration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"dev/jeziellago/compose/markdowntext/MarkdownTextKt$createMarkdownRender$1", "Lio/noties/markwon/AbstractMarkwonPlugin;", "configureConfiguration", BuildConfig.FLAVOR, "builder", "Lio/noties/markwon/MarkwonConfiguration$Builder;", "markdowntext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class MarkdownTextKt$createMarkdownRender$1 extends AbstractMarkwonPlugin {
    final /* synthetic */ Function1<String, Unit> $onLinkClicked;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public MarkdownTextKt$createMarkdownRender$1(Function1<? super String, Unit> function1) {
        this.$onLinkClicked = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: configureConfiguration$lambda-0, reason: not valid java name */
    public static final void m3191configureConfiguration$lambda0(Function1 function1, View view, String link) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(link, "link");
        if (function1 != null) {
            function1.invoke(link);
        }
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureConfiguration(MarkwonConfiguration.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        final Function1<String, Unit> function1 = this.$onLinkClicked;
        builder.linkResolver(new LinkResolver() { // from class: m1.b
            @Override // io.noties.markwon.LinkResolver
            public final void resolve(View view, String str) {
                MarkdownTextKt$createMarkdownRender$1.m3191configureConfiguration$lambda0(Function1.this, view, str);
            }
        });
    }
}
