package uz.devcraft.file.store.plugin.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileStorePluginService {

    String NAME = "fileStorePluginService";

    String save(MultipartFile file);

    Resource load(String filename);

    Stream<Path> loadAll();

    void delete(String filename);

    void deleteAll();


}
