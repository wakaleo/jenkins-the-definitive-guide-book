WORK_DIR=`pwd`
ps -aux | grep svnserve | awk '{print $2}' | xargs kill -9
svnserve -d -r ${WORK_DIR}/svn-repos
export HUDSON_HOME=${WORK_DIR}/hudson-data
java  -Dhttp.proxyHost=myproxyserver.com  -Dhttp.proxyPort=80 -jar hudson.war
