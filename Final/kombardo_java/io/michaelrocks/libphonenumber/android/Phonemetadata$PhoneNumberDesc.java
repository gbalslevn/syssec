package io.michaelrocks.libphonenumber.android;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class Phonemetadata$PhoneNumberDesc implements Externalizable {
    private static final long serialVersionUID = 1;
    private boolean hasExampleNumber;
    private boolean hasNationalNumberPattern;
    private String nationalNumberPattern_ = BuildConfig.FLAVOR;
    private List<Integer> possibleLength_ = new ArrayList();
    private List<Integer> possibleLengthLocalOnly_ = new ArrayList();
    private String exampleNumber_ = BuildConfig.FLAVOR;

    public int getPossibleLengthCount() {
        return this.possibleLength_.size();
    }

    public int getPossibleLengthLocalOnlyCount() {
        return this.possibleLengthLocalOnly_.size();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        if (objectInput.readBoolean()) {
            setNationalNumberPattern(objectInput.readUTF());
        }
        int readInt = objectInput.readInt();
        for (int i5 = 0; i5 < readInt; i5++) {
            this.possibleLength_.add(Integer.valueOf(objectInput.readInt()));
        }
        int readInt2 = objectInput.readInt();
        for (int i6 = 0; i6 < readInt2; i6++) {
            this.possibleLengthLocalOnly_.add(Integer.valueOf(objectInput.readInt()));
        }
        if (objectInput.readBoolean()) {
            setExampleNumber(objectInput.readUTF());
        }
    }

    public Phonemetadata$PhoneNumberDesc setExampleNumber(String str) {
        this.hasExampleNumber = true;
        this.exampleNumber_ = str;
        return this;
    }

    public Phonemetadata$PhoneNumberDesc setNationalNumberPattern(String str) {
        this.hasNationalNumberPattern = true;
        this.nationalNumberPattern_ = str;
        return this;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeBoolean(this.hasNationalNumberPattern);
        if (this.hasNationalNumberPattern) {
            objectOutput.writeUTF(this.nationalNumberPattern_);
        }
        int possibleLengthCount = getPossibleLengthCount();
        objectOutput.writeInt(possibleLengthCount);
        for (int i5 = 0; i5 < possibleLengthCount; i5++) {
            objectOutput.writeInt(this.possibleLength_.get(i5).intValue());
        }
        int possibleLengthLocalOnlyCount = getPossibleLengthLocalOnlyCount();
        objectOutput.writeInt(possibleLengthLocalOnlyCount);
        for (int i6 = 0; i6 < possibleLengthLocalOnlyCount; i6++) {
            objectOutput.writeInt(this.possibleLengthLocalOnly_.get(i6).intValue());
        }
        objectOutput.writeBoolean(this.hasExampleNumber);
        if (this.hasExampleNumber) {
            objectOutput.writeUTF(this.exampleNumber_);
        }
    }
}
