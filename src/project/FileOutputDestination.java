package project;

import project.networkapi.OutputDestination;

import java.nio.file.Path;

public class FileOutputDestination implements OutputDestination {
    private Path path;

    public FileOutputDestination(Path path) {
        this.path = path;
    }
    @Override
    public Path getPath() {
        return this.path;
    }
}
