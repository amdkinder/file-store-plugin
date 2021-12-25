package uz.devcraft.file.store.plugin.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "file-store-plugin")
public class FileStorePluginProperties {

    private String store;

}
