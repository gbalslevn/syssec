package dk.molslinjen.api;

import dk.molslinjen.core.ApiEnvironment;
import dk.molslinjen.core.Environment;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004\"\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004\"\u0015\u0010\r\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004\"\u0018\u0010\u000f\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004¨\u0006\u0011"}, d2 = {"verticaApiUrl", BuildConfig.FLAVOR, "Ldk/molslinjen/core/ApiEnvironment;", "getVerticaApiUrl", "(Ldk/molslinjen/core/ApiEnvironment;)Ljava/lang/String;", "baseNotificationServiceApiUrl", "getBaseNotificationServiceApiUrl", "notificationServiceApiKey", "getNotificationServiceApiKey", "baseRetailItsUrl", "getBaseRetailItsUrl", "retailItsApiUser", "getRetailItsApiUser", "retailItsApiKey", "getRetailItsApiKey", "retailITSCompanyId", "getRetailITSCompanyId", "api_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ApiEnvironmentExtensionsKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ApiEnvironment.values().length];
            try {
                iArr[ApiEnvironment.QA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ApiEnvironment.Stage.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ApiEnvironment.Prod.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String getBaseNotificationServiceApiUrl(ApiEnvironment apiEnvironment) {
        Intrinsics.checkNotNullParameter(apiEnvironment, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[apiEnvironment.ordinal()];
        if (i5 == 1 || i5 == 2) {
            return "https://notification.stage.molslinjen.dk/api";
        }
        if (i5 == 3) {
            return "https://notification.molslinjen.dk/api";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String getBaseRetailItsUrl(ApiEnvironment apiEnvironment) {
        Intrinsics.checkNotNullParameter(apiEnvironment, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[apiEnvironment.ordinal()];
        if (i5 == 1 || i5 == 2) {
            return "https://kaffeapp.mols-linien.dk:17068/mol_test_cateringWS/api/catering/dvm/v2.0/companies(" + getRetailITSCompanyId(apiEnvironment) + ")";
        }
        if (i5 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "https://kaffeapp.mols-linien.dk:19068/mol_api_lsc/api/catering/dvm/v2.0/companies(" + getRetailITSCompanyId(apiEnvironment) + ")";
    }

    public static final String getNotificationServiceApiKey(ApiEnvironment apiEnvironment) {
        Intrinsics.checkNotNullParameter(apiEnvironment, "<this>");
        Environment.Companion companion = Environment.INSTANCE;
        return companion.isKombardo() ? "b7nx8dnV94yDinNAQgiu4nmPLCuLuiykZLWmaeyBN3v" : companion.isMolslinjen() ? "4v0ScSI2AYveXUJ7w94GaHgB5dHpLjfnxBxdy1B2yBO" : BuildConfig.FLAVOR;
    }

    private static final String getRetailITSCompanyId(ApiEnvironment apiEnvironment) {
        int i5 = WhenMappings.$EnumSwitchMapping$0[apiEnvironment.ordinal()];
        if (i5 == 1 || i5 == 2) {
            return "803ebfa2-cfa2-eb11-b839-005056873a34";
        }
        if (i5 == 3) {
            return "c0bcee07-0fa2-eb11-b839-005056873a34";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String getRetailItsApiKey(ApiEnvironment apiEnvironment) {
        Intrinsics.checkNotNullParameter(apiEnvironment, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[apiEnvironment.ordinal()];
        if (i5 == 1 || i5 == 2) {
            return "yC1B5tWj/TfLfUw6JaWrkEnozzsKu5EiSuibT/lkojw=";
        }
        if (i5 == 3) {
            return "GvMXicXNbpG/ETRMBgSx0SRy6bFrig36Bli2CN0dFuI=";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String getRetailItsApiUser(ApiEnvironment apiEnvironment) {
        Intrinsics.checkNotNullParameter(apiEnvironment, "<this>");
        return "APIUser";
    }

    public static final String getVerticaApiUrl(ApiEnvironment apiEnvironment) {
        Intrinsics.checkNotNullParameter(apiEnvironment, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[apiEnvironment.ordinal()];
        if (i5 == 1) {
            return "https://api.qa.molslinjen.dk/api";
        }
        if (i5 == 2) {
            return "https://api.stage.molslinjen.dk/api";
        }
        if (i5 == 3) {
            return "https://api.molslinjen.dk/api";
        }
        throw new NoWhenBranchMatchedException();
    }
}
