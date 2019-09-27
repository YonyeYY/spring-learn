package or.airyny.spring.learn;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动Dubbo服务用的MainClass
 */
public class PublicDubboProvider {
    private static final Logger log = LogManager.getLogger(PublicDubboProvider.class);
    private static boolean isTrue = true;

    public static void main(String[] args) {
        try {
            writerLog();
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-collection-context.xml");
            context.start();
            writerLog2();
            log.info("************ Public Service Started! ************");
        } catch (Exception e) {
            log.error("== DubboProvider context start error:", e);
        }
        synchronized (PublicDubboProvider.class) {
 
            try {
                while (isTrue) {
                    PublicDubboProvider.class.wait();
                }
            } catch (InterruptedException e) {
                isTrue = false;
                log.debug("");
                Thread.currentThread().interrupt();
            }
        }
    }

    private static void writerLog() {
        log.info(
                "\n\t           ┏┓　  ┏┓+ +\n" +
                "              ┏┛┻━━━━┛┻━━━━━┓ + +\n" +
                "              ┃　　　　　　　┃\n" +
                "              ┃　　　━　　 　┃ ++ + + +\n" +
                "            ████━████ ┃+\n" +
                "              ┃　　　       ┃ +\n" +
                "              ┃　　　┻      ┃\n" +
                "              ┃　　         ┃ + +\n" +
                "              ┗━┓　　　 ┏━━━┛\n" +
                "                ┃　 　　┃\n" +
                "                ┃　 　　┃ + + + +\n" +
                "                ┃　　 　┃\n" +
                "                ┃　　 　┃ +\n" +
                "                ┃　　 　┃\n" +
                "                ┃　　　 ┃　　+\n" +
                "                ┃　 　　┗━━━━━━┓ + +\n" +
                "                ┃ 　　　　　　　┣┓\n" +
                "                ┃ 　　　　　　　┏┛\n" +
                "                ┗━┓┓┏━━┳┓┏━━━━━┛ + + + +\n" +
                "                  ┃┫┫　┃┫┫\n" +
                "                  ┗┻┛　┗┻┛+ + + +\n" +
                "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" +
                "Code is far away from bug with the animal protecting\n"+
                "              神兽保佑    代码无bug\n" +
                "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
    }
    private static void writerLog2() {
        log.info("\n\t                     .::::.\n" +
                "                       .::::::::.\n" +
                "                      :::::::::::\n" +
                "                   ..:::::::::::'\n" +
                "                '::::::::::::'\n" +
                "                   .::::::::::\n" +
                "              '::::::::::::::..\n" +
                "                   ..::::::::::::.\n" +
                "                 ``::::::::::::::::\n" +
                "                  ::::``:::::::::'        .:::.\n" +
                "                 ::::'   ':::::'       .::::::::.\n" +
                "               .::::'      ::::     .:::::::'::::.\n" +
                "              .:::'       :::::  .:::::::::' ':::::.\n" +
                "             .::'        :::::.:::::::::'      ':::::.\n" +
                "            .::'         ::::::::::::::'         ``::::.\n" +
                "        ...:::           ::::::::::::'              ``::.\n" +
                "       ```` ':.          ':::::::::'                  ::::..\n" +
                "                          '.:::::'                    ':'````..\n" +
                "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" +
                "                        美女保佑       永无BUG\n" +
                "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
    }

}