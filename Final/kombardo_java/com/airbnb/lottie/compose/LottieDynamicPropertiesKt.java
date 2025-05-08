package com.airbnb.lottie.compose;

import androidx.compose.runtime.Composer;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000)\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u000f\u001a+\u0010\u0004\u001a\u00020\u00032\u001a\u0010\u0002\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\u0000\"\u0006\u0012\u0002\b\u00030\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a?\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u00002\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0000\"\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a1\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0006*\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0004\u0012\u00028\u00000\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {BuildConfig.FLAVOR, "Lcom/airbnb/lottie/compose/LottieDynamicProperty;", "properties", "Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "rememberLottieDynamicProperties", "([Lcom/airbnb/lottie/compose/LottieDynamicProperty;Landroidx/compose/runtime/Composer;I)Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "T", "property", "value", BuildConfig.FLAVOR, "keyPath", "rememberLottieDynamicProperty", "(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Lcom/airbnb/lottie/compose/LottieDynamicProperty;", "Lkotlin/Function1;", "Lcom/airbnb/lottie/value/LottieFrameInfo;", "com/airbnb/lottie/compose/LottieDynamicPropertiesKt$toValueCallback$1", "toValueCallback", "(Lkotlin/jvm/functions/Function1;)Lcom/airbnb/lottie/compose/LottieDynamicPropertiesKt$toValueCallback$1;", "lottie-compose_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LottieDynamicPropertiesKt {
    public static final LottieDynamicProperties rememberLottieDynamicProperties(LottieDynamicProperty<?>[] properties, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(properties, "properties");
        composer.startReplaceableGroup(34467846);
        Integer valueOf = Integer.valueOf(Arrays.hashCode(properties));
        composer.startReplaceableGroup(-3686930);
        boolean changed = composer.changed(valueOf);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new LottieDynamicProperties(ArraysKt.toList(properties));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        LottieDynamicProperties lottieDynamicProperties = (LottieDynamicProperties) rememberedValue;
        composer.endReplaceableGroup();
        return lottieDynamicProperties;
    }

    public static final <T> LottieDynamicProperty<T> rememberLottieDynamicProperty(T t5, T t6, String[] keyPath, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(keyPath, "keyPath");
        composer.startReplaceableGroup(1613443783);
        composer.startReplaceableGroup(-3686930);
        boolean changed = composer.changed(keyPath);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new KeyPath((String[]) Arrays.copyOf(keyPath, keyPath.length));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        KeyPath keyPath2 = (KeyPath) rememberedValue;
        composer.startReplaceableGroup(-3686095);
        boolean changed2 = composer.changed(keyPath2) | composer.changed(t5) | composer.changed(t6);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new LottieDynamicProperty(t5, keyPath2, t6);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        LottieDynamicProperty<T> lottieDynamicProperty = (LottieDynamicProperty) rememberedValue2;
        composer.endReplaceableGroup();
        return lottieDynamicProperty;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> LottieDynamicPropertiesKt$toValueCallback$1 toValueCallback(final Function1<? super LottieFrameInfo<T>, ? extends T> function1) {
        return new LottieValueCallback<T>() { // from class: com.airbnb.lottie.compose.LottieDynamicPropertiesKt$toValueCallback$1
            @Override // com.airbnb.lottie.value.LottieValueCallback
            public T getValue(LottieFrameInfo<T> frameInfo) {
                Intrinsics.checkNotNullParameter(frameInfo, "frameInfo");
                return function1.invoke(frameInfo);
            }
        };
    }
}
