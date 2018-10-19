package com.sphereon.sdk.pdf.api.util;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PDFReadUtils {

    private PDFReadUtils() {}
    public static List<RenderedImage> getImagesFromPdf(PDDocument doc, int pageNumber) throws IOException {
        PDResources resources = doc.getPage(pageNumber).getResources();
        List<RenderedImage> images = new ArrayList<>();
        for (COSName xObjectName :resources.getXObjectNames()) {
            PDXObject xObject = resources.getXObject(xObjectName);
            if (xObject instanceof PDImageXObject)
                images.add(((PDImageXObject) xObject).getImage());
        }
        return  images;
    }
}
