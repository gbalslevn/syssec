package dk.molslinjen.api.extensions;

import dk.molslinjen.api.services.config.response.SiteDTO;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toPaymentLine", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/config/response/SiteDTO;", "api_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SiteDTOExtensionsKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SiteDTO.values().length];
            try {
                iArr[SiteDTO.Mols.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SiteDTO.Bornholm.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SiteDTO.Als.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SiteDTO.Langeland.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SiteDTO.Samsoe.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SiteDTO.Fanoe.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SiteDTO.Kombardo.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SiteDTO.Oeresund.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int toPaymentLine(SiteDTO siteDTO) {
        Intrinsics.checkNotNullParameter(siteDTO, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[siteDTO.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 1;
            case 8:
                return 8;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
