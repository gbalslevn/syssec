package androidx.compose.ui.tooling;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.FloatingActionButtonKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.view.ComponentActivity;
import androidx.view.compose.ComponentActivityKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/tooling/PreviewActivity;", "Landroidx/activity/ComponentActivity;", "()V", "TAG", BuildConfig.FLAVOR, "onCreate", BuildConfig.FLAVOR, "savedInstanceState", "Landroid/os/Bundle;", "setComposableContent", "composableFqn", "setParameterizedContent", "className", "methodName", "parameterProvider", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PreviewActivity extends ComponentActivity {
    private final String TAG = "PreviewActivity";

    private final void setComposableContent(String composableFqn) {
        Log.d(this.TAG, "PreviewActivity has composable " + composableFqn);
        final String substringBeforeLast$default = StringsKt.substringBeforeLast$default(composableFqn, '.', null, 2, null);
        final String substringAfterLast$default = StringsKt.substringAfterLast$default(composableFqn, '.', (String) null, 2, (Object) null);
        String stringExtra = getIntent().getStringExtra("parameterProviderClassName");
        if (stringExtra != null) {
            setParameterizedContent(substringBeforeLast$default, substringAfterLast$default, stringExtra);
            return;
        }
        Log.d(this.TAG, "Previewing '" + substringAfterLast$default + "' without a parameter provider.");
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-840626948, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.PreviewActivity$setComposableContent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
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
                    ComposerKt.traceEventStart(-840626948, i5, -1, "androidx.compose.ui.tooling.PreviewActivity.setComposableContent.<anonymous> (PreviewActivity.android.kt:76)");
                }
                ComposableInvoker.INSTANCE.invokeComposable(substringBeforeLast$default, substringAfterLast$default, composer, new Object[0]);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 1, null);
    }

    private final void setParameterizedContent(final String className, final String methodName, String parameterProvider) {
        Log.d(this.TAG, "Previewing '" + methodName + "' with parameter provider: '" + parameterProvider + '\'');
        final Object[] previewProviderParameters = PreviewUtils_androidKt.getPreviewProviderParameters(PreviewUtils_androidKt.asPreviewProviderClass(parameterProvider), getIntent().getIntExtra("parameterProviderIndex", -1));
        if (previewProviderParameters.length > 1) {
            ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-861939235, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.PreviewActivity$setParameterizedContent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
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
                        ComposerKt.traceEventStart(-861939235, i5, -1, "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous> (PreviewActivity.android.kt:109)");
                    }
                    Object rememberedValue = composer.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                        composer.updateRememberedValue(rememberedValue);
                    }
                    final MutableIntState mutableIntState = (MutableIntState) rememberedValue;
                    final Object[] objArr = previewProviderParameters;
                    ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(958604965, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.PreviewActivity$setParameterizedContent$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i6) {
                            if ((i6 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(958604965, i6, -1, "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous>.<anonymous> (PreviewActivity.android.kt:123)");
                            }
                            Function2<Composer, Integer, Unit> m2566getLambda1$ui_tooling_release = ComposableSingletons$PreviewActivity_androidKt.INSTANCE.m2566getLambda1$ui_tooling_release();
                            boolean changedInstance = composer2.changedInstance(objArr);
                            final MutableIntState mutableIntState2 = mutableIntState;
                            final Object[] objArr2 = objArr;
                            Object rememberedValue2 = composer2.rememberedValue();
                            if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.ui.tooling.PreviewActivity$setParameterizedContent$1$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        MutableIntState mutableIntState3 = MutableIntState.this;
                                        mutableIntState3.setIntValue((mutableIntState3.getIntValue() + 1) % objArr2.length);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue2);
                            }
                            FloatingActionButtonKt.m705ExtendedFloatingActionButtonwqdebIU(m2566getLambda1$ui_tooling_release, (Function0) rememberedValue2, null, null, null, null, 0L, 0L, null, composer2, 6, 508);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer, 54);
                    final String str = className;
                    final String str2 = methodName;
                    final Object[] objArr2 = previewProviderParameters;
                    ScaffoldKt.m719Scaffold27mzLpw(null, null, null, null, null, rememberComposableLambda, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.rememberComposableLambda(57310875, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.PreviewActivity$setParameterizedContent$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer2, Integer num) {
                            invoke(paddingValues, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(PaddingValues paddingValues, Composer composer2, int i6) {
                            if ((i6 & 6) == 0) {
                                i6 |= composer2.changed(paddingValues) ? 4 : 2;
                            }
                            if ((i6 & 19) == 18 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(57310875, i6, -1, "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous>.<anonymous> (PreviewActivity.android.kt:113)");
                            }
                            Modifier padding = PaddingKt.padding(Modifier.INSTANCE, paddingValues);
                            String str3 = str;
                            String str4 = str2;
                            Object[] objArr3 = objArr2;
                            MutableIntState mutableIntState2 = mutableIntState;
                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, padding);
                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                            if (composer2.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor);
                            } else {
                                composer2.useNode();
                            }
                            Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposableInvoker.INSTANCE.invokeComposable(str3, str4, composer2, objArr3[mutableIntState2.getIntValue()]);
                            composer2.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer, 54), composer, 196608, 12582912, 131039);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 1, null);
        } else {
            ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-1901447514, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.PreviewActivity$setParameterizedContent$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
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
                        ComposerKt.traceEventStart(-1901447514, i5, -1, "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous> (PreviewActivity.android.kt:134)");
                    }
                    ComposableInvoker composableInvoker = ComposableInvoker.INSTANCE;
                    String str = className;
                    String str2 = methodName;
                    Object[] objArr = previewProviderParameters;
                    composableInvoker.invokeComposable(str, str2, composer, Arrays.copyOf(objArr, objArr.length));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        String stringExtra;
        super.onCreate(savedInstanceState);
        if ((getApplicationInfo().flags & 2) == 0) {
            Log.d(this.TAG, "Application is not debuggable. Compose Preview not allowed.");
            finish();
            return;
        }
        Intent intent = getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra("composable")) == null) {
            return;
        }
        setComposableContent(stringExtra);
    }
}
