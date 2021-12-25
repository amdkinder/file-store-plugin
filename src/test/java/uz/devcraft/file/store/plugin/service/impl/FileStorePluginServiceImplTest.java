package uz.devcraft.file.store.plugin.service.impl;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;
import uz.devcraft.file.store.plugin.config.FileStorePluginProperties;
import uz.devcraft.file.store.plugin.config.TestConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

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
    public void fileProps() throws IOException {

    }

}
