package com.archsoft;

import java.io.*;
import java.util.Objects;

public class ProjectPersister {

    public void save(Project project, File file) throws IOException {
        Objects.requireNonNull(project);
        Objects.requireNonNull(file);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(project);
        }
    }

    public Project load(File file) throws IOException, ClassNotFoundException {
        Objects.requireNonNull(file);

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (Project) in.readObject();
        }
    }
}
