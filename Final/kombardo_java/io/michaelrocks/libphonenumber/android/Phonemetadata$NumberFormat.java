package io.michaelrocks.libphonenumber.android;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class Phonemetadata$NumberFormat implements Externalizable {
    private static final long serialVersionUID = 1;
    private boolean hasDomesticCarrierCodeFormattingRule;
    private boolean hasFormat;
    private boolean hasNationalPrefixFormattingRule;
    private boolean hasNationalPrefixOptionalWhenFormatting;
    private boolean hasPattern;
    private String pattern_ = BuildConfig.FLAVOR;
    private String format_ = BuildConfig.FLAVOR;
    private List<String> leadingDigitsPattern_ = new ArrayList();
    private String nationalPrefixFormattingRule_ = BuildConfig.FLAVOR;
    private boolean nationalPrefixOptionalWhenFormatting_ = false;
    private String domesticCarrierCodeFormattingRule_ = BuildConfig.FLAVOR;

    public int getLeadingDigitsPatternCount() {
        return this.leadingDigitsPattern_.size();
    }

    @Deprecated
    public int leadingDigitsPatternSize() {
        return getLeadingDigitsPatternCount();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        setPattern(objectInput.readUTF());
        setFormat(objectInput.readUTF());
        int readInt = objectInput.readInt();
        for (int i5 = 0; i5 < readInt; i5++) {
            this.leadingDigitsPattern_.add(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            setNationalPrefixFormattingRule(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            setDomesticCarrierCodeFormattingRule(objectInput.readUTF());
        }
        setNationalPrefixOptionalWhenFormatting(objectInput.readBoolean());
    }

    public Phonemetadata$NumberFormat setDomesticCarrierCodeFormattingRule(String str) {
        this.hasDomesticCarrierCodeFormattingRule = true;
        this.domesticCarrierCodeFormattingRule_ = str;
        return this;
    }

    public Phonemetadata$NumberFormat setFormat(String str) {
        this.hasFormat = true;
        this.format_ = str;
        return this;
    }

    public Phonemetadata$NumberFormat setNationalPrefixFormattingRule(String str) {
        this.hasNationalPrefixFormattingRule = true;
        this.nationalPrefixFormattingRule_ = str;
        return this;
    }

    public Phonemetadata$NumberFormat setNationalPrefixOptionalWhenFormatting(boolean z5) {
        this.hasNationalPrefixOptionalWhenFormatting = true;
        this.nationalPrefixOptionalWhenFormatting_ = z5;
        return this;
    }

    public Phonemetadata$NumberFormat setPattern(String str) {
        this.hasPattern = true;
        this.pattern_ = str;
        return this;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeUTF(this.pattern_);
        objectOutput.writeUTF(this.format_);
        int leadingDigitsPatternSize = leadingDigitsPatternSize();
        objectOutput.writeInt(leadingDigitsPatternSize);
        for (int i5 = 0; i5 < leadingDigitsPatternSize; i5++) {
            objectOutput.writeUTF(this.leadingDigitsPattern_.get(i5));
        }
        objectOutput.writeBoolean(this.hasNationalPrefixFormattingRule);
        if (this.hasNationalPrefixFormattingRule) {
            objectOutput.writeUTF(this.nationalPrefixFormattingRule_);
        }
        objectOutput.writeBoolean(this.hasDomesticCarrierCodeFormattingRule);
        if (this.hasDomesticCarrierCodeFormattingRule) {
            objectOutput.writeUTF(this.domesticCarrierCodeFormattingRule_);
        }
        objectOutput.writeBoolean(this.nationalPrefixOptionalWhenFormatting_);
    }
}
