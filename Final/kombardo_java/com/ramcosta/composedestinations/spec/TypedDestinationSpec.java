package com.ramcosta.composedestinations.spec;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavDeepLink;
import com.ramcosta.composedestinations.scope.DestinationScope;
import com.ramcosta.composedestinations.spec.DestinationStyle;
import com.ramcosta.composedestinations.spec.TypedRoute;
import java.util.List;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0019\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00028\u00000\u0003H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00028\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\t\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "T", "Lcom/ramcosta/composedestinations/spec/TypedRoute;", "Lcom/ramcosta/composedestinations/scope/DestinationScope;", BuildConfig.FLAVOR, "Content", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Landroidx/compose/runtime/Composer;I)V", "Landroid/os/Bundle;", "bundle", "argsFrom", "(Landroid/os/Bundle;)Ljava/lang/Object;", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "(Landroidx/lifecycle/SavedStateHandle;)Ljava/lang/Object;", "Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "getStyle", "()Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "style", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface TypedDestinationSpec<T> extends TypedRoute<T> {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static <T> List<NamedNavArgument> getArguments(TypedDestinationSpec<T> typedDestinationSpec) {
            return TypedRoute.DefaultImpls.getArguments(typedDestinationSpec);
        }

        public static <T> List<NavDeepLink> getDeepLinks(TypedDestinationSpec<T> typedDestinationSpec) {
            return TypedRoute.DefaultImpls.getDeepLinks(typedDestinationSpec);
        }

        public static <T> DestinationStyle getStyle(TypedDestinationSpec<T> typedDestinationSpec) {
            return DestinationStyle.Default.INSTANCE;
        }
    }

    void Content(DestinationScope<T> destinationScope, Composer composer, int i5);

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    T argsFrom(Bundle bundle);

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    T argsFrom(SavedStateHandle savedStateHandle);

    DestinationStyle getStyle();
}
