package com.ramcosta.composedestinations.spec;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavDeepLink;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/ramcosta/composedestinations/spec/DirectionDestinationSpec;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/spec/Direction;", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface DirectionDestinationSpec extends TypedDestinationSpec<Unit>, Direction {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static void argsFrom(DirectionDestinationSpec directionDestinationSpec, Bundle bundle) {
        }

        public static List<NamedNavArgument> getArguments(DirectionDestinationSpec directionDestinationSpec) {
            return TypedDestinationSpec.DefaultImpls.getArguments(directionDestinationSpec);
        }

        public static List<NavDeepLink> getDeepLinks(DirectionDestinationSpec directionDestinationSpec) {
            return TypedDestinationSpec.DefaultImpls.getDeepLinks(directionDestinationSpec);
        }

        public static DestinationStyle getStyle(DirectionDestinationSpec directionDestinationSpec) {
            return TypedDestinationSpec.DefaultImpls.getStyle(directionDestinationSpec);
        }

        public static Direction invoke(DirectionDestinationSpec directionDestinationSpec, Unit navArgs) {
            Intrinsics.checkNotNullParameter(navArgs, "navArgs");
            return directionDestinationSpec;
        }

        public static void argsFrom(DirectionDestinationSpec directionDestinationSpec, SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        }
    }
}
