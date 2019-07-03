package xy.core.annotaion.handler;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.xiuye.util.cls.TypeUtil;

import xy.core.bean.handler.ClassScanner;

public class AnnotationedClassScanner implements ClassScanner{

	private List<String> packages;

	/**
	 * 
	 * @param paths packages
	 */
	public AnnotationedClassScanner(List<String> packages) {
		this.packages = packages;
	}

	/**
	 * 
	 * @param paths packages
	 */
	public AnnotationedClassScanner(String... packages) {
		this(Arrays.asList(packages));
	}

	/**
	 * not contains sub dirs
	 * @return
	 */
	@Override
	public List<String> allClassNames() {
		Set<String> ps = TypeUtil.createSet();
		packages.forEach((p) -> {
			String currentPath = AnnotationedClassScanner.class.getClassLoader().getResource("").getPath().substring(1);
//			LogUtil.log("currentPath =", currentPath);
			Path path = Paths.get(currentPath + p.replace(".", File.separator));
			File[] files = path.toFile().listFiles();

			for (File f : files) {
				if (f.isFile()) {
					String name = f.getName();
					name = name.substring(0, name.lastIndexOf(".class"));
					name = p + "." + name;
					ps.add(name);
				}
			}
//			LogUtil.log("file set =", ps);

//			try {
//				Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
//
//					@Override
//					public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//						Objects.requireNonNull(file);
//						Objects.requireNonNull(attrs);
//
//						LogUtil.log("file = ", file.getFileName());
//
//						return FileVisitResult.CONTINUE;
//					}
//
//				});
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		});
		List<String> classNames = TypeUtil.createList();
		classNames.addAll(ps);
		return classNames;
	}

}
