#!/bin/sh

war_tmp_dir=hudsonbook-pdf/target/tmp-for-war
rm -rf $war_tmp_dir
mkdir -p $war_tmp_dir

cd $war_tmp_dir

echo "Creating the war structure (pwd=`pwd`)"
echo "-- Copying PDF"
cp -Rv ../continuous-integration-with-hudson.pdf .
echo "-- Copying HTML files"
cp -Rv ../../../hudsonbook-html/target/html/ .

zip -r jenkins-le-guide-complet.war *
