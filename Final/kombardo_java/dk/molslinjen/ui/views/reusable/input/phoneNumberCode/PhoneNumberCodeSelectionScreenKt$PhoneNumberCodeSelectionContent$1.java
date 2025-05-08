package dk.molslinjen.ui.views.reusable.input.phoneNumberCode;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class PhoneNumberCodeSelectionScreenKt$PhoneNumberCodeSelectionContent$1 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ List<LocaleWithPhoneNumberCode> $frequentlyUsed;
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ Function1<String, Unit> $onPhoneNumberCodeSelected;
    final /* synthetic */ List<LocaleWithPhoneNumberCode> $others;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public PhoneNumberCodeSelectionScreenKt$PhoneNumberCodeSelectionContent$1(LazyListState lazyListState, List<LocaleWithPhoneNumberCode> list, Function1<? super String, Unit> function1, List<LocaleWithPhoneNumberCode> list2) {
        this.$lazyListState = lazyListState;
        this.$frequentlyUsed = list;
        this.$onPhoneNumberCodeSelected = function1;
        this.$others = list2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(final List list, final List list2, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        ComposableSingletons$PhoneNumberCodeSelectionScreenKt composableSingletons$PhoneNumberCodeSelectionScreenKt = ComposableSingletons$PhoneNumberCodeSelectionScreenKt.INSTANCE;
        LazyListScope.item$default(LazyColumn, null, null, composableSingletons$PhoneNumberCodeSelectionScreenKt.m3421getLambda1$app_kombardoProd(), 3, null);
        final PhoneNumberCodeSelectionScreenKt$PhoneNumberCodeSelectionContent$1$invoke$lambda$3$lambda$2$$inlined$items$default$1 phoneNumberCodeSelectionScreenKt$PhoneNumberCodeSelectionContent$1$invoke$lambda$3$lambda$2$$inlined$items$default$1 = new Function1() { // from class: dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodeSelectionScreenKt$PhoneNumberCodeSelectionContent$1$invoke$lambda$3$lambda$2$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(LocaleWithPhoneNumberCode localeWithPhoneNumberCode) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((LocaleWithPhoneNumberCode) obj);
            }
        };
        LazyColumn.items(list.size(), null, new Function1<Integer, Object>() { // from class: dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodeSelectionScreenKt$PhoneNumberCodeSelectionContent$1$invoke$lambda$3$lambda$2$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i5) {
                return Function1.this.invoke(list.get(i5));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodeSelectionScreenKt$PhoneNumberCodeSelectionContent$1$invoke$lambda$3$lambda$2$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i5, Composer composer, int i6) {
                int i7;
                if ((i6 & 6) == 0) {
                    i7 = (composer.changed(lazyItemScope) ? 4 : 2) | i6;
                } else {
                    i7 = i6;
                }
                if ((i6 & 48) == 0) {
                    i7 |= composer.changed(i5) ? 32 : 16;
                }
                if ((i7 & 147) == 146 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, i7, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                }
                LocaleWithPhoneNumberCode localeWithPhoneNumberCode = (LocaleWithPhoneNumberCode) list.get(i5);
                composer.startReplaceGroup(2071208425);
                PhoneNumberCodeSelectionScreenKt.access$PhoneNumberCodeItem(localeWithPhoneNumberCode, function1, true, composer, 384);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        LazyListScope.item$default(LazyColumn, null, null, composableSingletons$PhoneNumberCodeSelectionScreenKt.m3422getLambda2$app_kombardoProd(), 3, null);
        final PhoneNumberCodeSelectionScreenKt$PhoneNumberCodeSelectionContent$1$invoke$lambda$3$lambda$2$$inlined$items$default$5 phoneNumberCodeSelectionScreenKt$PhoneNumberCodeSelectionContent$1$invoke$lambda$3$lambda$2$$inlined$items$default$5 = new Function1() { // from class: dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodeSelectionScreenKt$PhoneNumberCodeSelectionContent$1$invoke$lambda$3$lambda$2$$inlined$items$default$5
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(LocaleWithPhoneNumberCode localeWithPhoneNumberCode) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((LocaleWithPhoneNumberCode) obj);
            }
        };
        LazyColumn.items(list2.size(), null, new Function1<Integer, Object>() { // from class: dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodeSelectionScreenKt$PhoneNumberCodeSelectionContent$1$invoke$lambda$3$lambda$2$$inlined$items$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i5) {
                return Function1.this.invoke(list2.get(i5));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodeSelectionScreenKt$PhoneNumberCodeSelectionContent$1$invoke$lambda$3$lambda$2$$inlined$items$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i5, Composer composer, int i6) {
                int i7;
                if ((i6 & 6) == 0) {
                    i7 = (composer.changed(lazyItemScope) ? 4 : 2) | i6;
                } else {
                    i7 = i6;
                }
                if ((i6 & 48) == 0) {
                    i7 |= composer.changed(i5) ? 32 : 16;
                }
                if ((i7 & 147) == 146 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, i7, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                }
                LocaleWithPhoneNumberCode localeWithPhoneNumberCode = (LocaleWithPhoneNumberCode) list2.get(i5);
                composer.startReplaceGroup(2071616447);
                PhoneNumberCodeSelectionScreenKt.access$PhoneNumberCodeItem(localeWithPhoneNumberCode, function1, false, composer, 384);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope BottomSheetContainer, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-843341924, i5, -1, "dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodeSelectionContent.<anonymous> (PhoneNumberCodeSelectionScreen.kt:65)");
        }
        LazyListState lazyListState = this.$lazyListState;
        composer.startReplaceGroup(-546031591);
        boolean changedInstance = composer.changedInstance(this.$frequentlyUsed) | composer.changed(this.$onPhoneNumberCodeSelected) | composer.changedInstance(this.$others);
        final List<LocaleWithPhoneNumberCode> list = this.$frequentlyUsed;
        final List<LocaleWithPhoneNumberCode> list2 = this.$others;
        final Function1<String, Unit> function1 = this.$onPhoneNumberCodeSelected;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.reusable.input.phoneNumberCode.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = PhoneNumberCodeSelectionScreenKt$PhoneNumberCodeSelectionContent$1.invoke$lambda$3$lambda$2(list, list2, function1, (LazyListScope) obj);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        LazyDslKt.LazyColumn(null, lazyListState, null, false, null, null, null, false, (Function1) rememberedValue, composer, 0, 253);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
