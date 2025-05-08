package com.ramcosta.composedestinations.result;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J)\u0010\u0007\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00020\u00050\u0003H'¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/ramcosta/composedestinations/result/OpenResultRecipient;", "R", BuildConfig.FLAVOR, "Lkotlin/Function1;", "Lcom/ramcosta/composedestinations/result/NavResult;", BuildConfig.FLAVOR, "listener", "onNavResult", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface OpenResultRecipient<R> {
    void onNavResult(Function1<? super NavResult<? extends R>, Unit> function1, Composer composer, int i5);
}
