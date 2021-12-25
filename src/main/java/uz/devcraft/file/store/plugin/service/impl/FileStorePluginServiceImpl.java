package uz.devcraft.file.store.plugin.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.devcraft.file.store.plugin.service.FileStorePluginService;

import java.nio.file.Path;
import java.util.stream.Stream;

import static uz.devcraft.file.store.plugin.service.FileStorePluginService.NAME;

@RequiredArgsConstructor
@Slf4j
@Service(NAME)
public class FileStorePluginServiceImpl implements FileStorePluginService {

    private final BaseFileStorePluginService baseService;

    @Override
    public String save(MultipartFile file) {
        return baseService.save(file);
    }

    @Override
    public Resource load(String filename) {
        return baseService.load(filename);
    }

    @Override
    public Stream<Path> loadAll() {
        return baseService.loadAll();
    }

    @Override
    public void delete(String filename) {
        baseService.delete(filename);
    }

    @Override
    public void deleteAll() {
        baseService.deleteAll();
    }
}
