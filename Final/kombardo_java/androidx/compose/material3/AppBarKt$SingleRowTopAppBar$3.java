package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppBarKt$SingleRowTopAppBar$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $actionsRow;
    final /* synthetic */ boolean $centeredTitle;
    final /* synthetic */ TopAppBarColors $colors;
    final /* synthetic */ float $expandedHeight;
    final /* synthetic */ Function2<Composer, Integer, Unit> $navigationIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;
    final /* synthetic */ TextStyle $titleTextStyle;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppBarKt$SingleRowTopAppBar$3(WindowInsets windowInsets, float f5, TopAppBarScrollBehavior topAppBarScrollBehavior, TopAppBarColors topAppBarColors, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, boolean z5, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23) {
        super(2);
        this.$windowInsets = windowInsets;
        this.$expandedHeight = f5;
        this.$colors = topAppBarColors;
        this.$title = function2;
        this.$titleTextStyle = textStyle;
        this.$centeredTitle = z5;
        this.$navigationIcon = function22;
        this.$actionsRow = function23;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$lambda$1$lambda$0(TopAppBarScrollBehavior topAppBarScrollBehavior) {
        TopAppBarState state;
        if (topAppBarScrollBehavior == null || (state = topAppBarScrollBehavior.getState()) == null) {
            return 0.0f;
        }
        return state.getHeightOffset();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1943739546, i5, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1927)");
        }
        final TopAppBarScrollBehavior topAppBarScrollBehavior = null;
        Modifier m327heightInVpY3zN4$default = SizeKt.m327heightInVpY3zN4$default(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, this.$windowInsets)), 0.0f, this.$expandedHeight, 1, null);
        boolean changed = composer.changed((Object) null);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new ScrolledOffset(topAppBarScrollBehavior) { // from class: androidx.compose.material3.a
                @Override // androidx.compose.material3.ScrolledOffset
                public final float offset() {
                    float invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = AppBarKt$SingleRowTopAppBar$3.invoke$lambda$1$lambda$0(null);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        ScrolledOffset scrolledOffset = (ScrolledOffset) rememberedValue;
        long navigationIconContentColor = this.$colors.getNavigationIconContentColor();
        long titleContentColor = this.$colors.getTitleContentColor();
        long actionIconContentColor = this.$colors.getActionIconContentColor();
        Function2<Composer, Integer, Unit> function2 = this.$title;
        TextStyle textStyle = this.$titleTextStyle;
        Arrangement arrangement = Arrangement.INSTANCE;
        AppBarKt.m772TopAppBarLayoutkXwM9vE(m327heightInVpY3zN4$default, scrolledOffset, navigationIconContentColor, titleContentColor, actionIconContentColor, function2, textStyle, 1.0f, arrangement.getCenter(), this.$centeredTitle ? arrangement.getCenter() : arrangement.getStart(), 0, false, this.$navigationIcon, this.$actionsRow, composer, 113246208, 3126);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
