package com.ramcosta.composedestinations.result;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.ramcosta.composedestinations.navargs.DestinationsNavType;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001aI\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u00030\u0004j\u0002`\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010\f\u001aW\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00020\u000e\"\u0010\b\u0000\u0010\u000f*\n\u0012\u0002\b\u00030\u0004j\u0002`\u0005\"\u0004\b\u0001\u0010\u00022\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00112\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0007H\u0001¢\u0006\u0002\u0010\u0012\u001a<\u0010\u0013\u001a\u00020\u0014\"\u0010\b\u0000\u0010\u000f*\n\u0012\u0002\b\u00030\u0004j\u0002`\u0005\"\u0004\b\u0001\u0010\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0000\u001a<\u0010\u0016\u001a\u00020\u0014\"\u0010\b\u0000\u0010\u000f*\n\u0012\u0002\b\u00030\u0004j\u0002`\u0005\"\u0004\b\u0001\u0010\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0000¨\u0006\u0017"}, d2 = {"resultBackNavigator", "Lcom/ramcosta/composedestinations/result/ResultBackNavigator;", "R", "destination", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Lcom/ramcosta/composedestinations/spec/DestinationSpec;", "resultNavType", "Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;", "navController", "Landroidx/navigation/NavController;", "navBackStackEntry", "Landroidx/navigation/NavBackStackEntry;", "(Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;Landroidx/navigation/NavController;Landroidx/navigation/NavBackStackEntry;Landroidx/compose/runtime/Composer;I)Lcom/ramcosta/composedestinations/result/ResultBackNavigator;", "resultRecipient", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "D", "originType", "Lkotlin/reflect/KClass;", "(Landroidx/navigation/NavBackStackEntry;Lkotlin/reflect/KClass;Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;Landroidx/compose/runtime/Composer;I)Lcom/ramcosta/composedestinations/result/ResultRecipient;", "resultKey", BuildConfig.FLAVOR, "resultOriginType", "canceledKey", "compose-destinations_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ResultCommonsKt {
    public static final <D extends TypedDestinationSpec<?>, R> String canceledKey(KClass<D> resultOriginType, DestinationsNavType<R> resultNavType) {
        Intrinsics.checkNotNullParameter(resultOriginType, "resultOriginType");
        Intrinsics.checkNotNullParameter(resultNavType, "resultNavType");
        return "compose-destinations@" + resultOriginType.getQualifiedName() + '@' + Reflection.getOrCreateKotlinClass(resultNavType.getClass()).getQualifiedName() + "@canceled";
    }

    public static final <R> ResultBackNavigator<R> resultBackNavigator(TypedDestinationSpec<?> destination, DestinationsNavType<? super R> resultNavType, NavController navController, NavBackStackEntry navBackStackEntry, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(resultNavType, "resultNavType");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        composer.startReplaceGroup(951055888);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(951055888, i5, -1, "com.ramcosta.composedestinations.result.resultBackNavigator (ResultCommons.kt:18)");
        }
        composer.startReplaceGroup(-1123455939);
        boolean z5 = true;
        boolean changed = composer.changed(navBackStackEntry) | composer.changed(navController) | ((((i5 & 14) ^ 6) > 4 && composer.changed(destination)) || (i5 & 6) == 4);
        if ((((i5 & 112) ^ 48) <= 32 || !composer.changed(resultNavType)) && (i5 & 48) != 32) {
            z5 = false;
        }
        boolean z6 = changed | z5;
        Object rememberedValue = composer.rememberedValue();
        if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new ResultBackNavigatorImpl(navController, Reflection.getOrCreateKotlinClass(destination.getClass()), resultNavType);
            composer.updateRememberedValue(rememberedValue);
        }
        ResultBackNavigatorImpl resultBackNavigatorImpl = (ResultBackNavigatorImpl) rememberedValue;
        composer.endReplaceGroup();
        resultBackNavigatorImpl.handleCanceled(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return resultBackNavigatorImpl;
    }

    public static final <D extends TypedDestinationSpec<?>, R> String resultKey(KClass<D> resultOriginType, DestinationsNavType<R> resultNavType) {
        Intrinsics.checkNotNullParameter(resultOriginType, "resultOriginType");
        Intrinsics.checkNotNullParameter(resultNavType, "resultNavType");
        return "compose-destinations@" + resultOriginType.getQualifiedName() + '@' + Reflection.getOrCreateKotlinClass(resultNavType.getClass()).getQualifiedName() + "@result";
    }

    public static final <D extends TypedDestinationSpec<?>, R> ResultRecipient<D, R> resultRecipient(NavBackStackEntry navBackStackEntry, KClass<D> originType, DestinationsNavType<? super R> resultNavType, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Intrinsics.checkNotNullParameter(originType, "originType");
        Intrinsics.checkNotNullParameter(resultNavType, "resultNavType");
        composer.startReplaceGroup(-393982725);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-393982725, i5, -1, "com.ramcosta.composedestinations.result.resultRecipient (ResultCommons.kt:43)");
        }
        composer.startReplaceGroup(-1796780189);
        boolean changed = ((((i5 & 896) ^ 384) > 256 && composer.changed(resultNavType)) || (i5 & 384) == 256) | composer.changed(navBackStackEntry) | composer.changed(originType);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new ResultRecipientImpl(navBackStackEntry, originType, resultNavType);
            composer.updateRememberedValue(rememberedValue);
        }
        ResultRecipientImpl resultRecipientImpl = (ResultRecipientImpl) rememberedValue;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return resultRecipientImpl;
    }
}
