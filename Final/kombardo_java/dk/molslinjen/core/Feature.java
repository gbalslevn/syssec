package dk.molslinjen.core;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000f\u001a\u00020\u0010j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/core/Feature;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "SaleOnboard", "Account", "MultiRideTickets", "OnlyWalkingPassengers", "MultipleRouteTypes", "MultipleTicketTypes", "RoutesFromMultipleSites", "BikeOrStroller", "AddonsNoneRefundable", "MultipleCurrencies", "HardcodedSekCurrency", "isEnabled", BuildConfig.FLAVOR, "core_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Feature {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Feature[] $VALUES;
    public static final Feature SaleOnboard = new Feature("SaleOnboard", 0);
    public static final Feature Account = new Feature("Account", 1);
    public static final Feature MultiRideTickets = new Feature("MultiRideTickets", 2);
    public static final Feature OnlyWalkingPassengers = new Feature("OnlyWalkingPassengers", 3);
    public static final Feature MultipleRouteTypes = new Feature("MultipleRouteTypes", 4);
    public static final Feature MultipleTicketTypes = new Feature("MultipleTicketTypes", 5);
    public static final Feature RoutesFromMultipleSites = new Feature("RoutesFromMultipleSites", 6);
    public static final Feature BikeOrStroller = new Feature("BikeOrStroller", 7);
    public static final Feature AddonsNoneRefundable = new Feature("AddonsNoneRefundable", 8);
    public static final Feature MultipleCurrencies = new Feature("MultipleCurrencies", 9);
    public static final Feature HardcodedSekCurrency = new Feature("HardcodedSekCurrency", 10);

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Feature.values().length];
            try {
                iArr[Feature.SaleOnboard.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Feature.Account.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Feature.MultiRideTickets.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Feature.OnlyWalkingPassengers.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Feature.MultipleRouteTypes.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Feature.MultipleTicketTypes.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Feature.RoutesFromMultipleSites.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Feature.BikeOrStroller.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[Feature.AddonsNoneRefundable.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[Feature.MultipleCurrencies.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[Feature.HardcodedSekCurrency.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ Feature[] $values() {
        return new Feature[]{SaleOnboard, Account, MultiRideTickets, OnlyWalkingPassengers, MultipleRouteTypes, MultipleTicketTypes, RoutesFromMultipleSites, BikeOrStroller, AddonsNoneRefundable, MultipleCurrencies, HardcodedSekCurrency};
    }

    static {
        Feature[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private Feature(String str, int i5) {
    }

    public static Feature valueOf(String str) {
        return (Feature) Enum.valueOf(Feature.class, str);
    }

    public static Feature[] values() {
        return (Feature[]) $VALUES.clone();
    }

    public final boolean isEnabled() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return Environment.INSTANCE.isMolslinjen();
            case 2:
                return true;
            case 3:
                return Environment.INSTANCE.isMolslinjen();
            case 4:
                return Environment.INSTANCE.isKombardo();
            case 5:
                return Environment.INSTANCE.isKombardo();
            case 6:
                return Environment.INSTANCE.isMolslinjen();
            case 7:
                return Environment.INSTANCE.isMolslinjen();
            case 8:
                return Environment.INSTANCE.isKombardo();
            case 9:
                return Environment.INSTANCE.isKombardo();
            case 10:
                return Environment.INSTANCE.isMolslinjen();
            case 11:
                return Environment.INSTANCE.isKombardo() && Intrinsics.areEqual(Locale.getDefault().getLanguage(), "sv");
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
