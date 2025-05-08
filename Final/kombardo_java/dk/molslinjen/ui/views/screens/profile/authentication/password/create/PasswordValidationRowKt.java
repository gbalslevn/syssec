package dk.molslinjen.ui.views.screens.profile.authentication.password.create;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator;
import dk.molslinjen.ui.views.screens.profile.authentication.password.create.PasswordValidationRowKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a+\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {BuildConfig.FLAVOR, "label", BuildConfig.FLAVOR, "input", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$StringValidator;", "inputValidator", BuildConfig.FLAVOR, "PasswordValidationRow", "(ILjava/lang/String;Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$StringValidator;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PasswordValidationRowKt {
    public static final void PasswordValidationRow(final int i5, final String str, final IInputValidator.StringValidator inputValidator, Composer composer, final int i6) {
        int i7;
        Composer composer2;
        Intrinsics.checkNotNullParameter(inputValidator, "inputValidator");
        Composer startRestartGroup = composer.startRestartGroup(620733216);
        if ((i6 & 6) == 0) {
            i7 = (startRestartGroup.changed(i5) ? 4 : 2) | i6;
        } else {
            i7 = i6;
        }
        if ((i6 & 48) == 0) {
            i7 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i7 |= (i6 & 512) == 0 ? startRestartGroup.changed(inputValidator) : startRestartGroup.changedInstance(inputValidator) ? 256 : 128;
        }
        int i8 = i7;
        if ((i8 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(620733216, i8, -1, "dk.molslinjen.ui.views.screens.profile.authentication.password.create.PasswordValidationRow (PasswordValidationRow.kt:26)");
            }
            boolean z5 = inputValidator.validate(str) == null;
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i9 = z5 ? R.drawable.icon_checkmark_tick_small : R.drawable.icon_dot;
            final int i10 = z5 ? R.string.accessibilityLabel_fulfilled : R.string.accessibilityLabel_notFulfilled;
            Integer valueOf = Integer.valueOf(i9);
            startRestartGroup.startReplaceGroup(1913706107);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: z3.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        ContentTransform PasswordValidationRow$lambda$2$lambda$1$lambda$0;
                        PasswordValidationRow$lambda$2$lambda$1$lambda$0 = PasswordValidationRowKt.PasswordValidationRow$lambda$2$lambda$1$lambda$0((AnimatedContentTransitionScope) obj);
                        return PasswordValidationRow$lambda$2$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            AnimatedContentKt.AnimatedContent(valueOf, null, (Function1) rememberedValue, null, "CheckmarkAnimation", null, ComposableLambdaKt.rememberComposableLambda(1916086990, true, new Function4<AnimatedContentScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.password.create.PasswordValidationRowKt$PasswordValidationRow$1$2
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, Integer num, Composer composer3, Integer num2) {
                    invoke(animatedContentScope, num.intValue(), composer3, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedContentScope AnimatedContent, int i11, Composer composer3, int i12) {
                    Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1916086990, i12, -1, "dk.molslinjen.ui.views.screens.profile.authentication.password.create.PasswordValidationRow.<anonymous>.<anonymous> (PasswordValidationRow.kt:49)");
                    }
                    ImageKt.Image(PainterResources_androidKt.painterResource(i11, composer3, (i12 >> 3) & 14), StringResources_androidKt.stringResource(i10, composer3, 0), SizeKt.m331size3ABfNKs(PaddingKt.m313paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m2599constructorimpl(2), 0.0f, 2, null), Dp.m2599constructorimpl(16)), null, null, 0.0f, null, composer3, 384, 120);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, 1597824, 42);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(i5, composer2, i8 & 14), null, AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 384, 1572864, 65530);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: z3.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PasswordValidationRow$lambda$3;
                    PasswordValidationRow$lambda$3 = PasswordValidationRowKt.PasswordValidationRow$lambda$3(i5, str, inputValidator, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return PasswordValidationRow$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentTransform PasswordValidationRow$lambda$2$lambda$1$lambda$0(AnimatedContentTransitionScope AnimatedContent) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.m29scaleInL8ZKhE$default(null, 0.0f, 0L, 7, null), EnterExitTransitionKt.m31scaleOutL8ZKhE$default(null, 0.0f, 0L, 7, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PasswordValidationRow$lambda$3(int i5, String str, IInputValidator.StringValidator stringValidator, int i6, Composer composer, int i7) {
        PasswordValidationRow(i5, str, stringValidator, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
        return Unit.INSTANCE;
    }
}
