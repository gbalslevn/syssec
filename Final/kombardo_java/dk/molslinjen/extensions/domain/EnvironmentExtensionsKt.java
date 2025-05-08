package dk.molslinjen.extensions.domain;

import dk.molslinjen.core.Environment;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import uniffi.molslinjen_shared.BuildConfiguration;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toBuildConfiguration", "Luniffi/molslinjen_shared/BuildConfiguration;", "Ldk/molslinjen/core/Environment;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class EnvironmentExtensionsKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Environment.values().length];
            try {
                iArr[Environment.Dev.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Environment.Test.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Environment.ProdTest.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Environment.Prod.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final BuildConfiguration toBuildConfiguration(Environment environment) {
        Intrinsics.checkNotNullParameter(environment, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[environment.ordinal()];
        if (i5 == 1) {
            return BuildConfiguration.DEVELOPMENT;
        }
        if (i5 == 2) {
            return BuildConfiguration.TEST;
        }
        if (i5 == 3) {
            return BuildConfiguration.PROD_TEST;
        }
        if (i5 == 4) {
            return BuildConfiguration.PRODUCTION;
        }
        throw new NoWhenBranchMatchedException();
    }
}
