package uz.devcraft.file.store.plugin.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import uz.devcraft.file.store.plugin.config.FileStorePluginProperties;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.stream.Stream;

@Slf4j
@Service

public class BaseFileStorePluginService {

    private final Path root;

    public BaseFileStorePluginService(FileStorePluginProperties storePluginProperties) {
        root = Paths.get(storePluginProperties.getStore());
    }

    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    public String save(MultipartFile file) {

        log.debug("file original name: {}", file.getOriginalFilename());
        var filename = UUID.randomUUID().toString();
        var suffix = getFileSuffix(file);
        filename = filename + suffix;
        log.debug("Suffix: {}", suffix);
        try {
            Files.copy(file.getInputStream(), root.resolve(filename));
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
        }
        return filename;
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }

    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void delete(String filename) {
        try {
            Path path = root.resolve(filename);
            Files.delete(path);
        } catch (IOException e) {
            log.error("Error deleting file: {}", e.getMessage());
            throw new RuntimeException("Error: {}" + e.getMessage());
        }
    }


    private String getFileSuffix(MultipartFile multipartFile) {
        var fileName = multipartFile.getOriginalFilename();
        var suffix = ".txt";
        if (fileName == null) {
            if (multipartFile.getContentType() != null) {
                suffix = getFileSuffix(multipartFile.getContentType());
            }
        } else {
            var suffixIndex = fileName.lastIndexOf(".");
            if (suffixIndex != -1) {
                suffix = fileName.substring(suffixIndex);
            }
        }
        return suffix;
    }

    private String getFileSuffix(String contentType) {
        switch (contentType) {
            case "application/pdf":
                return ".pdf";
            case "application/msword":
                return ".doc";
            case "application/vnd.openxmlformats-officedocument.wordprocessingml.document":
                return ".docx";
            case "application/vnd.ms-powerpoint":
                return ".ppt";
            case "application/vnd.openxmlformats-officedocument.presentationml.presentation":
                return ".pptx";
            case "image/jpeg":
                return ".jpg";
            case "image/tiff":
                return ".tiff";
            default:
                return ".txt";
        }
    }
}
