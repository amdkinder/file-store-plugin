package uz.devcraft.file.store.plugin.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uz.devcraft.file.store.plugin.config.TestConfig;
import uz.devcraft.file.store.plugin.service.FileStorePluginService;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfig.class})
public class FileStorePluginServiceImplTest {

    @Autowired
    private FileStorePluginService fileStorePluginService;

    @Before
    public void setUp() {
        //Do something on starting
    }

    @After
    public void tearDown() {
        //Do something on finishing
    }

    @Test
    public void testSend() {
//        String response = fileStorePluginService.send("Hi, Javlon");
//        assertEquals("Response for : Hi, Javlon", response);
    }
}
