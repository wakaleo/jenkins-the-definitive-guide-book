#!/bin/sh
# This script is only here to obtain quickly a very rough estimation of where we are (and for the fun of writing it, granted)
# Feel free to improve it or propose improvement on ML if you prefer

#extensible : could be used on -zh if wanted
translation=fr

totalSize=0
totalTranslatedSize=0

for englishVersion in hudsonbook-content/src/main/resources/*.xml
do
	localeVersion=`echo $englishVersion| sed "s/hudsonbook-content/hudsonbook-content-\$translation/g"`
	englishSize=`du -sk $englishVersion| cut -f1`
	localeSize=`du -sk $localeVersion| cut -f1`
	totalSize=$(( $englishSize + $totalSize ))
	
	#echo "$englishVersion ($englishSize kb) -> $localeVersion ($localeSize kb)"
	
	title=`grep "<title>" $englishVersion|head -1|sed "s/ *<title>//g"|sed "s/ *<\/title>//g"`
	
	echo -n "$englishVersion: "
	if [[ `diff $englishVersion $localeVersion` ]]
	then
		#Here we do a roughy-rough estimation of the proportion of lines having been translated.
		#Any modified line between english and french is considered translated, obviously :-)
		translatedSize=$(( `diff $englishVersion $localeVersion |  egrep '^[<>]' | wc -c`/2000 ))
		totalTranslatedSize=$(( $totalTranslatedSize + $translatedSize ))
		#Note that sometimes, translation can be bigger than original, so display below can be disturbing :-) : 51/49 e.g.
		echo -n "$translatedSize/$englishSize kB"
	else
		echo -n "Untouched yet."
	fi
	echo " (title: $title)"
	
done
echo "Summary: $totalTranslatedSize/$totalSize"

