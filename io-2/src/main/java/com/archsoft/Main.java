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
				return Objects.nonNull(file) && !file.isHidden() && file.isFile();
			}
		};

		folderFilter = new FileFilter() {
			@Override
			public boolean accept(File file) {
				return Objects.nonNull(file) && file.isDirectory();
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
