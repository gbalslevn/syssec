package com.caverock.androidsvg;

import android.graphics.Matrix;
import android.util.Log;
import android.util.Xml;
import androidx.appcompat.R$styleable;
import com.adjust.sdk.Constants;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.sun.jna.Function;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.conscrypt.BuildConfig;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SVGParser {
    private static final String CURRENTCOLOR = "currentColor";
    private static final String FEATURE_STRING_PREFIX = "http://www.w3.org/TR/SVG11/feature#";
    private static final String NONE = "none";
    private static final String SVG_NAMESPACE = "http://www.w3.org/2000/svg";
    private static final String TAG = "SVGParser";
    private static final String VALID_DISPLAY_VALUES = "|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|";
    private static final String VALID_VISIBILITY_VALUES = "|visible|hidden|collapse|";
    private static final String XLINK_NAMESPACE = "http://www.w3.org/1999/xlink";
    private static final String XML_STYLESHEET_PROCESSING_INSTRUCTION = "xml-stylesheet";
    private int ignoreDepth;
    private SVG svgDocument = null;
    private SVG.SvgContainer currentElement = null;
    private boolean ignoring = false;
    private boolean inMetadataElement = false;
    private SVGElem metadataTag = null;
    private StringBuilder metadataElementContents = null;
    private boolean inStyleElement = false;
    private StringBuilder styleElementContents = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.caverock.androidsvg.SVGParser$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr;
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem;

        static {
            int[] iArr = new int[SVGAttr.values().length];
            $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr = iArr;
            try {
                iArr[SVGAttr.x.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.width.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.height.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.version.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.href.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.preserveAspectRatio.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.d.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.pathLength.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.rx.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.ry.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.cx.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.cy.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.r.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.x1.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.y1.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.x2.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.y2.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.dx.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.dy.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.requiredFeatures.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.requiredExtensions.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.systemLanguage.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.requiredFormats.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.requiredFonts.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.refX.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.refY.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.markerWidth.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.markerHeight.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.markerUnits.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.orient.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.gradientUnits.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.gradientTransform.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.spreadMethod.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fx.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fy.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.offset.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.clipPathUnits.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.startOffset.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.patternUnits.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.patternContentUnits.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.patternTransform.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.maskUnits.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.maskContentUnits.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.style.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.CLASS.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fill.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fill_rule.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fill_opacity.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_opacity.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_width.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_linecap.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_linejoin.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_miterlimit.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_dasharray.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_dashoffset.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.opacity.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.color.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.font.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.font_family.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.font_size.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.font_weight.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.font_style.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.text_decoration.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.direction.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.text_anchor.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.overflow.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.marker.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.marker_start.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.marker_mid.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.marker_end.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.display.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.visibility.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stop_color.ordinal()] = 75;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stop_opacity.ordinal()] = 76;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.clip.ordinal()] = 77;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.clip_path.ordinal()] = 78;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.clip_rule.ordinal()] = 79;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.mask.ordinal()] = 80;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.solid_color.ordinal()] = 81;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.solid_opacity.ordinal()] = 82;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.viewport_fill.ordinal()] = 83;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.viewport_fill_opacity.ordinal()] = 84;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.vector_effect.ordinal()] = 85;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.image_rendering.ordinal()] = 86;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.viewBox.ordinal()] = 87;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.type.ordinal()] = 88;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.media.ordinal()] = 89;
            } catch (NoSuchFieldError unused89) {
            }
            int[] iArr2 = new int[SVGElem.values().length];
            $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem = iArr2;
            try {
                iArr2[SVGElem.svg.ordinal()] = 1;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.g.ordinal()] = 2;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.a.ordinal()] = 3;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.defs.ordinal()] = 4;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.use.ordinal()] = 5;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.path.ordinal()] = 6;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.rect.ordinal()] = 7;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.circle.ordinal()] = 8;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.ellipse.ordinal()] = 9;
            } catch (NoSuchFieldError unused98) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.line.ordinal()] = 10;
            } catch (NoSuchFieldError unused99) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.polyline.ordinal()] = 11;
            } catch (NoSuchFieldError unused100) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.polygon.ordinal()] = 12;
            } catch (NoSuchFieldError unused101) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.text.ordinal()] = 13;
            } catch (NoSuchFieldError unused102) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.tspan.ordinal()] = 14;
            } catch (NoSuchFieldError unused103) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.tref.ordinal()] = 15;
            } catch (NoSuchFieldError unused104) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.SWITCH.ordinal()] = 16;
            } catch (NoSuchFieldError unused105) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.symbol.ordinal()] = 17;
            } catch (NoSuchFieldError unused106) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.marker.ordinal()] = 18;
            } catch (NoSuchFieldError unused107) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.linearGradient.ordinal()] = 19;
            } catch (NoSuchFieldError unused108) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.radialGradient.ordinal()] = 20;
            } catch (NoSuchFieldError unused109) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.stop.ordinal()] = 21;
            } catch (NoSuchFieldError unused110) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.title.ordinal()] = 22;
            } catch (NoSuchFieldError unused111) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.desc.ordinal()] = 23;
            } catch (NoSuchFieldError unused112) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.clipPath.ordinal()] = 24;
            } catch (NoSuchFieldError unused113) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.textPath.ordinal()] = 25;
            } catch (NoSuchFieldError unused114) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.pattern.ordinal()] = 26;
            } catch (NoSuchFieldError unused115) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.image.ordinal()] = 27;
            } catch (NoSuchFieldError unused116) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.view.ordinal()] = 28;
            } catch (NoSuchFieldError unused117) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.mask.ordinal()] = 29;
            } catch (NoSuchFieldError unused118) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.style.ordinal()] = 30;
            } catch (NoSuchFieldError unused119) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.solidColor.ordinal()] = 31;
            } catch (NoSuchFieldError unused120) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AspectRatioKeywords {
        private static final Map<String, PreserveAspectRatio.Alignment> aspectRatioKeywords;

        static {
            HashMap hashMap = new HashMap(10);
            aspectRatioKeywords = hashMap;
            hashMap.put(SVGParser.NONE, PreserveAspectRatio.Alignment.none);
            hashMap.put("xMinYMin", PreserveAspectRatio.Alignment.xMinYMin);
            hashMap.put("xMidYMin", PreserveAspectRatio.Alignment.xMidYMin);
            hashMap.put("xMaxYMin", PreserveAspectRatio.Alignment.xMaxYMin);
            hashMap.put("xMinYMid", PreserveAspectRatio.Alignment.xMinYMid);
            hashMap.put("xMidYMid", PreserveAspectRatio.Alignment.xMidYMid);
            hashMap.put("xMaxYMid", PreserveAspectRatio.Alignment.xMaxYMid);
            hashMap.put("xMinYMax", PreserveAspectRatio.Alignment.xMinYMax);
            hashMap.put("xMidYMax", PreserveAspectRatio.Alignment.xMidYMax);
            hashMap.put("xMaxYMax", PreserveAspectRatio.Alignment.xMaxYMax);
        }

        static PreserveAspectRatio.Alignment get(String str) {
            return aspectRatioKeywords.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ColourKeywords {
        private static final Map<String, Integer> colourKeywords;

        static {
            HashMap hashMap = new HashMap(47);
            colourKeywords = hashMap;
            hashMap.put("aliceblue", -984833);
            hashMap.put("antiquewhite", -332841);
            hashMap.put("aqua", -16711681);
            hashMap.put("aquamarine", -8388652);
            hashMap.put("azure", -983041);
            hashMap.put("beige", -657956);
            hashMap.put("bisque", -6972);
            hashMap.put("black", -16777216);
            hashMap.put("blanchedalmond", -5171);
            hashMap.put("blue", -16776961);
            hashMap.put("blueviolet", -7722014);
            hashMap.put("brown", -5952982);
            hashMap.put("burlywood", -2180985);
            hashMap.put("cadetblue", -10510688);
            hashMap.put("chartreuse", -8388864);
            hashMap.put("chocolate", -2987746);
            hashMap.put("coral", -32944);
            hashMap.put("cornflowerblue", -10185235);
            hashMap.put("cornsilk", -1828);
            hashMap.put("crimson", -2354116);
            hashMap.put("cyan", -16711681);
            hashMap.put("darkblue", -16777077);
            hashMap.put("darkcyan", -16741493);
            hashMap.put("darkgoldenrod", -4684277);
            hashMap.put("darkgray", -5658199);
            hashMap.put("darkgreen", -16751616);
            hashMap.put("darkgrey", -5658199);
            hashMap.put("darkkhaki", -4343957);
            hashMap.put("darkmagenta", -7667573);
            hashMap.put("darkolivegreen", -11179217);
            hashMap.put("darkorange", -29696);
            hashMap.put("darkorchid", -6737204);
            hashMap.put("darkred", -7667712);
            hashMap.put("darksalmon", -1468806);
            hashMap.put("darkseagreen", -7357297);
            hashMap.put("darkslateblue", -12042869);
            hashMap.put("darkslategray", -13676721);
            hashMap.put("darkslategrey", -13676721);
            hashMap.put("darkturquoise", -16724271);
            hashMap.put("darkviolet", -7077677);
            hashMap.put("deeppink", -60269);
            hashMap.put("deepskyblue", -16728065);
            hashMap.put("dimgray", -9868951);
            hashMap.put("dimgrey", -9868951);
            hashMap.put("dodgerblue", -14774017);
            hashMap.put("firebrick", -5103070);
            hashMap.put("floralwhite", -1296);
            hashMap.put("forestgreen", -14513374);
            hashMap.put("fuchsia", -65281);
            hashMap.put("gainsboro", -2302756);
            hashMap.put("ghostwhite", -460545);
            hashMap.put("gold", -10496);
            hashMap.put("goldenrod", -2448096);
            hashMap.put("gray", -8355712);
            hashMap.put("green", -16744448);
            hashMap.put("greenyellow", -5374161);
            hashMap.put("grey", -8355712);
            hashMap.put("honeydew", -983056);
            hashMap.put("hotpink", -38476);
            hashMap.put("indianred", -3318692);
            hashMap.put("indigo", -11861886);
            hashMap.put("ivory", -16);
            hashMap.put("khaki", -989556);
            hashMap.put("lavender", -1644806);
            hashMap.put("lavenderblush", -3851);
            hashMap.put("lawngreen", -8586240);
            hashMap.put("lemonchiffon", -1331);
            hashMap.put("lightblue", -5383962);
            hashMap.put("lightcoral", -1015680);
            hashMap.put("lightcyan", -2031617);
            hashMap.put("lightgoldenrodyellow", -329006);
            hashMap.put("lightgray", -2894893);
            hashMap.put("lightgreen", -7278960);
            hashMap.put("lightgrey", -2894893);
            hashMap.put("lightpink", -18751);
            hashMap.put("lightsalmon", -24454);
            hashMap.put("lightseagreen", -14634326);
            hashMap.put("lightskyblue", -7876870);
            hashMap.put("lightslategray", -8943463);
            hashMap.put("lightslategrey", -8943463);
            hashMap.put("lightsteelblue", -5192482);
            hashMap.put("lightyellow", -32);
            hashMap.put("lime", -16711936);
            hashMap.put("limegreen", -13447886);
            hashMap.put("linen", -331546);
            hashMap.put("magenta", -65281);
            hashMap.put("maroon", -8388608);
            hashMap.put("mediumaquamarine", -10039894);
            hashMap.put("mediumblue", -16777011);
            hashMap.put("mediumorchid", -4565549);
            hashMap.put("mediumpurple", -7114533);
            hashMap.put("mediumseagreen", -12799119);
            hashMap.put("mediumslateblue", -8689426);
            hashMap.put("mediumspringgreen", -16713062);
            hashMap.put("mediumturquoise", -12004916);
            hashMap.put("mediumvioletred", -3730043);
            hashMap.put("midnightblue", -15132304);
            hashMap.put("mintcream", -655366);
            hashMap.put("mistyrose", -6943);
            hashMap.put("moccasin", -6987);
            hashMap.put("navajowhite", -8531);
            hashMap.put("navy", -16777088);
            hashMap.put("oldlace", -133658);
            hashMap.put("olive", -8355840);
            hashMap.put("olivedrab", -9728477);
            hashMap.put("orange", -23296);
            hashMap.put("orangered", -47872);
            hashMap.put("orchid", -2461482);
            hashMap.put("palegoldenrod", -1120086);
            hashMap.put("palegreen", -6751336);
            hashMap.put("paleturquoise", -5247250);
            hashMap.put("palevioletred", -2396013);
            hashMap.put("papayawhip", -4139);
            hashMap.put("peachpuff", -9543);
            hashMap.put("peru", -3308225);
            hashMap.put("pink", -16181);
            hashMap.put("plum", -2252579);
            hashMap.put("powderblue", -5185306);
            hashMap.put("purple", -8388480);
            hashMap.put("rebeccapurple", -10079335);
            hashMap.put("red", -65536);
            hashMap.put("rosybrown", -4419697);
            hashMap.put("royalblue", -12490271);
            hashMap.put("saddlebrown", -7650029);
            hashMap.put("salmon", -360334);
            hashMap.put("sandybrown", -744352);
            hashMap.put("seagreen", -13726889);
            hashMap.put("seashell", -2578);
            hashMap.put("sienna", -6270419);
            hashMap.put("silver", -4144960);
            hashMap.put("skyblue", -7876885);
            hashMap.put("slateblue", -9807155);
            hashMap.put("slategray", -9404272);
            hashMap.put("slategrey", -9404272);
            hashMap.put("snow", -1286);
            hashMap.put("springgreen", -16711809);
            hashMap.put("steelblue", -12156236);
            hashMap.put("tan", -2968436);
            hashMap.put("teal", -16744320);
            hashMap.put("thistle", -2572328);
            hashMap.put("tomato", -40121);
            hashMap.put("turquoise", -12525360);
            hashMap.put("violet", -1146130);
            hashMap.put("wheat", -663885);
            hashMap.put("white", -1);
            hashMap.put("whitesmoke", -657931);
            hashMap.put("yellow", -256);
            hashMap.put("yellowgreen", -6632142);
            hashMap.put("transparent", 0);
        }

        static Integer get(String str) {
            return colourKeywords.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class FontSizeKeywords {
        private static final Map<String, SVG.Length> fontSizeKeywords;

        static {
            HashMap hashMap = new HashMap(9);
            fontSizeKeywords = hashMap;
            SVG.Unit unit = SVG.Unit.pt;
            hashMap.put("xx-small", new SVG.Length(0.694f, unit));
            hashMap.put("x-small", new SVG.Length(0.833f, unit));
            hashMap.put(Constants.SMALL, new SVG.Length(10.0f, unit));
            hashMap.put(Constants.MEDIUM, new SVG.Length(12.0f, unit));
            hashMap.put(Constants.LARGE, new SVG.Length(14.4f, unit));
            hashMap.put("x-large", new SVG.Length(17.3f, unit));
            hashMap.put("xx-large", new SVG.Length(20.7f, unit));
            SVG.Unit unit2 = SVG.Unit.percent;
            hashMap.put("smaller", new SVG.Length(83.33f, unit2));
            hashMap.put("larger", new SVG.Length(120.0f, unit2));
        }

        static SVG.Length get(String str) {
            return fontSizeKeywords.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class FontWeightKeywords {
        private static final Map<String, Integer> fontWeightKeywords;

        static {
            HashMap hashMap = new HashMap(13);
            fontWeightKeywords = hashMap;
            Integer valueOf = Integer.valueOf(Constants.MINIMAL_ERROR_STATUS_CODE);
            hashMap.put(Constants.NORMAL, valueOf);
            hashMap.put("bold", 700);
            hashMap.put("bolder", 1);
            hashMap.put("lighter", -1);
            hashMap.put("100", 100);
            hashMap.put("200", 200);
            hashMap.put("300", 300);
            hashMap.put("400", valueOf);
            hashMap.put("500", 500);
            hashMap.put("600", 600);
            hashMap.put("700", 700);
            hashMap.put("800", 800);
            hashMap.put("900", 900);
        }

        static Integer get(String str) {
            return fontWeightKeywords.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class SAXHandler extends DefaultHandler2 {
        private SAXHandler() {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i5, int i6) {
            SVGParser.this.text(new String(cArr, i5, i6));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() {
            SVGParser.this.endDocument();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            SVGParser.this.endElement(str, str2, str3);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) {
            SVGParser.this.handleProcessingInstruction(str, SVGParser.this.parseProcessingInstructionAttributes(new TextScanner(str2)));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() {
            SVGParser.this.startDocument();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            SVGParser.this.startElement(str, str2, str3, attributes);
        }

        /* synthetic */ SAXHandler(SVGParser sVGParser, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum SVGAttr {
        CLASS,
        clip,
        clip_path,
        clipPathUnits,
        clip_rule,
        color,
        cx,
        cy,
        direction,
        dx,
        dy,
        fx,
        fy,
        d,
        display,
        fill,
        fill_rule,
        fill_opacity,
        font,
        font_family,
        font_size,
        font_weight,
        font_style,
        gradientTransform,
        gradientUnits,
        height,
        href,
        image_rendering,
        marker,
        marker_start,
        marker_mid,
        marker_end,
        markerHeight,
        markerUnits,
        markerWidth,
        mask,
        maskContentUnits,
        maskUnits,
        media,
        offset,
        opacity,
        orient,
        overflow,
        pathLength,
        patternContentUnits,
        patternTransform,
        patternUnits,
        points,
        preserveAspectRatio,
        r,
        refX,
        refY,
        requiredFeatures,
        requiredExtensions,
        requiredFormats,
        requiredFonts,
        rx,
        ry,
        solid_color,
        solid_opacity,
        spreadMethod,
        startOffset,
        stop_color,
        stop_opacity,
        stroke,
        stroke_dasharray,
        stroke_dashoffset,
        stroke_linecap,
        stroke_linejoin,
        stroke_miterlimit,
        stroke_opacity,
        stroke_width,
        style,
        systemLanguage,
        text_anchor,
        text_decoration,
        transform,
        type,
        vector_effect,
        version,
        viewBox,
        width,
        x,
        y,
        x1,
        y1,
        x2,
        y2,
        viewport_fill,
        viewport_fill_opacity,
        visibility,
        UNSUPPORTED;

        private static final Map<String, SVGAttr> cache = new HashMap();

        static {
            for (SVGAttr sVGAttr : values()) {
                if (sVGAttr == CLASS) {
                    cache.put("class", sVGAttr);
                } else if (sVGAttr != UNSUPPORTED) {
                    cache.put(sVGAttr.name().replace('_', '-'), sVGAttr);
                }
            }
        }

        public static SVGAttr fromString(String str) {
            SVGAttr sVGAttr = cache.get(str);
            return sVGAttr != null ? sVGAttr : UNSUPPORTED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum SVGElem {
        svg,
        a,
        circle,
        clipPath,
        defs,
        desc,
        ellipse,
        g,
        image,
        line,
        linearGradient,
        marker,
        mask,
        path,
        pattern,
        polygon,
        polyline,
        radialGradient,
        rect,
        solidColor,
        stop,
        style,
        SWITCH,
        symbol,
        text,
        textPath,
        title,
        tref,
        tspan,
        use,
        view,
        UNSUPPORTED;

        private static final Map<String, SVGElem> cache = new HashMap();

        static {
            for (SVGElem sVGElem : values()) {
                if (sVGElem == SWITCH) {
                    cache.put("switch", sVGElem);
                } else if (sVGElem != UNSUPPORTED) {
                    cache.put(sVGElem.name(), sVGElem);
                }
            }
        }

        public static SVGElem fromString(String str) {
            SVGElem sVGElem = cache.get(str);
            return sVGElem != null ? sVGElem : UNSUPPORTED;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TextScanner {
        String input;
        int inputLength;
        int position = 0;
        private NumberParser numberParser = new NumberParser();

        /* JADX INFO: Access modifiers changed from: package-private */
        public TextScanner(String str) {
            this.inputLength = 0;
            String trim = str.trim();
            this.input = trim;
            this.inputLength = trim.length();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int advanceChar() {
            int i5 = this.position;
            int i6 = this.inputLength;
            if (i5 == i6) {
                return -1;
            }
            int i7 = i5 + 1;
            this.position = i7;
            if (i7 < i6) {
                return this.input.charAt(i7);
            }
            return -1;
        }

        String ahead() {
            int i5 = this.position;
            while (!empty() && !isWhitespace(this.input.charAt(this.position))) {
                this.position++;
            }
            String substring = this.input.substring(i5, this.position);
            this.position = i5;
            return substring;
        }

        Boolean checkedNextFlag(Object obj) {
            if (obj == null) {
                return null;
            }
            skipCommaWhitespace();
            return nextFlag();
        }

        float checkedNextFloat(float f5) {
            if (Float.isNaN(f5)) {
                return Float.NaN;
            }
            skipCommaWhitespace();
            return nextFloat();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean consume(char c5) {
            int i5 = this.position;
            boolean z5 = i5 < this.inputLength && this.input.charAt(i5) == c5;
            if (z5) {
                this.position++;
            }
            return z5;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean empty() {
            return this.position == this.inputLength;
        }

        boolean hasLetter() {
            int i5 = this.position;
            if (i5 == this.inputLength) {
                return false;
            }
            char charAt = this.input.charAt(i5);
            return (charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z');
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isEOL(int i5) {
            return i5 == 10 || i5 == 13;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isWhitespace(int i5) {
            return i5 == 32 || i5 == 10 || i5 == 13 || i5 == 9;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Integer nextChar() {
            int i5 = this.position;
            if (i5 == this.inputLength) {
                return null;
            }
            String str = this.input;
            this.position = i5 + 1;
            return Integer.valueOf(str.charAt(i5));
        }

        Boolean nextFlag() {
            int i5 = this.position;
            if (i5 == this.inputLength) {
                return null;
            }
            char charAt = this.input.charAt(i5);
            if (charAt != '0' && charAt != '1') {
                return null;
            }
            this.position++;
            return Boolean.valueOf(charAt == '1');
        }

        float nextFloat() {
            float parseNumber = this.numberParser.parseNumber(this.input, this.position, this.inputLength);
            if (!Float.isNaN(parseNumber)) {
                this.position = this.numberParser.getEndPos();
            }
            return parseNumber;
        }

        String nextFunction() {
            if (empty()) {
                return null;
            }
            int i5 = this.position;
            int charAt = this.input.charAt(i5);
            while (true) {
                if ((charAt < 97 || charAt > 122) && (charAt < 65 || charAt > 90)) {
                    break;
                }
                charAt = advanceChar();
            }
            int i6 = this.position;
            while (isWhitespace(charAt)) {
                charAt = advanceChar();
            }
            if (charAt == 40) {
                this.position++;
                return this.input.substring(i5, i6);
            }
            this.position = i5;
            return null;
        }

        SVG.Length nextLength() {
            float nextFloat = nextFloat();
            if (Float.isNaN(nextFloat)) {
                return null;
            }
            SVG.Unit nextUnit = nextUnit();
            return nextUnit == null ? new SVG.Length(nextFloat, SVG.Unit.px) : new SVG.Length(nextFloat, nextUnit);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String nextQuotedString() {
            if (empty()) {
                return null;
            }
            int i5 = this.position;
            char charAt = this.input.charAt(i5);
            if (charAt != '\'' && charAt != '\"') {
                return null;
            }
            int advanceChar = advanceChar();
            while (advanceChar != -1 && advanceChar != charAt) {
                advanceChar = advanceChar();
            }
            if (advanceChar == -1) {
                this.position = i5;
                return null;
            }
            int i6 = this.position;
            this.position = i6 + 1;
            return this.input.substring(i5 + 1, i6);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String nextToken() {
            return nextToken(' ', false);
        }

        String nextTokenWithWhitespace(char c5) {
            return nextToken(c5, true);
        }

        SVG.Unit nextUnit() {
            if (empty()) {
                return null;
            }
            if (this.input.charAt(this.position) == '%') {
                this.position++;
                return SVG.Unit.percent;
            }
            int i5 = this.position;
            if (i5 > this.inputLength - 2) {
                return null;
            }
            try {
                SVG.Unit valueOf = SVG.Unit.valueOf(this.input.substring(i5, i5 + 2).toLowerCase(Locale.US));
                this.position += 2;
                return valueOf;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String nextWord() {
            if (empty()) {
                return null;
            }
            int i5 = this.position;
            char charAt = this.input.charAt(i5);
            if ((charAt < 'A' || charAt > 'Z') && (charAt < 'a' || charAt > 'z')) {
                this.position = i5;
                return null;
            }
            int advanceChar = advanceChar();
            while (true) {
                if ((advanceChar < 65 || advanceChar > 90) && (advanceChar < 97 || advanceChar > 122)) {
                    break;
                }
                advanceChar = advanceChar();
            }
            return this.input.substring(i5, this.position);
        }

        float possibleNextFloat() {
            skipCommaWhitespace();
            float parseNumber = this.numberParser.parseNumber(this.input, this.position, this.inputLength);
            if (!Float.isNaN(parseNumber)) {
                this.position = this.numberParser.getEndPos();
            }
            return parseNumber;
        }

        String restOfText() {
            if (empty()) {
                return null;
            }
            int i5 = this.position;
            this.position = this.inputLength;
            return this.input.substring(i5);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean skipCommaWhitespace() {
            skipWhitespace();
            int i5 = this.position;
            if (i5 == this.inputLength || this.input.charAt(i5) != ',') {
                return false;
            }
            this.position++;
            skipWhitespace();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void skipWhitespace() {
            while (true) {
                int i5 = this.position;
                if (i5 >= this.inputLength || !isWhitespace(this.input.charAt(i5))) {
                    return;
                } else {
                    this.position++;
                }
            }
        }

        String nextToken(char c5) {
            return nextToken(c5, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean consume(String str) {
            int length = str.length();
            int i5 = this.position;
            boolean z5 = i5 <= this.inputLength - length && this.input.substring(i5, i5 + length).equals(str);
            if (z5) {
                this.position += length;
            }
            return z5;
        }

        String nextToken(char c5, boolean z5) {
            if (empty()) {
                return null;
            }
            char charAt = this.input.charAt(this.position);
            if ((!z5 && isWhitespace(charAt)) || charAt == c5) {
                return null;
            }
            int i5 = this.position;
            int advanceChar = advanceChar();
            while (advanceChar != -1 && advanceChar != c5 && (z5 || !isWhitespace(advanceChar))) {
                advanceChar = advanceChar();
            }
            return this.input.substring(i5, this.position);
        }

        float checkedNextFloat(Boolean bool) {
            if (bool == null) {
                return Float.NaN;
            }
            skipCommaWhitespace();
            return nextFloat();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class XPPAttributesWrapper implements Attributes {
        private XmlPullParser parser;

        public XPPAttributesWrapper(XmlPullParser xmlPullParser) {
            this.parser = xmlPullParser;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String str) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public int getLength() {
            return this.parser.getAttributeCount();
        }

        @Override // org.xml.sax.Attributes
        public String getLocalName(int i5) {
            return this.parser.getAttributeName(i5);
        }

        @Override // org.xml.sax.Attributes
        public String getQName(int i5) {
            String attributeName = this.parser.getAttributeName(i5);
            if (this.parser.getAttributePrefix(i5) == null) {
                return attributeName;
            }
            return this.parser.getAttributePrefix(i5) + ':' + attributeName;
        }

        @Override // org.xml.sax.Attributes
        public String getType(int i5) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getURI(int i5) {
            return this.parser.getAttributeNamespace(i5);
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String str, String str2) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str, String str2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str, String str2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(int i5) {
            return this.parser.getAttributeValue(i5);
        }
    }

    private void appendToTextContainer(String str) {
        SVG.SvgConditionalContainer svgConditionalContainer = (SVG.SvgConditionalContainer) this.currentElement;
        int size = svgConditionalContainer.children.size();
        SVG.SvgObject svgObject = size == 0 ? null : svgConditionalContainer.children.get(size - 1);
        if (!(svgObject instanceof SVG.TextSequence)) {
            this.currentElement.addChild(new SVG.TextSequence(str));
            return;
        }
        StringBuilder sb = new StringBuilder();
        SVG.TextSequence textSequence = (SVG.TextSequence) svgObject;
        sb.append(textSequence.text);
        sb.append(str);
        textSequence.text = sb.toString();
    }

    private void circle(Attributes attributes) {
        debug("<circle>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Circle circle = new SVG.Circle();
        circle.document = this.svgDocument;
        circle.parent = this.currentElement;
        parseAttributesCore(circle, attributes);
        parseAttributesStyle(circle, attributes);
        parseAttributesTransform(circle, attributes);
        parseAttributesConditional(circle, attributes);
        parseAttributesCircle(circle, attributes);
        this.currentElement.addChild(circle);
    }

    private static int clamp255(float f5) {
        if (f5 < 0.0f) {
            return 0;
        }
        return f5 > 255.0f ? Function.USE_VARARGS : Math.round(f5);
    }

    private void clipPath(Attributes attributes) {
        debug("<clipPath>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.ClipPath clipPath = new SVG.ClipPath();
        clipPath.document = this.svgDocument;
        clipPath.parent = this.currentElement;
        parseAttributesCore(clipPath, attributes);
        parseAttributesStyle(clipPath, attributes);
        parseAttributesTransform(clipPath, attributes);
        parseAttributesConditional(clipPath, attributes);
        parseAttributesClipPath(clipPath, attributes);
        this.currentElement.addChild(clipPath);
        this.currentElement = clipPath;
    }

    private void debug(String str, Object... objArr) {
    }

    private void defs(Attributes attributes) {
        debug("<defs>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Defs defs = new SVG.Defs();
        defs.document = this.svgDocument;
        defs.parent = this.currentElement;
        parseAttributesCore(defs, attributes);
        parseAttributesStyle(defs, attributes);
        parseAttributesTransform(defs, attributes);
        this.currentElement.addChild(defs);
        this.currentElement = defs;
    }

    private void ellipse(Attributes attributes) {
        debug("<ellipse>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Ellipse ellipse = new SVG.Ellipse();
        ellipse.document = this.svgDocument;
        ellipse.parent = this.currentElement;
        parseAttributesCore(ellipse, attributes);
        parseAttributesStyle(ellipse, attributes);
        parseAttributesTransform(ellipse, attributes);
        parseAttributesConditional(ellipse, attributes);
        parseAttributesEllipse(ellipse, attributes);
        this.currentElement.addChild(ellipse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endDocument() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endElement(String str, String str2, String str3) {
        if (this.ignoring) {
            int i5 = this.ignoreDepth - 1;
            this.ignoreDepth = i5;
            if (i5 == 0) {
                this.ignoring = false;
                return;
            }
        }
        if (SVG_NAMESPACE.equals(str) || BuildConfig.FLAVOR.equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            int i6 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.fromString(str2).ordinal()];
            if (i6 != 1 && i6 != 2 && i6 != 4 && i6 != 5 && i6 != 13 && i6 != 14) {
                switch (i6) {
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case R$styleable.Toolbar_titleTextColor /* 29 */:
                    case 31:
                        break;
                    case 22:
                    case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                        this.inMetadataElement = false;
                        StringBuilder sb = this.metadataElementContents;
                        if (sb != null) {
                            SVGElem sVGElem = this.metadataTag;
                            if (sVGElem == SVGElem.title) {
                                this.svgDocument.setTitle(sb.toString());
                            } else if (sVGElem == SVGElem.desc) {
                                this.svgDocument.setDesc(sb.toString());
                            }
                            this.metadataElementContents.setLength(0);
                            return;
                        }
                        return;
                    case 30:
                        StringBuilder sb2 = this.styleElementContents;
                        if (sb2 != null) {
                            this.inStyleElement = false;
                            parseCSSStyleSheet(sb2.toString());
                            this.styleElementContents.setLength(0);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            this.currentElement = ((SVG.SvgObject) this.currentElement).parent;
        }
    }

    private void g(Attributes attributes) {
        debug("<g>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Group group = new SVG.Group();
        group.document = this.svgDocument;
        group.parent = this.currentElement;
        parseAttributesCore(group, attributes);
        parseAttributesStyle(group, attributes);
        parseAttributesTransform(group, attributes);
        parseAttributesConditional(group, attributes);
        this.currentElement.addChild(group);
        this.currentElement = group;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleProcessingInstruction(String str, Map<String, String> map) {
        if (str.equals(XML_STYLESHEET_PROCESSING_INSTRUCTION)) {
            SVG.getFileResolver();
        }
    }

    private static int hslToRgb(float f5, float f6, float f7) {
        float f8 = f5 % 360.0f;
        if (f5 < 0.0f) {
            f8 += 360.0f;
        }
        float f9 = f8 / 60.0f;
        float f10 = f6 / 100.0f;
        float f11 = f7 / 100.0f;
        if (f10 < 0.0f) {
            f10 = 0.0f;
        } else if (f10 > 1.0f) {
            f10 = 1.0f;
        }
        float f12 = f11 >= 0.0f ? f11 > 1.0f ? 1.0f : f11 : 0.0f;
        float f13 = f12 <= 0.5f ? (f10 + 1.0f) * f12 : (f12 + f10) - (f10 * f12);
        float f14 = (f12 * 2.0f) - f13;
        return clamp255(hueToRgb(f14, f13, f9 - 2.0f) * 256.0f) | (clamp255(hueToRgb(f14, f13, f9 + 2.0f) * 256.0f) << 16) | (clamp255(hueToRgb(f14, f13, f9) * 256.0f) << 8);
    }

    private static float hueToRgb(float f5, float f6, float f7) {
        float f8;
        if (f7 < 0.0f) {
            f7 += 6.0f;
        }
        if (f7 >= 6.0f) {
            f7 -= 6.0f;
        }
        if (f7 < 1.0f) {
            f8 = (f6 - f5) * f7;
        } else {
            if (f7 < 3.0f) {
                return f6;
            }
            if (f7 >= 4.0f) {
                return f5;
            }
            f8 = (f6 - f5) * (4.0f - f7);
        }
        return f8 + f5;
    }

    private void image(Attributes attributes) {
        debug("<image>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Image image = new SVG.Image();
        image.document = this.svgDocument;
        image.parent = this.currentElement;
        parseAttributesCore(image, attributes);
        parseAttributesStyle(image, attributes);
        parseAttributesTransform(image, attributes);
        parseAttributesConditional(image, attributes);
        parseAttributesImage(image, attributes);
        this.currentElement.addChild(image);
        this.currentElement = image;
    }

    private void line(Attributes attributes) {
        debug("<line>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Line line = new SVG.Line();
        line.document = this.svgDocument;
        line.parent = this.currentElement;
        parseAttributesCore(line, attributes);
        parseAttributesStyle(line, attributes);
        parseAttributesTransform(line, attributes);
        parseAttributesConditional(line, attributes);
        parseAttributesLine(line, attributes);
        this.currentElement.addChild(line);
    }

    private void linearGradient(Attributes attributes) {
        debug("<linearGradient>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.SvgLinearGradient svgLinearGradient = new SVG.SvgLinearGradient();
        svgLinearGradient.document = this.svgDocument;
        svgLinearGradient.parent = this.currentElement;
        parseAttributesCore(svgLinearGradient, attributes);
        parseAttributesStyle(svgLinearGradient, attributes);
        parseAttributesGradient(svgLinearGradient, attributes);
        parseAttributesLinearGradient(svgLinearGradient, attributes);
        this.currentElement.addChild(svgLinearGradient);
        this.currentElement = svgLinearGradient;
    }

    private void marker(Attributes attributes) {
        debug("<marker>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Marker marker = new SVG.Marker();
        marker.document = this.svgDocument;
        marker.parent = this.currentElement;
        parseAttributesCore(marker, attributes);
        parseAttributesStyle(marker, attributes);
        parseAttributesConditional(marker, attributes);
        parseAttributesViewBox(marker, attributes);
        parseAttributesMarker(marker, attributes);
        this.currentElement.addChild(marker);
        this.currentElement = marker;
    }

    private void mask(Attributes attributes) {
        debug("<mask>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Mask mask = new SVG.Mask();
        mask.document = this.svgDocument;
        mask.parent = this.currentElement;
        parseAttributesCore(mask, attributes);
        parseAttributesStyle(mask, attributes);
        parseAttributesConditional(mask, attributes);
        parseAttributesMask(mask, attributes);
        this.currentElement.addChild(mask);
        this.currentElement = mask;
    }

    private void parseAttributesCircle(SVG.Circle circle, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()]) {
                case 12:
                    circle.cx = parseLength(trim);
                    break;
                case 13:
                    circle.cy = parseLength(trim);
                    break;
                case 14:
                    SVG.Length parseLength = parseLength(trim);
                    circle.f4241r = parseLength;
                    if (parseLength.isNegative()) {
                        throw new SVGParseException("Invalid <circle> element. r cannot be negative");
                    }
                    break;
            }
        }
    }

    private void parseAttributesClipPath(SVG.ClipPath clipPath, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            if (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()] == 38) {
                if ("objectBoundingBox".equals(trim)) {
                    clipPath.clipPathUnitsAreUser = Boolean.FALSE;
                } else {
                    if (!"userSpaceOnUse".equals(trim)) {
                        throw new SVGParseException("Invalid value for attribute clipPathUnits");
                    }
                    clipPath.clipPathUnitsAreUser = Boolean.TRUE;
                }
            }
        }
    }

    private void parseAttributesConditional(SVG.SvgConditional svgConditional, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()]) {
                case 21:
                    svgConditional.setRequiredFeatures(parseRequiredFeatures(trim));
                    break;
                case 22:
                    svgConditional.setRequiredExtensions(trim);
                    break;
                case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                    svgConditional.setSystemLanguage(parseSystemLanguage(trim));
                    break;
                case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                    svgConditional.setRequiredFormats(parseRequiredFormats(trim));
                    break;
                case 25:
                    List<String> parseFontFamily = parseFontFamily(trim);
                    svgConditional.setRequiredFonts(parseFontFamily != null ? new HashSet(parseFontFamily) : new HashSet(0));
                    break;
            }
        }
    }

    private void parseAttributesCore(SVG.SvgElementBase svgElementBase, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String qName = attributes.getQName(i5);
            if (qName.equals(com.sdk.growthbook.utils.Constants.ID_ATTRIBUTE_KEY) || qName.equals("xml:id")) {
                svgElementBase.id = attributes.getValue(i5).trim();
                return;
            }
            if (qName.equals("xml:space")) {
                String trim = attributes.getValue(i5).trim();
                if ("default".equals(trim)) {
                    svgElementBase.spacePreserve = Boolean.FALSE;
                    return;
                } else {
                    if ("preserve".equals(trim)) {
                        svgElementBase.spacePreserve = Boolean.TRUE;
                        return;
                    }
                    throw new SVGParseException("Invalid value for \"xml:space\" attribute: " + trim);
                }
            }
        }
    }

    private void parseAttributesEllipse(SVG.Ellipse ellipse, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()]) {
                case 10:
                    SVG.Length parseLength = parseLength(trim);
                    ellipse.rx = parseLength;
                    if (parseLength.isNegative()) {
                        throw new SVGParseException("Invalid <ellipse> element. rx cannot be negative");
                    }
                    break;
                case 11:
                    SVG.Length parseLength2 = parseLength(trim);
                    ellipse.ry = parseLength2;
                    if (parseLength2.isNegative()) {
                        throw new SVGParseException("Invalid <ellipse> element. ry cannot be negative");
                    }
                    break;
                case 12:
                    ellipse.cx = parseLength(trim);
                    break;
                case 13:
                    ellipse.cy = parseLength(trim);
                    break;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x008d, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseAttributesGradient(SVG.GradientElement gradientElement, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            int i6 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()];
            if (i6 != 6) {
                switch (i6) {
                    case 32:
                        if (!"objectBoundingBox".equals(trim)) {
                            if (!"userSpaceOnUse".equals(trim)) {
                                throw new SVGParseException("Invalid value for attribute gradientUnits");
                            }
                            gradientElement.gradientUnitsAreUser = Boolean.TRUE;
                            break;
                        } else {
                            gradientElement.gradientUnitsAreUser = Boolean.FALSE;
                            break;
                        }
                    case 33:
                        gradientElement.gradientTransform = parseTransformList(trim);
                        break;
                    case 34:
                        try {
                            gradientElement.spreadMethod = SVG.GradientSpread.valueOf(trim);
                            break;
                        } catch (IllegalArgumentException unused) {
                            throw new SVGParseException("Invalid spreadMethod attribute. \"" + trim + "\" is not a valid value.");
                        }
                }
            } else if (BuildConfig.FLAVOR.equals(attributes.getURI(i5)) || XLINK_NAMESPACE.equals(attributes.getURI(i5))) {
                gradientElement.href = trim;
            }
        }
    }

    private void parseAttributesImage(SVG.Image image, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            int i6 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()];
            if (i6 == 1) {
                image.f4242x = parseLength(trim);
            } else if (i6 == 2) {
                image.f4243y = parseLength(trim);
            } else if (i6 == 3) {
                SVG.Length parseLength = parseLength(trim);
                image.width = parseLength;
                if (parseLength.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. width cannot be negative");
                }
            } else if (i6 == 4) {
                SVG.Length parseLength2 = parseLength(trim);
                image.height = parseLength2;
                if (parseLength2.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. height cannot be negative");
                }
            } else if (i6 != 6) {
                if (i6 == 7) {
                    parsePreserveAspectRatio(image, trim);
                }
            } else if (BuildConfig.FLAVOR.equals(attributes.getURI(i5)) || XLINK_NAMESPACE.equals(attributes.getURI(i5))) {
                image.href = trim;
            }
        }
    }

    private void parseAttributesLine(SVG.Line line, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()]) {
                case 15:
                    line.f4244x1 = parseLength(trim);
                    break;
                case 16:
                    line.f4246y1 = parseLength(trim);
                    break;
                case 17:
                    line.f4245x2 = parseLength(trim);
                    break;
                case 18:
                    line.f4247y2 = parseLength(trim);
                    break;
            }
        }
    }

    private void parseAttributesLinearGradient(SVG.SvgLinearGradient svgLinearGradient, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()]) {
                case 15:
                    svgLinearGradient.f4257x1 = parseLength(trim);
                    break;
                case 16:
                    svgLinearGradient.f4259y1 = parseLength(trim);
                    break;
                case 17:
                    svgLinearGradient.f4258x2 = parseLength(trim);
                    break;
                case 18:
                    svgLinearGradient.f4260y2 = parseLength(trim);
                    break;
            }
        }
    }

    private void parseAttributesMarker(SVG.Marker marker, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()]) {
                case 26:
                    marker.refX = parseLength(trim);
                    break;
                case 27:
                    marker.refY = parseLength(trim);
                    break;
                case 28:
                    SVG.Length parseLength = parseLength(trim);
                    marker.markerWidth = parseLength;
                    if (parseLength.isNegative()) {
                        throw new SVGParseException("Invalid <marker> element. markerWidth cannot be negative");
                    }
                    break;
                case R$styleable.Toolbar_titleTextColor /* 29 */:
                    SVG.Length parseLength2 = parseLength(trim);
                    marker.markerHeight = parseLength2;
                    if (parseLength2.isNegative()) {
                        throw new SVGParseException("Invalid <marker> element. markerHeight cannot be negative");
                    }
                    break;
                case 30:
                    if (!"strokeWidth".equals(trim)) {
                        if (!"userSpaceOnUse".equals(trim)) {
                            throw new SVGParseException("Invalid value for attribute markerUnits");
                        }
                        marker.markerUnitsAreUser = true;
                        break;
                    } else {
                        marker.markerUnitsAreUser = false;
                        break;
                    }
                case 31:
                    if ("auto".equals(trim)) {
                        marker.orient = Float.valueOf(Float.NaN);
                        break;
                    } else {
                        marker.orient = Float.valueOf(parseFloat(trim));
                        break;
                    }
            }
        }
    }

    private void parseAttributesMask(SVG.Mask mask, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            int i6 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()];
            if (i6 == 1) {
                mask.f4248x = parseLength(trim);
            } else if (i6 == 2) {
                mask.f4249y = parseLength(trim);
            } else if (i6 == 3) {
                SVG.Length parseLength = parseLength(trim);
                mask.width = parseLength;
                if (parseLength.isNegative()) {
                    throw new SVGParseException("Invalid <mask> element. width cannot be negative");
                }
            } else if (i6 == 4) {
                SVG.Length parseLength2 = parseLength(trim);
                mask.height = parseLength2;
                if (parseLength2.isNegative()) {
                    throw new SVGParseException("Invalid <mask> element. height cannot be negative");
                }
            } else if (i6 != 43) {
                if (i6 != 44) {
                    continue;
                } else if ("objectBoundingBox".equals(trim)) {
                    mask.maskContentUnitsAreUser = Boolean.FALSE;
                } else {
                    if (!"userSpaceOnUse".equals(trim)) {
                        throw new SVGParseException("Invalid value for attribute maskContentUnits");
                    }
                    mask.maskContentUnitsAreUser = Boolean.TRUE;
                }
            } else if ("objectBoundingBox".equals(trim)) {
                mask.maskUnitsAreUser = Boolean.FALSE;
            } else {
                if (!"userSpaceOnUse".equals(trim)) {
                    throw new SVGParseException("Invalid value for attribute maskUnits");
                }
                mask.maskUnitsAreUser = Boolean.TRUE;
            }
        }
    }

    private void parseAttributesPath(SVG.Path path, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            int i6 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()];
            if (i6 == 8) {
                path.f4250d = parsePath(trim);
            } else if (i6 != 9) {
                continue;
            } else {
                Float valueOf = Float.valueOf(parseFloat(trim));
                path.pathLength = valueOf;
                if (valueOf.floatValue() < 0.0f) {
                    throw new SVGParseException("Invalid <path> element. pathLength cannot be negative");
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d0, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseAttributesPattern(SVG.Pattern pattern, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            int i6 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()];
            if (i6 == 1) {
                pattern.f4251x = parseLength(trim);
            } else if (i6 == 2) {
                pattern.f4252y = parseLength(trim);
            } else if (i6 == 3) {
                SVG.Length parseLength = parseLength(trim);
                pattern.width = parseLength;
                if (parseLength.isNegative()) {
                    throw new SVGParseException("Invalid <pattern> element. width cannot be negative");
                }
            } else if (i6 == 4) {
                SVG.Length parseLength2 = parseLength(trim);
                pattern.height = parseLength2;
                if (parseLength2.isNegative()) {
                    throw new SVGParseException("Invalid <pattern> element. height cannot be negative");
                }
            } else if (i6 != 6) {
                switch (i6) {
                    case 40:
                        if (!"objectBoundingBox".equals(trim)) {
                            if (!"userSpaceOnUse".equals(trim)) {
                                throw new SVGParseException("Invalid value for attribute patternUnits");
                            }
                            pattern.patternUnitsAreUser = Boolean.TRUE;
                            break;
                        } else {
                            pattern.patternUnitsAreUser = Boolean.FALSE;
                            break;
                        }
                    case 41:
                        if (!"objectBoundingBox".equals(trim)) {
                            if (!"userSpaceOnUse".equals(trim)) {
                                throw new SVGParseException("Invalid value for attribute patternContentUnits");
                            }
                            pattern.patternContentUnitsAreUser = Boolean.TRUE;
                            break;
                        } else {
                            pattern.patternContentUnitsAreUser = Boolean.FALSE;
                            break;
                        }
                    case 42:
                        pattern.patternTransform = parseTransformList(trim);
                        break;
                }
            } else if (BuildConfig.FLAVOR.equals(attributes.getURI(i5)) || XLINK_NAMESPACE.equals(attributes.getURI(i5))) {
                pattern.href = trim;
            }
        }
    }

    private void parseAttributesPolyLine(SVG.PolyLine polyLine, Attributes attributes, String str) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            if (SVGAttr.fromString(attributes.getLocalName(i5)) == SVGAttr.points) {
                TextScanner textScanner = new TextScanner(attributes.getValue(i5));
                ArrayList arrayList = new ArrayList();
                textScanner.skipWhitespace();
                while (!textScanner.empty()) {
                    float nextFloat = textScanner.nextFloat();
                    if (Float.isNaN(nextFloat)) {
                        throw new SVGParseException("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                    textScanner.skipCommaWhitespace();
                    float nextFloat2 = textScanner.nextFloat();
                    if (Float.isNaN(nextFloat2)) {
                        throw new SVGParseException("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                    }
                    textScanner.skipCommaWhitespace();
                    arrayList.add(Float.valueOf(nextFloat));
                    arrayList.add(Float.valueOf(nextFloat2));
                }
                polyLine.points = new float[arrayList.size()];
                Iterator it = arrayList.iterator();
                int i6 = 0;
                while (it.hasNext()) {
                    polyLine.points[i6] = ((Float) it.next()).floatValue();
                    i6++;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseAttributesRadialGradient(SVG.SvgRadialGradient svgRadialGradient, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            int i6 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()];
            if (i6 == 35) {
                svgRadialGradient.fx = parseLength(trim);
            } else if (i6 != 36) {
                switch (i6) {
                    case 12:
                        svgRadialGradient.cx = parseLength(trim);
                        break;
                    case 13:
                        svgRadialGradient.cy = parseLength(trim);
                        break;
                    case 14:
                        SVG.Length parseLength = parseLength(trim);
                        svgRadialGradient.f4261r = parseLength;
                        if (parseLength.isNegative()) {
                            throw new SVGParseException("Invalid <radialGradient> element. r cannot be negative");
                        }
                        break;
                }
            } else {
                svgRadialGradient.fy = parseLength(trim);
            }
        }
    }

    private void parseAttributesRect(SVG.Rect rect, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            int i6 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()];
            if (i6 == 1) {
                rect.f4253x = parseLength(trim);
            } else if (i6 == 2) {
                rect.f4254y = parseLength(trim);
            } else if (i6 == 3) {
                SVG.Length parseLength = parseLength(trim);
                rect.width = parseLength;
                if (parseLength.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. width cannot be negative");
                }
            } else if (i6 == 4) {
                SVG.Length parseLength2 = parseLength(trim);
                rect.height = parseLength2;
                if (parseLength2.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. height cannot be negative");
                }
            } else if (i6 == 10) {
                SVG.Length parseLength3 = parseLength(trim);
                rect.rx = parseLength3;
                if (parseLength3.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. rx cannot be negative");
                }
            } else if (i6 != 11) {
                continue;
            } else {
                SVG.Length parseLength4 = parseLength(trim);
                rect.ry = parseLength4;
                if (parseLength4.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. ry cannot be negative");
                }
            }
        }
    }

    private void parseAttributesSVG(SVG.Svg svg, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            int i6 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()];
            if (i6 == 1) {
                svg.f4255x = parseLength(trim);
            } else if (i6 == 2) {
                svg.f4256y = parseLength(trim);
            } else if (i6 == 3) {
                SVG.Length parseLength = parseLength(trim);
                svg.width = parseLength;
                if (parseLength.isNegative()) {
                    throw new SVGParseException("Invalid <svg> element. width cannot be negative");
                }
            } else if (i6 == 4) {
                SVG.Length parseLength2 = parseLength(trim);
                svg.height = parseLength2;
                if (parseLength2.isNegative()) {
                    throw new SVGParseException("Invalid <svg> element. height cannot be negative");
                }
            } else if (i6 == 5) {
                svg.version = trim;
            }
        }
    }

    private void parseAttributesStop(SVG.Stop stop, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            if (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()] == 37) {
                stop.offset = parseGradientOffset(trim);
            }
        }
    }

    private void parseAttributesStyle(SVG.SvgElementBase svgElementBase, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            if (trim.length() != 0) {
                int i6 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()];
                if (i6 == 45) {
                    parseStyle(svgElementBase, trim);
                } else if (i6 != 46) {
                    if (svgElementBase.baseStyle == null) {
                        svgElementBase.baseStyle = new SVG.Style();
                    }
                    processStyleProperty(svgElementBase.baseStyle, attributes.getLocalName(i5), attributes.getValue(i5).trim());
                } else {
                    svgElementBase.classNames = CSSParser.parseClassAttribute(trim);
                }
            }
        }
    }

    private void parseAttributesTRef(SVG.TRef tRef, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            if (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()] == 6 && (BuildConfig.FLAVOR.equals(attributes.getURI(i5)) || XLINK_NAMESPACE.equals(attributes.getURI(i5)))) {
                tRef.href = trim;
            }
        }
    }

    private void parseAttributesTextPath(SVG.TextPath textPath, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            int i6 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()];
            if (i6 != 6) {
                if (i6 == 39) {
                    textPath.startOffset = parseLength(trim);
                }
            } else if (BuildConfig.FLAVOR.equals(attributes.getURI(i5)) || XLINK_NAMESPACE.equals(attributes.getURI(i5))) {
                textPath.href = trim;
            }
        }
    }

    private void parseAttributesTextPosition(SVG.TextPositionedContainer textPositionedContainer, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            int i6 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()];
            if (i6 == 1) {
                textPositionedContainer.f4262x = parseLengthList(trim);
            } else if (i6 == 2) {
                textPositionedContainer.f4263y = parseLengthList(trim);
            } else if (i6 == 19) {
                textPositionedContainer.dx = parseLengthList(trim);
            } else if (i6 == 20) {
                textPositionedContainer.dy = parseLengthList(trim);
            }
        }
    }

    private void parseAttributesTransform(SVG.HasTransform hasTransform, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            if (SVGAttr.fromString(attributes.getLocalName(i5)) == SVGAttr.transform) {
                hasTransform.setTransform(parseTransformList(attributes.getValue(i5)));
            }
        }
    }

    private void parseAttributesUse(SVG.Use use, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            int i6 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()];
            if (i6 == 1) {
                use.f4264x = parseLength(trim);
            } else if (i6 == 2) {
                use.f4265y = parseLength(trim);
            } else if (i6 == 3) {
                SVG.Length parseLength = parseLength(trim);
                use.width = parseLength;
                if (parseLength.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. width cannot be negative");
                }
            } else if (i6 == 4) {
                SVG.Length parseLength2 = parseLength(trim);
                use.height = parseLength2;
                if (parseLength2.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. height cannot be negative");
                }
            } else if (i6 == 6 && (BuildConfig.FLAVOR.equals(attributes.getURI(i5)) || XLINK_NAMESPACE.equals(attributes.getURI(i5)))) {
                use.href = trim;
            }
        }
    }

    private void parseAttributesViewBox(SVG.SvgViewBoxContainer svgViewBoxContainer, Attributes attributes) {
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            int i6 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()];
            if (i6 == 7) {
                parsePreserveAspectRatio(svgViewBoxContainer, trim);
            } else if (i6 == 87) {
                svgViewBoxContainer.viewBox = parseViewBox(trim);
            }
        }
    }

    private void parseCSSStyleSheet(String str) {
        this.svgDocument.addCSSRules(new CSSParser(CSSParser.MediaType.screen, CSSParser.Source.Document).parse(str));
    }

    private static SVG.CSSClipRect parseClip(String str) {
        if ("auto".equals(str) || !str.startsWith("rect(")) {
            return null;
        }
        TextScanner textScanner = new TextScanner(str.substring(5));
        textScanner.skipWhitespace();
        SVG.Length parseLengthOrAuto = parseLengthOrAuto(textScanner);
        textScanner.skipCommaWhitespace();
        SVG.Length parseLengthOrAuto2 = parseLengthOrAuto(textScanner);
        textScanner.skipCommaWhitespace();
        SVG.Length parseLengthOrAuto3 = parseLengthOrAuto(textScanner);
        textScanner.skipCommaWhitespace();
        SVG.Length parseLengthOrAuto4 = parseLengthOrAuto(textScanner);
        textScanner.skipWhitespace();
        if (textScanner.consume(')') || textScanner.empty()) {
            return new SVG.CSSClipRect(parseLengthOrAuto, parseLengthOrAuto2, parseLengthOrAuto3, parseLengthOrAuto4);
        }
        return null;
    }

    private static SVG.Colour parseColour(String str) {
        if (str.charAt(0) == '#') {
            IntegerParser parseHex = IntegerParser.parseHex(str, 1, str.length());
            if (parseHex == null) {
                throw new SVGParseException("Bad hex colour value: " + str);
            }
            int endPos = parseHex.getEndPos();
            if (endPos == 4) {
                int value = parseHex.value();
                int i5 = value & 3840;
                int i6 = value & 240;
                int i7 = value & 15;
                return new SVG.Colour(i7 | (i5 << 8) | (-16777216) | (i5 << 12) | (i6 << 8) | (i6 << 4) | (i7 << 4));
            }
            if (endPos == 5) {
                int value2 = parseHex.value();
                int i8 = 61440 & value2;
                int i9 = value2 & 3840;
                int i10 = value2 & 240;
                int i11 = value2 & 15;
                return new SVG.Colour((i11 << 24) | (i11 << 28) | (i8 << 8) | (i8 << 4) | (i9 << 4) | i9 | i10 | (i10 >> 4));
            }
            if (endPos == 7) {
                return new SVG.Colour(parseHex.value() | (-16777216));
            }
            if (endPos == 9) {
                return new SVG.Colour((parseHex.value() >>> 8) | (parseHex.value() << 24));
            }
            throw new SVGParseException("Bad hex colour value: " + str);
        }
        String lowerCase = str.toLowerCase(Locale.US);
        boolean startsWith = lowerCase.startsWith("rgba(");
        if (!startsWith && !lowerCase.startsWith("rgb(")) {
            boolean startsWith2 = lowerCase.startsWith("hsla(");
            if (!startsWith2 && !lowerCase.startsWith("hsl(")) {
                return parseColourKeyword(lowerCase);
            }
            TextScanner textScanner = new TextScanner(str.substring(startsWith2 ? 5 : 4));
            textScanner.skipWhitespace();
            float nextFloat = textScanner.nextFloat();
            float checkedNextFloat = textScanner.checkedNextFloat(nextFloat);
            if (!Float.isNaN(checkedNextFloat)) {
                textScanner.consume('%');
            }
            float checkedNextFloat2 = textScanner.checkedNextFloat(checkedNextFloat);
            if (!Float.isNaN(checkedNextFloat2)) {
                textScanner.consume('%');
            }
            if (!startsWith2) {
                textScanner.skipWhitespace();
                if (!Float.isNaN(checkedNextFloat2) && textScanner.consume(')')) {
                    return new SVG.Colour(hslToRgb(nextFloat, checkedNextFloat, checkedNextFloat2) | (-16777216));
                }
                throw new SVGParseException("Bad hsl() colour value: " + str);
            }
            float checkedNextFloat3 = textScanner.checkedNextFloat(checkedNextFloat2);
            textScanner.skipWhitespace();
            if (!Float.isNaN(checkedNextFloat3) && textScanner.consume(')')) {
                return new SVG.Colour((clamp255(checkedNextFloat3 * 256.0f) << 24) | hslToRgb(nextFloat, checkedNextFloat, checkedNextFloat2));
            }
            throw new SVGParseException("Bad hsla() colour value: " + str);
        }
        TextScanner textScanner2 = new TextScanner(str.substring(startsWith ? 5 : 4));
        textScanner2.skipWhitespace();
        float nextFloat2 = textScanner2.nextFloat();
        if (!Float.isNaN(nextFloat2) && textScanner2.consume('%')) {
            nextFloat2 = (nextFloat2 * 256.0f) / 100.0f;
        }
        float checkedNextFloat4 = textScanner2.checkedNextFloat(nextFloat2);
        if (!Float.isNaN(checkedNextFloat4) && textScanner2.consume('%')) {
            checkedNextFloat4 = (checkedNextFloat4 * 256.0f) / 100.0f;
        }
        float checkedNextFloat5 = textScanner2.checkedNextFloat(checkedNextFloat4);
        if (!Float.isNaN(checkedNextFloat5) && textScanner2.consume('%')) {
            checkedNextFloat5 = (checkedNextFloat5 * 256.0f) / 100.0f;
        }
        if (!startsWith) {
            textScanner2.skipWhitespace();
            if (!Float.isNaN(checkedNextFloat5) && textScanner2.consume(')')) {
                return new SVG.Colour((clamp255(nextFloat2) << 16) | (-16777216) | (clamp255(checkedNextFloat4) << 8) | clamp255(checkedNextFloat5));
            }
            throw new SVGParseException("Bad rgb() colour value: " + str);
        }
        float checkedNextFloat6 = textScanner2.checkedNextFloat(checkedNextFloat5);
        textScanner2.skipWhitespace();
        if (!Float.isNaN(checkedNextFloat6) && textScanner2.consume(')')) {
            return new SVG.Colour((clamp255(checkedNextFloat6 * 256.0f) << 24) | (clamp255(nextFloat2) << 16) | (clamp255(checkedNextFloat4) << 8) | clamp255(checkedNextFloat5));
        }
        throw new SVGParseException("Bad rgba() colour value: " + str);
    }

    private static SVG.Colour parseColourKeyword(String str) {
        Integer num = ColourKeywords.get(str);
        if (num != null) {
            return new SVG.Colour(num.intValue());
        }
        throw new SVGParseException("Invalid colour keyword: " + str);
    }

    private static SVG.SvgPaint parseColourSpecifer(String str) {
        str.hashCode();
        if (str.equals(NONE)) {
            return SVG.Colour.TRANSPARENT;
        }
        if (str.equals(CURRENTCOLOR)) {
            return SVG.CurrentColor.getInstance();
        }
        try {
            return parseColour(str);
        } catch (SVGParseException unused) {
            return null;
        }
    }

    private static SVG.Style.FillRule parseFillRule(String str) {
        if ("nonzero".equals(str)) {
            return SVG.Style.FillRule.NonZero;
        }
        if ("evenodd".equals(str)) {
            return SVG.Style.FillRule.EvenOdd;
        }
        return null;
    }

    private static float parseFloat(String str) {
        int length = str.length();
        if (length != 0) {
            return parseFloat(str, 0, length);
        }
        throw new SVGParseException("Invalid float value (empty string)");
    }

    private static void parseFont(SVG.Style style, String str) {
        String nextToken;
        if ("|caption|icon|menu|message-box|small-caption|status-bar|".contains('|' + str + '|')) {
            TextScanner textScanner = new TextScanner(str);
            Integer num = null;
            SVG.Style.FontStyle fontStyle = null;
            String str2 = null;
            while (true) {
                nextToken = textScanner.nextToken('/');
                textScanner.skipWhitespace();
                if (nextToken != null) {
                    if (num != null && fontStyle != null) {
                        break;
                    }
                    if (!nextToken.equals(Constants.NORMAL) && (num != null || (num = FontWeightKeywords.get(nextToken)) == null)) {
                        if (fontStyle != null || (fontStyle = parseFontStyle(nextToken)) == null) {
                            if (str2 != null || !nextToken.equals("small-caps")) {
                                break;
                            } else {
                                str2 = nextToken;
                            }
                        }
                    }
                } else {
                    return;
                }
            }
            SVG.Length parseFontSize = parseFontSize(nextToken);
            if (textScanner.consume('/')) {
                textScanner.skipWhitespace();
                String nextToken2 = textScanner.nextToken();
                if (nextToken2 != null) {
                    try {
                        parseLength(nextToken2);
                    } catch (SVGParseException unused) {
                        return;
                    }
                }
                textScanner.skipWhitespace();
            }
            style.fontFamily = parseFontFamily(textScanner.restOfText());
            style.fontSize = parseFontSize;
            style.fontWeight = Integer.valueOf(num == null ? Constants.MINIMAL_ERROR_STATUS_CODE : num.intValue());
            if (fontStyle == null) {
                fontStyle = SVG.Style.FontStyle.Normal;
            }
            style.fontStyle = fontStyle;
            style.specifiedFlags |= 122880;
        }
    }

    private static List<String> parseFontFamily(String str) {
        TextScanner textScanner = new TextScanner(str);
        ArrayList arrayList = null;
        do {
            String nextQuotedString = textScanner.nextQuotedString();
            if (nextQuotedString == null) {
                nextQuotedString = textScanner.nextTokenWithWhitespace(',');
            }
            if (nextQuotedString == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(nextQuotedString);
            textScanner.skipCommaWhitespace();
        } while (!textScanner.empty());
        return arrayList;
    }

    private static SVG.Length parseFontSize(String str) {
        try {
            SVG.Length length = FontSizeKeywords.get(str);
            return length == null ? parseLength(str) : length;
        } catch (SVGParseException unused) {
            return null;
        }
    }

    private static SVG.Style.FontStyle parseFontStyle(String str) {
        str.hashCode();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1657669071:
                if (str.equals("oblique")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1178781136:
                if (str.equals("italic")) {
                    c5 = 1;
                    break;
                }
                break;
            case -1039745817:
                if (str.equals(Constants.NORMAL)) {
                    c5 = 2;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                return SVG.Style.FontStyle.Oblique;
            case 1:
                return SVG.Style.FontStyle.Italic;
            case 2:
                return SVG.Style.FontStyle.Normal;
            default:
                return null;
        }
    }

    private static Integer parseFontWeight(String str) {
        return FontWeightKeywords.get(str);
    }

    private static String parseFunctionalIRI(String str, String str2) {
        if (!str.equals(NONE) && str.startsWith("url(")) {
            return str.endsWith(")") ? str.substring(4, str.length() - 1).trim() : str.substring(4).trim();
        }
        return null;
    }

    private Float parseGradientOffset(String str) {
        if (str.length() == 0) {
            throw new SVGParseException("Invalid offset value in <stop> (empty string)");
        }
        int length = str.length();
        boolean z5 = true;
        if (str.charAt(str.length() - 1) == '%') {
            length--;
        } else {
            z5 = false;
        }
        try {
            float parseFloat = parseFloat(str, 0, length);
            float f5 = 100.0f;
            if (z5) {
                parseFloat /= 100.0f;
            }
            if (parseFloat < 0.0f) {
                f5 = 0.0f;
            } else if (parseFloat <= 100.0f) {
                f5 = parseFloat;
            }
            return Float.valueOf(f5);
        } catch (NumberFormatException e5) {
            throw new SVGParseException("Invalid offset value in <stop>: " + str, e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SVG.Length parseLength(String str) {
        if (str.length() == 0) {
            throw new SVGParseException("Invalid length value (empty string)");
        }
        int length = str.length();
        SVG.Unit unit = SVG.Unit.px;
        char charAt = str.charAt(length - 1);
        if (charAt == '%') {
            length--;
            unit = SVG.Unit.percent;
        } else if (length > 2 && Character.isLetter(charAt) && Character.isLetter(str.charAt(length - 2))) {
            length -= 2;
            try {
                unit = SVG.Unit.valueOf(str.substring(length).toLowerCase(Locale.US));
            } catch (IllegalArgumentException unused) {
                throw new SVGParseException("Invalid length unit specifier: " + str);
            }
        }
        try {
            return new SVG.Length(parseFloat(str, 0, length), unit);
        } catch (NumberFormatException e5) {
            throw new SVGParseException("Invalid length value: " + str, e5);
        }
    }

    private static List<SVG.Length> parseLengthList(String str) {
        if (str.length() == 0) {
            throw new SVGParseException("Invalid length list (empty string)");
        }
        ArrayList arrayList = new ArrayList(1);
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        while (!textScanner.empty()) {
            float nextFloat = textScanner.nextFloat();
            if (Float.isNaN(nextFloat)) {
                throw new SVGParseException("Invalid length list value: " + textScanner.ahead());
            }
            SVG.Unit nextUnit = textScanner.nextUnit();
            if (nextUnit == null) {
                nextUnit = SVG.Unit.px;
            }
            arrayList.add(new SVG.Length(nextFloat, nextUnit));
            textScanner.skipCommaWhitespace();
        }
        return arrayList;
    }

    private static SVG.Length parseLengthOrAuto(TextScanner textScanner) {
        return textScanner.consume("auto") ? new SVG.Length(0.0f) : textScanner.nextLength();
    }

    private static Float parseOpacity(String str) {
        try {
            float parseFloat = parseFloat(str);
            float f5 = 0.0f;
            if (parseFloat >= 0.0f) {
                f5 = 1.0f;
                if (parseFloat > 1.0f) {
                }
                return Float.valueOf(parseFloat);
            }
            parseFloat = f5;
            return Float.valueOf(parseFloat);
        } catch (SVGParseException unused) {
            return null;
        }
    }

    private static Boolean parseOverflow(String str) {
        str.hashCode();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1217487446:
                if (str.equals("hidden")) {
                    c5 = 0;
                    break;
                }
                break;
            case -907680051:
                if (str.equals("scroll")) {
                    c5 = 1;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    c5 = 2;
                    break;
                }
                break;
            case 466743410:
                if (str.equals("visible")) {
                    c5 = 3;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
            case 1:
                return Boolean.FALSE;
            case 2:
            case 3:
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    private static SVG.SvgPaint parsePaintSpecifier(String str) {
        if (!str.startsWith("url(")) {
            return parseColourSpecifer(str);
        }
        int indexOf = str.indexOf(")");
        if (indexOf == -1) {
            return new SVG.PaintReference(str.substring(4).trim(), null);
        }
        String trim = str.substring(4, indexOf).trim();
        String trim2 = str.substring(indexOf + 1).trim();
        return new SVG.PaintReference(trim, trim2.length() > 0 ? parseColourSpecifer(trim2) : null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x02a4, code lost:
    
        return r9;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0038. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:17:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x027b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static SVG.PathDefinition parsePath(String str) {
        float checkedNextFloat;
        float checkedNextFloat2;
        float f5;
        float f6;
        TextScanner textScanner = new TextScanner(str);
        SVG.PathDefinition pathDefinition = new SVG.PathDefinition();
        if (textScanner.empty()) {
            return pathDefinition;
        }
        int intValue = textScanner.nextChar().intValue();
        int i5 = 109;
        if (intValue != 77 && intValue != 109) {
            return pathDefinition;
        }
        int i6 = intValue;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        while (true) {
            textScanner.skipWhitespace();
            switch (i6) {
                case 65:
                case 97:
                    float nextFloat = textScanner.nextFloat();
                    float checkedNextFloat3 = textScanner.checkedNextFloat(nextFloat);
                    float checkedNextFloat4 = textScanner.checkedNextFloat(checkedNextFloat3);
                    Boolean checkedNextFlag = textScanner.checkedNextFlag(Float.valueOf(checkedNextFloat4));
                    Boolean checkedNextFlag2 = textScanner.checkedNextFlag(checkedNextFlag);
                    float checkedNextFloat5 = textScanner.checkedNextFloat(checkedNextFlag2);
                    float checkedNextFloat6 = textScanner.checkedNextFloat(checkedNextFloat5);
                    if (!Float.isNaN(checkedNextFloat6) && nextFloat >= 0.0f && checkedNextFloat3 >= 0.0f) {
                        if (i6 == 97) {
                            checkedNextFloat5 += f7;
                            checkedNextFloat6 += f9;
                        }
                        pathDefinition.arcTo(nextFloat, checkedNextFloat3, checkedNextFloat4, checkedNextFlag.booleanValue(), checkedNextFlag2.booleanValue(), checkedNextFloat5, checkedNextFloat6);
                        f7 = checkedNextFloat5;
                        f8 = f7;
                        f9 = checkedNextFloat6;
                        f10 = f9;
                        textScanner.skipCommaWhitespace();
                        if (!textScanner.empty()) {
                            return pathDefinition;
                        }
                        if (textScanner.hasLetter()) {
                            i6 = textScanner.nextChar().intValue();
                        }
                        i5 = 109;
                    }
                    break;
                case 67:
                case 99:
                    float nextFloat2 = textScanner.nextFloat();
                    float checkedNextFloat7 = textScanner.checkedNextFloat(nextFloat2);
                    float checkedNextFloat8 = textScanner.checkedNextFloat(checkedNextFloat7);
                    float checkedNextFloat9 = textScanner.checkedNextFloat(checkedNextFloat8);
                    checkedNextFloat = textScanner.checkedNextFloat(checkedNextFloat9);
                    checkedNextFloat2 = textScanner.checkedNextFloat(checkedNextFloat);
                    if (Float.isNaN(checkedNextFloat2)) {
                        Log.e(TAG, "Bad path coords for " + ((char) i6) + " path segment");
                        return pathDefinition;
                    }
                    if (i6 == 99) {
                        checkedNextFloat += f7;
                        checkedNextFloat2 += f9;
                        nextFloat2 += f7;
                        checkedNextFloat7 += f9;
                        checkedNextFloat8 += f7;
                        checkedNextFloat9 += f9;
                    }
                    f5 = checkedNextFloat8;
                    f6 = checkedNextFloat9;
                    pathDefinition.cubicTo(nextFloat2, checkedNextFloat7, f5, f6, checkedNextFloat, checkedNextFloat2);
                    f8 = f5;
                    f7 = checkedNextFloat;
                    f10 = f6;
                    f9 = checkedNextFloat2;
                    textScanner.skipCommaWhitespace();
                    if (!textScanner.empty()) {
                    }
                    break;
                case 72:
                case 104:
                    float nextFloat3 = textScanner.nextFloat();
                    if (Float.isNaN(nextFloat3)) {
                        Log.e(TAG, "Bad path coords for " + ((char) i6) + " path segment");
                        return pathDefinition;
                    }
                    if (i6 == 104) {
                        nextFloat3 += f7;
                    }
                    f7 = nextFloat3;
                    pathDefinition.lineTo(f7, f9);
                    f8 = f7;
                    textScanner.skipCommaWhitespace();
                    if (!textScanner.empty()) {
                    }
                    break;
                case 76:
                case 108:
                    float nextFloat4 = textScanner.nextFloat();
                    float checkedNextFloat10 = textScanner.checkedNextFloat(nextFloat4);
                    if (Float.isNaN(checkedNextFloat10)) {
                        Log.e(TAG, "Bad path coords for " + ((char) i6) + " path segment");
                        return pathDefinition;
                    }
                    if (i6 == 108) {
                        nextFloat4 += f7;
                        checkedNextFloat10 += f9;
                    }
                    f7 = nextFloat4;
                    f9 = checkedNextFloat10;
                    pathDefinition.lineTo(f7, f9);
                    f8 = f7;
                    f10 = f9;
                    textScanner.skipCommaWhitespace();
                    if (!textScanner.empty()) {
                    }
                    break;
                case 77:
                case 109:
                    float nextFloat5 = textScanner.nextFloat();
                    float checkedNextFloat11 = textScanner.checkedNextFloat(nextFloat5);
                    if (Float.isNaN(checkedNextFloat11)) {
                        Log.e(TAG, "Bad path coords for " + ((char) i6) + " path segment");
                        return pathDefinition;
                    }
                    if (i6 == i5 && !pathDefinition.isEmpty()) {
                        nextFloat5 += f7;
                        checkedNextFloat11 += f9;
                    }
                    f7 = nextFloat5;
                    f9 = checkedNextFloat11;
                    pathDefinition.moveTo(f7, f9);
                    f8 = f7;
                    f11 = f8;
                    f10 = f9;
                    f12 = f10;
                    i6 = i6 != i5 ? 76 : 108;
                    textScanner.skipCommaWhitespace();
                    if (!textScanner.empty()) {
                    }
                    break;
                case 81:
                case 113:
                    f8 = textScanner.nextFloat();
                    f10 = textScanner.checkedNextFloat(f8);
                    float checkedNextFloat12 = textScanner.checkedNextFloat(f10);
                    float checkedNextFloat13 = textScanner.checkedNextFloat(checkedNextFloat12);
                    if (Float.isNaN(checkedNextFloat13)) {
                        Log.e(TAG, "Bad path coords for " + ((char) i6) + " path segment");
                        return pathDefinition;
                    }
                    if (i6 == 113) {
                        checkedNextFloat12 += f7;
                        checkedNextFloat13 += f9;
                        f8 += f7;
                        f10 += f9;
                    }
                    f7 = checkedNextFloat12;
                    f9 = checkedNextFloat13;
                    pathDefinition.quadTo(f8, f10, f7, f9);
                    textScanner.skipCommaWhitespace();
                    if (!textScanner.empty()) {
                    }
                    break;
                case 83:
                case 115:
                    float f13 = (f7 * 2.0f) - f8;
                    float f14 = (2.0f * f9) - f10;
                    float nextFloat6 = textScanner.nextFloat();
                    float checkedNextFloat14 = textScanner.checkedNextFloat(nextFloat6);
                    checkedNextFloat = textScanner.checkedNextFloat(checkedNextFloat14);
                    checkedNextFloat2 = textScanner.checkedNextFloat(checkedNextFloat);
                    if (Float.isNaN(checkedNextFloat2)) {
                        Log.e(TAG, "Bad path coords for " + ((char) i6) + " path segment");
                        return pathDefinition;
                    }
                    if (i6 == 115) {
                        checkedNextFloat += f7;
                        checkedNextFloat2 += f9;
                        nextFloat6 += f7;
                        checkedNextFloat14 += f9;
                    }
                    f5 = nextFloat6;
                    f6 = checkedNextFloat14;
                    pathDefinition.cubicTo(f13, f14, f5, f6, checkedNextFloat, checkedNextFloat2);
                    f8 = f5;
                    f7 = checkedNextFloat;
                    f10 = f6;
                    f9 = checkedNextFloat2;
                    textScanner.skipCommaWhitespace();
                    if (!textScanner.empty()) {
                    }
                    break;
                case 84:
                case 116:
                    f8 = (f7 * 2.0f) - f8;
                    f10 = (2.0f * f9) - f10;
                    float nextFloat7 = textScanner.nextFloat();
                    float checkedNextFloat15 = textScanner.checkedNextFloat(nextFloat7);
                    if (Float.isNaN(checkedNextFloat15)) {
                        Log.e(TAG, "Bad path coords for " + ((char) i6) + " path segment");
                        return pathDefinition;
                    }
                    if (i6 == 116) {
                        nextFloat7 += f7;
                        checkedNextFloat15 += f9;
                    }
                    f7 = nextFloat7;
                    f9 = checkedNextFloat15;
                    pathDefinition.quadTo(f8, f10, f7, f9);
                    textScanner.skipCommaWhitespace();
                    if (!textScanner.empty()) {
                    }
                    break;
                case 86:
                case 118:
                    float nextFloat8 = textScanner.nextFloat();
                    if (Float.isNaN(nextFloat8)) {
                        Log.e(TAG, "Bad path coords for " + ((char) i6) + " path segment");
                        return pathDefinition;
                    }
                    if (i6 == 118) {
                        nextFloat8 += f9;
                    }
                    f9 = nextFloat8;
                    pathDefinition.lineTo(f7, f9);
                    f10 = f9;
                    textScanner.skipCommaWhitespace();
                    if (!textScanner.empty()) {
                    }
                    break;
                case 90:
                case 122:
                    pathDefinition.close();
                    f7 = f11;
                    f8 = f7;
                    f9 = f12;
                    f10 = f9;
                    textScanner.skipCommaWhitespace();
                    if (!textScanner.empty()) {
                    }
                    break;
                default:
                    return pathDefinition;
            }
        }
    }

    private static void parsePreserveAspectRatio(SVG.SvgPreserveAspectRatioContainer svgPreserveAspectRatioContainer, String str) {
        svgPreserveAspectRatioContainer.preserveAspectRatio = parsePreserveAspectRatio(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> parseProcessingInstructionAttributes(TextScanner textScanner) {
        HashMap hashMap = new HashMap();
        textScanner.skipWhitespace();
        String nextToken = textScanner.nextToken('=');
        while (nextToken != null) {
            textScanner.consume('=');
            hashMap.put(nextToken, textScanner.nextQuotedString());
            textScanner.skipWhitespace();
            nextToken = textScanner.nextToken('=');
        }
        return hashMap;
    }

    private static SVG.Style.RenderQuality parseRenderQuality(String str) {
        str.hashCode();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -933002398:
                if (str.equals("optimizeQuality")) {
                    c5 = 0;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    c5 = 1;
                    break;
                }
                break;
            case 362741610:
                if (str.equals("optimizeSpeed")) {
                    c5 = 2;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                return SVG.Style.RenderQuality.optimizeQuality;
            case 1:
                return SVG.Style.RenderQuality.auto;
            case 2:
                return SVG.Style.RenderQuality.optimizeSpeed;
            default:
                return null;
        }
    }

    private static Set<String> parseRequiredFeatures(String str) {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.empty()) {
            String nextToken = textScanner.nextToken();
            if (nextToken.startsWith(FEATURE_STRING_PREFIX)) {
                hashSet.add(nextToken.substring(35));
            } else {
                hashSet.add("UNSUPPORTED");
            }
            textScanner.skipWhitespace();
        }
        return hashSet;
    }

    private static Set<String> parseRequiredFormats(String str) {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.empty()) {
            hashSet.add(textScanner.nextToken());
            textScanner.skipWhitespace();
        }
        return hashSet;
    }

    private static SVG.Length[] parseStrokeDashArray(String str) {
        SVG.Length nextLength;
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        if (textScanner.empty() || (nextLength = textScanner.nextLength()) == null || nextLength.isNegative()) {
            return null;
        }
        float floatValue = nextLength.floatValue();
        ArrayList arrayList = new ArrayList();
        arrayList.add(nextLength);
        while (!textScanner.empty()) {
            textScanner.skipCommaWhitespace();
            SVG.Length nextLength2 = textScanner.nextLength();
            if (nextLength2 == null || nextLength2.isNegative()) {
                return null;
            }
            arrayList.add(nextLength2);
            floatValue += nextLength2.floatValue();
        }
        if (floatValue == 0.0f) {
            return null;
        }
        return (SVG.Length[]) arrayList.toArray(new SVG.Length[arrayList.size()]);
    }

    private static SVG.Style.LineCap parseStrokeLineCap(String str) {
        if ("butt".equals(str)) {
            return SVG.Style.LineCap.Butt;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineCap.Round;
        }
        if ("square".equals(str)) {
            return SVG.Style.LineCap.Square;
        }
        return null;
    }

    private static SVG.Style.LineJoin parseStrokeLineJoin(String str) {
        if ("miter".equals(str)) {
            return SVG.Style.LineJoin.Miter;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineJoin.Round;
        }
        if ("bevel".equals(str)) {
            return SVG.Style.LineJoin.Bevel;
        }
        return null;
    }

    private static void parseStyle(SVG.SvgElementBase svgElementBase, String str) {
        TextScanner textScanner = new TextScanner(str.replaceAll("/\\*.*?\\*/", BuildConfig.FLAVOR));
        while (true) {
            String nextToken = textScanner.nextToken(':');
            textScanner.skipWhitespace();
            if (!textScanner.consume(':')) {
                return;
            }
            textScanner.skipWhitespace();
            String nextTokenWithWhitespace = textScanner.nextTokenWithWhitespace(';');
            if (nextTokenWithWhitespace == null) {
                return;
            }
            textScanner.skipWhitespace();
            if (textScanner.empty() || textScanner.consume(';')) {
                if (svgElementBase.style == null) {
                    svgElementBase.style = new SVG.Style();
                }
                processStyleProperty(svgElementBase.style, nextToken, nextTokenWithWhitespace);
                textScanner.skipWhitespace();
            }
        }
    }

    private static Set<String> parseSystemLanguage(String str) {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.empty()) {
            String nextToken = textScanner.nextToken();
            int indexOf = nextToken.indexOf(45);
            if (indexOf != -1) {
                nextToken = nextToken.substring(0, indexOf);
            }
            hashSet.add(new Locale(nextToken, BuildConfig.FLAVOR, BuildConfig.FLAVOR).getLanguage());
            textScanner.skipWhitespace();
        }
        return hashSet;
    }

    private static SVG.Style.TextAnchor parseTextAnchor(String str) {
        str.hashCode();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1074341483:
                if (str.equals("middle")) {
                    c5 = 0;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c5 = 1;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c5 = 2;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                return SVG.Style.TextAnchor.Middle;
            case 1:
                return SVG.Style.TextAnchor.End;
            case 2:
                return SVG.Style.TextAnchor.Start;
            default:
                return null;
        }
    }

    private static SVG.Style.TextDecoration parseTextDecoration(String str) {
        str.hashCode();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1171789332:
                if (str.equals("line-through")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1026963764:
                if (str.equals("underline")) {
                    c5 = 1;
                    break;
                }
                break;
            case 3387192:
                if (str.equals(NONE)) {
                    c5 = 2;
                    break;
                }
                break;
            case 93826908:
                if (str.equals("blink")) {
                    c5 = 3;
                    break;
                }
                break;
            case 529818312:
                if (str.equals("overline")) {
                    c5 = 4;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                return SVG.Style.TextDecoration.LineThrough;
            case 1:
                return SVG.Style.TextDecoration.Underline;
            case 2:
                return SVG.Style.TextDecoration.None;
            case 3:
                return SVG.Style.TextDecoration.Blink;
            case 4:
                return SVG.Style.TextDecoration.Overline;
            default:
                return null;
        }
    }

    private static SVG.Style.TextDirection parseTextDirection(String str) {
        str.hashCode();
        if (str.equals("ltr")) {
            return SVG.Style.TextDirection.LTR;
        }
        if (str.equals("rtl")) {
            return SVG.Style.TextDirection.RTL;
        }
        return null;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x002b. Please report as an issue. */
    private Matrix parseTransformList(String str) {
        Matrix matrix = new Matrix();
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        while (!textScanner.empty()) {
            String nextFunction = textScanner.nextFunction();
            if (nextFunction == null) {
                throw new SVGParseException("Bad transform function encountered in transform list: " + str);
            }
            char c5 = 65535;
            switch (nextFunction.hashCode()) {
                case -1081239615:
                    if (nextFunction.equals("matrix")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -925180581:
                    if (nextFunction.equals("rotate")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 109250890:
                    if (nextFunction.equals("scale")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 109493390:
                    if (nextFunction.equals("skewX")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 109493391:
                    if (nextFunction.equals("skewY")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case 1052832078:
                    if (nextFunction.equals("translate")) {
                        c5 = 5;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    textScanner.skipWhitespace();
                    float nextFloat = textScanner.nextFloat();
                    textScanner.skipCommaWhitespace();
                    float nextFloat2 = textScanner.nextFloat();
                    textScanner.skipCommaWhitespace();
                    float nextFloat3 = textScanner.nextFloat();
                    textScanner.skipCommaWhitespace();
                    float nextFloat4 = textScanner.nextFloat();
                    textScanner.skipCommaWhitespace();
                    float nextFloat5 = textScanner.nextFloat();
                    textScanner.skipCommaWhitespace();
                    float nextFloat6 = textScanner.nextFloat();
                    textScanner.skipWhitespace();
                    if (!Float.isNaN(nextFloat6) && textScanner.consume(')')) {
                        Matrix matrix2 = new Matrix();
                        matrix2.setValues(new float[]{nextFloat, nextFloat3, nextFloat5, nextFloat2, nextFloat4, nextFloat6, 0.0f, 0.0f, 1.0f});
                        matrix.preConcat(matrix2);
                        break;
                    } else {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    break;
                case 1:
                    textScanner.skipWhitespace();
                    float nextFloat7 = textScanner.nextFloat();
                    float possibleNextFloat = textScanner.possibleNextFloat();
                    float possibleNextFloat2 = textScanner.possibleNextFloat();
                    textScanner.skipWhitespace();
                    if (Float.isNaN(nextFloat7) || !textScanner.consume(')')) {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    if (Float.isNaN(possibleNextFloat)) {
                        matrix.preRotate(nextFloat7);
                        break;
                    } else if (!Float.isNaN(possibleNextFloat2)) {
                        matrix.preRotate(nextFloat7, possibleNextFloat, possibleNextFloat2);
                        break;
                    } else {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                case 2:
                    textScanner.skipWhitespace();
                    float nextFloat8 = textScanner.nextFloat();
                    float possibleNextFloat3 = textScanner.possibleNextFloat();
                    textScanner.skipWhitespace();
                    if (!Float.isNaN(nextFloat8) && textScanner.consume(')')) {
                        if (!Float.isNaN(possibleNextFloat3)) {
                            matrix.preScale(nextFloat8, possibleNextFloat3);
                            break;
                        } else {
                            matrix.preScale(nextFloat8, nextFloat8);
                            break;
                        }
                    } else {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    break;
                case 3:
                    textScanner.skipWhitespace();
                    float nextFloat9 = textScanner.nextFloat();
                    textScanner.skipWhitespace();
                    if (!Float.isNaN(nextFloat9) && textScanner.consume(')')) {
                        matrix.preSkew((float) Math.tan(Math.toRadians(nextFloat9)), 0.0f);
                        break;
                    } else {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                case 4:
                    textScanner.skipWhitespace();
                    float nextFloat10 = textScanner.nextFloat();
                    textScanner.skipWhitespace();
                    if (!Float.isNaN(nextFloat10) && textScanner.consume(')')) {
                        matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians(nextFloat10)));
                        break;
                    } else {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    break;
                case 5:
                    textScanner.skipWhitespace();
                    float nextFloat11 = textScanner.nextFloat();
                    float possibleNextFloat4 = textScanner.possibleNextFloat();
                    textScanner.skipWhitespace();
                    if (!Float.isNaN(nextFloat11) && textScanner.consume(')')) {
                        if (!Float.isNaN(possibleNextFloat4)) {
                            matrix.preTranslate(nextFloat11, possibleNextFloat4);
                            break;
                        } else {
                            matrix.preTranslate(nextFloat11, 0.0f);
                            break;
                        }
                    } else {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    break;
                default:
                    throw new SVGParseException("Invalid transform list fn: " + nextFunction + ")");
            }
            if (textScanner.empty()) {
                return matrix;
            }
            textScanner.skipCommaWhitespace();
        }
        return matrix;
    }

    private void parseUsingSAX(InputStream inputStream) {
        Log.d(TAG, "Falling back to SAX parser");
        try {
            SAXParserFactory newInstance = SAXParserFactory.newInstance();
            newInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
            newInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            XMLReader xMLReader = newInstance.newSAXParser().getXMLReader();
            SAXHandler sAXHandler = new SAXHandler(this, null);
            xMLReader.setContentHandler(sAXHandler);
            xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", sAXHandler);
            xMLReader.parse(new InputSource(inputStream));
        } catch (IOException e5) {
            throw new SVGParseException("Stream error", e5);
        } catch (ParserConfigurationException e6) {
            throw new SVGParseException("XML parser problem", e6);
        } catch (SAXException e7) {
            throw new SVGParseException("SVG parse error", e7);
        }
    }

    private void parseUsingXmlPullParser(InputStream inputStream, boolean z5) {
        try {
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                XPPAttributesWrapper xPPAttributesWrapper = new XPPAttributesWrapper(newPullParser);
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", false);
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                newPullParser.setInput(inputStream, null);
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.nextToken()) {
                    if (eventType == 0) {
                        startDocument();
                    } else if (eventType == 8) {
                        Log.d(TAG, "PROC INSTR: " + newPullParser.getText());
                        TextScanner textScanner = new TextScanner(newPullParser.getText());
                        handleProcessingInstruction(textScanner.nextToken(), parseProcessingInstructionAttributes(textScanner));
                    } else if (eventType != 10) {
                        if (eventType == 2) {
                            String name = newPullParser.getName();
                            if (newPullParser.getPrefix() != null) {
                                name = newPullParser.getPrefix() + ':' + name;
                            }
                            startElement(newPullParser.getNamespace(), newPullParser.getName(), name, xPPAttributesWrapper);
                        } else if (eventType == 3) {
                            String name2 = newPullParser.getName();
                            if (newPullParser.getPrefix() != null) {
                                name2 = newPullParser.getPrefix() + ':' + name2;
                            }
                            endElement(newPullParser.getNamespace(), newPullParser.getName(), name2);
                        } else if (eventType == 4) {
                            int[] iArr = new int[2];
                            text(newPullParser.getTextCharacters(iArr), iArr[0], iArr[1]);
                        } else if (eventType == 5) {
                            text(newPullParser.getText());
                        }
                    } else if (z5 && this.svgDocument.getRootElement() == null && newPullParser.getText().contains("<!ENTITY ")) {
                        try {
                            Log.d(TAG, "Switching to SAX parser to process entities");
                            inputStream.reset();
                            parseUsingSAX(inputStream);
                            return;
                        } catch (IOException unused) {
                            Log.w(TAG, "Detected internal entity definitions, but could not parse them.");
                            return;
                        }
                    }
                }
                endDocument();
            } catch (IOException e5) {
                throw new SVGParseException("Stream error", e5);
            }
        } catch (XmlPullParserException e6) {
            throw new SVGParseException("XML parser problem", e6);
        }
    }

    private static SVG.Style.VectorEffect parseVectorEffect(String str) {
        str.hashCode();
        if (str.equals(NONE)) {
            return SVG.Style.VectorEffect.None;
        }
        if (str.equals("non-scaling-stroke")) {
            return SVG.Style.VectorEffect.NonScalingStroke;
        }
        return null;
    }

    private static SVG.Box parseViewBox(String str) {
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        float nextFloat = textScanner.nextFloat();
        textScanner.skipCommaWhitespace();
        float nextFloat2 = textScanner.nextFloat();
        textScanner.skipCommaWhitespace();
        float nextFloat3 = textScanner.nextFloat();
        textScanner.skipCommaWhitespace();
        float nextFloat4 = textScanner.nextFloat();
        if (Float.isNaN(nextFloat) || Float.isNaN(nextFloat2) || Float.isNaN(nextFloat3) || Float.isNaN(nextFloat4)) {
            throw new SVGParseException("Invalid viewBox definition - should have four numbers");
        }
        if (nextFloat3 < 0.0f) {
            throw new SVGParseException("Invalid viewBox. width cannot be negative");
        }
        if (nextFloat4 >= 0.0f) {
            return new SVG.Box(nextFloat, nextFloat2, nextFloat3, nextFloat4);
        }
        throw new SVGParseException("Invalid viewBox. height cannot be negative");
    }

    private void path(Attributes attributes) {
        debug("<path>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Path path = new SVG.Path();
        path.document = this.svgDocument;
        path.parent = this.currentElement;
        parseAttributesCore(path, attributes);
        parseAttributesStyle(path, attributes);
        parseAttributesTransform(path, attributes);
        parseAttributesConditional(path, attributes);
        parseAttributesPath(path, attributes);
        this.currentElement.addChild(path);
    }

    private void pattern(Attributes attributes) {
        debug("<pattern>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Pattern pattern = new SVG.Pattern();
        pattern.document = this.svgDocument;
        pattern.parent = this.currentElement;
        parseAttributesCore(pattern, attributes);
        parseAttributesStyle(pattern, attributes);
        parseAttributesConditional(pattern, attributes);
        parseAttributesViewBox(pattern, attributes);
        parseAttributesPattern(pattern, attributes);
        this.currentElement.addChild(pattern);
        this.currentElement = pattern;
    }

    private void polygon(Attributes attributes) {
        debug("<polygon>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.PolyLine polygon = new SVG.Polygon();
        polygon.document = this.svgDocument;
        polygon.parent = this.currentElement;
        parseAttributesCore(polygon, attributes);
        parseAttributesStyle(polygon, attributes);
        parseAttributesTransform(polygon, attributes);
        parseAttributesConditional(polygon, attributes);
        parseAttributesPolyLine(polygon, attributes, "polygon");
        this.currentElement.addChild(polygon);
    }

    private void polyline(Attributes attributes) {
        debug("<polyline>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.PolyLine polyLine = new SVG.PolyLine();
        polyLine.document = this.svgDocument;
        polyLine.parent = this.currentElement;
        parseAttributesCore(polyLine, attributes);
        parseAttributesStyle(polyLine, attributes);
        parseAttributesTransform(polyLine, attributes);
        parseAttributesConditional(polyLine, attributes);
        parseAttributesPolyLine(polyLine, attributes, "polyline");
        this.currentElement.addChild(polyLine);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void processStyleProperty(SVG.Style style, String str, String str2) {
        if (str2.length() == 0 || str2.equals("inherit")) {
            return;
        }
        try {
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(str).ordinal()]) {
                case 47:
                    SVG.SvgPaint parsePaintSpecifier = parsePaintSpecifier(str2);
                    style.fill = parsePaintSpecifier;
                    if (parsePaintSpecifier != null) {
                        style.specifiedFlags |= 1;
                        return;
                    }
                    return;
                case 48:
                    SVG.Style.FillRule parseFillRule = parseFillRule(str2);
                    style.fillRule = parseFillRule;
                    if (parseFillRule != null) {
                        style.specifiedFlags |= 2;
                        return;
                    }
                    return;
                case 49:
                    Float parseOpacity = parseOpacity(str2);
                    style.fillOpacity = parseOpacity;
                    if (parseOpacity != null) {
                        style.specifiedFlags |= 4;
                        return;
                    }
                    return;
                case 50:
                    SVG.SvgPaint parsePaintSpecifier2 = parsePaintSpecifier(str2);
                    style.stroke = parsePaintSpecifier2;
                    if (parsePaintSpecifier2 != null) {
                        style.specifiedFlags |= 8;
                        return;
                    }
                    return;
                case 51:
                    Float parseOpacity2 = parseOpacity(str2);
                    style.strokeOpacity = parseOpacity2;
                    if (parseOpacity2 != null) {
                        style.specifiedFlags |= 16;
                        return;
                    }
                    return;
                case 52:
                    style.strokeWidth = parseLength(str2);
                    style.specifiedFlags |= 32;
                    break;
                case 53:
                    SVG.Style.LineCap parseStrokeLineCap = parseStrokeLineCap(str2);
                    style.strokeLineCap = parseStrokeLineCap;
                    if (parseStrokeLineCap != null) {
                        style.specifiedFlags |= 64;
                        return;
                    }
                    return;
                case 54:
                    SVG.Style.LineJoin parseStrokeLineJoin = parseStrokeLineJoin(str2);
                    style.strokeLineJoin = parseStrokeLineJoin;
                    if (parseStrokeLineJoin != null) {
                        style.specifiedFlags |= 128;
                        return;
                    }
                    return;
                case 55:
                    style.strokeMiterLimit = Float.valueOf(parseFloat(str2));
                    style.specifiedFlags |= 256;
                    break;
                case 56:
                    if (NONE.equals(str2)) {
                        style.strokeDashArray = null;
                        style.specifiedFlags |= 512;
                        return;
                    }
                    SVG.Length[] parseStrokeDashArray = parseStrokeDashArray(str2);
                    style.strokeDashArray = parseStrokeDashArray;
                    if (parseStrokeDashArray != null) {
                        style.specifiedFlags |= 512;
                        return;
                    }
                    return;
                case 57:
                    style.strokeDashOffset = parseLength(str2);
                    style.specifiedFlags |= 1024;
                    break;
                case 58:
                    style.opacity = parseOpacity(str2);
                    style.specifiedFlags |= 2048;
                    return;
                case 59:
                    style.color = parseColour(str2);
                    style.specifiedFlags |= 4096;
                    break;
                case 60:
                    parseFont(style, str2);
                    return;
                case 61:
                    List<String> parseFontFamily = parseFontFamily(str2);
                    style.fontFamily = parseFontFamily;
                    if (parseFontFamily != null) {
                        style.specifiedFlags |= 8192;
                        return;
                    }
                    return;
                case 62:
                    SVG.Length parseFontSize = parseFontSize(str2);
                    style.fontSize = parseFontSize;
                    if (parseFontSize != null) {
                        style.specifiedFlags |= 16384;
                        return;
                    }
                    return;
                case Function.ALT_CONVENTION /* 63 */:
                    Integer parseFontWeight = parseFontWeight(str2);
                    style.fontWeight = parseFontWeight;
                    if (parseFontWeight != null) {
                        style.specifiedFlags |= 32768;
                        return;
                    }
                    return;
                case Function.THROW_LAST_ERROR /* 64 */:
                    SVG.Style.FontStyle parseFontStyle = parseFontStyle(str2);
                    style.fontStyle = parseFontStyle;
                    if (parseFontStyle != null) {
                        style.specifiedFlags |= 65536;
                        return;
                    }
                    return;
                case 65:
                    SVG.Style.TextDecoration parseTextDecoration = parseTextDecoration(str2);
                    style.textDecoration = parseTextDecoration;
                    if (parseTextDecoration != null) {
                        style.specifiedFlags |= 131072;
                        return;
                    }
                    return;
                case 66:
                    SVG.Style.TextDirection parseTextDirection = parseTextDirection(str2);
                    style.direction = parseTextDirection;
                    if (parseTextDirection != null) {
                        style.specifiedFlags |= 68719476736L;
                        return;
                    }
                    return;
                case 67:
                    SVG.Style.TextAnchor parseTextAnchor = parseTextAnchor(str2);
                    style.textAnchor = parseTextAnchor;
                    if (parseTextAnchor != null) {
                        style.specifiedFlags |= 262144;
                        return;
                    }
                    return;
                case 68:
                    Boolean parseOverflow = parseOverflow(str2);
                    style.overflow = parseOverflow;
                    if (parseOverflow != null) {
                        style.specifiedFlags |= 524288;
                        return;
                    }
                    return;
                case 69:
                    String parseFunctionalIRI = parseFunctionalIRI(str2, str);
                    style.markerStart = parseFunctionalIRI;
                    style.markerMid = parseFunctionalIRI;
                    style.markerEnd = parseFunctionalIRI;
                    style.specifiedFlags |= 14680064;
                    return;
                case 70:
                    style.markerStart = parseFunctionalIRI(str2, str);
                    style.specifiedFlags |= 2097152;
                    return;
                case 71:
                    style.markerMid = parseFunctionalIRI(str2, str);
                    style.specifiedFlags |= 4194304;
                    return;
                case 72:
                    style.markerEnd = parseFunctionalIRI(str2, str);
                    style.specifiedFlags |= 8388608;
                    return;
                case 73:
                    if (str2.indexOf(124) < 0) {
                        if (VALID_DISPLAY_VALUES.contains('|' + str2 + '|')) {
                            style.display = Boolean.valueOf(!str2.equals(NONE));
                            style.specifiedFlags |= 16777216;
                            return;
                        }
                        return;
                    }
                    return;
                case 74:
                    if (str2.indexOf(124) < 0) {
                        if (VALID_VISIBILITY_VALUES.contains('|' + str2 + '|')) {
                            style.visibility = Boolean.valueOf(str2.equals("visible"));
                            style.specifiedFlags |= 33554432;
                            return;
                        }
                        return;
                    }
                    return;
                case 75:
                    if (str2.equals(CURRENTCOLOR)) {
                        style.stopColor = SVG.CurrentColor.getInstance();
                    } else {
                        try {
                            style.stopColor = parseColour(str2);
                        } catch (SVGParseException e5) {
                            Log.w(TAG, e5.getMessage());
                            return;
                        }
                    }
                    style.specifiedFlags |= 67108864;
                    return;
                case 76:
                    style.stopOpacity = parseOpacity(str2);
                    style.specifiedFlags |= 134217728;
                    return;
                case 77:
                    SVG.CSSClipRect parseClip = parseClip(str2);
                    style.clip = parseClip;
                    if (parseClip != null) {
                        style.specifiedFlags |= 1048576;
                        return;
                    }
                    return;
                case 78:
                    style.clipPath = parseFunctionalIRI(str2, str);
                    style.specifiedFlags |= 268435456;
                    return;
                case 79:
                    style.clipRule = parseFillRule(str2);
                    style.specifiedFlags |= 536870912;
                    return;
                case 80:
                    style.mask = parseFunctionalIRI(str2, str);
                    style.specifiedFlags |= 1073741824;
                    return;
                case 81:
                    if (str2.equals(CURRENTCOLOR)) {
                        style.solidColor = SVG.CurrentColor.getInstance();
                    } else {
                        try {
                            style.solidColor = parseColour(str2);
                        } catch (SVGParseException e6) {
                            Log.w(TAG, e6.getMessage());
                            return;
                        }
                    }
                    style.specifiedFlags |= 2147483648L;
                    return;
                case 82:
                    style.solidOpacity = parseOpacity(str2);
                    style.specifiedFlags |= 4294967296L;
                    return;
                case 83:
                    if (str2.equals(CURRENTCOLOR)) {
                        style.viewportFill = SVG.CurrentColor.getInstance();
                    } else {
                        try {
                            style.viewportFill = parseColour(str2);
                        } catch (SVGParseException e7) {
                            Log.w(TAG, e7.getMessage());
                            return;
                        }
                    }
                    style.specifiedFlags |= 8589934592L;
                    return;
                case 84:
                    style.viewportFillOpacity = parseOpacity(str2);
                    style.specifiedFlags |= 17179869184L;
                    return;
                case 85:
                    SVG.Style.VectorEffect parseVectorEffect = parseVectorEffect(str2);
                    style.vectorEffect = parseVectorEffect;
                    if (parseVectorEffect != null) {
                        style.specifiedFlags |= 34359738368L;
                        return;
                    }
                    return;
                case 86:
                    SVG.Style.RenderQuality parseRenderQuality = parseRenderQuality(str2);
                    style.imageRendering = parseRenderQuality;
                    if (parseRenderQuality != null) {
                        style.specifiedFlags |= 137438953472L;
                        return;
                    }
                    return;
                default:
            }
        } catch (SVGParseException unused) {
        }
    }

    private void radialGradient(Attributes attributes) {
        debug("<radialGradient>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.SvgRadialGradient svgRadialGradient = new SVG.SvgRadialGradient();
        svgRadialGradient.document = this.svgDocument;
        svgRadialGradient.parent = this.currentElement;
        parseAttributesCore(svgRadialGradient, attributes);
        parseAttributesStyle(svgRadialGradient, attributes);
        parseAttributesGradient(svgRadialGradient, attributes);
        parseAttributesRadialGradient(svgRadialGradient, attributes);
        this.currentElement.addChild(svgRadialGradient);
        this.currentElement = svgRadialGradient;
    }

    private void rect(Attributes attributes) {
        debug("<rect>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Rect rect = new SVG.Rect();
        rect.document = this.svgDocument;
        rect.parent = this.currentElement;
        parseAttributesCore(rect, attributes);
        parseAttributesStyle(rect, attributes);
        parseAttributesTransform(rect, attributes);
        parseAttributesConditional(rect, attributes);
        parseAttributesRect(rect, attributes);
        this.currentElement.addChild(rect);
    }

    private void solidColor(Attributes attributes) {
        debug("<solidColor>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.SolidColor solidColor = new SVG.SolidColor();
        solidColor.document = this.svgDocument;
        solidColor.parent = this.currentElement;
        parseAttributesCore(solidColor, attributes);
        parseAttributesStyle(solidColor, attributes);
        this.currentElement.addChild(solidColor);
        this.currentElement = solidColor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDocument() {
        this.svgDocument = new SVG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        if (this.ignoring) {
            this.ignoreDepth++;
            return;
        }
        if (SVG_NAMESPACE.equals(str) || BuildConfig.FLAVOR.equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            SVGElem fromString = SVGElem.fromString(str2);
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[fromString.ordinal()]) {
                case 1:
                    svg(attributes);
                    return;
                case 2:
                case 3:
                    g(attributes);
                    return;
                case 4:
                    defs(attributes);
                    return;
                case 5:
                    use(attributes);
                    return;
                case 6:
                    path(attributes);
                    return;
                case 7:
                    rect(attributes);
                    return;
                case 8:
                    circle(attributes);
                    return;
                case 9:
                    ellipse(attributes);
                    return;
                case 10:
                    line(attributes);
                    return;
                case 11:
                    polyline(attributes);
                    return;
                case 12:
                    polygon(attributes);
                    return;
                case 13:
                    text(attributes);
                    return;
                case 14:
                    tspan(attributes);
                    return;
                case 15:
                    tref(attributes);
                    return;
                case 16:
                    zwitch(attributes);
                    return;
                case 17:
                    symbol(attributes);
                    return;
                case 18:
                    marker(attributes);
                    return;
                case 19:
                    linearGradient(attributes);
                    return;
                case 20:
                    radialGradient(attributes);
                    return;
                case 21:
                    stop(attributes);
                    return;
                case 22:
                case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                    this.inMetadataElement = true;
                    this.metadataTag = fromString;
                    return;
                case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                    clipPath(attributes);
                    return;
                case 25:
                    textPath(attributes);
                    return;
                case 26:
                    pattern(attributes);
                    return;
                case 27:
                    image(attributes);
                    return;
                case 28:
                    view(attributes);
                    return;
                case R$styleable.Toolbar_titleTextColor /* 29 */:
                    mask(attributes);
                    return;
                case 30:
                    style(attributes);
                    return;
                case 31:
                    solidColor(attributes);
                    return;
                default:
                    this.ignoring = true;
                    this.ignoreDepth = 1;
                    return;
            }
        }
    }

    private void stop(Attributes attributes) {
        debug("<stop>", new Object[0]);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        if (!(svgContainer instanceof SVG.GradientElement)) {
            throw new SVGParseException("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
        }
        SVG.Stop stop = new SVG.Stop();
        stop.document = this.svgDocument;
        stop.parent = this.currentElement;
        parseAttributesCore(stop, attributes);
        parseAttributesStyle(stop, attributes);
        parseAttributesStop(stop, attributes);
        this.currentElement.addChild(stop);
        this.currentElement = stop;
    }

    private void style(Attributes attributes) {
        debug("<style>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        String str = "all";
        boolean z5 = true;
        for (int i5 = 0; i5 < attributes.getLength(); i5++) {
            String trim = attributes.getValue(i5).trim();
            int i6 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i5)).ordinal()];
            if (i6 == 88) {
                z5 = trim.equals("text/css");
            } else if (i6 == 89) {
                str = trim;
            }
        }
        if (z5 && CSSParser.mediaMatches(str, CSSParser.MediaType.screen)) {
            this.inStyleElement = true;
        } else {
            this.ignoring = true;
            this.ignoreDepth = 1;
        }
    }

    private void svg(Attributes attributes) {
        debug("<svg>", new Object[0]);
        SVG.Svg svg = new SVG.Svg();
        svg.document = this.svgDocument;
        svg.parent = this.currentElement;
        parseAttributesCore(svg, attributes);
        parseAttributesStyle(svg, attributes);
        parseAttributesConditional(svg, attributes);
        parseAttributesViewBox(svg, attributes);
        parseAttributesSVG(svg, attributes);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            this.svgDocument.setRootElement(svg);
        } else {
            svgContainer.addChild(svg);
        }
        this.currentElement = svg;
    }

    private void symbol(Attributes attributes) {
        debug("<symbol>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.SvgViewBoxContainer symbol = new SVG.Symbol();
        symbol.document = this.svgDocument;
        symbol.parent = this.currentElement;
        parseAttributesCore(symbol, attributes);
        parseAttributesStyle(symbol, attributes);
        parseAttributesConditional(symbol, attributes);
        parseAttributesViewBox(symbol, attributes);
        this.currentElement.addChild(symbol);
        this.currentElement = symbol;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void text(String str) {
        if (this.ignoring) {
            return;
        }
        if (this.inMetadataElement) {
            if (this.metadataElementContents == null) {
                this.metadataElementContents = new StringBuilder(str.length());
            }
            this.metadataElementContents.append(str);
        } else if (this.inStyleElement) {
            if (this.styleElementContents == null) {
                this.styleElementContents = new StringBuilder(str.length());
            }
            this.styleElementContents.append(str);
        } else if (this.currentElement instanceof SVG.TextContainer) {
            appendToTextContainer(str);
        }
    }

    private void textPath(Attributes attributes) {
        debug("<textPath>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.TextPath textPath = new SVG.TextPath();
        textPath.document = this.svgDocument;
        textPath.parent = this.currentElement;
        parseAttributesCore(textPath, attributes);
        parseAttributesStyle(textPath, attributes);
        parseAttributesConditional(textPath, attributes);
        parseAttributesTextPath(textPath, attributes);
        this.currentElement.addChild(textPath);
        this.currentElement = textPath;
        SVG.SvgContainer svgContainer = textPath.parent;
        if (svgContainer instanceof SVG.TextRoot) {
            textPath.setTextRoot((SVG.TextRoot) svgContainer);
        } else {
            textPath.setTextRoot(((SVG.TextChild) svgContainer).getTextRoot());
        }
    }

    private void tref(Attributes attributes) {
        debug("<tref>", new Object[0]);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        if (!(svgContainer instanceof SVG.TextContainer)) {
            throw new SVGParseException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
        SVG.TRef tRef = new SVG.TRef();
        tRef.document = this.svgDocument;
        tRef.parent = this.currentElement;
        parseAttributesCore(tRef, attributes);
        parseAttributesStyle(tRef, attributes);
        parseAttributesConditional(tRef, attributes);
        parseAttributesTRef(tRef, attributes);
        this.currentElement.addChild(tRef);
        SVG.SvgContainer svgContainer2 = tRef.parent;
        if (svgContainer2 instanceof SVG.TextRoot) {
            tRef.setTextRoot((SVG.TextRoot) svgContainer2);
        } else {
            tRef.setTextRoot(((SVG.TextChild) svgContainer2).getTextRoot());
        }
    }

    private void tspan(Attributes attributes) {
        debug("<tspan>", new Object[0]);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        if (!(svgContainer instanceof SVG.TextContainer)) {
            throw new SVGParseException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
        SVG.TSpan tSpan = new SVG.TSpan();
        tSpan.document = this.svgDocument;
        tSpan.parent = this.currentElement;
        parseAttributesCore(tSpan, attributes);
        parseAttributesStyle(tSpan, attributes);
        parseAttributesConditional(tSpan, attributes);
        parseAttributesTextPosition(tSpan, attributes);
        this.currentElement.addChild(tSpan);
        this.currentElement = tSpan;
        SVG.SvgContainer svgContainer2 = tSpan.parent;
        if (svgContainer2 instanceof SVG.TextRoot) {
            tSpan.setTextRoot((SVG.TextRoot) svgContainer2);
        } else {
            tSpan.setTextRoot(((SVG.TextChild) svgContainer2).getTextRoot());
        }
    }

    private void use(Attributes attributes) {
        debug("<use>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Use use = new SVG.Use();
        use.document = this.svgDocument;
        use.parent = this.currentElement;
        parseAttributesCore(use, attributes);
        parseAttributesStyle(use, attributes);
        parseAttributesTransform(use, attributes);
        parseAttributesConditional(use, attributes);
        parseAttributesUse(use, attributes);
        this.currentElement.addChild(use);
        this.currentElement = use;
    }

    private void view(Attributes attributes) {
        debug("<view>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.SvgViewBoxContainer view = new SVG.View();
        view.document = this.svgDocument;
        view.parent = this.currentElement;
        parseAttributesCore(view, attributes);
        parseAttributesConditional(view, attributes);
        parseAttributesViewBox(view, attributes);
        this.currentElement.addChild(view);
        this.currentElement = view;
    }

    private void zwitch(Attributes attributes) {
        debug("<switch>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Switch r02 = new SVG.Switch();
        r02.document = this.svgDocument;
        r02.parent = this.currentElement;
        parseAttributesCore(r02, attributes);
        parseAttributesStyle(r02, attributes);
        parseAttributesTransform(r02, attributes);
        parseAttributesConditional(r02, attributes);
        this.currentElement.addChild(r02);
        this.currentElement = r02;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SVG parse(InputStream inputStream, boolean z5) {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        try {
            inputStream.mark(3);
            int read = inputStream.read() + (inputStream.read() << 8);
            inputStream.reset();
            if (read == 35615) {
                inputStream = new BufferedInputStream(new GZIPInputStream(inputStream));
            }
        } catch (IOException unused) {
        }
        try {
            inputStream.mark(4096);
            parseUsingXmlPullParser(inputStream, z5);
            return this.svgDocument;
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused2) {
                Log.e(TAG, "Exception thrown closing input stream");
            }
        }
    }

    static PreserveAspectRatio parsePreserveAspectRatio(String str) {
        PreserveAspectRatio.Scale scale;
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        String nextToken = textScanner.nextToken();
        if ("defer".equals(nextToken)) {
            textScanner.skipWhitespace();
            nextToken = textScanner.nextToken();
        }
        PreserveAspectRatio.Alignment alignment = AspectRatioKeywords.get(nextToken);
        textScanner.skipWhitespace();
        if (textScanner.empty()) {
            scale = null;
        } else {
            String nextToken2 = textScanner.nextToken();
            nextToken2.hashCode();
            if (nextToken2.equals("meet")) {
                scale = PreserveAspectRatio.Scale.meet;
            } else if (nextToken2.equals("slice")) {
                scale = PreserveAspectRatio.Scale.slice;
            } else {
                throw new SVGParseException("Invalid preserveAspectRatio definition: " + str);
            }
        }
        return new PreserveAspectRatio(alignment, scale);
    }

    private static float parseFloat(String str, int i5, int i6) {
        float parseNumber = new NumberParser().parseNumber(str, i5, i6);
        if (!Float.isNaN(parseNumber)) {
            return parseNumber;
        }
        throw new SVGParseException("Invalid float value: " + str);
    }

    private void text(char[] cArr, int i5, int i6) {
        if (this.ignoring) {
            return;
        }
        if (this.inMetadataElement) {
            if (this.metadataElementContents == null) {
                this.metadataElementContents = new StringBuilder(i6);
            }
            this.metadataElementContents.append(cArr, i5, i6);
        } else if (this.inStyleElement) {
            if (this.styleElementContents == null) {
                this.styleElementContents = new StringBuilder(i6);
            }
            this.styleElementContents.append(cArr, i5, i6);
        } else if (this.currentElement instanceof SVG.TextContainer) {
            appendToTextContainer(new String(cArr, i5, i6));
        }
    }

    private void text(Attributes attributes) {
        debug("<text>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Text text = new SVG.Text();
            text.document = this.svgDocument;
            text.parent = this.currentElement;
            parseAttributesCore(text, attributes);
            parseAttributesStyle(text, attributes);
            parseAttributesTransform(text, attributes);
            parseAttributesConditional(text, attributes);
            parseAttributesTextPosition(text, attributes);
            this.currentElement.addChild(text);
            this.currentElement = text;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }
}
