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
        havingValue = "true",
        matchIfMissing = true
)
public class DummyFileStorePluginServiceImpl implements FileStorePluginService {

    public DummyFileStorePluginServiceImpl() {
        log.debug("############### FileStorePlugin simulation is ON ###############");
    }

//    @Override
//    public String send(String request) {
//        log.debug("Dummy request : {}", request);
//        return "Response for : " + request;
//    }

}
