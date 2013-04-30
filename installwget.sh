#!/bin/sh

#  install-wget.sh
#  
#
#  Created by Andrew Ghobrial on 4/27/13.
#

curl -O http://ftp.gnu.org/gnu/wget/wget-1.14.tar.gz
tar -xzf wget-1.14.tar.gz
cd wget-1.14
./configure --with-ssl=openssl
make
sudo make install
cd ..
rm -rf wget*