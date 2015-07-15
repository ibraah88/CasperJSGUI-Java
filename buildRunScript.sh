#!/usr/bin/env bash
mvn clean package assembly:single
cp target/CasperJSGUI-1.0-SNAPSHOT-jar-with-dependencies.jar run-jar
java -jar target/CasperJSGUI-1.0-SNAPSHOT-jar-with-dependencies.jar