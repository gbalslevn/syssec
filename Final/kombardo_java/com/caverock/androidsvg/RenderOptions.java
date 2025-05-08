package com.caverock.androidsvg;

import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.SVG;

/* loaded from: classes.dex */
public class RenderOptions {
    CSSParser.Ruleset css = null;
    PreserveAspectRatio preserveAspectRatio = null;
    String targetId = null;
    SVG.Box viewBox = null;
    String viewId = null;
    SVG.Box viewPort = null;

    public RenderOptions css(String str) {
        this.css = new CSSParser(CSSParser.Source.RenderOptions).parse(str);
        return this;
    }

    public boolean hasCss() {
        CSSParser.Ruleset ruleset = this.css;
        return ruleset != null && ruleset.ruleCount() > 0;
    }

    public boolean hasPreserveAspectRatio() {
        return this.preserveAspectRatio != null;
    }

    public boolean hasTarget() {
        return this.targetId != null;
    }

    public boolean hasView() {
        return this.viewId != null;
    }

    public boolean hasViewBox() {
        return this.viewBox != null;
    }

    public boolean hasViewPort() {
        return this.viewPort != null;
    }

    public RenderOptions viewPort(float f5, float f6, float f7, float f8) {
        this.viewPort = new SVG.Box(f5, f6, f7, f8);
        return this;
    }
}
