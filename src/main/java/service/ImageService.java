package service;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import util.PropertiesUtil;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

import static java.nio.file.StandardOpenOption.CREATE;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ImageService {
    private static final ImageService INSTANCE = new ImageService();
    private final String basePath = PropertiesUtil.get("image.base.url");
    @SneakyThrows
    public void upload(String imagePath, InputStream imageContent){
        var imageFullPath = Path.of(basePath,imagePath);
        try(imageContent){
            Files.createDirectories(imageFullPath.getParent());
            Files.write(imageFullPath,imageContent.readAllBytes(), CREATE,StandardOpenOption.TRUNCATE_EXISTING);
        }
    }
    @SneakyThrows
    public Optional<InputStream>get(String path){
        var imageFullPath = Path.of(basePath,path);
        return Files.exists(imageFullPath)?Optional.of(Files.newInputStream(imageFullPath)):Optional.empty();
    }

    public static ImageService getInstance(){
        return INSTANCE;
    }
}
