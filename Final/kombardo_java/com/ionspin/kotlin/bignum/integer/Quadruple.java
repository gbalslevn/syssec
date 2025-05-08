package com.ionspin.kotlin.bignum.integer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u00042\u00020\u0005B'\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u0012\u0006\u0010\b\u001a\u00028\u0002\u0012\u0006\u0010\t\u001a\u00028\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0010\u001a\u00028\u0003HÆ\u0003¢\u0006\u0004\b\u0010\u0010\rJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0006\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\rR\u0017\u0010\u0007\u001a\u00028\u00018\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001d\u0010\rR\u0017\u0010\b\u001a\u00028\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001e\u0010\rR\u0017\u0010\t\u001a\u00028\u00038\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001f\u0010\r¨\u0006 "}, d2 = {"Lcom/ionspin/kotlin/bignum/integer/Quadruple;", "A", "B", "C", "D", BuildConfig.FLAVOR, "a", "b", "c", "d", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "component1", "()Ljava/lang/Object;", "component2", "component3", "component4", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getA", "getB", "getC", "getD", "bignum"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Quadruple<A, B, C, D> {
    private final A a;
    private final B b;
    private final C c;
    private final D d;

    public Quadruple(A a5, B b5, C c5, D d5) {
        this.a = a5;
        this.b = b5;
        this.c = c5;
        this.d = d5;
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

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Quadruple)) {
            return false;
        }
        Quadruple quadruple = (Quadruple) other;
        return Intrinsics.areEqual(this.a, quadruple.a) && Intrinsics.areEqual(this.b, quadruple.b) && Intrinsics.areEqual(this.c, quadruple.c) && Intrinsics.areEqual(this.d, quadruple.d);
    }

    public int hashCode() {
        A a5 = this.a;
        int hashCode = (a5 == null ? 0 : a5.hashCode()) * 31;
        B b5 = this.b;
        int hashCode2 = (hashCode + (b5 == null ? 0 : b5.hashCode())) * 31;
        C c5 = this.c;
        int hashCode3 = (hashCode2 + (c5 == null ? 0 : c5.hashCode())) * 31;
        D d5 = this.d;
        return hashCode3 + (d5 != null ? d5.hashCode() : 0);
    }

    public String toString() {
        return "Quadruple(a=" + this.a + ", b=" + this.b + ", c=" + this.c + ", d=" + this.d + ')';
    }
}
