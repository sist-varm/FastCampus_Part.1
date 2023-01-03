package org.example;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class WebApplicationServer {
    private static final Logger log = LoggerFactory.getLogger(WebApplicationServer.class);

    public static void main(String[] args) throws Exception{
        String webappDirLocation = "webapps/";
        // Project Structure > Module 부분에서 설정한것이 webapps 하위에 빌드된 파일이 들어가도록 설정한것
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        log.info("configuring app with basedir : {}", new File("./"+ webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();

    }
}
