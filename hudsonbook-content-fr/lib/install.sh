#!/bin/bash
# Install locally jars needed by the build. -- Jean-Laurent
mvn install:install-file -DgroupId=docbook -DartifactId=docbook-xml -Dversion=4.5 -Dpackaging=jar -Dfile=docbook-4.5.jar
mvn install:install-file -DgroupId=org.apache.fop -DartifactId=fop-pdf-images -Dversion=1.3 -Dpackaging=jar -Dfile=fop-pdf-images-1.3.jar
mvn install:install-file -DgroupId=org.apache.fop -DartifactId=fop-pdf-images-res -Dversion=1.3 -Dclassifier=res -Dpackaging=jar -Dfile=fop-pdf-images-1.3-res.jar
mvn install:install-file -DgroupId=pdfbox -DartifactId=pdfbox -Dversion=0.7.4-dev -Dclassifier=dev -Dpackaging=jar -Dfile=PDFBox-0.7.4-dev.jar
