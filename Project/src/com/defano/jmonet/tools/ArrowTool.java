package com.defano.jmonet.tools;

import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.builder.PaintTool;

import java.awt.*;

/**
 * A no-op tool; does not modify the canvas in any way.
 */
public class ArrowTool extends PaintTool {

    public ArrowTool() {
        super(PaintToolType.ARROW);
        setToolCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}
