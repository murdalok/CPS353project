package project;

import project.networkapi.InputSource;

import java.nio.file.Path;

public class FileInputSource implements InputSource {
    private Path path;

    public FileInputSource(Path path) {
        this.path = path;
    }

    @Override
    public Path getPath() {
        return this.path;
    }
}
