package ru.pts28;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipReadWriteFiles {
    private static Logger log = Logger.getLogger(SingleSourceFileMap.class.getName());
    ArrayList<String> alFileName = new ArrayList<>();
    String[] strLineFileName;
    public String [] mainRetArrUnzipFiles() throws Exception {
        log.info("unzip and read source files");
//чтение и распаковка архива
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream("source_archive.zip"))) {
            ZipEntry entry;
            String name;
            long size;
            System.out.println("Text message: list of packed files:");
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName(); // название файла
                System.out.printf("%s \n", name);
//список для имен файлов
                int k = 0;
                alFileName.add(k, name);
                ++k;
                FileOutputStream fout = new FileOutputStream("unzip_" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            log.log(Level.SEVERE, "Exception: ", ex);
        }
        log.fine("some minor, debug message");
        System.out.println(" ");
//составление списка распакованных файлов
        log.info("list formation for source files");
        System.out.println("Text message: list of unpacked files:");
        strLineFileName = new String[alFileName.size()];
        for (int u = 0; u < strLineFileName.length; u++) {
            strLineFileName[u] = ("unzip_" + alFileName.get(u));
            System.out.println(strLineFileName[u]);
        }
        System.out.println(" ");
return strLineFileName;
}
}
