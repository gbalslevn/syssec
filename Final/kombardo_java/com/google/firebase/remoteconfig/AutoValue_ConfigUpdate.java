package com.google.firebase.remoteconfig;

import java.util.Set;

/* loaded from: classes2.dex */
final class AutoValue_ConfigUpdate extends ConfigUpdate {
    private final Set<String> updatedKeys;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ConfigUpdate(Set<String> set) {
        if (set == null) {
            throw new NullPointerException("Null updatedKeys");
        }
        this.updatedKeys = set;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ConfigUpdate) {
            return this.updatedKeys.equals(((ConfigUpdate) obj).getUpdatedKeys());
        }
        return false;
    }

    @Override // com.google.firebase.remoteconfig.ConfigUpdate
    public Set<String> getUpdatedKeys() {
        return this.updatedKeys;
    }

    public int hashCode() {
        return this.updatedKeys.hashCode() ^ 1000003;
    }

    public String toString() {
        return "ConfigUpdate{updatedKeys=" + this.updatedKeys + "}";
    }
}
