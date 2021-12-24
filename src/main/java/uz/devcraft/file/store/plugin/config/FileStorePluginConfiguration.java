package uz.devcraft.file.store.plugin.config;



import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(FileStorePluginProperties.class)
public class FileStorePluginConfiguration {

//    @Bean("fileStorePluginRestTemplate")
//    public RestTemplate fileStorePluginRestTemplate(RestTemplateBuilder restTemplateBuilder, FileStorePluginProperties fileStorePluginProperties) {
//        return restTemplateBuilder
//                .setReadTimeout(fileStorePluginProperties.getReadTimeout())
//                .setConnectTimeout(fileStorePluginProperties.getConnectTimeout())
//                .basicAuthorization(fileStorePluginProperties.getLogin(), fileStorePluginProperties.getPassword())
//                .build();
//    }



}
