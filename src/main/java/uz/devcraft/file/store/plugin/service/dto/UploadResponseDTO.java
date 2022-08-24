package uz.devcraft.file.store.plugin.service.dto;

public class UploadResponseDTO {
    private String filename;
    private Boolean success;

    public UploadResponseDTO(String filename) {
        this.filename = filename;
        this.success = true;
    }

    public UploadResponseDTO(String filename, Boolean success) {
        this.filename = filename;
        this.success = success;
    }
}
