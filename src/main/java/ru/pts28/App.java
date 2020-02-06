package ru.pts28;

import java.util.Map;
import java.util.logging.Logger;

//главный класс приложения
public class App {
    private static Logger log = Logger.getLogger(App.class.getName());

    public static void main( String[] args ) throws Exception {
/*        try {// внимание! при компиляции файл настроек логирования стирается из корневого каталога
            LogManager.getLogManager().readConfiguration(
                    App.class.getResourceAsStream("logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
*/
        log.info("program start");
        System.out.println("Text message: program start...");
        System.out.println(" ");
//получение MAP с искомыми ключами
        log.info("receive SearchMap");
        Map<String, Integer> appMapSearchFile;
        SearchMap SM = new SearchMap();
        appMapSearchFile = SM.mainRetSearchMap();

        UnzipReadWriteFiles URWF=new UnzipReadWriteFiles();
        String [] appListFiles = URWF.mainRetArrUnzipFiles();

        GeneralSourceMap_J1_J2_J3 GSM123=new GeneralSourceMap_J1_J2_J3(appMapSearchFile,appListFiles);
        Map <String,Integer> appMap_J1_J2=GSM123.mainRetGeneralSourceMap_J1_J2();
        Map <String,Integer[]> appMap_J3=GSM123.mainRetGeneralSourceMap_J3();

//JSON_1
        log.info("start to JSON_1");
        Map<String,Integer> afterPJ1;
        PrevJ1 pj1= new PrevJ1(appMapSearchFile, appMap_J1_J2);
        afterPJ1=pj1.mainRetJ1();
        FinJ1.JSON_1_Write(afterPJ1);

//JSON_2
        log.info("start to JSON_2");
        Map<String,Integer> afterPJ2;
        PrevJ2 pj2= new PrevJ2(appMapSearchFile, afterPJ1);
        afterPJ2=pj2.mainRetJ2();
        FinJ2.JSON_2_Write(afterPJ2);

//JSON_3
        log.info("start to JSON_1");
        Map<String,Integer[]> afterPJ3;
        PrevJ3 pj3= new PrevJ3(appMapSearchFile, appMap_J3);
        afterPJ3=pj3.mainRetJ3();
        FinJ3.JSON_3_Write(afterPJ3);

        System.out.println(" ");
        System.out.println("Text message: successful completion of the program!");
        log.info("program finished");
    }


}














