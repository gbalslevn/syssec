package com.ionspin.kotlin.bignum.integer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u0004*\u0004\b\u0004\u0010\u0005*\u0004\b\u0005\u0010\u00062\u00020\u0007B7\u0012\u0006\u0010\b\u001a\u00028\u0000\u0012\u0006\u0010\t\u001a\u00028\u0001\u0012\u0006\u0010\n\u001a\u00028\u0002\u0012\u0006\u0010\u000b\u001a\u00028\u0003\u0012\u0006\u0010\f\u001a\u00028\u0004\u0012\u0006\u0010\r\u001a\u00028\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0013\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0011J\u0010\u0010\u0014\u001a\u00028\u0003HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0011J\u0010\u0010\u0015\u001a\u00028\u0004HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0011J\u0010\u0010\u0016\u001a\u00028\u0005HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0011J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\b\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010\u0011R\u0017\u0010\t\u001a\u00028\u00018\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b#\u0010\u0011R\u0017\u0010\n\u001a\u00028\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b$\u0010\u0011R\u0017\u0010\u000b\u001a\u00028\u00038\u0006¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b%\u0010\u0011R\u0017\u0010\f\u001a\u00028\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b&\u0010\u0011R\u0017\u0010\r\u001a\u00028\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b'\u0010\u0011¨\u0006("}, d2 = {"Lcom/ionspin/kotlin/bignum/integer/Sextuple;", "A", "B", "C", "D", "E", "F", BuildConfig.FLAVOR, "a", "b", "c", "d", "e", "f", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "component1", "()Ljava/lang/Object;", "component2", "component3", "component4", "component5", "component6", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getA", "getB", "getC", "getD", "getE", "getF", "bignum"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Sextuple<A, B, C, D, E, F> {
    private final A a;
    private final B b;
    private final C c;
    private final D d;
    private final E e;
    private final F f;

    public Sextuple(A a5, B b5, C c5, D d5, E e5, F f5) {
        this.a = a5;
        this.b = b5;
        this.c = c5;
        this.d = d5;
        this.e = e5;
        this.f = f5;
    }

    public final A component1() {
        return this.a;
    }

    public final B component2() {
        return this.b;
    }

    public final C component3() {
        return this.c;
    }

    public final D component4() {
        return this.d;
    }

    public final E component5() {
        return this.e;
    }

    public final F component6() {
        return this.f;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Sextuple)) {
            return false;
        }
        Sextuple sextuple = (Sextuple) other;
        return Intrinsics.areEqual(this.a, sextuple.a) && Intrinsics.areEqual(this.b, sextuple.b) && Intrinsics.areEqual(this.c, sextuple.c) && Intrinsics.areEqual(this.d, sextuple.d) && Intrinsics.areEqual(this.e, sextuple.e) && Intrinsics.areEqual(this.f, sextuple.f);
    }

    public int hashCode() {
        A a5 = this.a;
        int hashCode = (a5 == null ? 0 : a5.hashCode()) * 31;
        B b5 = this.b;
        int hashCode2 = (hashCode + (b5 == null ? 0 : b5.hashCode())) * 31;
        C c5 = this.c;
        int hashCode3 = (hashCode2 + (c5 == null ? 0 : c5.hashCode())) * 31;
        D d5 = this.d;
        int hashCode4 = (hashCode3 + (d5 == null ? 0 : d5.hashCode())) * 31;
        E e5 = this.e;
        int hashCode5 = (hashCode4 + (e5 == null ? 0 : e5.hashCode())) * 31;
        F f5 = this.f;
        return hashCode5 + (f5 != null ? f5.hashCode() : 0);
    }

    public String toString() {
        return "Sextuple(a=" + this.a + ", b=" + this.b + ", c=" + this.c + ", d=" + this.d + ", e=" + this.e + ", f=" + this.f + ')';
    }
}
