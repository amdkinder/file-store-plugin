package uz.devcraft.file.store.plugin.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.beans.factory.annotation.Qualifier;
import uz.devcraft.file.store.plugin.config.FileStorePluginProperties;
import uz.devcraft.file.store.plugin.service.FileStorePluginService;
import lombok.extern.slf4j.Slf4j;

import static uz.devcraft.file.store.plugin.service.FileStorePluginService.NAME;

@Slf4j
@Service(NAME)
@ConditionalOnProperty(
        prefix = "file-store-plugin",
        name = "simulate",
        havingValue = "false"
)
public class FileStorePluginServiceImpl implements FileStorePluginService {

    private final FileStorePluginProperties fileStorePluginProperties;
//    private final RestTemplate fileStorePluginRestTemplate;

    @Autowired
    public FileStorePluginServiceImpl(FileStorePluginProperties fileStorePluginProperties/*, @Qualifier("fileStorePluginRestTemplate") RestTemplate fileStorePluginRestTemplate*/) {
        this.fileStorePluginProperties = fileStorePluginProperties;
//        this.fileStorePluginRestTemplate = fileStorePluginRestTemplate;
    }

//    @Override
//    public String send(String request) {
//        log.debug("Request : {}, name : {}", request, fileStorePluginProperties.getName());
//        return "Response for : " + request;
//    }

}
