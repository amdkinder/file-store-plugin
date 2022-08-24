package uz.devcraft.file.store.plugin.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.devcraft.file.store.plugin.service.FileStorePluginService;
import uz.devcraft.file.store.plugin.service.dto.UploadResponseDTO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/content")
public class ContentResource {

    private final FileStorePluginService storePluginService;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public ContentResource(FileStorePluginService storePluginService) {
        this.storePluginService = storePluginService;
    }

    @GetMapping("/download/{filename}")
    public ResponseEntity<?> getFile(@PathVariable("filename") String filename) throws IOException {
        var resource = storePluginService.load(filename);
        var headers = new HttpHeaders();
        var path = Paths.get(resource.getURI());
        headers.add(HttpHeaders.CONTENT_TYPE, Files.probeContentType(path));
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=$filename");
        return ResponseEntity.ok()
            .headers(headers)
            .contentLength(resource.contentLength())
            .body(resource);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        log.debug("Request to save file: {}", file.getOriginalFilename());
        var filename = storePluginService.save(file);
        return ResponseEntity.ok(new UploadResponseDTO(filename));
    }

}
