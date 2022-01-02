package uz.devcraft.file.store.plugin.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uz.devcraft.file.store.plugin.config.FileStorePluginProperties;
import uz.devcraft.file.store.plugin.config.TestConfig;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfig.class})
public class FileStorePluginServiceImplTest {


    @Autowired
    private FileStorePluginProperties storePluginProperties;

    @Before
    public void setUp() {
        log.info("Assalom alaykum");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSend() {
    }

    @Test
    public void generateImage() {
        var filename = "kotlin-reference.pdf";
        var imageUrl = generateImageFromPdf(filename);
        System.out.println(imageUrl);
    }

    private String generateImageFromPdf(String filename) {
        var root = Paths.get(storePluginProperties.getStore());
        var path = root.resolve(filename);
        String imageUri = "default.png";
        try {
            PDDocument document = PDDocument.load(path.toFile());
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            if (document.getNumberOfPages() > 0) {
                BufferedImage image = pdfRenderer.renderImageWithDPI(0, 100, ImageType.RGB);
                imageUri = "abc.png";
                File outPutFile = new File(root.resolve(imageUri).toUri());
                ImageIO.write(image, "png", outPutFile);
                document.close();
            }
        } catch (Exception e) {
            log.warn("Can not load pdf");
        }
        return imageUri;
    }

}
