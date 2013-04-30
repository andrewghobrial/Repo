#!/bin/sh

#  Script.sh
#  
#
#  Created by Andrew Ghobrial on 4/27/13.
#

if [ $# -eq 0 ]
then
echo "Please enter URL from which to download and zip all PDFs as the first argument."
else
    mkdir "DownloadedPDFs"
    wget -r -P ./"DownloadedPDFs" -A pdf $1
    zip -r "ZippedPDFs.zip" "DownloadedPDFs"
    rm -rf "DownloadedPDFs"

fi
