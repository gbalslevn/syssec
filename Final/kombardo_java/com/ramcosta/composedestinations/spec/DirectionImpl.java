package com.ramcosta.composedestinations.spec;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ramcosta/composedestinations/spec/DirectionImpl;", "Lcom/ramcosta/composedestinations/spec/Direction;", BuildConfig.FLAVOR, "route", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getRoute", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final /* data */ class DirectionImpl implements Direction {
    private final String route;

    public DirectionImpl(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        this.route = route;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DirectionImpl) && Intrinsics.areEqual(this.route, ((DirectionImpl) other).route);
    }

    @Override // com.ramcosta.composedestinations.spec.Direction, com.ramcosta.composedestinations.spec.RouteOrDirection
    public String getRoute() {
        return this.route;
    }

    public int hashCode() {
        return this.route.hashCode();
    }

    public String toString() {
        return "DirectionImpl(route=" + this.route + ')';
    }
}
