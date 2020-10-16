package com.archsoft;

import java.io.File;
import java.io.FileFilter;
import java.util.Objects;

import static java.lang.System.out;

public class Main {

	private static FileFilter fileFilter;

	private static FileFilter folderFilter;

	static {
		fileFilter = new FileFilter() {

			@Override
			public boolean accept(File file) {
				return !file.isHidden() && file.isFile();
			}
		};

		folderFilter = new FileFilter() {
			@Override
			public boolean accept(File file) {
				return !file.getName().startsWith(".")
						&& !file.getName().equals("node_modules")
						&& !file.getName().equals("AppData")
						&& !file.getName().equals("Dropbox")
						&& file.isDirectory();
			}
		};
	}

	public static void main(String[] args) {
		list(new File(System.getProperty("user.home")));
	}

	static void list(File file) {
		out.println(file.getAbsolutePath());

		File[] files = file.listFiles(fileFilter);

		if (Objects.nonNull(files)) {
			for (File f: files) {
				out.println("\t" + f.getName());
			}
		}

		File[] folders = file.listFiles(folderFilter);

		if (Objects.nonNull(folders)) {
			for (File f : folders) {
				list(f);
			}
		}
	}
}
