package com.facebook.appevents.iap;

import java.util.Currency;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchase;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "eventName", BuildConfig.FLAVOR, "amount", "Ljava/util/Currency;", "currency", "<init>", "(Ljava/lang/String;DLjava/util/Currency;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getEventName", "D", "getAmount", "()D", "Ljava/util/Currency;", "getCurrency", "()Ljava/util/Currency;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class InAppPurchase {
    private final double amount;
    private final Currency currency;
    private final String eventName;

    public InAppPurchase(String eventName, double d5, Currency currency) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(currency, "currency");
        this.eventName = eventName;
        this.amount = d5;
        this.currency = currency;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InAppPurchase)) {
            return false;
        }
        InAppPurchase inAppPurchase = (InAppPurchase) other;
        return Intrinsics.areEqual(this.eventName, inAppPurchase.eventName) && Intrinsics.areEqual(Double.valueOf(this.amount), Double.valueOf(inAppPurchase.amount)) && Intrinsics.areEqual(this.currency, inAppPurchase.currency);
    }

    public final double getAmount() {
        return this.amount;
    }

    public final Currency getCurrency() {
        return this.currency;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public int hashCode() {
        return (((this.eventName.hashCode() * 31) + Double.hashCode(this.amount)) * 31) + this.currency.hashCode();
    }

    public String toString() {
        return "InAppPurchase(eventName=" + this.eventName + ", amount=" + this.amount + ", currency=" + this.currency + ')';
    }
}
