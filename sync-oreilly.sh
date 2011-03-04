DIRECTORY=$(cd `dirname $0` && pwd)
export SVN_REPO=$DIRECTORY/../continuous-integration-with-hudson-oreilly
if [ -d $SVN_REPO ]; then
echo "Subversion repo already exists"
else
svn co https://prod.oreilly.com/external/authors/books/9781449389598/current SVN_REPO
fi
#mvn verify
cp hudsonbook-content/src/main/resources/*.xml $SVN_REPO
cp -Rf hudsonbook-content/src/main/resources/figs/* $SVN_REPO/figs
cp hudsonbook-content/target/classes/book.xml $SVN_REPO
cd $SVN_REPO
svn up
svn add *
svn add figs/*
svn commit -m "Integrating latest changes; orm:commitpdf"

