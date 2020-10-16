package com.archsoft;

import java.io.File;

public class DirCommand implements Command {

    @Override
    public String execute(String input) {
        String targetDir = input.split(" ")[1];
        File file = new File(targetDir);

        if (!file.isDirectory()) {
            return file.getAbsolutePath() + " is not a folder";
        }

        StringBuilder builder = new StringBuilder();

        dir(builder, file);

        return builder.toString();
    }

    public void dir(StringBuilder builder, File file) {
        for (File f: file.listFiles()) {
            if (f.isFile()) {
                builder.append(f.getAbsolutePath() + "\n");
            }
        }

        //Lista diretorios recursivamente
        for (File f: file.listFiles()) {
            if (f.isDirectory()) {
                dir(builder, f);
            }
        }
    }
}
